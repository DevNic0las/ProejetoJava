public class Magiafogo extends Magia {
  public Magiafogo(String nome, int poder) {
    super(nome, poder);
  }

  @Override
  public void usar(Personagem jogador, Personagem alvo) {
    System.out.println(jogador.getNome() + " lança " + getNome() + " em " + alvo.getNome() +
            ", causando " + getPoder() + " de dano!");
    alvo.calculaDano(getPoder());
  }
}
