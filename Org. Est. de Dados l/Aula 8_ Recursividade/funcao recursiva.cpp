#include <stdio.h>
#include <stdlib.h>

void recursiveFunction (int num) {
	if (num < 5){
		//Ordem crescente, mostra o num depois empilha
		printf("%d - \n", num);
		recursiveFunction(num + 1);
		//Ordem decrescente, empilha todos depois mostra de cima para baixo.
		//printf("%d - \n", num);
	}
}

main () {
	recursiveFunction (0);
	system("PAUSE");
}
