import java.util.Scanner;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Random random = new Random();

    apresentarJogo();

    Personagem jogador = atributosDoplayer(input);
    Personagem inimigo = new Inimigo(50, 25, "Goblin", 12);

    System.out.println(Falas.TUTORIAL.getTexto());
    System.out.println(Inimigos.GOBLINS.getInimigo());

    //chamasse apeenas esse método, pois os outros 2 estão inclusos
    boolean jogadorVenceu = batalha(jogador, inimigo, input, random);

    // Mensagem final
    if (jogadorVenceu) {
      System.out.println("Parabéns! Você derrotou " + inimigo.getNome() + "!");
    } else {
      System.out.println("Você foi derrotado por " + inimigo.getNome() + ". Melhor sorte na próxima vez!");
    }

    input.close();
  }

  private static void apresentarJogo() {
    System.out.println("Olá, Forasteiro! O mundo foi tomado por monstros...\n");
    System.out.println("E você é o único que restou para salvar a humanidade!\n");
    System.out.println("Seu objetivo é derrotar o último monstro da torre, mas cuidado, em cada compartimento...");
    System.out.println("haverá aberrações de diferentes tipos... Boa sorte.\n");
  }

  private static Personagem atributosDoplayer(Scanner input) {
    System.out.println("Qual o seu nome?");
    String nomeJogador = input.nextLine();
    if (nomeJogador.trim().isEmpty()) {
      nomeJogador = "Jogador";
    }
    Personagem jogador = new Jogador(200, 10, nomeJogador);
    System.out.println("Esses são seus atributos:\n");
    System.out.println("Vida: " + jogador.getVida());
    System.out.println("Dano: " + jogador.getDano());
    System.out.println("Nome: " + jogador.getNome());
    return jogador;
  }

  public static int escolhaPlayer(Scanner input) {
    while (true) {
      System.out.println("\nEscolha sua ação:");
      System.out.println("1 - Atacar");
      System.out.println("2 - Defender");
      System.out.println("3 - Usar Habilidade Especial");
      try {
        int escolha = input.nextInt();
        if (escolha >= 1 && escolha <= 3) {
          return escolha;
        }
        System.out.println("Escolha inválida! Tente novamente.");
      } catch (Exception e) {
        System.out.println("Entrada inválida! Insira um número.");
        input.nextLine(); // Limpar entrada inválida
      }
    }
  }

  public static Destino acao(int escolha) {
    switch (escolha) {
      case 1:
        return Destino.ATACAR;
      case 2:
        return Destino.DEFENDER;
      case 3:
        return Destino.HABILIDADE_ESPECIAL;
      default:
        throw new IllegalArgumentException("Escolha inválida.");
    }
  }

  public static boolean batalha(Personagem jogador, Personagem inimigo, Scanner input, Random random) {
    while (!jogador.estaMorto() && !inimigo.estaMorto()) {
      int escolha = escolhaPlayer(input); // escolhe o numero de 1 a 3 e chamada de metodo do while
      Destino destino = acao(escolha); //guarda o retorno do metodo acao
      int dado = random.nextInt(10) + 1;
      System.out.println("Você rolou o dado: " + dado);

      if (dado >= 8) {
        System.out.println("Ação crítica! Efeito poderoso!");
        executarAcaoCritica(destino, jogador, inimigo, input);
      } else if (dado == 1) {
        System.out.println("Ação falhou! Você recebeu um dano crítico!");
        inimigo.critico(jogador);
      } else if (dado >= 6) {
        System.out.println("Ação bem-sucedida!");
        destino.executarAcao(jogador, inimigo);
      } else {
        System.out.println("Ação falhou! Você perdeu a vez.");
      }
      if (destino == Destino.DEFENDER) {
        jogador.calculaDano(0);
      } else {
        System.out.println(inimigo.getNome() + " está atacando!");
        inimigo.atacar(jogador);

      }

    }

    return !jogador.estaMorto();
  }

  private static void executarAcaoCritica(Destino destino, Personagem jogador, Personagem inimigo, Scanner input) {
    if (destino == Destino.ATACAR) {
      jogador.critico(inimigo);
    } else if (destino == Destino.DEFENDER) {
      jogador.defender(inimigo);

    } else if (destino == Destino.HABILIDADE_ESPECIAL) {
      System.out.println("Magia ativa, escolha a magia que quer usar:");
      System.out.println("1 - Bola de Fogo");
      System.out.println("2 - Feitiço de Vida");
      int escolhaMagia = escolhaPlayer(input);
      if (escolhaMagia == 1) {
        Magias.BOLADEFOGO.executarMagia(jogador, inimigo);
      } else if (escolhaMagia == 2) {
        Magias.CURA.executarMagia(jogador, jogador);
      }
    }
  }
}
