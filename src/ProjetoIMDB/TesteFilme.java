package ProjetoIMDB;

import java.util.ArrayList;
import java.util.Arrays;

public class TesteFilme {
    public static void main(String[] args) {

        String[] diretorFilme1 = {"Alex","Marsha"};
        String[] diretorFilme2 = {"Kafka","Relaz"};


        String[] atoresFilme1 = {"Marcia","Gabriel","Fernando"};
        String[] atoresFilme2 = {"Sandra", "Maria", "Dirce"};


        Filme filme1 = new Filme("Corra","Terror","inglês",diretorFilme1,"2010",atoresFilme1);
        Filme filme2 = new Filme("Spike Lee","drama","português",diretorFilme2,"2019",atoresFilme2);

        OperacoesFilme operacoesFilme = new OperacoesFilme();

        operacoesFilme.inserirFilme(filme1);
        operacoesFilme.inserirFilme(filme2);

        ArrayList<Filme> filmesSalvos = operacoesFilme.getFilmes();

        for(Filme item : filmesSalvos) {
            System.out.println("Filme salvo no banco de dados: " + item.getTitulo() + " Diretor:" +
                    Arrays.toString(item.getDiretor()));
        }

    }
}
