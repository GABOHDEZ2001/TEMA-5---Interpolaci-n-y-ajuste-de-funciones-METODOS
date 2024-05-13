package MetodoDeCorrelacion;

public class MetodoDeCorrelacion1 {

    public static void main(String[] args) {
        // Datos de ejemplo
        double[] x = {1, 2, 3, 4};
        double[] y = {2, 4, 6, 8};

        // Calcular la correlación
        double correlation = calculateCorrelation(x, y);

        // Imprimir el resultado
        System.out.println("Correlación: " + correlation);
    }

    // Método para calcular la correlación entre dos arrays
    public static double calculateCorrelation(double[] x, double[] y) {
        // Verificar si los dos arrays tienen la misma longitud
        if (x.length != y.length) {
            throw new IllegalArgumentException("Los arrays deben tener la misma longitud");
        }

        // Calcular la media de x e y
        double meanX = calculateMean(x);
        double meanY = calculateMean(y);

        // Calcular el numerador de la correlación
        double numerator = 0;
        for (int i = 0; i < x.length; i++) {
            numerator += (x[i] - meanX) * (y[i] - meanY);
        }

        // Calcular el denominador de la correlación
        double denominatorX = 0;
        double denominatorY = 0;
        for (int i = 0; i < x.length; i++) {
            denominatorX += Math.pow(x[i] - meanX, 2);
            denominatorY += Math.pow(y[i] - meanY, 2);
        }

        // Calcular la correlación
        double correlation;
        if (denominatorX == 0 || denominatorY == 0) {
            correlation = 0; // Si uno de los denominadores es 0, la correlación es 0
        } else {
            correlation = numerator / (Math.sqrt(denominatorX) * Math.sqrt(denominatorY));
        }

        return correlation;
    }

    // Método para calcular la media de un array de números
    public static double calculateMean(double[] array) {
        double sum = 0;
        for (double num : array) {
            sum += num;
        }
        return sum / array.length;
    }
}
