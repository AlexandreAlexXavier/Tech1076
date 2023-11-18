import java.util.Scanner;

public class Solucao {
    public static double[] custosCarro( double[] input) {

        double[] saida = new double[2];
        saida[0] =(input[1] / input[0]) * 100;
        saida[1] =(input[2] / input[0]) * 100;

        return saida;
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Entre o preço final de fábrica, o valor do custo com o distribuidor " +
                "e o valor do preço dos impostos, separados por vírgula:");

        String[] valores = entrada.nextLine().split(" ");

        double[] valorCarro = new double[3];
        valorCarro[0] = Double.parseDouble(valores[0]);
        valorCarro[1] = Double.parseDouble(valores[1]);
        valorCarro[2] = Double.parseDouble(valores[2]);

        double[] resultado;
        resultado = custosCarro(valorCarro);
        System.out.print("Porcentagem: ");

        for (int i = 0; i < 2; i++) {
            System.out.printf(resultado[i] + " ");
        }

    }

}
