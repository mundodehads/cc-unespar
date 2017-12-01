//Henrique Alves da Silva - 2º Ano Ciências da Computação - UNESPAR
//
//Obs¹: Na conversão de binario para decimal, quando informar o valor em binario, informar o numero desejado e completar o seu TAMANHOBINARIO com 0 a esquerda.
//Obs²: Escolha o tamanho dos valores binarios alterando o numero após o TAMANHOBINARIO, para teste está se inicializando com 12.
#define TAMANHOBINARIO 12

#include <stdio.h>
#include <stdlib.h>
#include <conio.h>

//Cria o valor MAXIMO pelo TAMANHOBINARIO e atribui o mesmo no conversor de binario para decimal.
int MAXIMO (){
	int MAXIMO[TAMANHOBINARIO];
	MAXIMO [0] = 1;
	for (int i=1;i<TAMANHOBINARIO;i++){
		MAXIMO[i] = MAXIMO[i-1]*2;
	}
	
	return MAXIMO[(TAMANHOBINARIO-1)];
}

//Faz a conversão de binario para decimal, atribuindo valores em bits para um conversor e verificando onde o binario é 1 para adicionar a soma do decimal.
int binario_decimal (int binario[]){
	int decimal = 0;
	int conversor[TAMANHOBINARIO];
	conversor[0] = MAXIMO();
	for (int c2=1;c2<TAMANHOBINARIO;c2++){
		conversor[c2] = conversor[c2-1]/2;
	}
	for (int i=0;i<TAMANHOBINARIO;i++){
		if (binario[i] == 1){
			decimal = decimal + conversor[i];
		}
	}
	return decimal;
}

//Recebe valores para conversão de binario para decimal e apresenta informações em tela.
void escolha_binario_decimal () {
	setbuf(stdin, NULL);
	int binario[TAMANHOBINARIO];
	for(int i=0;i<TAMANHOBINARIO;i++){
		printf("Binario: ");
		scanf("%d",&binario[i]);
	}
	int decimal = binario_decimal(binario);
	printf("\nDecimal: %i\n", decimal);
	getch();
	setbuf(stdin, NULL);
	system("CLS");
}

//Cria a variavel binario para retornar o valor da conversão de decimal para binario.
int binario[TAMANHOBINARIO];
int c=0;

//Faz a conersão de decimal para binario, usando um conversor com valores de bits já atribuidos, procura onde o decimal é menor ou igual, depois vai a sua esquerda e
//compara todos valores se o decimal é maior ou igual, se sim, adiciona 1 na posição do binario, caso não, se adiciona um 0.
void decimal_binario (int decimal) {
	int conversor[TAMANHOBINARIO];
	conversor [0] = 1;
	for (int c=1;c<TAMANHOBINARIO;c++){
		conversor[c] = conversor[c-1]*2;
	}
	int p;
	for (int i=0;i<TAMANHOBINARIO;i++){
		if (decimal <= conversor[i]){
			p = i;
		}
	}
	for (int j=p;j>=0;j--){
		if(decimal >= conversor[j]) {
			decimal = decimal - conversor[j];
			binario[c]=1;
			c++;
		} else {
			binario[c]=0;
			c++;
		}
	} 
}

//Recebe valores para conversão de decimal para binario e apresenta informações em tela.
void escolha_decimal_binario () {
	setbuf(stdin, NULL);
	int decimal;
	printf("Decimal: ");
	scanf("%i",&decimal);
	decimal_binario(decimal);
	printf("\nBinario: ");
	for(int i=0;i<TAMANHOBINARIO;i++){
		printf("%i",binario[i]);
	}
	printf("\n");
	getch();
	setbuf(stdin, NULL);
	system("CLS");
}

//Menu que recebe os valores da escolha e apresenta em tela o desejado.
void Menu (){
	int escolha;
	printf("Escolha  uma operacao:\n");
	printf("[1] Converter de decimal para binario.\n");
	printf("[2] Converter de binario para decimal.\n");
	printf("[3] Sair.\n");
	printf(">");
	scanf("%i",&escolha);
	switch (escolha) {
		case 1: {
			system("CLS");
			escolha_decimal_binario();
			Menu();
			break;
		}
		case 2: {
			system("CLS");
			escolha_binario_decimal();
			Menu();
			break;
		}
		case 3: {
			system("CLS");
			system("PAUSE");
			break;
		}
		default : {
			system("CLS");
			printf("Voce informou um numero errado !\n");
			getch();
			system("CLS");
			Menu();
			break;
		}
	}
}

//Onde o programa começa, contido somente a inicialização do menu.
int main () {
	Menu();
}
