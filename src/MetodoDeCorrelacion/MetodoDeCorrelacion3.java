package MetodoDeCorrelacion;

public class MetodoDeCorrelacion3 {
    public static double calcularCorrelacion(double[] x, double[] y) {

        int concordant = 0, discordant = 0;
        int n = x.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((x[i] - x[j]) * (y[i] - y[j]) > 0) {
                    concordant++;
                } else if ((x[i] - x[j]) * (y[i] - y[j]) < 0) {
                    discordant++;
                }
            }
        }

        double correlation = (concordant - discordant) / Math.sqrt((concordant + discordant) * (n * (n - 1) / 2));
        return correlation;
    }

    public static void main(String[] args) {
        double[] x = {1, 2, 3, 4, 12};
        double[] y = {2, 4, 6, 8, 10};
        double correlation = calcularCorrelacion(x, y);
        System.out.println("Correlación Método 4: " + correlation);
    }
}
//ENTRADA
// double[] x = {1, 2, 3, 4, 12};
// double[] y = {2, 4, 6, 8, 10};