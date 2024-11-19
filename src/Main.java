import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        // Narrativa inicial
        System.out.println("Olá, Forasteiro! O mundo foi tomado por monstros...\n");
        System.out.println("E você é o único que restou para salvar a humanidade!\n");
        System.out.println("Seu objetivo é derrotar o último monstro da torre, mas cuidado, em cada compartimento...\n" +
                "haverá aberrações de diferentes tipos... Boa sorte.\n");
        System.out.println("Qual o seu nome?");

        String nomeJogador = input.nextLine();
        if (nomeJogador.trim().isEmpty()) {
            nomeJogador = "Jogador";
        }

        // Criação do personagem
        Personagem jogador = new Jogador(200, 10, nomeJogador);
        Personagem inimigo = new Inimigo(50, 25, "Goblin", 12);

        // Atributos do jogador
        System.out.println("Esses são seus atributos:\n");
        System.out.println("Vida: " + jogador.getVida());
        System.out.println("Dano: " + jogador.getDano());
        System.out.println("Nome: " + jogador.getNome());
        System.out.println(Falas.TUTORIAL.getTexto());
        System.out.println(Inimigos.GOBLINS.getInimigo());
        while (true) {
            // Escolha do jogador
            System.out.println("\nEscolha sua ação:");
            System.out.println("1 - Atacar");
            System.out.println("2 - Defender");
            System.out.println("3 - Usar Habilidade Especial");
            int escolha = input.nextInt();

            Destino destino;
            switch (escolha) {
                case 1:
                    destino = Destino.ATACAR;
                    break;
                case 2:
                    destino = Destino.DEFENDER;
                    break;
                case 3:
                    destino = Destino.HABILIDADE_ESPECIAL;
                    break;
                default:
                    System.out.println("Escolha inválida! Tente novamente.");
                    continue;
            }

            // Jogar o dado para definir o resultado
            int dado = random.nextInt(9) + 1; // Dado de 10 lados
            System.out.println("Você rolou o dado: " + dado);

            if (dado >= 8) { // Crítico
                System.out.println("Ação crítica! Efeito poderoso!");
                if (destino == Destino.ATACAR) {
                    jogador.critico(inimigo); // Dano dobrado no inimigo
                } else if (destino == Destino.HABILIDADE_ESPECIAL) {
                    System.out.println("Magia ativa, efeito poderoso");
                    System.out.println("Escolha a magia que quer usar:\n");
                    System.out.println("1 - Bola de fogo");
                    int escolhaMagia = input.nextInt();
                    if (escolhaMagia == 1) {
                        Magias magias = Magias.BOLADEFOGO;
                        magias.executarMagia(jogador, inimigo);
                        System.out.println("Devido ao uso de magia:\n");
                        jogador.calculaDano(50);// Chama o método da magia corretamente
                    }
                }
            } else if (dado == 1) { // Falha crítica
                System.out.println("Ação falhou! Você recebeu um dano crítico!");
                inimigo.critico(jogador); // Inimigo aplica um ataque crítico
            } else if (dado >= 7) {
                System.out.println("Ação bem-sucedida!");
                destino.executarAcao(jogador, inimigo);
            } else { // Falha simples
                System.out.println("Ação falhou! Você perdeu a vez.");
            }

// Verificar se o inimigo está morto
            if (inimigo.estaMorto()) {
                System.out.println(inimigo.getNome() + " foi derrotado! Você venceu!");
                break;
            }

// Turno do inimigo
            System.out.println(inimigo.getNome() + " está atacando!");
            inimigo.atacar(jogador);

// Verificar se o jogador está morto
            if (jogador.estaMorto()) {
                System.out.println("Você foi derrotado. Que pena, forasteiro...");
                break;
            }


        }
            input.close();
    }
}
