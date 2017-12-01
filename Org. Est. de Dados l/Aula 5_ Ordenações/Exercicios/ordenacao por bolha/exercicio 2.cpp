#include <stdio.h>
#include <stdlib.h>

int ordenacaoPorBolha(int lista[], int tamanho){
     int i, j, aux, trocas=0;
     for (i=0;i<tamanho;i++){
         for(j=i+1;j<tamanho;j++){
           if(lista[i]>lista[j]){
             aux=lista[i];
             lista[i]=lista[j];
             lista[j]=aux;
             trocas++;
             }
           }
         }
     return trocas;
     }
     
main () {
     int num[15];
     int i;
     for(i=0;i<15;i++){
       printf("Informe o %i numero:", i+1);
       scanf("%i",&num[i]);
       }
     int trocas = ordenacaoPorBolha(num, 15);
     printf("Foram realizadas %i trocas\n", trocas);
     printf("Numeros Ordenados:\n");
     for(i=0;i<15;i++){
       printf("%i numero: %i\n",i+1, num[i]);
       }
     system("PAUSE");
}
