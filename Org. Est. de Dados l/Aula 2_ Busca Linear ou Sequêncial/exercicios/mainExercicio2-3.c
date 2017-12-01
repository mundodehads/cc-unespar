#include <stdio.h>
#include <stdlib.h>

int buscaLinear(int lista[], int tamanho, int media) {
    int indice;
    int quantidade = 0;
    for(indice = 0; indice < tamanho ; indice++){
         if (lista[indice] > media) {        
            quantidade++;            
        }
    }    
    return quantidade; 
}

float listaDeNotas[4];

main() {
     float mediaParaBusca;  
     int indice;
     for(indice = 0; indice < 4; indice++){
        printf("Digite a %d nota: ", indice + 1);        
        scanf("%f", &listaDeNotas[indice]);
     }       
            
     printf("\nDigite uma media para realizar a busca: ");
     scanf("%f", &mediaParaBusca);
     int quantidade = buscaLinear(listaDeNotas, 4 , mediaParaBusca);  
     if (quantidade > 0){
        printf("\nExiste %d notas acima da media de %.2f!", quantidade, mediaParaBusca);                     
     }else{
        printf("\nNenhuma nota esta acima da media!");       
     }                            
     
     printf("\n");  
     system("PAUSE");
}
