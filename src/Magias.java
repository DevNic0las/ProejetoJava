public enum Magias {
    BOLADEFOGO;
    public void executarMagia( Personagem jogador, Personagem inimigo){
        switch (this){
            case BOLADEFOGO:
                Magia magia = new Magiafogo("Bola de fogo", 200);
                magia.usemagia(inimigo);
                break;
        }
    }
}
