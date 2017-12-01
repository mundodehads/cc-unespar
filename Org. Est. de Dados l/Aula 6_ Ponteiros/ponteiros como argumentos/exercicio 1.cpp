#include <stdio.h>
#include <stdlib.h>

void dobro (int *i){
	*i = *i * 2;
}

main () {
	int num;
	printf("Digite um numero: ");
	scanf("%i",&num);
	dobro (&num);
	printf("Numero dobrado: %i\n", num);
	system("PAUSE");
}
