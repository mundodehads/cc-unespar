#include <stdio.h>
#include <stdlib.h>

struct pessoa{
    int codigo;
    char nome[50];
};

struct pessoa listaDePessoas[4];

main(){
       int  i;
       for (i = 0 ; i < 4; i++){
         printf("Digite o codigo da %d pessoa:", i + 1);    
         scanf("%d", &listaDePessoas[i].codigo);         
         printf("Digite o nome da %d pessoa:", i + 1);    
         setbuf(stdin, NULL);         
         gets(listaDePessoas[i].nome);                
      }
          
      for (i = 0; i < 4; i++){
          printf("\n\nCodigo: %d", listaDePessoas[i].codigo);
          printf("\nNome  : %s", listaDePessoas[i].nome);
      }
      
      printf("\n");
      system("PAUSE");
}
