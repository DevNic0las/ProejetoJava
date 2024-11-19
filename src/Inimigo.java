public class Inimigo extends Personagem {
  private int sorte;

  public Inimigo(int vida, int dano, String nome, int sorte) {
    super(vida, dano, nome);
    this.sorte = sorte;
  }

  @Override
  public void atacar(Personagem alvo) {
    System.out.println(getNome() + " atacou " + alvo.getNome() + " causando " + getDano() + " de dano!");
    alvo.calculaDano(getDano());
  }

  @Override
  public void defender(Personagem alvo) {
    int danoReduzido = alvo.getDano() / 2;
    System.out.println(getNome() + " se defendeu contra e o dano foi reduzido para " + danoReduzido);
    calculaDano(danoReduzido);
  }

  @Override
  public void critico(Personagem alvo) {
    int danoCritico = getDano() * 2;
    System.out.println(getNome() + "realizou um ataque crítico em" + alvo.getNome());
    alvo.calculaDano(danoCritico);
  }
}
