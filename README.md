# T5---E2---Problemario
Desarrolla ejercicios que involucran cálculos numéricos para solución de problemas de interpolación

# MetodosNumericosTema3Problemario

### Gabriel Hernández Zaavala



## Método De Interpolación De Lagrange.
### Descripcion 

El método de interpolación de Lagrange es una técnica matemática utilizada para encontrar un polinomio que pase exactamente por un conjunto dado de puntos. Este método es especialmente útil cuando se tiene un conjunto de datos discretos y se desea construir un polinomio que los describa de manera precisa. 
trapecio para calcular el área bajo la curva.

### Pseudocódigo 
```
// Definir el procedimiento principal
Inicio
    // Definir los valores de x y y
    xValues <- [1.0, 3.0]
    yValues <- [2.0, 4.0]

    // Definir el punto a interpolar
    x <- 2.0

    // Llamar a la función lagrange para obtener el valor interpolado
    interpolatedValue <- lagrange(x, xValues, yValues)

    // Mostrar el valor interpolado
    Imprimir "El valor interpolado en x = " + x + " es " + interpolatedValue
Fin

// Definir la función lagrange que calcula el polinomio de Lagrange
Función lagrange(x, xValues, yValues) Devuelve Real
    // Inicializar el resultado
    resultado <- 0

    // Iterar sobre los valores de xValues
    Para i desde 0 hasta longitud(xValues) - 1 hacer
        // Inicializar el término de Lagrange para el i-ésimo valor
        término <- yValues[i]

        // Calcular el término de Lagrange
        Para j desde 0 hasta longitud(xValues) - 1 hacer
            Si j != i entonces
                término <- término * (x - xValues[j]) / (xValues[i] - xValues[j])
            FinSi
        FinPara

        // Sumar el término al resultado
        resultado <- resultado + término
    FinPara

    // Devolver el resultado final
    Devolver resultado
FinFunción

```


### Implementacion 
- Implementacion en Python

```
  def lagrange(x, x_values, y_values):
    result = 0
    for i in range(len(x_values)):
        term = y_values[i]
        for j in range(len(x_values)):
            if j != i:
                term *= (x - x_values[j]) / (x_values[i] - x_values[j])
        result += term
    return result

def main():
    x_values = [1.0, 3.0]  # Valores de x
    y_values = [2.0, 4.0]  # Valores de y

    x = 2.0  # Punto a interpolar

    interpolated_value = lagrange(x, x_values, y_values)
    print(f"El valor interpolado en x = {x} es {interpolated_value}")

if __name__ == "__main__":
    main()



```


### Ejercicios en java

[Ejemplo 1](https://github.com/GABOHDEZ2001/TEMA-5---Interpolacion-y-ajuste-de-funciones-METODOS/blob/master/src/MetodoDeInterpolacionDeLagrange/MetodoDeInterpolacionDeLagrange1.java)

[Ejemplo 2](https://github.com/GABOHDEZ2001/TEMA-5---Interpolacion-y-ajuste-de-funciones-METODOS/blob/master/src/MetodoDeInterpolacionDeLagrange/MetodoDeInterpolacionDeLagrange2.java)

[Ejemplo 3](https://github.com/GABOHDEZ2001/TEMA-5---Interpolacion-y-ajuste-de-funciones-METODOS/blob/master/src/MetodoDeInterpolacionDeLagrange/MetodoDeInterpolacionDeLagrange3.java)

[Ejemplo 4](https://github.com/GABOHDEZ2001/TEMA-5---Interpolacion-y-ajuste-de-funciones-METODOS/blob/master/src/MetodoDeInterpolacionDeLagrange/MetodoDeInterpolacionDeLagrange4.java)



======================================================================================


## Método De Interpolación De Newton.
### Descripcion 

El método de interpolación de Newton es otra técnica ampliamente utilizada para encontrar un polinomio que pase exactamente por un conjunto de puntos dados. Este método es especialmente útil debido a su eficiencia en la construcción y actualización del polinomio cuando se añaden nuevos puntos de datos. 
### Pseudocódigo 
```
// Definir el procedimiento principal
Inicio
    // Definir los valores de x y y
    x <- [0.0, 1.0, 2.0, 3.0]
    y <- [1.0, 2.0, 3.0, 4.0]
    
    // Definir el valor a interpolar
    valor <- 1.5
    
    // Llamar a la función interpolacionNewton para obtener el valor interpolado
    resultado <- interpolacionNewton(x, y, valor)
    
    // Mostrar el valor interpolado
    Imprimir "Resultado: " + resultado
Fin

// Definir la función interpolacionNewton
Función interpolacionNewton(x, y, valor) Devuelve Real
    n <- longitud(x)
    resultado <- y[0]
    f <- nuevo Arreglo de tamaño n
    f[0] <- resultado
    
    // Calcular los coeficientes de Newton
    Para i desde 1 hasta n - 1 hacer
        Para j desde 0 hasta n - i - 1 hacer
            Si i == 1 entonces
                f[j] <- (y[j + 1] - y[j]) / (x[j + i] - x[j])
            Sino
                f[j] <- (f[j + 1] - f[j]) / (x[j + i] - x[j])
            FinSi
        FinPara
        // Calcular el término de la interpolación
        resultado <- resultado + f[0] * calcularProducto(valor, x, 0, i)
    FinPara
    
    // Devolver el resultado final
    Devolver resultado
FinFunción

// Definir la función calcularProducto
Función calcularProducto(valor, x, inicio, fin) Devuelve Real
    producto <- 1.0
    Para i desde inicio hasta fin hacer
        producto <- producto * (valor - x[i])
    FinPara
    Devolver producto
FinFunción


```

### Implementacion 
- Implementacion en Python

```
def interpolacion_newton(x, y, valor):
    n = len(x)
    resultado = y[0]
    f = [0] * n
    f[0] = resultado

    # Calcula los coeficientes de Newton
    for i in range(1, n):
        for j in range(n - i):
            if i == 1:
                f[j] = (y[j + 1] - y[j]) / (x[j + i] - x[j])
            else:
                f[j] = (f[j + 1] - f[j]) / (x[j + i] - x[j])
        # Calcula el término de la interpolación
        resultado += f[0] * calcular_producto(valor, x, 0, i)
    
    return resultado

def calcular_producto(valor, x, inicio, fin):
    producto = 1.0
    for i in range(inicio, fin + 1):
        producto *= (valor - x[i])
    return producto

def main():
    x = [0.0, 1.0, 2.0, 3.0]
    y = [1.0, 2.0, 3.0, 4.0]
    valor = 1.5

    resultado = interpolacion_newton(x, y, valor)
    print(f"Resultado: {resultado}")

if __name__ == "__main__":
    main()


```


### Ejercicios en java

[Ejemplo 1](https://github.com/GABOHDEZ2001/TEMA-5---Interpolacion-y-ajuste-de-funciones-METODOS/blob/master/src/MetodoDeInterpolacionDeNewton/MetodoDeInterpolacionDeNewton1.java)

[Ejemplo 2](https://github.com/GABOHDEZ2001/TEMA-5---Interpolacion-y-ajuste-de-funciones-METODOS/blob/master/src/MetodoDeInterpolacionDeNewton/MetodoDeInterpolacionDeNewton2.java)

[Ejemplo 3](https://github.com/GABOHDEZ2001/TEMA-5---Interpolacion-y-ajuste-de-funciones-METODOS/blob/master/src/MetodoDeInterpolacionDeNewton/MetodoDeInterpolacionDeNewton3.java)

[Ejemplo 4](https://github.com/GABOHDEZ2001/TEMA-5---Interpolacion-y-ajuste-de-funciones-METODOS/blob/master/src/MetodoDeInterpolacionDeNewton/MetodoDeInterpolacionDeNewton4.java)





======================================================================================
## Método De Correlación
### Descripcion 

La correlación se refiere a la medida de la relación entre dos variables. El coeficiente de correlación es una medida numérica que describe la dirección y la fuerza de una relación lineal entre dos variables. Los dos coeficientes de correlación más comunes son el coeficiente de correlación de Pearson y el coeficiente de correlación de Spearman.

### Pseudocódigo 
```
Inicio
    // Definir los vectores de datos x e y
    x <- [1, 2, 3, 4, 5]
    y <- [2, 4, 6, 8, 10]
    
    // Verificar si los vectores tienen la misma longitud
    Si longitud(x) no es igual a longitud(y) entonces
        Lanzar una excepción con el mensaje "Los vectores deben tener la misma longitud"
    FinSi
    
    // Inicializar variables para sumas y para el número de elementos
    sumXY <- 0.0
    sumX <- 0.0
    sumY <- 0.0
    sumXSquared <- 0.0
    sumYSquared <- 0.0
    n <- longitud(x)
    
    // Calcular sumatorias
    Para cada elemento i desde 0 hasta n-1 hacer
        sumXY <- sumXY + x[i] * y[i]
        sumX <- sumX + x[i]
        sumY <- sumY + y[i]
        sumXSquared <- sumXSquared + x[i] * x[i]
        sumYSquared <- sumYSquared + y[i] * y[i]
    FinPara
    
    // Calcular correlación
    correlation <- (n * sumXY - sumX * sumY) /
                   raízCuadrada((n * sumXSquared - sumX * sumX) *
                                (n * sumYSquared - sumY * sumY))
    
    // Devolver correlación
    Devolver correlation
Fin

```


### Implementacion 
- Implementacion en Python

```
  import math

def calcular_correlacion(x, y):
    if len(x) != len(y):
        raise ValueError("Los vectores deben tener la misma longitud")

    sum_xy = sum_x = sum_y = sum_x_squared = sum_y_squared = 0.0
    n = len(x)

    # Calcular sumatorias
    for i in range(n):
        sum_xy += x[i] * y[i]
        sum_x += x[i]
        sum_y += y[i]
        sum_x_squared += x[i] * x[i]
        sum_y_squared += y[i] * y[i]

    # Calcular correlación
    correlation = (n * sum_xy - sum_x * sum_y) / math.sqrt((n * sum_x_squared - sum_x ** 2) * (n * sum_y_squared - sum_y ** 2))
    
    return correlation

def main():
    x = [1, 2, 3, 4, 5]
    y = [2, 4, 6, 8, 10]
    correlation = calcular_correlacion(x, y)
    print("Correlación:", correlation)

if __name__ == "__main__":
    main()

```


### Ejercicios en java

[Ejemplo 1](https://github.com/GABOHDEZ2001/TEMA-5---Interpolacion-y-ajuste-de-funciones-METODOS/blob/master/src/MetodoDeCorrelacion/MetodoDeCorrelacion1.java)

[Ejemplo 2](https://github.com/GABOHDEZ2001/TEMA-5---Interpolacion-y-ajuste-de-funciones-METODOS/blob/master/src/MetodoDeCorrelacion/MetodoDeCorrelacion2.java)

[Ejemplo 3](https://github.com/GABOHDEZ2001/TEMA-5---Interpolacion-y-ajuste-de-funciones-METODOS/blob/master/src/MetodoDeCorrelacion/MetodoDeCorrelacion3.java)

[Ejemplo 4](https://github.com/GABOHDEZ2001/TEMA-5---Interpolacion-y-ajuste-de-funciones-METODOS/blob/master/src/MetodoDeCorrelacion/MetodoDeCorrelacion4.java)




======================================================================================

## Método De Minimos Cuadros
### Descripcion 
El método de los mínimos cuadrados es una técnica estadística utilizada en el análisis de regresión para encontrar la mejor línea de ajuste a través de un conjunto de puntos de datos. Su objetivo principal es minimizar la suma de los cuadrados de las diferencias entre los valores observados y los valores predichos por el modelo. 


### Pseudocódigo 
```
Inicio
    // Definir los vectores de datos x e y
    x <- [1, 2, 3, 4, 5]
    y <- [2, 3, 4, 5, 6]
    
    // Verificar si los vectores tienen la misma longitud y no están vacíos
    Si longitud(x) no es igual a longitud(y) o longitud(x) es igual a 0 entonces
        Lanzar una excepción con el mensaje "Las matrices 'x' y 'y' deben tener la misma longitud y no estar vacías."
    FinSi
    
    // Inicializar variables para sumatorias y para el número de elementos
    sumX <- 0.0
    sumY <- 0.0
    sumXY <- 0.0
    sumXSquare <- 0.0
    n <- longitud(x)
    
    // Calcular sumatorias
    Para cada elemento i desde 0 hasta n-1 hacer
        sumX <- sumX + x[i]
        sumY <- sumY + y[i]
        sumXY <- sumXY + x[i] * y[i]
        sumXSquare <- sumXSquare + x[i] * x[i]
    FinPara
    
    // Calcular coeficiente "b"
    m <- (n * sumXY - sumX * sumY) / (n * sumXSquare - sumX * sumX)
    b <- (sumY - m * sumX) / n
    
    // Devolver coeficiente "b"
    Devolver b
Fin

```


### Implementacion 
- Implementacion en Python

```
 def calcular_coeficiente_b(x, y):
    if len(x) != len(y) or len(x) == 0:
        raise ValueError("Las listas 'x' e 'y' deben tener la misma longitud y no estar vacías.")
    
    n = len(x)
    sum_x = sum(x)
    sum_y = sum(y)
    sum_xy = sum(x_i * y_i for x_i, y_i in zip(x, y))
    sum_x_squared = sum(x_i ** 2 for x_i in x)
    
    m = (n * sum_xy - sum_x * sum_y) / (n * sum_x_squared - sum_x ** 2)
    b = (sum_y - m * sum_x) / n
    
    return b

def main():
    x = [1, 2, 3, 4, 5]
    y = [2, 3, 4, 5, 6]
    
    coeficiente_b = calcular_coeficiente_b(x, y)
    print("El valor de 'b' es:", coeficiente_b)

if __name__ == "__main__":
    main()
 
```


### Ejercicios en java

[Ejemplo 1](https://github.com/GABOHDEZ2001/TEMA-5---Interpolacion-y-ajuste-de-funciones-METODOS/blob/master/src/MetodoDeMinimosCuadros/MetodoDeMinimosCuadros1.java)

[Ejemplo 2](https://github.com/GABOHDEZ2001/TEMA-5---Interpolacion-y-ajuste-de-funciones-METODOS/blob/master/src/MetodoDeMinimosCuadros/MetodoDeMinimosCuadros2.java)

[Ejemplo 3](https://github.com/GABOHDEZ2001/TEMA-5---Interpolacion-y-ajuste-de-funciones-METODOS/blob/master/src/MetodoDeMinimosCuadros/MetodoDeMinimosCuadros3.java)

[Ejemplo 4](https://github.com/GABOHDEZ2001/TEMA-5---Interpolacion-y-ajuste-de-funciones-METODOS/blob/master/src/MetodoDeMinimosCuadros/MetodoDeMinimosCuadros4.java)




======================================================================================

## Método De Regresion
### Descripcion 
La regresión se utiliza para examinar la relación entre una variable dependiente (Y) y una o más variables independientes (X). El objetivo principal es desarrollar un modelo matemático que describa cómo la variable dependiente cambia en función de las variables independientes.


### Pseudocódigo 
```
Inicio
    // Definir los vectores de datos x e y
    x <- [1, 2, 3, 4, 5]
    y <- [2, 3, 4, 5, 6]
    
    // Verificar si los vectores tienen la misma longitud y no están vacíos
    Si longitud(x) no es igual a longitud(y) o longitud(x) es igual a 0 entonces
        Lanzar una excepción con el mensaje "Las listas 'x' e 'y' deben tener la misma longitud y no estar vacías."
    FinSi
    
    // Inicializar variables para sumatorias y para el número de elementos
    sumX <- 0.0
    sumY <- 0.0
    sumXX <- 0.0
    sumXY <- 0.0
    n <- longitud(x)
    
    // Calcular sumatorias
    Para cada elemento i desde 0 hasta n-1 hacer
        sumX <- sumX + x[i]
        sumY <- sumY + y[i]
        sumXX <- sumXX + x[i] * x[i]
        sumXY <- sumXY + x[i] * y[i]
    FinPara
    
    // Calcular coeficientes de la línea de regresión (y = mx + b)
    m <- (n * sumXY - sumX * sumY) / (n * sumXX - sumX * sumX)
    b <- (sumY - m * sumX) / n
    
    // Imprimir los resultados
    Imprimir "La línea de regresión es: y = " + m + "x + " + b
Fin

```


### Implementacion 
- Implementacion en Python

```
  Inicio
    // Definir los vectores de datos x e y
    x <- [1, 2, 3, 4, 5]
    y <- [2, 3, 4, 5, 6]
    
    // Verificar si los vectores tienen la misma longitud y no están vacíos
    Si longitud(x) no es igual a longitud(y) o longitud(x) es igual a 0 entonces
        Lanzar una excepción con el mensaje "Las listas 'x' e 'y' deben tener la misma longitud y no estar vacías."
    FinSi
    
    // Inicializar variables para sumatorias y para el número de elementos
    sumX <- 0.0
    sumY <- 0.0
    sumXX <- 0.0
    sumXY <- 0.0
    n <- longitud(x)
    
    // Calcular sumatorias
    Para cada elemento i desde 0 hasta n-1 hacer
        sumX <- sumX + x[i]
        sumY <- sumY + y[i]
        sumXX <- sumXX + x[i] * x[i]
        sumXY <- sumXY + x[i] * y[i]
    FinPara
    
    // Calcular coeficientes de la línea de regresión (y = mx + b)
    m <- (n * sumXY - sumX * sumY) / (n * sumXX - sumX * sumX)
    b <- (sumY - m * sumX) / n
    
    // Imprimir los resultados
    Imprimir "La línea de regresión es: y = " + m + "x + " + b
Fin

```


### Ejercicios en java

[Ejemplo 1](https://github.com/GABOHDEZ2001/TEMA-5---Interpolacion-y-ajuste-de-funciones-METODOS/blob/master/src/MetodoDeRegresion/MetodoDeRegresion1.java)

[Ejemplo 2](https://github.com/GABOHDEZ2001/TEMA-5---Interpolacion-y-ajuste-de-funciones-METODOS/blob/master/src/MetodoDeRegresion/MetodoDeRegresion2.java)

[Ejemplo 3](https://github.com/GABOHDEZ2001/TEMA-5---Interpolacion-y-ajuste-de-funciones-METODOS/blob/master/src/MetodoDeRegresion/MetodoDeRegresion3.java)

[Ejemplo 4](https://github.com/GABOHDEZ2001/TEMA-5---Interpolacion-y-ajuste-de-funciones-METODOS/blob/master/src/MetodoDeRegresion/MetodoDeRegresion4.java)




======================================================================================

