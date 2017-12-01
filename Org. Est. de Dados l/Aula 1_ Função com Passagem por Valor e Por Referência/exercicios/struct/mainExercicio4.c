#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

struct estoque{
      int codigo;
      char nomeProduto[50];
      char corDoProduto[30];
      float quantidadeEstoque;
      float preco;
      char observacoes[150];
};

struct estoque listaDeEstoques[100];

main(){
       setlocale(LC_ALL, "");   
       int  i;
       for (i = 0; i < 100; i++){
         printf("Digite o código do %dº produto: ", i + 1); 
         scanf("%d", &listaDeEstoques[i].codigo);
         if ((listaDeEstoques[i].codigo) == 0){                     
            break;                            
         }                                                        
         printf("Digite o nome do %dº produto: ", i + 1);    
         setbuf(stdin, NULL);         
         gets(listaDeEstoques[i].nomeProduto);          
         printf("Digite a cor do %dº produto: ", i + 1);    
         setbuf(stdin, NULL);         
         gets(listaDeEstoques[i].corDoProduto); 
         printf("Digite a quantidade em estoque do %dº produto: ", i + 1);  
         scanf("%f", &listaDeEstoques[i].quantidadeEstoque); 
         printf("Digite o preço do %dº produto: ", i + 1);  
         scanf("%f", &listaDeEstoques[i].preco);
         printf("Digite as observações do %dº produto: ", i + 1);    
         setbuf(stdin, NULL);         
         gets(listaDeEstoques[i].observacoes);
         printf("\n");                 
      }    
      
      for (i = 0; i < 100; i++){
          if (listaDeEstoques[i].codigo == 0){
             break;                           
          }   
          printf("\n--------------------------------------------");                           
          printf("\nCódigo: %d", listaDeEstoques[i].codigo);
          printf("\nNome do Produto: %s", listaDeEstoques[i].nomeProduto);
          printf("\nCOR: %s", listaDeEstoques[i].corDoProduto);
          printf("\nQuantidade em estoque: %.2f", listaDeEstoques[i].quantidadeEstoque);
          printf("\nPreço: %.2f", listaDeEstoques[i].preco);
          printf("\nObservações: %s", listaDeEstoques[i].observacoes);
          printf("\n--------------------------------------------\n\n");
      }
      printf("\n");
      printf("\n");  
      system("PAUSE");
}
