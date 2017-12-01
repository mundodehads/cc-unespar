#include <stdio.h>
#include <stdlib.h>

void troca(int *a, int *b){
	int temp;
	temp = *a;
	*a = *b;
	*b = temp;
} 

main(){
	int x = 10, y = 20;
	printf("ANTES da funcao troca\n");
	printf("x = %d    y = %d\n", x , y );
	getch();
	troca(&x,  &y);
	printf("DEPOIS da funcao troca\n");
	printf("x = %d    y = %d\n", x , y );
    system("PAUSE");
}
