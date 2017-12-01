#include <stdio.h>
#include <stdlib.h>

main (){
	int *numeros;
	int quant;
	printf("Digite a quantidade de numeros a digitar:");
	scanf("%d",&quant);
	numeros=(int*)malloc(quant * (sizeof(int)));
	//numeros = calloc(quant, (sizeof(int)));
	int i;
	for(i=0;i<quant;i++){
		printf("Digite o %d numero:", i+1);
		scanf("%d",&numeros[i]);
	}
	for(i=0;i<quant;i++){
		printf("Numero digitado: %d\n", numeros[i]);
	}
	free(numeros);
	system("PAUSE");
}
