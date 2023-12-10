package ProjetoIMDB;

import java.util.ArrayList;

public class TesteDiretor {

    public static void main(String[] args) {

        Diretor diretor1 = new Diretor("Ava DuVernay");
        Diretor diretor2 = new Diretor("Spike Lee");

        OperacoesDiretor operacoesDiretor = new OperacoesDiretor();

        operacoesDiretor.inserirDiretor(diretor1);
        operacoesDiretor.inserirDiretor(diretor2);

        ArrayList<Diretor> diretoresSalvos = operacoesDiretor.getDbDiretores();

        for(Diretor item : diretoresSalvos) {
            System.out.println("Diretor salvo no banco de dados: " + item.getNome());
        }

    }
}
