import java.util.ArrayList;
import java.util.List;

public class Fases {
  private List<FaseEstrutura> fases;

  public Fases() {
    fases = new ArrayList<>();
    comecarFases();
  }

  private void comecarFases() {
    fases.add(new FaseEstrutura("Nível 1", new Inimigo(200, 75, "Besta de 3 cabeças"), true, false));
    fases.add(new FaseEstrutura("Nível 2", new Inimigo(300, 80, "Dragão de Fogo"), true, true));
    fases.add(new FaseEstrutura("Nível 3", new Inimigo(400, 90, "Lich do Caos"), false, true));
  }

  public FaseEstrutura getFase(int indice) {
    return fases.get(indice);
  }

  public int getQuantidadeDeFases() {
    return fases.size();
  }
}
