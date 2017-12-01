#include <stdio.h>
#include <stdlib.h>
#include<string.h>

main (){
	int *numeros;
	int i;
	numeros = (int*) malloc(10 * (sizeof(int)));
	for (i=0;i<10;i++){
		printf("Informe %i numero: ", i+1);
		scanf("%i",&numeros[i]);
	}
	numeros = (int*) realloc(numeros, (15 * (sizeof(int))));
	for (i=10;i<15;i++){
		printf("Informe %i numero: ", i+1);
		scanf("%i",&numeros[i]);
	}
	for (i=0;i<15;i++){
		printf("O %i numero digitado foi: %i\n", i+1, numeros[i]);
	}
	free(numeros);
	system("PAUSE");
}

