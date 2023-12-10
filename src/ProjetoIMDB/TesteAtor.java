package ProjetoIMDB;

import java.util.ArrayList;

public class TesteAtor {

    public static void main(String[] args) {

        Ator ator1 = new Ator("Thais Araujo");
        Ator ator2 = new Ator("Lazaro Ramos");

        OperacoesAtor operacoesAtor = new OperacoesAtor();

        operacoesAtor.inserirAtor(ator1);
        operacoesAtor.inserirAtor(ator2);

        ArrayList<Ator> atoresSalvos = operacoesAtor.getAtores();

        for(Ator item : atoresSalvos) {
            System.out.println("Ator salvo no banco de dados: " + item.getNome());
        }

    }
}
