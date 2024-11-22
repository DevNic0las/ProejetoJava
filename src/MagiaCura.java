public class MagiaCura extends Magia {
  private float multiplicadorCura;

  public MagiaCura(String nome, int poder, float multiplicadorCura) {
    super(nome, poder); // Poder pode ser irrelevante aqui, mas mantido por consistência
    this.multiplicadorCura = multiplicadorCura;
  }

  @Override
  public void usar(Personagem jogador, Personagem alvo) {
    int novaVida = (int) (alvo.getVida() * multiplicadorCura);

    if (jogador.getVida() <= 50) {
      System.out.println(jogador.getNome() + " usa " + getNome() +
              " para curar " + alvo.getNome() + ". Nova vida: " + novaVida);
      alvo.setVida(novaVida);

    }
    System.out.println("Você poderá usar apenas se estiver abaixo de 50 de vida");
  }
}
