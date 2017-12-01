//	Trabalho Prático do 1º Bimestre
// 	Simulador de memória cache
//
//  2º Ano Ciências da Computação - UNESPAR
//
//	Bianca Lee Azuma
//	Henrique Alves da Silva

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <conio.h>
#include <time.h>

//Função para criação da simulação de uma memoria principal de tamanho 1000.
struct MemoriaPrincipal {
	int dado;
};
struct MemoriaPrincipal MP[1000];

//Função para criação da simulação de uma memoria cache de tamanho 10.
struct MemoriaCache {
	int dado;
	//Ponto da memória principal que foi recebido o dado.
	int pontoMP;
	//Disponibilidade de utilização da cache, usada de indentificador com 0 ou 1.
	int disponivel;
}; 
struct MemoriaCache MC[10];

//Função para preenchimento automatico da memória principal em cada posição.
//PMP = Preenchimento da Memoria Principal.
//PM = Posicionamento da Principal.
void PMP () {
	srand(time (NULL));
	for(int i=0;i<1000;i++){
		MP[i].dado=rand () % 100000;
	}
}

//Função para preenchimento automatico da memória cache em cada posição.
//PMC = Preenchimento da Memoria Cache.
void PMC (){
	for (int i=0;i<10;i++){
		MC[i].dado = NULL;
		// Controle de politica write-back
		MC[i].disponivel = 0;
	}
}

//Registrador de LOG
int cLOG = 0;
struct LOG {
	int dadoMP;
	int pMP;
	int dadoMC;
	int pMC;
	int disponivel;
	int tipo;
}; struct LOG LOG[20];

void PLOG () {
	for(int i=0;i<20;i++){
		LOG[i].disponivel = 0;
	}
}

//Função para realizar a limpeza da memória cache depois de cheia, recebe o valor x para diferenciar com leitura [0] e leitura/modificação [1].
//c1LC = Contador 1 da Limpeza da Cache, utiliza-se para contagem de quando começa efetuar a limpeza.
int c1LC = 0;
//LC = Limpeza da Cache.
void LC (){
	for (int i=0; i<10;i++){
		if (MC[i].disponivel == 1){
			MP[MC[i].pontoMP].dado = MC[i].dado;
			MC[i].disponivel = 0;
		}
	}
}


//Função para realizar o mapeamento associativo para armazenar dados na memoria cache.
//MA = Mapeamento Associativo.
void MA (int x, int y) {
	srand(time (NULL));
	int j = 0;
	int r[1000];
	int c = 0;
	do {	
		r[j] = rand () % 10;
		if (MC[r[j]].disponivel == 0) {
			MC[r[j]].dado = x;
			MC[r[j]].pontoMP = y;
			MC[r[j]].disponivel = 1;
			LOG[cLOG].dadoMC = MC[r[j]].dado;
			LOG[cLOG].pMC = r[j];
			LOG[cLOG].disponivel = 1;
			c1LC = c1LC + 1;;
			c = 1;
		}
		j = j + 1;

		} while ( c == 0 );
	cLOG = cLOG+1;
	int rg = r[j];	
}

//Função para leitura de um dado.
//LD = Leitura de Dado.
void LD () {
	int p;
	printf("Informe uma posicao [0-999] da memoria principal para leitura:");
	scanf("%i",&p);
	if (p > 999){
		printf("Valor maior que 999 ou menor que 0, por favor informe novamente um valor valido !");
		getch();
		system("CLS");
		LD();
	} else {
		// Verificação do contador da Limpeza da Cache, verifica se a cache está cheia antes de realizar o mapeamento associativo.
		if (c1LC == 10) {
			c1LC = 9;
			LC();
		}
		// Informa o ponto recebido da Memoria Principal e o dado contido nele para o Mapeamento Associativo.
		LOG[cLOG].dadoMP = MP[p].dado;
		LOG[cLOG].pMP = p;
		LOG[cLOG].tipo = 0;
		MA(MP[p].dado, p);
		system("CLS");
		printf("Sua escolha retornou: \n\n");
		printf("        Memoria Principal      \n");
		printf("------------------------------\n");
		printf(" %i - %i\n", p, MP[p].dado);
		printf("------------------------------\n\n");
		printf("         Memoria Cache        \n");
		printf("------------------------------\n");
		for(int i=0;i<10;i++){
			printf(" %i - %i\n", i, MC[i].dado);
			printf("------------------------------\n");
		}
		printf("\nRegistro de LOG's:\n");
		for(int j=0;j<20;j++){
			if (LOG[j].disponivel == 0){
				j=20;
			} else {
				printf("LOG %i | [%i] | MP[%i] = %i / MC[%i] = %i.\n", j, LOG[j].tipo, LOG[j].pMP, LOG[j].dadoMP, LOG[j].pMC, LOG[j].dadoMC);
			}
		}
		getch();
		system("CLS");
	}
}

//Função para leitura e modificação de um dado.
//LMD = Leitura e Modificação de Dado.
void LMD () {
	int p;
	printf("Informe uma posicao [0-999] da memoria principal para leitura/modificacao:");
	scanf("%i",&p);
	if (p > 999){
		printf("Valor maior que 999 ou menor que 0, por favor informe novamente um valor valido !");
		getch();
		system("CLS");
		LD();
	} else {
		// Verificação do contador da Limpeza da Cache, verifica se a cache está cheia antes de realizar o mapeamento associativo.
		if (c1LC == 10) {
			c1LC = 9;
			LC();
		}
		LOG[cLOG].dadoMP = MP[p].dado;
		LOG[cLOG].pMP = p;
		LOG[cLOG].tipo = 1;
		srand(time (NULL));
		int novodado=rand () % 100000;
		// Informa o ponto recebido da Memoria Principal e o novo dado atribuido randomicamente para o Mapeamento Associativo.
		MA(novodado, p);
		system("CLS");
		printf("Sua escolha modificou: \n\n");
		printf("        Memoria Principal      \n");
		printf("------------------------------\n");
		printf(" %i - %i\n", p, MP[p].dado);
		printf("------------------------------\n\n");
		printf("         Memoria Cache        \n");
		printf("------------------------------\n");
		for(int i=0;i<10;i++){
			printf(" %i - %i\n", i, MC[i].dado);
			printf("------------------------------\n");
		}
		printf("\nRegistro de LOG's:\n");
		for(int j=0;j<20;j++){
			if (LOG[j].disponivel == 0){
				j=20;
			} else {
				printf("LOG %i | [%i] | MP[%i] = %i / MC[%i] = %i.\n", j, LOG[j].tipo, LOG[j].pMP, LOG[j].dadoMP, LOG[j].pMC, LOG[j].dadoMC);
			}
		}
	}
	getch();
	system("CLS");
}

//Menu para visualização e interação com o usuario.
void Menu () {
		printf("Simulador de Memoria Cache !\n\n");
		printf("Escolha uma opcao:\n");
		printf("[1] Leitura de um dado.\n");
		printf("[2] Leitura e modificacao.\n");
		printf("[3] Finalizar.\n");
		int escolha;
		printf(">");
		scanf("%i",&escolha);
		switch (escolha) {
			case 1: {
				system("CLS");
				LD ();
				Menu ();
				break;
			}
			case 2: {
				system("CLS");
				LMD ();
				Menu ();
				break;
			}
			case 3: {
				system("CLS");
				printf("Programado por: \n\n");
				printf("Bianca Lee Azuma\n");
				printf("Henrique Alves da Silva\n\n");
				printf("2 ano, Ciencias da Computacao - UNESPAR\n\n");
				system("PAUSE");
				break;
			}
			default : {
				printf("Opcao inexistente !\n");
				getch();
				system("CLS");
				Menu ();
				break;
			}
		}
}
	
int main () {
	//Inicializando a simulação das memorias principal e cache.
	PMP ();
	PMC ();
	//Inicialização do menu.
	Menu();
}
