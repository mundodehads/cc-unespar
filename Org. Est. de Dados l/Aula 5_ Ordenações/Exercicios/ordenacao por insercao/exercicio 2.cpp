#include <stdio.h>
#include <stdlib.h>

int ordenarPorInsercao(int lista[], int tamanho) {
     int i, j, aux, contador = 0;
     for(i=1;i<tamanho;i++){
       j=i;
       aux=lista[j];
       while(j>0 && aux<lista[j-1]){
         lista[j]=lista[j-1];
         j--;
         contador++;
       }
       lista[j]=aux;
     }
     return contador;
  }

main () {
     int num[20];
     int i;
     for(i=0;i<20;i++){
       printf("Informe %i numero:", i+1);
       scanf("%i",&num[i]);
       }
     printf("\n");
     int contador = ordenarPorInsercao(num, 20);
     printf("Foram feitas %i trocas\n", contador);
     for(i=0;i<20;i++){
     printf("Lista ordenada, %i numero: %i\n", i+1, num[i]);
     }
     system("PAUSE");
}
