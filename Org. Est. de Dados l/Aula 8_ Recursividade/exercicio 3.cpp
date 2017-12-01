#include <stdio.h>
#include <stdlib.h>

int soma (int num){
	if(num > 0){
		num=num+soma(num-1);
	}
	return num;
}

main () {
	int num, resultado;
	printf("Digite o numero:");
	scanf("%d",&num);
	resultado=soma(num);
	printf("Resultado Da Soma dos Inteiros = %d\n", resultado);
	system("PAUSE");
}
