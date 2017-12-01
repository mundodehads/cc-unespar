#include <stdio.h>
#include <stdlib.h>

void ordenacaoPorBolha(char lista[], int tamanho){
     int i, j; 
     char aux;
     for (i=0;i<tamanho;i++){
         for(j=i+1;j<tamanho;j++){
           if(lista[i]>lista[j]){
             aux=lista[i];
             lista[i]=lista[j];
             lista[j]=aux;
             }
           }
         }
     }
     
main () {
    char alfabeto[7]={'y','c','e','i','q','c','t'};
    ordenacaoPorBolha(alfabeto, 7);
    int i;
    for(i=0;i<7;i++){
      printf("%c\n", alfabeto[i]);
      }
     system("PAUSE");
     } 
