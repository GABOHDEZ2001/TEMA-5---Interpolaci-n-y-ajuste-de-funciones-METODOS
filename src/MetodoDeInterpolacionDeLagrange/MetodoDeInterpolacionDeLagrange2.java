package MetodoDeInterpolacionDeLagrange;

public class MetodoDeInterpolacionDeLagrange2 {
    // Método para calcular el polinomio de Lagrange
    public static double lagrange(double x, double[] xValues, double[] yValues) {
        double result = 0;
        for (int i = 0; i < xValues.length; i++) {
            double term = yValues[i];
            for (int j = 0; j < xValues.length; j++) {
                if (j != i) {
                    term *= (x - xValues[j]) / (xValues[i] - xValues[j]);
                }
            }
            result += term;
        }
        return result;
    }

    public static void main(String[] args) {
        double[] xValues = {1.0, 2.0, 3.0}; // Valores de x
        double[] yValues = {2.0, 4.0, 6.0}; // Valores de y

        double x = 2.5; // Punto a interpolar

        double interpolatedValue = lagrange(x, xValues, yValues);
        System.out.println("El valor interpolado en x = " + x + " es " + interpolatedValue);
    }
}

//ENTRADA
//1.0, 2.0, 3.0 // Valores de x
//2.0, 4.0, 6.0 // Valores de y

//SALIDA (RESULTADO)
//El valor interpolado en x = 2.5 es 5.0
