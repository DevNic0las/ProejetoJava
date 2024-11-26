public class Inimigo extends Personagem {


  public Inimigo(int vida, int dano, String nome) {
    super(vida, dano, nome);
  }


  @Override
  public void atacar(Personagem alvo) {
    System.out.println(getNome() + " atacou " + alvo.getNome() + " causando " + getDano() + " de dano! \n");
    alvo.calculaDano(getDano());
  }


  @Override
  public void defender(Personagem alvo) {
    System.out.println(getNome() + " se defendeu contra " + alvo.getNome() + "! Dano foi reduzido.");
  }


  @Override
  public void critico(Personagem alvo) {
    int danoCritico = getDano() * 2;
    System.out.println(getNome() + " realizou um ataque crítico em " + alvo.getNome() + "\n");
    alvo.calculaDano(danoCritico);
  }
}
