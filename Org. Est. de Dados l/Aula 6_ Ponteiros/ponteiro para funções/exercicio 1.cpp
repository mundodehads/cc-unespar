#include <stdio.h>
#include <stdlib.h>

int adicao (int a, int b) {
	return (a+b);
}

int subtracao (int a, int b) {
	return (a-b);
}

int divisao (int a, int b) {
	return (a/b);
}

int multiplicacao (int a, int b) {
	return (a*b);
}

int operacao (int x, int y, int(*func)(int,int)){
	int g;
	g = (*func)(x,y);
	return (g);
}

main () {
	int n1, n2;
	printf("Informe n1: ");
	scanf("%i",&n1);
	printf("Informe n2: ");
	scanf("%i",&n2);
	int escolha;
	printf("Informe a operacao que deseja realizar:\n[1] Adicao\n[2] Subtracao\n[3] Divisao\n[4] Multiplicacao\n>");
	scanf("%i",&escolha);
	int receber;
	if (escolha == 1 ){
		receber = operacao(n1, n2 ,adicao);
	} else if (escolha == 2){
		receber = operacao(n1, n2 ,subtracao);
	} else if (escolha == 3) {
		receber = operacao(n1, n2 ,divisao);
	} else if (escolha == 4) {
		receber = operacao(n1, n2 ,multiplicacao);
	} else {
		printf("Opcao invalida x.x\n");
	}
	printf("Resultado : %d\n", receber);
	system("PAUSE");
}
