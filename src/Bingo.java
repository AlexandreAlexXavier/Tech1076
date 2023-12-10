import java.util.Arrays;
import java.util.Scanner;

public class Bingo {

    static String[] EntrarNomeJogadores() {

        Scanner entrada = new Scanner(System.in);
        String[] nomes = entrada.nextLine().split("-");

        return nomes;
    }

    static int[][] GerarSequenciaNumeros(int numeroJogadores) {

        int[][] sequenciaNumeros = new int[numeroJogadores][5];

        for (int i = 0; i < numeroJogadores; i++) {
            for (int j = 0; j < 5; j++) {
                sequenciaNumeros[i][j] = (int) (Math.random() * 60);
            }
            Arrays.sort(sequenciaNumeros[i]);

            boolean SequenciaValida = (ValidarCartela(sequenciaNumeros[i]));
            if (!SequenciaValida) {
                i--;
            }
        }
        return sequenciaNumeros;
    }

    static boolean ValidarCartela(int[] cartela) {

        boolean cartelaValida = true;
        int i = 0;

        while (cartelaValida && (i < cartela.length - 1)) {
            if (cartela[i] == cartela[i + 1]) {
                cartelaValida = false;
            }
            i++;
        }
        return cartelaValida;
    }

    static int[] CriarListaNumeros(int valorMáximo) {

        int[] listaNumeros = new int[valorMáximo + 1];
        for (int i = 0; i <= valorMáximo; i++) {
            listaNumeros[i] = i;
        }
        return listaNumeros;
    }

    public static void main(String[] args) {

        System.out.println("Digite o nome d@s participantes (separe por -)");
        String[] nomesJogadores = EntrarNomeJogadores();

        int[][] numerosCartelas = GerarSequenciaNumeros(nomesJogadores.length);

        for (int i = 0; i < nomesJogadores.length; i++) {
            System.out.printf(nomesJogadores[i].toUpperCase() + " " + Arrays.toString(numerosCartelas[i]));
            System.out.println();
        }

        int[] saquinhoSorteio = CriarListaNumeros(60);

        for (int i = 0; i < saquinhoSorteio.length; i++) {
            System.out.printf(saquinhoSorteio[i] + " ");
        }
        System.out.println();
    }
}