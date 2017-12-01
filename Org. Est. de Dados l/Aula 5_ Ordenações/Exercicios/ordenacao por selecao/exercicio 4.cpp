#include<stdio.h>
#include<stdlib.h>

int ordenacaoPorSelecao(int lista[], int tamanho){
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
     return trocas;
}

main () {
     int num[10];
     int i;
     for(i=0;i<10;i++){
                       printf("Informe o %i numero:", i+1);
                       scanf("%i",&num[i]);
                       }
     int trocas = ordenacaoPorSelecao(num, 10);
     printf("Quantidade de trocas feitas: %i\n", trocas);
     printf("Numero ordenados:\n");
     for(i=0;i<10;i++){
                       printf("%i numero: %i\n", i+1, num[i]);
                       }
     system("PAUSE");
}
