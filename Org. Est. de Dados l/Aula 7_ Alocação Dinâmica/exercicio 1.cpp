#include <stdio.h>
#include <stdlib.h>

main (){
	float *notas;
	int quant;
	float media=0;
	printf("Digite a quantidade de notas a digitar:");
	scanf("%d",&quant);
	notas=(float*)malloc(quant * (sizeof(float)));
	int i;
	for(i=0;i<quant;i++){
		printf("Digite a %d nota:", i+1);
		scanf("%f",&notas[i]);
		media=media+notas[i];
	}
	media=media/quant;
	printf("Media das notas: %.1f\n", media);
	free(notas);
	system("PAUSE");
}
