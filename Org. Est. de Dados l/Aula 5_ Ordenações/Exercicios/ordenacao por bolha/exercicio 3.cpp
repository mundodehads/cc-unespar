#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void ordenacaoPorBolha(char lista[][50], int tamanho){
     int i, j;
     char aux[50];
     for (i=0;i<tamanho;i++){
         for(j=i+1;j<tamanho;j++){
           if(strcmp(lista[i], lista[j])>0){
             strcpy(aux, lista[i]);
             strcpy(lista[i], lista[j]);
             strcpy(lista[j], aux);
             }
           }
         }
     }
     
main () {
     char cidades[10][50];
     int i;
     for(i=0;i<10;i++){
       printf("Informe o nome da %i cidade:", i+1);
       gets(cidades[i]);
       }
     ordenacaoPorBolha(cidades, 10);
     printf("Nomes em ordem alfabetica:\n");
     for(i=0;i<10;i++){
       printf("%i cidade: %s\n", i+1, cidades[i]);
       }
     system("PAUSE");
     }
