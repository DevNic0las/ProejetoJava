import java.util.Scanner;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Random random = new Random();

    apresentarJogo();

    Personagem jogador = atributosDoplayer(input);

    System.out.println(Falas.TUTORIAL.getTexto());
    Personagem goblin = new Inimigo(50, 25, "Goblin");
    System.out.println("Você está enfrentando o " + goblin.getNome() + "! Prepare-se!");

    boolean venceuTutorial = batalha(jogador, goblin, null, input, random);
    if (!venceuTutorial) {
      System.out.println("Você foi derrotado pelo Goblin. Melhor sorte na próxima vez!");
      input.close();
      return; // Caso jogador perca
    }

    System.out.println("Parabéns! Você venceu o tutorial e está pronto para enfrentar os desafios reais!");

    Fases fases = new Fases();
    int faseAtual = 0;

    while (faseAtual < fases.getQuantidadeDeFases() && !jogador.estaMorto()) {
      System.out.println("\n=== Fase " + (faseAtual + 1) + " ===");
      FaseEstrutura fase = fases.getFase(faseAtual);
      System.out.println("Inimigo: " + fase.getInimigo().getNome());

      boolean jogadorVenceu = batalha(jogador, fase.getInimigo(), fase, input, random);

      if (jogadorVenceu) {
        System.out.println("Você venceu a fase " + fase.getNome() + "!");
        jogador.setVida(jogador.getVida() + 25);
        jogador.setDano(jogador.getDano() + 25);
        faseAtual++;
      } else {
        System.out.println("Você foi derrotado na fase " + fase.getNome() + ". Fim do jogo.");
        break;
      }
    }

    if (jogador.estaMorto()) {
      System.out.println("Você foi derrotado. Melhor sorte na próxima vez!");
    } else {
      System.out.println("Parabéns! Você completou todas as fases e salvou a humanidade!");
    }

    input.close();
  }

  private static void apresentarJogo() {
    System.out.println("Olá, Forasteiro! O mundo foi tomado por monstros...\n");
    System.out.println("E você é o único que restou para salvar a humanidade!\n");
    System.out.println("Seu objetivo é derrotar o último monstro da torre, mas cuidado, em cada compartimento...");
    System.out.println("haverá aberrações de diferentes tipos... Boa sorte.\n");
    System.out.println(Falas.FRASE_INICIAL.getTexto());
  }

  private static Personagem atributosDoplayer(Scanner input) {
    System.out.println("\nQual o nome do seu Herói?");
    String nomeJogador = input.nextLine().trim();
    if (nomeJogador.isEmpty()) {
      nomeJogador = "Jogador";
    }
    Personagem jogador = new Jogador(200, 50, nomeJogador);
    System.out.println("Esses são seus atributos:\n");
    System.out.println("Vida: " + jogador.getVida());
    System.out.println("Dano: " + jogador.getDano());
    System.out.println("Nome: " + jogador.getNome());
    return jogador;
  }

  private static int escolhaMagia(Scanner input) {
    while (true) {
      System.out.println("Escolha a magia que quer usar:");
      System.out.println("1 - Bola de Fogo");
      System.out.println("2 - Feitiço de Vida");
      try {
        int escolha = input.nextInt();
        if (escolha == 1 || escolha == 2) {
          return escolha;
        }
        System.out.println("Escolha inválida! Tente novamente.");
      } catch (Exception e) {
        System.out.println("Entrada inválida! Insira um número.");
        input.nextLine();
      }
    }
  }

  public static int escolhaPlayer(Scanner input) {
    while (true) {
      System.out.println("\nEscolha sua ação:");
      System.out.println("1 - Atacar");
      System.out.println("2 - Defender");
      System.out.println("3 - Usar Habilidade Especial\n");
      try {
        int escolha = input.nextInt();
        if (escolha >= 1 && escolha <= 3) {
          return escolha;
        }
        System.out.println("Escolha inválida! Tente novamente.");
      } catch (Exception e) {
        System.out.println("Entrada inválida! Insira um número.");
        input.nextLine();
      }
    }
  }

  public static Destino acao(int escolha) {
    return switch (escolha) {
      case 1 -> Destino.ATACAR;
      case 2 -> Destino.DEFENDER;
      case 3 -> Destino.HABILIDADE_ESPECIAL;
      default -> throw new IllegalArgumentException("Escolha inválida.");
    };
  }

  private static void executarAcaoCritica(Destino destino, Personagem jogador, Personagem inimigo, Scanner input) {
    if (destino == Destino.ATACAR) {
      jogador.critico(inimigo);
    } else if (destino == Destino.DEFENDER) {
      jogador.defender(inimigo);
    } else if (destino == Destino.HABILIDADE_ESPECIAL) {
      int escolhaMagia = escolhaMagia(input);
      if (escolhaMagia == 1) {
        Magias.BOLADEFOGO.executarMagia(jogador, inimigo);
      } else if (escolhaMagia == 2) {
        Magias.CURA.executarMagia(jogador, jogador);
      }
    }
  }

  public static boolean batalha(Personagem jogador, Personagem inimigo, FaseEstrutura faseAtual, Scanner input, Random random) {
    while (!jogador.estaMorto() && !inimigo.estaMorto()) {
      int escolha = escolhaPlayer(input);
      Destino destino = acao(escolha);
      int dado = random.nextInt(10) + 1;
      int dadoInimigo = random.nextInt(4) + 1;
      System.out.println("Você rolou o dado: " + dado + "\n");

      if (dado >= 8) {
        System.out.println("Ação crítica! Efeito poderoso!\n");
        executarAcaoCritica(destino, jogador, inimigo, input);
        if (destino == Destino.DEFENDER) {
          System.out.println("Contra-ataque realizado!\n");
          jogador.critico(inimigo);
        }
      } else if (dado == 1) {
        System.out.println("Ação falhou! Você recebeu um dano crítico!\n");
        inimigo.critico(jogador);
      }
      if (dado >= 6) {
        if (destino == Destino.ATACAR) {
          if (dadoInimigo == 2) {
            // Inimigo defende
            int danoReduzido = jogador.getDano() / 2; // Reduz dano pela metade
            System.out.println(inimigo.getNome() + " se defendeu! O dano foi reduzido para " + danoReduzido);
            inimigo.calculaDano(danoReduzido);
          } else {
            // Inimigo não defendeu, jogador ataca normalmente
            jogador.atacar(inimigo);
            System.out.println(jogador.getNome() + " atacou " + inimigo.getNome() + " causando " + jogador.getDano() + " de dano.");
          }
        }
      } else {
        System.out.println("Ação falhou! Você perdeu a vez.\n");
      }

      //turno inimigo

      if (!inimigo.estaMorto()) {
        if (dadoInimigo == 1) {
          System.out.println(inimigo.getNome() + " está atacando!\n");
          inimigo.atacar(jogador);
        } else if (dadoInimigo == 2 && destino == Destino.ATACAR) {
          inimigo.defender(jogador);
        } else if (dadoInimigo == 3) {
          if (faseAtual != null && faseAtual.isCuraPermitida()) {
            System.out.println(inimigo.getNome() + " está se curando!\n");
            Magias.CURA.executarMagia(inimigo, inimigo);
          } else if (faseAtual != null && faseAtual.isUsomagia()) {
            System.out.println(inimigo.getNome() + " Roubou sua mágia");
            Magias.ROUBOMAGIA.executarMagia(inimigo, jogador);
          } else {
            System.out.println(inimigo.getNome() + " tenta se curar, mas a habilidade não está disponível nesta fase!\n");
          }

        }
      }
    }

    return inimigo.estaMorto();
  }

}

