import java.text.DecimalFormat;
import java.util.Arrays;

public class Descontos {

        public static String geraRecibo(double[] input) {

            Arrays.sort(input);

            double valorFinal = 0.0;
            double desconto = input[0]*0.5;

            for(int i=0; i< input.length; i++) {
                valorFinal = valorFinal + input[i];
            }

            DecimalFormat formatter = new DecimalFormat("#0.00");
            String valorFinalFormat = (formatter.format(valorFinal));
            String descontoFormat   = (formatter.format(desconto));
            String valorPagarFormat = (formatter.format(valorFinal-desconto));

            return "Valor total: " + valorFinalFormat + " | Valor de descontos: " + descontoFormat +
                    " | Valor a pagar: " + valorPagarFormat;
        }

    public static void main(String[] args) {

        double[] valores;
        valores = new double[] {20.0,80.0,60.0,40.0};
        System.out.println(geraRecibo(valores));

    }
}
