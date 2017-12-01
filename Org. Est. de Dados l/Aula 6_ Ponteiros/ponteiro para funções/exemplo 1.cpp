#include <stdio.h>
#include <stdlib.h>

int soma (int a, int b) {
	return (a+b);
}

int operacao (int x, int y, int(*func)(int,int)){
	int g;
	g = (*func)(x,y);
	return (g);
}

main () {
	int m;
	m = operacao(7,5,soma);
	printf("%d\n", m);
	system("PAUSE");
}
