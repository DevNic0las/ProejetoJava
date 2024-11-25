public enum Falas {
  FRASE_INICIAL("Vamos as regras e como jogar:\n \nVocê podera escolher suas jogadas, mas não o sucesso delas.\n" +
          " \nIsso será definido pelo dado de 10 lados, cujo qual, irá julgar se sua jogada irá ter exito ou não.\n" +
          " \nVocê podera atacar, defender e usar magia. A cada nível, as criaturas contém habilidades distintas.\n" +
          "\nSOBRE O DADO:\n" +
          "\nJogadas acimas de 8 terá efeito critíco para o jogador (Dano critico é caracterizado pelo dobro de dano).\n" +
          "\nValores iguais a 1 o inimigo dará dano critino ao jogador.\n" +
          "\nValores iguais ou maiores que 6 e menores ou igauis a 7 terão ações bem sucedidas. (Dano ou defesas padrão)\n" +
          "\nValores como: 3,4 e 5 o jogador perde a vez"),


  TUTORIAL("\nVAMOS PARA O TUTORIAL PARA VOCÊ SE FAMILIARIZAR:\n" +
          "\nTutorial: No caminho, você se depara com uma guangue de globins, e terá que enfrentá-los...\n" +
          "Escolha uma das opções para continuar, ao escolher, o dado será lançado automaticamente."),

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
