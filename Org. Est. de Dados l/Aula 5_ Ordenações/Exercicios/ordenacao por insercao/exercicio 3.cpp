#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void ordenarPorInsercao(char lista[][50], int tamanho) {
     int i, j;
     char aux[50];
     for(i=1;i<tamanho;i++){
       j=i;
       strcpy(aux, lista[j]);
       while(j>0 && strcmp(aux, lista[j-1]) < 0){
         strcpy(lista[j], lista[j-1]);
         j--;
       }
       strcpy(lista[j], aux);
     }
  }

main () {
     char nome[5][50];
     int i;
     for(i=0;i<5;i++){
       printf("Informe %i nome:", i+1);
       gets(nome[i]);
       }
     ordenarPorInsercao(nome, 5);
     printf("\n");
     for(i=0;i<5;i++){
       printf("Lista ordenada, %i nome: %s\n", i+1, nome[i]);
       }
     system("PAUSE");
}
