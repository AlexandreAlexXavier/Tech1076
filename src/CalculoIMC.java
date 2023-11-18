import java.util.Scanner;

public class CalculoIMC {

        public static void main(String[] args) {

            Scanner entrada = new Scanner(System.in);

            System.out.println("Entre a altura e o peso separados por espaço:");
            String[] valores = entrada.nextLine().split(" ");
            float valorAltura = Float.parseFloat(valores[0]);
            float valorPeso = Float.parseFloat(valores[1]);

            String classificacao = null;
            final float IMC_IDEAL = 24.9f;
            float imc = valorPeso / (valorAltura*valorAltura);
            float pesoIdeal = valorAltura * valorAltura * IMC_IDEAL;

            if (imc < 18.5) {
                classificacao = "Magreza";
            } else if (imc >= 18.5 && imc <= 24.9) {
                classificacao = "Normal";
            } else if (imc > 24.9 && imc <= 30) {
                classificacao = "Sobrepeso";
            } else if (imc > 30) {
                classificacao = "Obesidade";
            }

            System.out.println("Resultado:");
            System.out.printf("O seu IMC é: %.2f kg/m² \n", imc);
            System.out.printf("A sua classificação é: %s \n", classificacao);
            System.out.printf("O seu peso ideal é: %.2f\n", pesoIdeal);
        }
}
