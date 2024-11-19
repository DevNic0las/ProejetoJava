public abstract class Personagem {
  private int vida;
  private int dano;
  private String nome;

  public Personagem(int vida, int dano, String nome) {
    this.vida = vida;
    this.dano = dano;
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public int getVida() {
    return vida;
  }

  public void setVida(int vida) {
    this.vida = vida;
  }

  public int getDano() {
    return dano;
  }

  public void calculaDano(int danoRecebido) {
    this.vida -= danoRecebido;
    if (this.vida < 0) this.vida = 0;
    System.out.println(getNome() + " recebeu " + danoRecebido + " de dano. Vida restante: " + this.vida);

  }

  // para poder de cura:
  public void recuperarVida(float percente) {
    this.vida = (int) (this.vida * 1.2f);
  }

  public boolean estaMorto() {
    return this.vida <= 0;
  }

 // tanto jogador e inimigo causam isso, mas de maneiras distintas. Por isso usar.
  public abstract void atacar(Personagem alvo);

  public abstract void defender(Personagem alvo);

  public abstract void critico(Personagem alvo);

}
