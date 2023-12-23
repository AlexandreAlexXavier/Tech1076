package ProjetoIMDB;

import java.util.ArrayList;
import java.util.List;

class Filme {
    String nome;
    String dataLancamento;
    double orcamento;
    String descricao;
    Diretor diretor;
    List<Ator> atores;

    public Filme(String nome, String dataLancamento, double orcamento, String descricao, Diretor diretor) {
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.orcamento = orcamento;
        this.descricao = descricao;
        this.diretor = diretor;
        this.atores = new ArrayList<>();
    }

    public void adicionarAtor(Ator ator) {

        atores.add(ator);
    }
}
