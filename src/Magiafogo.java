public class Magiafogo extends Magia {
    public Magiafogo(String nome, int poder) {
        super(nome, poder);
    }

    @Override
    public void danoMagia(Personagem alvo) {
        System.out.println("Lançando " + getnome() + " com poder de " + getdano());
        alvo.calculaDano(getdano());  // Aplica o dano no alvo
    }

    @Override
    public void usemagia(Personagem alvo) {
        System.out.println(getnome() + " é lançado em " + alvo.getNome());
        danoMagia(alvo);  //o this passa o objeto da magia para a função danoMagia.
    }
}
