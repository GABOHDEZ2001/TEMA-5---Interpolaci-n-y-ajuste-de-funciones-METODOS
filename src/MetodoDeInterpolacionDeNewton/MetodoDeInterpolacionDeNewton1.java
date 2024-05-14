package MetodoDeInterpolacionDeNewton;

import java.util.ArrayList;

public class MetodoDeInterpolacionDeNewton1 {
    // Implementación del Método de Interpolación de Newton con una única función

    public static double interpolacionNewton(double[] x, double[] y, double valor) {
        int n = x.length;
        double resultado = y[0];
        double[] f = new double[n];
        f[0] = resultado;

        // Calcula los coeficientes de Newton
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (i == 1) {
                    f[j] = (y[j + 1] - y[j]) / (x[j + i] - x[j]);
                } else {
                    f[j] = (f[j + 1] - f[j]) / (x[j + i] - x[j]);
                }
            }
            // Calcula el término de la interpolación
            resultado += f[0] * calcularProducto(valor, x, 0, i);
        }
        return resultado;
    }

    // Calcula el producto de (valor - xi) para los términos de la interpolación
    private static double calcularProducto(double valor, double[] x, int inicio, int fin) {
        double producto = 1.0;
        for (int i = inicio; i <= fin; i++) {
            producto *= (valor - x[i]);
        }
        return producto;
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
//Resultado: 1.75
