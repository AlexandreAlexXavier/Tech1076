import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.Integer.compare;
import static java.lang.Integer.valueOf;

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

        int[][] cartelasGeradas = GerarSequenciaDeNumeros(numeroDeJogadores, quantidadeDeNumerosPorCartela,
                valorMaximoNaCartela);

        /*for (int i = 0; i < nomesDeJogadores.length; i++) {
            System.out.printf(nomesDeJogadores[i].toUpperCase() + " " + Arrays.toString(cartelasGeradas[i]));
            System.out.println();
        }*/

        int[] saquinhoDeSorteio = CriarListaDeNumeros(valorMaximoNaCartela);
        System.out.println(Arrays.toString(saquinhoDeSorteio));
        System.out.println();

        int[][] numeroDeAcertos = new int[numeroDeJogadores][5];
        int numeroDePosicoes = saquinhoDeSorteio.length;


        for (int round = 1; round < 13; round++) {

            int[][] posicoesSorteadas = GerarSequenciaDeNumeros(1, quantidadeDeNumerosPorCartela,
                    numeroDePosicoes);
            int[]   numerosSorteados = new int[5];

            for (int i=0; i<5; i++) {
                numerosSorteados[i] = saquinhoDeSorteio[posicoesSorteadas[0][i]];
                }
            System.out.println();
            System.out.println("Round: " + round +
                                " Números sorteados: " + Arrays.toString(numerosSorteados));
            System.out.println();

            for (int a = 0; a < numeroDeJogadores; a++) {
                for (int b=0; b<5; b++){
                    for (int c=0; c<5; c++) {
                        if (numerosSorteados[b] == cartelasGeradas[a][c]) {
                            numeroDeAcertos[a][c] = 1;
                        }
                    }
                }
            }

            for (int i = 0; i < numeroDeJogadores; i++) {
                System.out.printf(nomesDeJogadores[i].toUpperCase() +
                        " " + Arrays.toString(cartelasGeradas[i]) +
                        " " + Arrays.toString(numeroDeAcertos[i]));
                System.out.println();
            }
            int numeroDePosicoesAux = numeroDePosicoes;
            numeroDePosicoes = numeroDePosicoes - 5;

            int[] saquinhoAuxiliar = new int[numeroDePosicoes];
            int j = 0;
            int k = 0;

            for (int i = 0; i < numeroDePosicoesAux; i++) {
                if (j < 5 && i == posicoesSorteadas[0][j]) {
                    j++;
                } else {
                    saquinhoAuxiliar[k] = saquinhoDeSorteio[i];
                    k++;
                }

            }
            for (int i = 0; i < numeroDePosicoes; i++) {
                saquinhoDeSorteio[i] = saquinhoAuxiliar[i];
            }

            numeroDePosicoes = saquinhoAuxiliar.length;

            /*
            System.out.println(Arrays.toString(saquinhoDeSorteio));
            System.out.println(Arrays.toString(saquinhoAuxiliar));
            System.out.println();
            */

            int[] total = new int[numeroDeJogadores];
            boolean alguemVenceu = false;

            for (int d =0; d<numeroDeJogadores; d++){
                for (int e = 0; e<5; e++){
                    total[d] = total[d] + numeroDeAcertos[d][e];
                    if (total[d] == 5) {
                        alguemVenceu = true;
                    }

                }
            }
            if (alguemVenceu){
                System.out.println("Alguem venceu");
                break;
            }
        }
    }
}