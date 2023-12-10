package ProjetoIMDB;

import java.util.ArrayList;

public class OperacoesFilme {

    private ArrayList<Filme> dbFilmes;

    public OperacoesFilme() {
        this.dbFilmes = new ArrayList<>();
    }
    public void inserirFilme(Filme filme) {
        this.dbFilmes.add(filme);
    }
    public void removerFilme(Filme filme) {
        this.dbFilmes.remove(filme);
    }
    public ArrayList<Filme> getFilmes() {
        return this.dbFilmes;
    }

}
