#include <stdio.h>
#include <stdlib.h>

struct produto {
       int codigo;
       char nome[50];
       struct produto *proximo;
}; 
     
struct produto *inicio = NULL;

void inserirNoInicio(struct produto *prod){          
          prod->proximo = inicio;
          inicio = prod; 
          printf("Inserido com sucesso!");                                                 
} 

void inserirNoFinal(struct produto *prod){
        struct produto *aux = inicio;
        while (aux->proximo != NULL) {        
           aux = aux->proximo;
        }                
        aux->proximo = prod;         
        printf("Inserido com sucesso!");           
}        

void inserirEntreElementos(struct produto *prod){
        int cod;
        printf("Digite o codigo do produto anterior: ");
        scanf("%d", &cod);        
        struct produto *aux = inicio;
        while (aux != NULL) {
               if (aux->codigo == cod){
                   prod->proximo = aux->proximo;            
                   aux->proximo = prod;  
                   printf("Inserido com sucesso!");         
                   return;            
               }                                              
               aux = aux->proximo;
        }  
        printf("Codigo nao foi encontrado!");         
} 

void excluirNoInicio(){ 
        struct produto *aux = inicio->proximo;     
        free(inicio);
        inicio = aux;                                               
        printf("Excluido com sucesso!");              
} 

void excluirNoFinal(){
        struct produto *aux = inicio;
        if (aux->proximo == NULL){                         
            excluirNoInicio();             
        } else {                  
            while (aux->proximo->proximo != NULL) {        
                aux = aux->proximo;             
            }                
            free(aux->proximo);        
            aux->proximo = NULL; 
            printf("Excluido com sucesso!");        
        }
}        

void excluirEntreElementos(){
        int cod;
        printf("Digite o codigo do produto: ");
        scanf("%d", &cod);        
        struct produto *aux = inicio;
        if (aux->codigo == cod){
           excluirNoInicio();                                
        } else {                        
           while (aux->proximo != NULL) {
               if (aux->proximo->codigo == cod){
                 struct produto *prodAExcluir = aux->proximo;
                 aux->proximo = aux->proximo->proximo;
                 free(prodAExcluir);                     
                 printf("Excluido com sucesso!");
                 return;           
               }                                          
               aux = aux->proximo;
           }  
           printf("Codigo nao foi encontrado!");  
        }       
}  

void excluir(){
     if (inicio == NULL){
         printf("A Lista esta vazia!");     
     } else {
         printf("1 - Excluir o primeiro da lista\n");       
         printf("2 - Excluir ultimo da lista\n");       
    printf("3 - Excluir entre elementos da lista\n");
         printf("Digite a opcao: ");          
         int opcao;
         scanf("%d", &opcao);
         if (opcao == 1){
              excluirNoInicio();      
         } else if (opcao == 2){
              excluirNoFinal();  
         } else if (opcao == 3){
              excluirEntreElementos();   
         }                         
     }
     getch();
}     

void inserir(){
     struct produto *prod;
     prod = (struct produto*) 
               malloc(sizeof(struct produto));     
     printf("Digite o codigo:");
     scanf("%d", &prod->codigo);
     printf("Digite o nome:");
     setbuf(stdin, NULL);
     gets(prod->nome);      
     prod->proximo = NULL; 
     if (inicio == NULL) {
          inicio = prod;
          printf("Inserido com sucesso!");                
     } else {
          printf("1 - Inserir no inicio da lista\n");       
          printf("2 - Inserir no final da lista\n");       
          printf("3 - Inserir entre elementos da lista\n");
          printf("Digite a opcao: ");          
          int opcao;
          scanf("%d", &opcao);
          if (opcao == 1){
              inserirNoInicio(prod);      
          } else if (opcao == 2){
              inserirNoFinal(prod);  
          } else if (opcao == 3){
              inserirEntreElementos(prod);   
          }                              
     }  
     getch();
}      

void listar(){
     if (inicio == NULL){
         printf("A Lista esta vazia!");  
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
           printf("1 - Inserir\n");
           printf("2 - Excluir\n");
           printf("3 - Listar\n");        
           printf("0 - Sair\n");
           printf("Digite a opcao: ");
           scanf("%d",&op);           
           system("cls");           
           if (op == 1){
               inserir();
           } else if (op == 2) { 
               excluir();
           } else if (op == 3) {
               listar(); 
           }                                
  }  while(op!=0);
}
