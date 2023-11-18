import java.util.Scanner;

public class EhTriangulo {
    public static boolean eUmTriangulo(int[] input) {

        int[] lados = new int[3];
        lados = input;
        boolean teste = ((lados[0]+lados[1])>lados[2]) && ((lados[0] + lados[2]) > lados[1])
                && ((lados[1] + lados[2]) > lados[0]);
        if (teste) {
            return true;
        } else {
            return false;
        }

    }
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Entre os lados de um triângulo separados por vírgula:");

        String[] valores = entrada.nextLine().split(" ");

        int[] valorLado = new int[3];
        valorLado[0] = Integer.parseInt(valores[0]);
        valorLado[1] = Integer.parseInt(valores[1]);
        valorLado[2] = Integer.parseInt(valores[2]);


        boolean resultado = eUmTriangulo(valorLado);

        if (resultado) {
            System.out.print("É um triângulo.");
        } else {
            System.out.print("Não é um triângulo.");
        }
    }
}

