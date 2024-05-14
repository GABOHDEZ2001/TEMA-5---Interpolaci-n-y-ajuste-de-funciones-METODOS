package MetodoDeInterpolacionDeNewton;

import java.util.ArrayList;

public class MetodoDeInterpolacionDeNewton3 {
    // Implementación del Método de Interpolación de Newton con listas en lugar de arrays

    public static double interpolacionNewton(ArrayList<Double> x, ArrayList<Double> y, double valor) {
        int n = x.size();
        double resultado = y.get(0);
        ArrayList<Double> f = new ArrayList<>();
        f.add(resultado);

        // Calcula los coeficientes de Newton
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (i == 1) {
                    f.add((y.get(j + 1) - y.get(j)) / (x.get(j + 1) - x.get(j)));
                } else {
                    f.set(j, (f.get(j + 1) - f.get(j)) / (x.get(j + i) - x.get(j)));
                }
            }
            // Calcula el término de la interpolación
            double terminoInterpolacion = f.get(0);
            for (int k = 0; k < i; k++) {
                terminoInterpolacion *= (valor - x.get(k));
            }
            resultado += terminoInterpolacion;
        }
        return resultado;
    }

    public static void main(String[] args) {
        ArrayList<Double> x = new ArrayList<>();
        x.add(0.0);
        x.add(1.0);
        x.add(2.0);
        x.add(3.0);

        ArrayList<Double> y = new ArrayList<>();
        y.add(1.0);
        y.add(2.0);
        y.add(3.0);
        y.add(4.0);

        double valor = 1.5;

        double resultado = interpolacionNewton(x, y, valor);
        System.out.println("Resultado: " + resultado);
    }
}
// Entrada
//  ArrayList<Double> x = new ArrayList<>();
//        x.add(0.0);
//        x.add(1.0);
//        x.add(2.0);
//        x.add(3.0);
//
//        ArrayList<Double> y = new ArrayList<>();
//        y.add(1.0);
//        y.add(2.0);
//        y.add(3.0);
//        y.add(4.0);

// Salida (Resultado)
//Resultado: 2.5