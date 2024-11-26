public class Jogador extends Personagem {

  public Jogador(int vida, int dano, String nome) {
    super(vida, dano, nome);
  }

  @Override
  public void atacar(Personagem alvoAtaque) {
    System.out.println(getNome() + " atacou " + alvoAtaque.getNome() + " causando " + getDano() + " de dano!");
    alvoAtaque.calculaDano(getDano());
  }

  @Override
  public void defender(Personagem alvo) {
    System.out.println(getNome() + " se defendeu contra " + alvo.getNome() + "! Dano foi reduzido.");
  }


  @Override
  public void critico(Personagem alvo) {
    int danoCritico = getDano() * 2;
    System.out.println(getNome() + " realizou um ataque crítico em  " + alvo.getNome() + ", causando " + danoCritico + " de dano!\n");
    alvo.calculaDano(danoCritico);
  }


}
