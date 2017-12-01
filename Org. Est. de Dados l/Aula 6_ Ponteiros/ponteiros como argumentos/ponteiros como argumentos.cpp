#include <stdio.h>
#include <stdlib.h>

void troca (int *i, int *j){
	int temp;
	temp = *i;
	*i = *j;
	*j = temp;
}
main () {
	int a=5, b=10;
	printf("Valor antes da troca: %d / %d\n", a, b);
	troca (&a, &b);
	printf("Valor depois da troca: %d / %d\n", a, b);
	system("PAUSE");
}
