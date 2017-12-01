#include <stdio.h>
#include <stdlib.h>

void ordenarPorInsercao(int lista[], int tamanho) {
     int i, j, aux;
     for(i=1;i<tamanho;i++){
       j=i;
       aux=lista[j];
       while(j>0 && aux>lista[j-1]){
         lista[j]=lista[j-1];
         j--;
       }
       lista[j]=aux;
     }
  }

main () {
     int num[10];
     int i;
     for(i=0;i<10;i++){
       printf("Informe %i numero:", i+1);
       scanf("%i",&num[i]);
       }
     ordenarPorInsercao(num, 10);
     printf("\n");
     for(i=0;i<10;i++){
       printf("Lista ordenada invertida, %i numero: %i\n", i+1, num[i]);
       }
     system("PAUSE");
}
