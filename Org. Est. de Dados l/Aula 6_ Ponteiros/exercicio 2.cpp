//Faça um programa que leia 4 números, declare 4 variáveis do tipo
//ponteiro que receba o endereço de memória destas variáveis.
//Apresente o valor contido nas variáveis utilizando os ponteiros.

#include <stdio.h>
#include <stdlib.h>

main () {
	int num[4];
	for (int i=0;i<4;i++){
		printf("Informe o %i numero:", i+1);
		scanf("%i",&num[i]);
	}
	int *p1 = &num[0], *p2 = &num[1], *p3 = &num[2], *p4 = &num[3];
	printf("Valor contido na variavel apontada pelo p1: %p\n", *p1);
	printf("Valor contido na variavel apontada pelo p2: %p\n", *p2);
	printf("Valor contido na variavel apontada pelo p3: %p\n", *p3);
	printf("Valor contido na variavel apontada pelo p4: %p\n", *p4);
	system("PAUSE");
}
