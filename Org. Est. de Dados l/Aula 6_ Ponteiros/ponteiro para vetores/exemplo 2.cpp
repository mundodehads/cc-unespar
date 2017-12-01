#include <stdio.h>
#include <stdlib.h>

main () {
	int numeros[5];
	int *p;
	int i;
	p = numeros;
	*p = 5;
	p++;
	*p = 10;
	p  = &numeros[2];
	*p = 15;
	p = numeros + 3;
	*p = 20;
	p = numeros;
	*(p +4) = 25;
	for(i=0; i<5; i++){
		printf("%d\n", numeros[i]);
	}
	system("PAUSE");
}
