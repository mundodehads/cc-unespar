#include <stdio.h>
#include <stdlib.h>
#include <string.h>
 
void adicionarSobrenome(char nome[]) {
     char sobrenome[50];
     printf("Digite o sobrenome: ");     
     gets(sobrenome);   
     strcat(nome, " ");
     strcat(nome, sobrenome);
} 
 
main() { 
    char nome[50];
    printf("Digite o seu primeiro nome: ");
    gets(nome); 
    adicionarSobrenome(nome);
    printf ("\nNome completo: %s\n", nome); 
    system("PAUSE");
}
