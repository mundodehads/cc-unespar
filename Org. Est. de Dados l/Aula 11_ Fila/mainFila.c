#include <stdio.h>
#include <stdlib.h>
struct produto {
       int codigo;
       char nome[50];
       struct produto *proximo;
}; 
     
struct produto *inicio = NULL;
struct produto *fim = NULL;

void adicionar(){
     struct produto *prod;
     prod = (struct produto*) malloc(sizeof(struct produto));
     
     printf("Digite o codigo:");
     scanf("%d", &prod->codigo);
     printf("Digite o nome:");
     setbuf(stdin, NULL);
     gets(prod->nome);      
     prod->proximo = NULL; 
     if (inicio == NULL) {
          inicio = prod;
          fim = prod;          
     } else {                
          fim->proximo = prod; 
          fim = prod;         
     }     
     printf("Inserido com sucesso!"); 
     getch();         
}        

void retirar(){ 
     if (inicio == NULL){
         printf("A Fila esta vazia!");     
     } else {
        struct produto *segundo = inicio->proximo;     
        free(inicio);
        inicio = segundo;                                               
        printf("Retirado com sucesso!");              
     }
     getch();
}         

void listar(){
     if (inicio == NULL){
         printf("A Fila esta vazia!");  
     } else {
         struct produto *aux;
         aux = inicio;   
         while (aux != NULL) {
               printf("------------------------------\n");
               printf("Codigo: %d\n", aux->codigo);
               printf("Nome: %s\n", aux->nome);                              
               printf("------------------------------\n");
               aux = aux->proximo;
         }         
     }    
     getch();              
}                   

main(){
   int op;    
   do{
           system("cls");
           printf("1 - Adicionar\n");
           printf("2 - Retirar\n");
           printf("3 - Listar\n");           
           printf("0 - Sair\n");
           printf("Digite a opcao: ");
           scanf("%d",&op);
           
           system("cls");
           
           if (op == 1){
               adicionar();
           } else if (op == 2) { 
               retirar();
           } else if (op == 3) {
               listar(); 
           }                       
           
  }  while(op!=0);
}
