#include <stdio.h>
#include <stdlib.h>

int buscaBinaria(int lista[], int tamanhoTotal, int chave){
    int central;  
    int baixo = 0;
    int alto = tamanhoTotal - 1;  
    while (baixo <= alto) {
           central = (baixo + alto) / 2;           
           if(chave == lista[central])
                return central;
           else if(chave < lista[central])
                alto = central-1;
           else 
                baixo = central + 1;           
    }    
    return -1;
}

int listaDeNumeros[10];

main() {
     int numeroParaBusca;  
     int indice;
     for(indice = 0; indice < 10; indice++){
        printf("Digite o %d numero p/ o indice %d: ", indice + 1, indice);        
        scanf("%d", &listaDeNumeros[indice]);
     }                   
     printf("\nDigite um numero para realizar a busca binaria: ");
     scanf("%d", &numeroParaBusca);
     
     int indiceRetornado = buscaBinaria(listaDeNumeros, 10 , numeroParaBusca);  
     if (indiceRetornado != -1){
        printf("\nNumero foi encontrado e esta no indice %d da lista de numeros.", indiceRetornado);                     
     }else{
        printf("\nO numero não foi encontrado!");       
     }                                 
     printf("\n");  
     system("PAUSE");
}
