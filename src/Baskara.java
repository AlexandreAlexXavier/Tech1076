import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Baskara {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        float[] coeficiente = new float[3];
        boolean entradaCerta = true;
        int indice = 0;

        while((entradaCerta)&&(indice<3)) {
            System.out.println("Entre o " + (indice+1) + "º coeficiente da equação:");
            try {
                coeficiente[indice] = entrada.nextFloat();
            } catch (Exception e){
                System.out.println("Coeficiente inválido. Programa encerrado.");
                entradaCerta = false;
            }
            indice = indice + 1;
        }

        if (entradaCerta) {

            float delta = coeficiente[1]*coeficiente[1] - (4*coeficiente[0]*coeficiente[2]);

            if (delta>=0) {
                float raizDelta = (float) sqrt(delta);
                float raiz1 = (-coeficiente[1] + raizDelta) / (2 * coeficiente[0]);
                float raiz2 = (-coeficiente[1] - raizDelta) / (2 * coeficiente[0]);
                System.out.printf("As raízes da equação (%.2f)x² + (%.2f)x + (%.2f) são %.2f e %.2f.",
                        coeficiente[0], coeficiente[1], coeficiente[2], raiz1, raiz2);

            } else {
                System.out.printf("As raízes da equação (%.2f)x² + (%.2f)x + (%.2f) não são reais.",
                        coeficiente[0], coeficiente[1], coeficiente[2]);
            }
        }

    }
}
