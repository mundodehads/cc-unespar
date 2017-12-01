#include <stdio.h>
#include <stdlib.h>

int multiplicacao (int num){
	if(num == 0){
		return 1;
	}else{
		num=num*multiplicacao(num-1);
	}
	return num;
}

main () {
	int num, resultado;
	printf("Digite o numero:");
	scanf("%d",&num);
	resultado=multiplicacao(num);
	printf("Resultado Do Fatorial = %d\n", resultado);
	system("PAUSE");
}
