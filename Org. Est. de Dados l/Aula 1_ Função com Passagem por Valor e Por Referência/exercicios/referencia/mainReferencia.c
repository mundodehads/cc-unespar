#include <stdio.h>
#include <stdlib.h>

void inverterNumeros(int *primeiroNumero, int *segundoNumero, int *terceiroNumero, int *quartoNumero){
	int temp;
	temp = *primeiroNumero;
	*primeiroNumero = *segundoNumero;
	*segundoNumero = temp;
	temp = *terceiroNumero;
	*terceiroNumero = *quartoNumero;
	*quartoNumero = temp;
} 

main(){
	int num1, num2, num3, num4;
     printf("Digite o primeiro numero: ");
     scanf("%d", &num1);        
     printf("Digite o segundo numero: ");
     scanf("%d", &num2);        
     printf("Digite o terceiro numero: ");
     scanf("%d", &num3);        
     printf("Digite o quarto numero: ");
     scanf("%d", &num4);        
	printf("\nValores Digitados Pelo Usuario\n");
	printf("num1 = %d num2 = %d num3 = %d num4 = %d\n\n", num1 , num2, num3, num4);
	getch();
	inverterNumeros( &num1, &num2, &num3, &num4);
	printf("Valores Invertidos Depois da Funcao\n");
	printf("num1 = %d num2 = %d num3 = %d num4 = %d\n\n", num1 , num2, num3, num4);
    system("PAUSE");
}
