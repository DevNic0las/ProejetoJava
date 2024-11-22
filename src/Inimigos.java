public enum Inimigos {
  GOBLINS("Perigo: mínimo\n Dificuldade: Fácil\n Poder: Nenhum\n Armas: Espadas velhas");
  private final String goblins;

  Inimigos(String goblins) {
    this.goblins = goblins;
  }

  public String getInimigo() {
    return goblins;
  }
}

