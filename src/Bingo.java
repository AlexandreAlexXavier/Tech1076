import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.Integer.compare;
import static java.lang.Integer.valueOf;

public class Bingo {


    static void Abertura() throws IOException, InterruptedException {

        /*if (System.getProperty("os.name").contains("Windows"))
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();*/

        System.out.println();
        System.out.println("*******************************************************************");
        System.out.println("*******************************************************************");
        System.out.println("***************         e-BINGO 5.0 PLUS            ***************");
        System.out.println("*******************************************************************");
        System.out.println("*******************************************************************");
        System.out.println();
    }

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

    public static void main(String[] args) throws IOException, InterruptedException {

        Abertura();

        System.out.println("Digite o nome d@s participantes (separe por -):");
        String[] nomesDeJogadores = EntrarNomesDeJogadores();
        System.out.println();
        System.out.println("Geração de cartelas Manual ou Automática (M/A)?");
        Scanner entrada = new Scanner(System.in);
        String manualAutomatico = entrada.nextLine();


        int     quantidadeDeNumerosPorCartela   = 5;
        int     valorMaximoNaCartela            = 60;
        int     numeroDeJogadores               = nomesDeJogadores.length;
        int[][] numeroDeAcertos                 = new int[numeroDeJogadores][5];
        int[]   saquinhoDeSorteio               = CriarListaDeNumeros(valorMaximoNaCartela);
        int     numeroDePosicoes                = saquinhoDeSorteio.length;

        if (manualAutomatico.equalsIgnoreCase("A")){
            int[][] cartelasGeradas                 = GerarSequenciaDeNumeros(numeroDeJogadores,
                                                        quantidadeDeNumerosPorCartela,
                                                        valorMaximoNaCartela);

        } /* entrada de cartelas */

        for (int rodadaDoJogo = 1; rodadaDoJogo < 13; rodadaDoJogo++) {

            int[][] posicoesSorteadas = GerarSequenciaDeNumeros(1, quantidadeDeNumerosPorCartela,
                    numeroDePosicoes);
            int[]   numerosSorteados = new int[5];

            for (int i=0; i<5; i++) {
                numerosSorteados[i] = saquinhoDeSorteio[posicoesSorteadas[0][i]];
                }
            System.out.println();
            System.out.println("Rodada: " + rodadaDoJogo +
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
                System.out.printf("%-20s %-30s %-30s", nomesDeJogadores[i].toUpperCase(),
                        Arrays.toString(cartelasGeradas[i]),Arrays.toString(numeroDeAcertos[i]));
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

            int[]    totalPontos           = new int[numeroDeJogadores];
            String[] vencedoresDoBingo     = new String[numeroDeJogadores];
            boolean  alguemVenceu          = false;

            for (int d =0; d<numeroDeJogadores; d++){
                for (int e = 0; e<5; e++){
                    totalPontos[d] = totalPontos[d] + numeroDeAcertos[d][e];
                    if (totalPontos[d] == 5) {
                        alguemVenceu = true;
                        vencedoresDoBingo[d] = "venceu";
                    }else {
                        vencedoresDoBingo[d] = "";
                    }
                }
            }
            if (alguemVenceu){
                System.out.println();
                System.out.println("A partida foi vencida por: ");
                for(int i=0; i<numeroDeJogadores; i++){
                    if (!vencedoresDoBingo[i].isEmpty()) {
                        System.out.println(nomesDeJogadores[i].toUpperCase());
                    }
                }
                break;
            }
        }
    }
}