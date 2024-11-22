public enum Destino {
  ATACAR,
  DEFENDER,
  HABILIDADE_ESPECIAL,
  INIMIGO_ATACA,
  ATAQUE_CRITICO,
  INIMIGO_DEFENDE,
  HABILIDADE_ESPECIAL_INIMIGO;

  public void executarAcao(Personagem jogador, Personagem inimigo) {
    switch (this) {

      case ATAQUE_CRITICO:
        System.out.println("recebeu um dano critico");
        break;
      case INIMIGO_ATACA:
        inimigo.atacar(jogador);
        break;
      case INIMIGO_DEFENDE:
        System.out.println("Inimigo se esquivou");
        break;
      case ATACAR:
        jogador.atacar(inimigo);
        break;
      case DEFENDER:
        jogador.defender(inimigo);
        break;
      case HABILIDADE_ESPECIAL:
        System.out.println("Magia sendo utilizada:");
        break;
      case HABILIDADE_ESPECIAL_INIMIGO:
        System.out.println("Magia sendo utilizada:");
        break;
    }
  }
  }
