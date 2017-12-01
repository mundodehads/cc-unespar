#include <stdio.h>
#include <stdlib.h>

main () {
	int a;
	printf("Informe um numero: ");
	scanf("%i",&a);
	int *b;
	int **c;
	b = &a;
	c = &b;
	**c = *b + 100;
	printf("Numero +100 = %i\n", a);
	system("PAUSE");
}
