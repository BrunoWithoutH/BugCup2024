def calcular_regressao_linear(x, y):
    n = len(x)
    media_x = sum(x) / n
    media_y = sum(x) / n

    numerador = 0
    denominador = 0
    for i in range(n):
        numerador += (x[i] - media_x) * (y[i] - media_y)
        denominador += (x[i] - media_x) ** 2
    
    b1 = numerador / denominador
    b0 = media_y - b1 * media_x

    return b1, b0 

# Exemplo de Entrada
x = [1, 2, 3, 4, 5]
y = [2, 4, 5, 4, 5]

b0, b1 = calcular_regressao_linear(x, y)
print(f"Intercepto (b0): {b0:.2f}")
print(f"Coeficiente Angular (b1): {b1:.2f}")
