#include <stdio.h>
#include <stdlib.h>


void argumentosPorValor(int numero){
     numero = numero + 10;
}

void argumentosPorReferencia(int *numero){
     *numero = *numero + 10;
}

main(){
      int valor1 = 10;
      int valor2 = 10;
      
      printf("Valores originais\n");
      printf("%d\n", valor1);
      printf("%d\n", valor2);
      
      getch();
            
      argumentosPorValor(valor1);      
      argumentosPorReferencia(&valor2);

      printf("Valores alterados\n");      
      printf("%d\n", valor1);
      printf("%d\n", valor2);
      system("PAUSE");      
 }
