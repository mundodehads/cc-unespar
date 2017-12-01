#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int buscaBinaria(char lista[][50], int tamanhoTotal, char chave[50]){
    int central;  
    int baixo = 0;
    int alto = tamanhoTotal - 1;  
    while (baixo <= alto) {
           central = (baixo + alto) / 2;           
           if (strcmp(chave, lista[central]) == 0)
                return central;
           else if (strcmp(chave, lista[central]) < 0)
                alto = central - 1;
           else 
                baixo = central + 1;           
    }    
    return -1;
}

char listaDeNomes[8][50];

main() {
     char nomeParaBusca[50];  
     int indice;
     for(indice = 0; indice < 8; indice++){
        printf("Digite o %d nome p/ o indice %d: ", indice + 1, indice); 
        setbuf(stdin, NULL);       
        gets(listaDeNomes[indice]);
     }       
            
     printf("\nDigite um nome para realizar a busca binaria: ");
     gets(nomeParaBusca);
     
     int indiceRetornado = buscaBinaria(listaDeNomes, 8 , nomeParaBusca);  
     if (indiceRetornado != -1){
        printf("\nNome foi encontrado e esta no indice %d da lista de nomes dos alunos.", indiceRetornado);                     
     }else{
        printf("\nO nome não foi encontrado!");       
     }                            
     
     printf("\n");  
     system("PAUSE");
}
