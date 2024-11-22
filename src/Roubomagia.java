public class Roubomagia extends Magia {
  private Magia magiaRoubada;

  public Roubomagia(String nome, int poder, Magia magiaRoubada) {
    super(nome, poder);
    this.magiaRoubada = magiaRoubada;
  }

  @Override
  public void usar(Personagem jogador, Personagem alvo) {
    System.out.println(jogador.getNome() + "Rouba a magia de " + alvo.getNome() + magiaRoubada.getNome());
    alvo.calculaDano(magiaRoubada.getPoder());
  }
}
