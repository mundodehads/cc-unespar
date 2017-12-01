#include <stdio.h>
#include <stdlib.h>

main (){
	int *numeros;
	int quant;
	printf("Informe a quantidade de numero que deseja digitar: ");
	scanf("%i",&quant);
	numeros = (int*)calloc(quant, (sizeof(int)));
	int i;
	for(i=0;i<quant;i++){
		printf("Digite o %i numero:", i+1);
		scanf("%i",&numeros[i]);
	}
	for(i=0;i<quant;i++){
		printf("Numero digitado: %i\n", numeros[i]);
	}
	free(numeros);
	system("PAUSE");
}
