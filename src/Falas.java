public enum Falas {
  FRASE_INICIAL("Bem vindo, Forasteiro. Aqui está as regras:\n Sobre: Você terá que chegar ao topo da torre\n" +
          "suas ações serão ditas por um simples dado de 10 lados, não se preocupe, não é viciado. Enquanto maior o \n" +
          "numero que será tirado, as coisas irão facilitar pra você, caso não, as coisas irão se complicar.\n" +
          "vamo as regras:"),
  TUTORIAL("Tutorial: No caminho, você se depara com uma guangue de globins, e terá que enfrentá-los...\n" +
          "Seus ataques e defesas serão definidos quando jogar o dado, números baixos significam condicões não muito " +
          "boas pra voce, então estará a merce da sorte... Boa sorte.\n"),
  FASE_1("Primeira fase:\nVocê entra na torre e no terreo, encontra uma besta de 3 cabeças \n" +
          " vida:200\n poder mágico:Regeneração\n Dano:75");


  private final String texto;


  Falas(String texto) {
    this.texto = texto;
  }


  public String getTexto() {
    return texto;
  }
}
