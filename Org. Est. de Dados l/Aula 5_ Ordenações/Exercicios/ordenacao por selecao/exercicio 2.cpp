#include<stdio.h>
#include<stdlib.h>
#include<string.h>

void ordenacaoPorSelecao(char lista[][50], int tamanho){
     int i, j, min;
     char aux[50];
     for(i=0;i<(tamanho-1);i++){
       min = i;
       for(j=(i+1);j<tamanho;j++){
         if(strcmp(lista[j], lista[min])<0){
            min=j;
            }
       }
       if(i!=min){
                  strcpy(aux, lista[i]);
                  strcpy(lista[i], lista[min]);
                  strcpy(lista[min], aux);
                  }
     }
}

main () {
     char cidades[8][50];
     int i;
     for(i=0;i<8;i++){
                      printf("Informe a %i cidade:", i+1);
                      gets(cidades[i]);
                      }
     ordenacaoPorSelecao(cidades, 8);
     printf("Cidades em ordem alfabetica:\n");
     for(i=0;i<8;i++){
                      printf("%i cidade: %s\n", i+1, cidades[i]);
                      }
     system("PAUSE");
}
