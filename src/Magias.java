public enum Magias {
  BOLADEFOGO,
  CURA;

  public void executarMagia(Personagem jogador, Personagem inimigo) {
    switch (this) {
      case BOLADEFOGO:
        Magia magia = new Magiafogo("Bola de fogo", 200);
        magia.usar(jogador, inimigo);
        break;

      case CURA:
        Magia cura = new MagiaCura("Cura", 0, 1.2f);
        cura.usar(jogador, jogador);
        break;
    }
  }
}
