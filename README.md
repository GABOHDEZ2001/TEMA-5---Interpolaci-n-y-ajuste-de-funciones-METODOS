# T5---E2---Problemario
Desarrolla ejercicios que involucran cálculos numéricos para solución de problemas de interpolación

# MetodosNumericosTema3Problemario

### Gabriel Hernández Zaavala



## Método De Interpolación De Lagrange.
### Descripcion 

trapecio para calcular el área bajo la curva.

### Pseudocódigo 
```
Función MetodoTrapecio(a, b, n, f):
    h = (b - a) / n
    sum = 0.5 * (f(a) + f(b))

    Para cada i de 1 a n-1:
        x = a + i * h
        sum += f(x)

    retornar h * sum

Función funcionEjemplo(x):
    retornar x * x

a = 0 // Límite inferior de integración
b = 2 // Límite superior de integración
n = 100 // Número de trapecios

integral = MetodoTrapecio(a, b, n, funcionEjemplo)

Imprimir "La aproximación de la integral es: " + integral

```


### Implementacion 
- Implementacion en Python

```
  def f(x):
    # Define la función que deseas integrar
    return x**2  # Ejemplo: x^2

def metodo_trapecio(a, b, n):
    # Calcula el ancho de cada subintervalo
    h = (b - a) / n
    
    # Inicializa la suma
    suma = 0
    
    # Calcula la suma de las áreas de los trapecios
    for i in range(1, n):
        xi = a + i * h
        suma += f(xi)
    
    # Aplica la fórmula del método del trapecio
    resultado = h * (f(a) / 2 + f(b) / 2 + suma)
    return resultado

# Ejemplo de uso
a = 0  # Límite inferior
b = 1  # Límite superior
n = 1000  # Número de subintervalos

resultado = metodo_trapecio(a, b, n)
print("Resultado de la integración usando el método del trapecio:", resultado)

```




        

### Ejercicios en java

[Ejemplo 1](https://github.com/GABOHDEZ2001/PROBLEMARIOTEMA4METODOS/blob/main/T4-E2-Problemario/src/M%C3%A9todoDeTrapecio/MetodoTrapecio1.java)

[Ejemplo 2](https://github.com/GABOHDEZ2001/PROBLEMARIOTEMA4METODOS/blob/main/T4-E2-Problemario/src/M%C3%A9todoDeTrapecio/MetodoTrapecio2.java)

[Ejemplo 3](https://github.com/GABOHDEZ2001/PROBLEMARIOTEMA4METODOS/blob/main/T4-E2-Problemario/src/M%C3%A9todoDeTrapecio/MetodoTrapecio3.java)

[Ejemplo 4](https://github.com/GABOHDEZ2001/PROBLEMARIOTEMA4METODOS/blob/main/T4-E2-Problemario/src/M%C3%A9todoDeTrapecio/MetodoTrapecio4.java)

[Ejemplo 5](https://github.com/GABOHDEZ2001/PROBLEMARIOTEMA4METODOS/blob/main/T4-E2-Problemario/src/M%C3%A9todoDeTrapecio/MetodoTrapecio5.java)


==========================================================================================================================
