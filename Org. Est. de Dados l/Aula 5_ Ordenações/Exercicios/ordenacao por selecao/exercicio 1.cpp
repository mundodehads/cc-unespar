#include<stdio.h>
#include<stdlib.h>

void ordenacaoPorSelecao(float lista[], int tamanho){
     int i, j, min;
     float aux;
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

main () {
     float notas[10];
     int i;
     for(i=0;i<10;i++){
                       printf("Informe a nota do %i aluno:", i+1);
                       scanf("%f",&notas[i]);
                       }
     ordenacaoPorSelecao(notas, 10);
     printf("Notas ordenadas:\n");
     for(i=0;i<10;i++){
                       printf("%i nota: %.1f\n", i+1, notas[i]);
                       }
     system("PAUSE");
     }
     
