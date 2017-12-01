#include <stdio.h>
#include <stdlib.h>

main () {
	int num = 10;
	int *p1;
	int **p2;
	p1 = &num;
	p2 = &p1;
	printf("num = %d\n", num);
	printf("*p1 = %d\n", *p1);
	printf("**p2 = %d\n", **p2);
	system("PAUSE");
	
}
