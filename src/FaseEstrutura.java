public class FaseEstrutura {
  private String nome;
  private Inimigo inimigo;
  private boolean curaPermitida;
  private boolean usomagiaRoubada;

  public FaseEstrutura(String nome, Inimigo inimigo, boolean curaPermitida, boolean usomagiaRoubada) {
    this.nome = nome;
    this.inimigo = inimigo;
    this.curaPermitida = curaPermitida;
    this.usomagiaRoubada = usomagiaRoubada;
  }

  public String getNome() {
    return nome;
  }

  public Inimigo getInimigo() {
    return inimigo;
  }

  public boolean isCuraPermitida() {
    return curaPermitida;
  }

  public boolean isUsomagia() {
    return usomagiaRoubada;
  }
}
