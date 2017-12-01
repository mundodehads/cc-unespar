#include <stdio.h>
#include <stdlib.h>
struct produto {
       int codigo;
       char nome[50];
       struct produto *proximo;
}; 
     
struct produto *topo = NULL;

void empilhar_Push(){ 
     struct produto *prod;
     prod = (struct produto*) malloc(sizeof(struct produto));
     if (prod == NULL){
          printf("OVERFLOW!");                    
          return;    
     }         
     printf("Digite o codigo:");
     scanf("%d", &prod->codigo);
     printf("Digite o nome:");
     setbuf(stdin, NULL);
     gets(prod->nome);      
     prod->proximo = NULL; 
     if (topo == NULL) {
          topo = prod;               
     } else {         
          prod->proximo = topo;
          topo = prod; 
     }                                                      
     printf("Empilhado com sucesso!"); 
     getch();
} 

void desempilhar_Pop(){ 
     if (topo == NULL){
         printf("UNDERFLOW!");  
     }else{
        struct produto *aux = topo->proximo;     
        free(topo);
        topo = aux;                                               
        printf("Desempilhado com sucesso!");              
     }   
     getch();
}     
    
void listar(){
     if (topo == NULL){
         printf("A Pilha esta vazia!");  
     } else {
         struct produto *aux;
         aux = topo;   
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
           printf("1 - Empilhar\n");
           printf("2 - Desempilhar\n");
           printf("3 - Listar\n");                                 
           printf("0 - Sair\n");
           printf("Digite a opcao: ");
           scanf("%d",&op);
           
           system("cls");
           
           if (op == 1){
               empilhar_Push();
           } else if (op == 2) { 
               desempilhar_Pop();
           } else if (op == 3) {
               listar(); 
           } 
           
  }  while(op!=0);
}
