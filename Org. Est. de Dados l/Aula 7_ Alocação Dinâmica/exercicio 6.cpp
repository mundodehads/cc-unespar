#include <stdio.h>
#include <stdlib.h>

int recursiveFunction (int vetor[], int y) {
	int resultado;
	for (int i=0;i<y;i++){
		if (i == 0){
			resultado = vetor[i]*vetor[i];
		}
		resultado = resultado * vetor[i];
	}
	return resultado;
}

main () {
	int x, y;
	printf("Informe o x: ");
	scanf("%i", &x);
	printf("Informe o y: ");
	scanf("%i", &y);
	int vetor[y];
	for(int i=0;i<y;i++){
		vetor[y]=x;
	}
	int potencia = recursiveFunction (vetor, y);
	printf("%i elevado a potencia %i: %i\n", x, y, potencia);
	system("PAUSE");
}
