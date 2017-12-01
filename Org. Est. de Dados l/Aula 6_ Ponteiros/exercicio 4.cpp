//Escreva um programa que leia 2 números inteiros, declare 2
//ponteiros (p1,p2) que receba os endereços de memória destas
//variáveis. Faça uma programação para trocar o valor destes ponteiros
//entre si.
//Apresente o valor de p1 e p2 e o endereço de memória de a e
//b armazenados em p1 e p2;

#include <stdio.h>
#include <stdlib.h>

void troca (int *n1, int *n2) {
	int *temp;
	temp = n1;
	n1 = n2;
	n2 = temp;
}

main () {
	int n1, n2;
	printf("Informe n1:");
	scanf("%i",&n1);
	printf("Informe n2:");
	scanf("%i",&n2);
	int *p1, *p2;
	p1 = &n1;
	p2 = &n2;
	troca (p1, p2);
	printf("Valor de p1: %p\n", *p1);
	printf("Valor de p2: %p\n", *p2);
	printf("Endereco de memoria de p1: %p\n", p1);
	printf("Endereco de memoria de p2: %p\n", p2);
	system("PAUSE");
}
