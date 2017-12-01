#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int buscaPorNomes(char lista[10][50], int tamanho, char chave[50]) {
    int indice;
    for(indice = 0; indice < tamanho ; indice++)            
         if (strcmp(lista[indice], chave) == 0) {                            
            return indice;            
        }
    return -1;
}

char listaDeNomes[10][50];

main() {
     char nomeParaBusca[50];  
     int indice;
     for(indice = 0; indice < 10; indice++){
        printf("Digite o %d nome: ", indice + 1);   
        setbuf(stdin, NULL);     
        gets(listaDeNomes[indice]);
     }       
            
     printf("\nDigite um nome para realizar a busca: ");
     gets(nomeParaBusca);
     int indiceRetornado = buscaPorNomes(listaDeNomes, 10 , nomeParaBusca);  
     if (indiceRetornado != -1){
        printf("\nNome foi encontrado e esta no indice %d da lista de nomes.", indiceRetornado);                     
     }else{
        printf("\nO nome não foi encontrado!");       
     }                            
     
     printf("\n");  
     system("PAUSE");
}
