#include<stdio.h>
#include<stdlib.h>

void ordenacaoPorSelecao(int lista[], int tamanho){
     int i, j, aux, min;
     for(i=0;i<(tamanho-1);i++){
       min = i;
       for(j=(i+1);j<tamanho;j++){
         if(lista[j]<lista[min]){
            min=j;
            }
       }
       if(i!=min){
                  aux=lista[i];
                  lista[i]=lista[min];
                  lista[min]=aux;
                  }
     }
}

-----------------------------------------------------

#include<stdio.h>
#include<stdlib.h>

void ordenacaoPorSelecao(int lista[], int tamanho){
     int i, j, aux, min, trocas=0;
     for(i=0;i<(tamanho-1);i++){
       min = i;
       for(j=(i+1);j<tamanho;j++){
         if(lista[j]<lista[min]){
            min=j;
            trocas++;
            }
       }
       if(i!=min){
                  aux=lista[i];
                  lista[i]=lista[min];
                  lista[min]=aux;
                  }
     }
}

-------------------------------------------------------

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
