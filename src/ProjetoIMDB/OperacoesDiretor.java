package ProjetoIMDB;

import java.util.ArrayList;

public class OperacoesDiretor {
    private ArrayList<Diretor> dbDiretores;

    public OperacoesDiretor() {
        this.dbDiretores = new ArrayList<>();
    }
    public void inserirDiretor(Diretor diretor) {
        dbDiretores.add(diretor);
    }
    public void removerDiretor(Diretor diretor) {
        this.dbDiretores.remove(diretor);
    }
    public ArrayList<Diretor> getDbDiretores() {
        return this.dbDiretores;
    }

}
