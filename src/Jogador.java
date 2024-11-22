public class Jogador extends Personagem {

  public Jogador(int vida, int dano, String nome) {
    super(vida, dano, nome);  // Passa os atributos para a classe pai
  }

  @Override
  public void atacar(Personagem alvo) {
    System.out.println(getNome() + " atacou " + alvo.getNome() + " causando " + getDano() + " de dano!");
    alvo.calculaDano(getDano());
  }

  @Override
  public void defender(Personagem alvo) {
    System.out.println(getNome() + " se defendeu contra " + alvo.getNome() + "! Dano foi reduzido.");
  }


  @Override
  public void critico(Personagem alvo) {
    int danoCritico = getDano() * 2; // Supondo que o crítico seja o dobro do dano
    System.out.println(getNome() + " realizou um ataque crítico em " + alvo.getNome() + ", causando " + danoCritico + " de dano!\n");
    alvo.calculaDano(danoCritico);
  }


}
