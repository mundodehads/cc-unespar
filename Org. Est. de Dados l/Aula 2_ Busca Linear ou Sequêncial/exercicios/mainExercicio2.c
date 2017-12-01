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

int listaDeNumeros[10];

main() {
     int numeroParaBusca;  
     int indice;
     for(indice = 0; indice < 10; indice++){
        printf("Digite o %d numero: ", indice + 1);        
        scanf("%d", &listaDeNumeros[indice]);
     }       
            
     printf("\nDigite um numero para realizar a busca: ");
     scanf("%d", &numeroParaBusca);
     int indiceRetornado = buscaLinear(listaDeNumeros, 10 , numeroParaBusca);  
     if (indiceRetornado != -1){
        printf("\nNumero foi encontrado e esta no indice %d da lista de numeros.", indiceRetornado);                     
     }else{
        printf("\nO numero não foi encontrado!");       
     }                            
     
     printf("\n");  
     system("PAUSE");
}
