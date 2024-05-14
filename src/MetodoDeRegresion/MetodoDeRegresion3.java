package MetodoDeRegresion;

public class MetodoDeRegresion3 {

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
        double[] x = {0.5, 1.0, 1.5, 2.0, 2.5};
        double[] y = {1.2, 2.3, 3.4, 4.5, 5.6};

        // Calcular regresión lineal
        regresionLineal(x, y);
    }
}

// Entrada
//double[] x = {0.5, 1.0, 1.5, 2.0, 2.5};
//double[] y = {1.2, 2.3, 3.4, 4.5, 5.6};


//Salida (Resultado)
//La línea de regresión es: y = 2.2x + 0.1
