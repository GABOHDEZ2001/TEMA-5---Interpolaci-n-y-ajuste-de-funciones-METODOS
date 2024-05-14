package MetodoDeCorrelacion;

public class MetodoDeCorrelacion2 {
    public static double calcularCorrelacion(double[] x, double[] y) {

        // Aquí puedes implementar otro método de correlación

        double sumX = 0.0, sumY = 0.0, sumXY = 0.0, sumXSquare = 0.0, sumYSquare = 0.0;

        int n = x.length;
        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumXSquare += x[i] * x[i];
            sumYSquare += y[i] * y[i];
        }

        double correlation = (n * sumXY - sumX * sumY) /
                Math.sqrt((n * sumXSquare - sumX * sumX) * (n * sumYSquare - sumY * sumY));

        return correlation;
    }

    public static void main(String[] args) {
        double[] x = {2, 3, 4, 5, 6};
        double[] y = {4, 6, 8, 10, 12};
        double correlation = calcularCorrelacion(x, y);
        System.out.println("Correlación Método 2: " + correlation);
    }
}

//ENTRADA
//double[] x = {2, 3, 4, 5, 6};
//  double[] y = {4, 6, 8, 10, 12};