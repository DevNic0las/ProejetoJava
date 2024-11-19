public abstract class Magia {
    private String nome;
    private int poder;
    public Magia(String nome, int poder){
        this.poder = poder;
        this.nome = nome;
    }
    public int getdano(){
        return this.poder;
    }
    public String getnome(){
        return this.nome;
    }
    public abstract void usemagia(Personagem alvo);
    public abstract void danoMagia(Personagem alvo);
}

