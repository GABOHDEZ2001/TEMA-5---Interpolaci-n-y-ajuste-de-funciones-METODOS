package MetodoDeMinimosCuadros;

import java.util.stream.IntStream;

public class MetodoDeMinimosCuadros3 {
    public static double calcular(double[] x, double[] y) {
        if (x.length != y.length || x.length == 0) {
            throw new IllegalArgumentException("Las matrices 'x' y 'y' deben tener la misma longitud y no estar vacías.");
        }

        int n = x.length;
        double sumX = IntStream.range(0, n).mapToDouble(i -> x[i]).sum();
        double sumY = IntStream.range(0, n).mapToDouble(i -> y[i]).sum();
        double sumXY = IntStream.range(0, n).mapToDouble(i -> x[i] * y[i]).sum();
        double sumXSquare = IntStream.range(0, n).mapToDouble(i -> x[i] * x[i]).sum();

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