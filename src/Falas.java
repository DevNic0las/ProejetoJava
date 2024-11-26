public enum Falas {
  FRASE_INICIAL("""
          Vamos as regras e como jogar:
          \s
          Você podera escolher suas jogadas, mas não o sucesso delas.
          \s
          Isso será definido pelo dado de 10 lados, cujo qual, irá julgar se sua jogada irá ter êxito ou não.
          \s
          Você podera atacar, defender e usar magia. A cada nível, as criaturas contém habilidades distintas.
          
          SOBRE O DADO:
          
          Jogadas acimas de 8 terá efeito critíco para o inimigo (Dano critico é caracterizado pelo dobro de dano).
          
          Valores iguais a 1 o inimigo dará dano critico ao jogador.
          
          Valores iguais ou maiores que 6 e menores ou igauis a 7 terão ações bem sucedidas. (Dano ou defesa padrão)
          
          Valores como: 3,4 e 5 o jogador perde a vez"""),


  TUTORIAL("""
          
          VAMOS PARA O TUTORIAL PARA VOCÊ SE FAMILIARIZAR:
          
          Tutorial: No caminho, você se depara com uma guangue de globins, e terá que enfrentá-los...
          Escolha uma das opções para continuar, ao escolher, o dado será lançado automaticamente.""");



  private final String texto;


  Falas(String texto) {
    this.texto = texto;
  }


  public String getTexto() {
    return texto;
  }
}
