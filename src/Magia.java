public abstract class Magia {
  private String nome;
  private int poder;

  public Magia(String nome, int poder) {
    this.nome = nome;
    this.poder = poder;
  }

  public String getNome() {
    return nome;
  }

  public int getPoder() {
    return poder;
  }


  public abstract void usar(Personagem jogador, Personagem alvo);
}
