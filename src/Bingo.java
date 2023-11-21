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

            boolean SequenciaValida = (ValidarSequenciaDeNumeros(sequenciaNumerica[i]));
            if (!SequenciaValida) {
                i--;
            }
        }
        return sequenciaNumerica;
    }

    static boolean ValidarSequenciaDeNumeros(int[] sequencia) {

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
        int numeroDeJogadores = nomesDeJogadores.length;

        int[][] cartelasGeradas = GerarSequenciaDeNumeros(numeroDeJogadores,quantidadeDeNumerosPorCartela,
                valorMaximoNaCartela);

        for (int i = 0; i < nomesDeJogadores.length; i++) {
            System.out.printf(nomesDeJogadores[i].toUpperCase() + " " + Arrays.toString(cartelasGeradas[i]));
            System.out.println();
        }

        int[] saquinhoDeSorteio = CriarListaDeNumeros(valorMaximoNaCartela);
        int[][] numerosSorteados = GerarSequenciaDeNumeros(1,quantidadeDeNumerosPorCartela,
                valorMaximoNaCartela);

        System.out.println(Arrays.toString(saquinhoDeSorteio));
        System.out.println();
        System.out.println(Arrays.toString(numerosSorteados[0]));
        System.out.println();


        int[] saquinhoAuxiliar = new int[55];
        int j=0;
        int k=0;

        for ( int i = 0;i < saquinhoDeSorteio.length-1; i++) {
            if (j<5 && i == numerosSorteados[0][j]) {
                j++;
            } else {
                saquinhoAuxiliar[k] = saquinhoDeSorteio[i];
                k++;
            }

        }


        System.out.println(Arrays.toString(saquinhoAuxiliar));
    }
}