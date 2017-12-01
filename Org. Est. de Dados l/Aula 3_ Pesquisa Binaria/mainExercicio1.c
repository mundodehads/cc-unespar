#include <stdio.h>
#include <stdlib.h>
// EXEMPLO

int BuscaBinaria(int lista[], int tamanhoVetor, int chave){
    int central;    
    int baixo = 0;
    int alto = tamanhoVetor - 1;
    int i;
    while (baixo <= alto) {
           central = (baixo + alto) / 2;                   
           if(chave == lista[central])
                return central;
           else if(chave < lista[central])
                alto = central - 1;
           else 
                baixo = central + 1;           
    }    
    return -1;
}

int dados[10] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
main(){
     printf("Indice Busca Binaria : %d\n", BuscaBinaria(dados, 10, 10));  
     printf("Indice Busca Binaria : %d\n", BuscaBinaria(dados, 10, 3));  
     printf("Indice Busca Binaria : %d\n", BuscaBinaria(dados, 10, 0));  
     printf("Indice Busca Binaria : %d\n", BuscaBinaria(dados, 10, 6));  


     
      
   //  printf("Indice Busca Binaria : %d", BuscaBinaria(dados, 10, 9)); 
   //  printf("Indice Busca Binaria : %d", BuscaBinaria(dados, 10, 4)); 
   //  printf("Indice Busca Binaria : %d", BuscaBinaria(dados, 10, 1)); 
     printf("\n");    
     system("PAUSE");
}
