#include <stdio.h>
#include <stdlib.h>

main () {
	char a;
	char *b;
	char **c;
	a= 'Z';
	b = &a;
	*b = 'C';
	c = &b;
	**c = 'M';
	printf("Valor de A: %c\n", a);
	system("PAUSE");
}
