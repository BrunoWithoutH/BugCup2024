def merge_sort(lista):

    if len(lista) <= 1:
        return lista

    meio = len(lista) // 2
    esquerda = lista[:meio]
    direita = lista[meio:]

    esquerda_ordenada = merge_sort(esquerda)
    direita_ordenada = merge_sort(direita)

    return merge(esquerda_ordenada, direita_ordenada)

def merge(esquerda, direita):

    resultado = []
    i = j = 0

    while i < len(esquerda) and j < len(direita):
        if esquerda[i] <= direita[j]:
            resultado.append(esquerda[i])
            i += 1
        else:
            resultado.append(direita[j])
            j =+ 1

    resultado.extend(esquerda[i:])
    resultado.extend(direita[j:])

    return resultado

lista = [64, 34, 25, 12, 22, 11, 90, 110, 1, 5, 13, 85, 121, 27, 88, 91, 54, 67]
print("Lista antes da ordenação:", lista)

lista_ordenada = merge_sort(lista)
print("Lista após a ordenação:", lista_ordenada)

