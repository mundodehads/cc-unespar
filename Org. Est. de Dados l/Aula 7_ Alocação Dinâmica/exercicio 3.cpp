#include <stdio.h>
#include <stdlib.h>

main (){
	int *numeros;
	int quant;
	printf("Informe a quantidade de numero que deseja digitar: ");
	scanf("%i",&quant);
	numeros = (int*)calloc(quant, (sizeof(int)));
	int i;
	int maior;
	for(i=0;i<quant;i++){
		printf("Digite o %i numero:", i+1);
		scanf("%i",&numeros[i]);
		if (i == 0){
			maior = numeros[i];
		} else if (numeros[i] >= maior){
			maior = numeros[i];
		} 
	}
	for(i=0;i<quant;i++){
		printf("Numero digitado: %i\n", numeros[i]);
	}
	printf("Maior numero digitado: %i\n", maior);
	free(numeros);
	system("PAUSE");
}
