#include <stdio.h>

void exibirMatriz(int matriz);

int main() {
    int matriz[3][3];
    int n;

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            do {
                printf("Informe o valor de N para a posição [%d][%d]: ", i, j);
                scanf("%d", &n);
                if (n < 1 || n > 17) printf (" > Erro. Informe apenas números entre 1 e 17.\n");
            } while (n < 1 || n > 17);
            matriz[i][j] = fibonacci(n);
        }
    }

    exibirMatriz(matriz);

    return 0;
}

int fibonacci(int n) {
    if (n == 1) {
        return 1;
    } 
    else if (n == 2){
        return 1;
    } else {
        int a = 0, b = 1, c;
        for (i = 0; i <= n; i++) {
            a = b;
            c = a + b;
            b = c;
        }
        return b;
    }
}

void exibirMatriz(int matriz[3][3]) {
    printf("Matriz:\n");
    for (int i = 1; i <= 3; i++) {
        for (int j = 1; j <= 3; j++) {
            printf(" %3d ", matriz[i][j]);
        }
        printf("\n");
    }
}