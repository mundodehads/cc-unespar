//Faça um algoritmo que leia 1 número inteiro em uma variável
//chamada numero, declare 3 ponteiros (p1,p2,p3) que receba o
//endereço de memória de numero. Apresente o endereço da memória
//de numero, da memória apontada pelos ponteiros e o valor da
//variável apontada por p1, p2, p3; 

#include <stdio.h>
#include <stdlib.h>

main () {
	int numero;
	printf("Informe o valor de numero:");
	scanf("%i",&numero);
	int *p1, *p2, *p3;
	p1 = &numero;
	p2 = &numero;
	p3 = &numero;
	printf("Endereco da memoria de numero: %p\n", &numero);
	printf("Endereco da memoria apontada por p1: %p\n", &p1);
	printf("Endereco da memoria apontada por p2: %p\n", &p2);
	printf("Endereco da memoria apontada por p3: %p\n", &p3);
	printf("Valor da variavel apontada pelo p1: %p\n", *p1);
	printf("Valor da variavel apontada pelo p2: %p\n", *p2);
	printf("Valor da variavel apontada pelo p3: %p\n", *p3);
	system("PAUSE");
}
