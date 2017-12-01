#include <stdio.h>
#include <stdlib.h>

void funcao1(){
	printf("Acessou a funcao 1\n");
}

void funcao2(){
	printf("Acessou a funcao 2\n");
}

main () {
	int opcao;
	void(*VetorFuncao[2])();
	VetorFuncao[0] = funcao1;
	VetorFuncao[1] = funcao2;
	printf("Digite 1 para a primeira funcao e 2 para a segunda funcao: ");
	scanf("%d",&opcao);
	if (opcao == 1){
		(*VetorFuncao[0])();
	} else if (opcao == 2){
		(*VetorFuncao[1])();
	} else {
		printf("\nOpcao Invalida\n");
	}
	system("PAUSE");
}
