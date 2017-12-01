#include <stdio.h>
#include <stdlib.h>

void ordenacaoPorBolha(float lista[], int tamanho){
     int i, j, aux;
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
     float num[8];
     int i;
     for(i=0;i<8;i++){
       printf("Informe o %i numero:", i+1);
       scanf("%f",&num[i]);
       }
     ordenacaoPorBolha(num, 8);
     printf("Numeros Ordenados:\n");
     for(i=0;i<8;i++){
       printf("%i numero: %.2f\n",i+1, num[i]);
       }
     system("PAUSE");
}
