#include <stdio.h>
#include <stdlib.h>

void recursiveFunction (int num) {
	if (num <= 50){
		printf("%d - \n", num);
		recursiveFunction(num + 1);
	}
}

main () {
	int num;
	printf("Informe num:");
	scanf("%d",&num);
	recursiveFunction(num);
}
