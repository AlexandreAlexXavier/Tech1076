package ProjetoIMDB;

import java.util.ArrayList;

public class OperacoesAtor {

    private ArrayList<Ator> dbAtores;

    public OperacoesAtor() {
        this.dbAtores = new ArrayList<>();
    }
    public void inserirAtor(Ator ator) {
        this.dbAtores.add(ator);

    }
    public void removerAtor(Ator ator) {
        this.dbAtores.remove(ator);
    }
    public ArrayList<Ator> getAtores() {
        return this.dbAtores;
    }

}
