import java.util.Arrays;
import java.util.Scanner;

public class Bingo {

    static String[] EntrarNomesDeJogadores() {

        Scanner entrada = new Scanner(System.in);
        String[] nomes = entrada.nextLine().split("-");

        return nomes;
    }

    static int[][] GerarSequenciaDeNumeros(int quantidadeDeSequencias, int quantidadeNumerosDaSequencia,
                                         int valorMaximoDaSequencia) {

        int[][] sequenciaNumerica = new int[quantidadeDeSequencias][quantidadeNumerosDaSequencia];

        for (int i = 0; i < quantidadeDeSequencias; i++) {
            for (int j = 0; j < quantidadeNumerosDaSequencia; j++) {
                sequenciaNumerica[i][j] = (int) (Math.random() * valorMaximoDaSequencia);
            }
            Arrays.sort(sequenciaNumerica[i]);

            boolean SequenciaValida = (ValidarSequenciaNumerica(sequenciaNumerica[i]));
            if (!SequenciaValida) {
                i--;
            }
        }
        return sequenciaNumerica;
    }

    static boolean ValidarSequenciaNumerica(int[] sequencia) {

        boolean sequenciaValida = true;
        int i = 0;

        while (sequenciaValida && (i < sequencia.length - 1)) {
            if (sequencia[i] == sequencia[i + 1]) {
                sequenciaValida = false;
            }
            i++;
        }
        return sequenciaValida;
    }

    static int[] CriarListaDeNumeros(int valorMáximo) {

        int[] listaDeNumeros = new int[valorMáximo + 1];
        for (int i = 0; i <= valorMáximo; i++) {
            listaDeNumeros[i] = i;
        }
        return listaDeNumeros;
    }

    public static void main(String[] args) {

        System.out.println("Digite o nome d@s participantes (separe por -)");
        String[] nomesDeJogadores = EntrarNomesDeJogadores();

        int quantidadeDeNumerosPorCartela = 5;
        int valorMaximoNaCartela = 60;

        int[][] cartelasGeradas = GerarSequenciaDeNumeros(nomesDeJogadores.length,quantidadeDeNumerosPorCartela,
                valorMaximoNaCartela);

        for (int i = 0; i < nomesDeJogadores.length; i++) {
            System.out.printf(nomesDeJogadores[i].toUpperCase() + " " + Arrays.toString(cartelasGeradas[i]));
            System.out.println();
        }

        int[] saquinhoSorteio = CriarListaDeNumeros(valorMaximoNaCartela);

        for (int i = 0; i < saquinhoSorteio.length; i++) {
            System.out.printf(saquinhoSorteio[i] + " ");
        }
        System.out.println();
    }
}