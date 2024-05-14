package MetodoDeRegresion;

public class MetodoDeRegresion4 {

    // Método para calcular el método de regresión lineal
    public static void regresionLineal(double[] x, double[] y) {
        int n = x.length;

        // Calcular sumas
        double sumX = 0, sumY = 0, sumXX = 0, sumXY = 0;
        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXX += x[i] * x[i];
            sumXY += x[i] * y[i];
        }

        // Calcular coeficientes de la línea de regresión (y = mx + b)
        double m = (n * sumXY - sumX * sumY) / (n * sumXX - sumX * sumX);
        double b = (sumY - m * sumX) / n;

        // Imprimir los resultados
        System.out.println("La línea de regresión es: y = " + m + "x + " + b);
    }

    // Método main para probar el método de regresión
    public static void main(String[] args) {
        // Datos de ejemplo
        double[] x = {-2, -1, 0, 1, 2};
        double[] y = {5, 2, 1, 3, 6};

        // Calcular regresión lineal
        regresionLineal(x, y);
    }
}

// Entrada
//double[] x = {-2, -1, 0, 1, 2};
//double[] y = {5, 2, 1, 3, 6};


//Salida (Resultado)
//La línea de regresión es: y = 0.3x + 3.4