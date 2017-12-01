#include <stdio.h>
#include <stdlib.h>

void recursiveFunction (int x, int y) {
	if (y <= 10){
		printf("%i * %i = %i \n", x, y, x*y);
		recursiveFunction(x, y + 1);
	}
}

main () {
	int num;
	printf("Informe um numero: ");
	scanf("%i", &num);
	recursiveFunction (num, 0);
	system("PAUSE");
}

