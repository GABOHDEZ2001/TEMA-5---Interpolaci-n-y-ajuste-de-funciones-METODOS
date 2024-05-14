package MetodoDeCorrelacion;

public class MetodoDeCorrelacion1 {
    public static double calcularCorrelacion(double[] x, double[] y) {
        if (x.length != y.length) {
            throw new IllegalArgumentException("Los vectores deben tener la misma longitud");
        }

        double sumXY = 0.0;
        double sumX = 0.0;
        double sumY = 0.0;
        double sumXSquared = 0.0;
        double sumYSquared = 0.0;
        int n = x.length;

        for (int i = 0; i < n; i++) {
            sumXY += x[i] * y[i];
            sumX += x[i];
            sumY += y[i];
            sumXSquared += x[i] * x[i];
            sumYSquared += y[i] * y[i];
        }

        double correlation = (n * sumXY - sumX * sumY) /
                Math.sqrt((n * sumXSquared - sumX * sumX) *
                        (n * sumYSquared - sumY * sumY));

        return correlation;
    }

    public static void main(String[] args) {
        double[] x = {1, 2, 3, 4, 5};
        double[] y = {2, 4, 6, 8, 10};
        double correlation = calcularCorrelacion(x, y);
        System.out.println("Correlación: " + correlation);
    }
}
//ENTRADA
//double[] x = {1, 2, 3, 4, 5};
//double[] y = {2, 4, 6, 8, 10};

