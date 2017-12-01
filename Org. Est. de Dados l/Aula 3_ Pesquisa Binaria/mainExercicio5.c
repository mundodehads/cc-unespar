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

int buscaLinear(int lista[],int tamanhoTotal,int chave){
    int i;
    for(i = 0; i < tamanhoTotal; i++){
         if(lista[i] == chave){                  
            return i;          
         }
     }          
    return -1;
}

int listaDeNumeros[15];

main() {
     int numeroParaBusca;  
     int indice;
     int codigoBusca;
     for(indice = 0; indice < 15; indice++){
        printf("Digite o %d numero p/ o indice %d: ", indice + 1, indice);        
        scanf("%d", &listaDeNumeros[indice]);
     }                                             
            
     printf("\nDigite um numero para realizar a busca binaria: ");
     scanf("%d", &numeroParaBusca);
     
     printf("\n1 - BUSCA BINARIA ");
     printf("\n2 - BUSCA LINEAR ");     
     printf("\nTipo de Busca:");
     scanf("%d", &codigoBusca);
     
     int indiceRetornado = -1;
     if (codigoBusca == 1){
        indiceRetornado = buscaBinaria(listaDeNumeros, 15 , numeroParaBusca);              
     } else if (codigoBusca == 2){
        indiceRetornado = buscaLinear(listaDeNumeros, 15 , numeroParaBusca);                 
     }      
      
     if (indiceRetornado != -1){
        printf("\nNumero foi encontrado e esta no indice %d da lista de numeros.", indiceRetornado);                     
     }else{
        printf("\nO numero nao foi encontrado!");       
     }                            
     
     printf("\n");  
     system("PAUSE");
}
