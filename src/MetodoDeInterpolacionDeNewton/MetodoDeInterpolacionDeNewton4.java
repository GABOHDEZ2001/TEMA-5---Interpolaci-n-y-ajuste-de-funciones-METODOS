package MetodoDeInterpolacionDeNewton;

import java.util.ArrayList;

public class MetodoDeInterpolacionDeNewton4 {
    // Implementación del Método de Interpolación de Newton con coeficientes precalculados

    public static double interpolacionNewton(double[] x, double[] y, double valor) {
        int n = x.length;
        double[] coeficientes = precalcularCoeficientes(x, y);

        double resultado = coeficientes[0];
        double producto = 1.0;

        // Calcula la interpolación utilizando los coeficientes precalculados
        for (int i = 1; i < n; i++) {
            producto *= (valor - x[i - 1]);
            resultado += coeficientes[i] * producto;
        }

        return resultado;
    }

    // Precalcula los coeficientes de Newton
    private static double[] precalcularCoeficientes(double[] x, double[] y) {
        int n = x.length;
        double[][] tablaDiferenciasDivididas = new double[n][n];
        double[] coeficientes = new double[n];

        // Calcula las diferencias divididas
        for (int i = 0; i < n; i++) {
            tablaDiferenciasDivididas[i][0] = y[i];
        }

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                tablaDiferenciasDivididas[i][j] = (tablaDiferenciasDivididas[i + 1][j - 1] - tablaDiferenciasDivididas[i][j - 1]) / (x[i + j] - x[i]);
            }
        }

        // Obtiene los coeficientes de Newton
        for (int i = 0; i < n; i++) {
            coeficientes[i] = tablaDiferenciasDivididas[0][i];
        }

        return coeficientes;
    }

    public static void main(String[] args) {
        double[] x = {0.0, 1.0, 2.0, 3.0};
        double[] y = {1.0, 2.0, 3.0, 4.0};
        double valor = 1.5;

        double resultado = interpolacionNewton(x, y, valor);
        System.out.println("Resultado: " + resultado);
    }
}
// Entrada
//double[] x = {0.0, 1.0, 2.0, 3.0};
//double[] y = {1.0, 2.0, 3.0, 4.0};

// Salida (Resultado)
//Resultado: 2.5