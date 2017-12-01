#include<stdio.h>
#include<stdlib.h>

void ordenacaoPorSelecao(char lista[], int tamanho){
     int i, j, min;
     char aux;
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
     char alfabeto[26]={'z','x','y','w','v','u','t','s','r','q','p','o','n','m','l','k','j','i','h','g','f','e','d','c','b','a'};
     ordenacaoPorSelecao(alfabeto, 26);
     int i;
     printf("Char alfabeto organizado:\n");
     for(i=0;i<26;i++){
                       printf("%c\n", alfabeto[i]);
                       }
     system("PAUSE");
}
     
