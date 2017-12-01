#include <stdio.h>
#include <stdlib.h>

int buscaLinear(int lista[], int tamanho, int chave) {
    int indice;
    for(indice = 0; indice < tamanho ; indice++)    
         if (lista[indice] == chave) {        
            return indice;            
        }
    return -1;
}

int dados[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

main() {
     printf("Busca Linear/Sequencial:  %d", buscaLinear(dados, 10 , 5));    
     printf("\n");  
     system("PAUSE");
}
