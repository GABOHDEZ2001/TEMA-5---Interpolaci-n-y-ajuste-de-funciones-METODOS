package MetodoDeMinimosCuadros;

public class MetodoDeMinimosCuadros4 {
    public static double calcular(double[] x, double[] y) {
        if (x.length != y.length || x.length == 0) {
            throw new IllegalArgumentException("Las matrices 'x' y 'y' deben tener la misma longitud y no estar vacías.");
        }

        int n = x.length;
        double sumX = 0, sumY = 0, sumXY = 0, sumXSquare = 0;

        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumXSquare += x[i] * x[i];
        }

        double m = (n * sumXY - sumX * sumY) / (n * sumXSquare - sumX * sumX);
        double b = (sumY - m * sumX) / n;

        return b;
    }

    public static void main(String[] args) {
        double[] x = {1, 2, 3, 4, 5};
        double[] y = {2, 3, 4, 5, 6};
        System.out.println("El valor de 'b' es: " + calcular(x, y));
    }
}

//Entrada
// double[] x = {1, 2, 3, 4, 5};
// double[] y = {2, 3, 4, 5, 6};

//Salida (Resultado)
//El valor de 'b' es: 1.0
