#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>

//Definido um valor maximo para a maquina de turing e outro para as transações, trocar por malloc.
#define MAX1 21
#define MAX2 200
//Recebe o tamanho maximo de estados.
int nestados = 0;
//Recebe o tamanho maximo de estados finais.
int MAXEF = 0;
//Recebe o tamanho maximo do alfabeto.
int MAXA = 0;
//Recebe o tamanho maximo do alfabeto auxiliar.
int MAXAA = 0;
//Recebe o numero de funcoes de transições.
int contft = 0;

//Iniciliza uma estrutura para a maquina de turing.
struct MaquinaDeTuring {
	char estados[100];
	char estadoinicial[100];
	int ei;
	char estadofinal[100];
	int ef;
	char alfabeto[2];
	char alfabetoauxiliar[2];
	char marcadorinicio;
	char simbolobranco;
}; struct MaquinaDeTuring MT[MAX1];

//Inicializa uma estrutara para as funções de transições.
struct funcaodetransicao {
	char nome[100];
	int estadoatual;
	int simboloatual;
	int estado;
	char estadoft[100];
	int altera;
	char alteraft[2];
	int movimenta;
	char movimentaft;
}; struct funcaodetransicao FT[MAX2];

//Função para receber o numero de estados e seus nomes.
void NES () {
	printf("Informe o numero de estados: ");
	scanf("%i",&nestados);
	if(nestados > MAX1){
		printf("ERRO: Valor de estados maior que o valor maximo !\n");
	}else {
		for(int i=0;i<nestados;i++){
			printf("Informe o nome do %i estado: ",i+1);
			setbuf(stdin, NULL);
			gets(MT[i].estados);
		}
	}
}

//Função para receber o estado inicial.
void EI () {
	printf("\nEscolha o estado inicial:\n");
	for(int i=0;i<nestados;i++){
		printf("[%i] %s\n",i+1, MT[i].estados);
	}
	int escolha;
	printf(">");
	scanf("%i",&escolha);
	if(escolha > (nestados+1) || escolha <= 0){
		printf("ERRO: Estado nao existente !\n");
		getch();
		system("CLS");
		EI();
	}else {
		strcpy(MT[0].estadoinicial, MT[escolha-1].estados);
		MT[0].ei = 1;
		printf("O estado %s, agora e o estado inicial.\n", MT[0].estadoinicial);
	}
}

//Função para escolher o(s) estado(s) final(is).
void EF () {
	int escolha;
	printf("\nInfome quantos estados sao finais: ");
	scanf("%i",&escolha);
	if(escolha > nestados+1){
		printf("ERRO: Numero de estados finais maior que estados existentes !\n");
		getch();
		system("CLS");
		EF();
	}else {
		MAXEF += escolha;
		printf("\nEscolha os estados finais: \n");
		for(int i=0;i<nestados;i++){
		printf("[%i] %s\n",i+1, MT[i].estados);
		}
		int escolha2;
		for(int i=0;i<MAXEF;i++){
			printf(">");
			scanf("%i",&escolha2);
			if(escolha > (nestados+1) || escolha2 <= 0){
			printf("ERRO: Estado nao existente !\n");
			getch();
			system("CLS");
			EF();
			}else {
				strcpy(MT[i].estadofinal, MT[escolha2-1].estados);
				MT[escolha2-1].ef = 1;
				printf("O estado %s, agora e o estado final.\n", MT[i].estadofinal);
			}
		}
	}
}

//Função para receber o tamanho e os simbolos do alfabeto.
void TA () {
	int escolha;
	printf("\nInforme o tamanho do alfabeto: ");
	scanf("%i",&escolha);
	MAXA += escolha;
	for(int i=1;i<=MAXA;i++){
		printf("Informe o %i simbolo do alfabeto: ", i);
		setbuf(stdin, NULL);
		gets(MT[i].alfabeto);
	}
}

//Função para receber o tamanho e os simbolos do alfabeto auxiliar.
void TAA () {
	int escolha;
	printf("\nInforme o tamanho do alfabeto auxiliar: ");
	scanf("%i",&escolha);
	MAXAA = escolha+MAXA;
	for(int i=MAXA+1;i<=MAXAA;i++){
		printf("Informe o %i simbolo do alfabeto auxiliar: ", (i)-MAXA);
		setbuf(stdin, NULL);
		gets(MT[i].alfabetoauxiliar);
	}
	MAXAA -= MAXA;
}

//Função para informar os nomes do marcador de inicio e do simbolo do branco.
void PIB () {
	char marcadorinicio = {'<'};
	MT[0].marcadorinicio = marcadorinicio;
	char simbolobranco = {'#'};
	MT[20].simbolobranco = simbolobranco;
}

//Função para preechimento das funções de transições da maquina de turing.
void PFT () {
	system("cls");
	//int cont1= 1, cont2=MAXA+1, cont3=0, parada, e, a, m;
	printf("Informe as funcoes de transicoes.\n\n");
	printf("[E] disponiveis: ");
	for(int i=0;i<nestados;i++){
		printf("[%i]%s\t", i+1, MT[i].estados);
	}
	printf("\n[A] disponveis: ");
	for(int i=1;i<=(MAXA+MAXAA);i++){
		if(i<=MAXA){
			printf("[%i]%s\t", i, MT[i].alfabeto);
		}else {
			printf("[%i]%s\t", i, MT[i].alfabetoauxiliar);
		}
	}
	printf("[0]%c\t", MT[0].marcadorinicio);
	printf("[20]%c\t", MT[20].simbolobranco);
	printf("\n[M]ovimentos disponiveis: 0\t1\t\n\n");
	printf("Legenda:\nE = Estado que a transicao leva o simbolo.\nA = Altera o simbolo para o novo A.\n");
	printf("M = Direcao do movimento - [0]Esquerda/[1]Direita.\n< = Marcador do inicio.\n");
	printf("# = Simbolo do branco/vazio.\n999 = Nenhuma acao existente.\n\n");
	int parada, e, a, m;
	for(int i=0;i<nestados;i++){
		parada = 0;
		int cont1= 1, cont2=MAXA+1, cont3=0;
		do{
			if(cont1 <= MAXA){
				strcpy(FT[contft].nome, MT[i].estados);
				strcat(FT[contft].nome, " , ");
				strcat(FT[contft].nome, MT[cont1].alfabeto);
				FT[contft].estadoatual = i;
				FT[contft].simboloatual = cont1;
				cont1++;
				printf("[%s] = E, A, M\n", FT[contft].nome);
				printf("E: ");
				scanf("%i",&e);
				if (e == 999){
					strcpy(FT[contft].estadoft, "X");
				}else if (e > (nestados+1)){
					printf("ERRO: Numero de estado inexistente !\n");
					getch();
					PFT();
				} else {
					FT[contft].estado = e-1;
					strcpy(FT[contft].estadoft, MT[e-1].estados);
				}
				printf("A: ");
				scanf("%i",&a);
				if (a == 999){
				}else if (a == 20){
					FT[contft].altera = a;
					strcpy(FT[contft].alteraft, "#");
				}else if(a > (MAXA+MAXAA)){
					printf("ERRO: Numero dos alfabetos inexistente !\n");
					getch();
					PFT();
				}else if(a == 0){
					FT[contft].altera = a;
					strcpy(FT[contft].alteraft, "<");
				} else {
					FT[contft].altera = a;
					if(a <= MAXA){
						strcpy(FT[contft].alteraft, MT[a].alfabeto);
					}else {
						strcpy(FT[contft].alteraft, MT[a].alfabetoauxiliar);
					}
				}
				printf("M: ");
				scanf("%i",&m);
				if (m == 999){
				}else if (m > 1){
					printf("ERRO: Numero dos movimentos inexistente !\n");
					getch();
					PFT();
				}else {
					FT[contft].movimenta = m;
					if(m == 0){
						char esquerda = {'E'};
						FT[contft].movimentaft = esquerda;
					}else {
						char direita = {'D'};
						FT[contft].movimentaft = direita;
					}
				}
				contft++;
			}else if(cont2 <= (MAXAA+MAXA)){
				strcpy(FT[contft].nome, MT[i].estados);
				strcat(FT[contft].nome, " , ");
				strcat(FT[contft].nome, MT[cont2].alfabetoauxiliar);
				FT[contft].estadoatual = i;
				FT[contft].simboloatual = cont2;
				cont2++;
				printf("[%s] = E, A, M\n", FT[contft].nome);
				printf("E: ");
				scanf("%i",&e);
				if (e == 999){
					strcpy(FT[contft].estadoft, "X");
				}else if (e > (nestados+1)){
					printf("ERRO: Numero de estado inexistente !\n");
					getch();
					PFT();
				} else {
					FT[contft].estado = e-1;
					strcpy(FT[contft].estadoft, MT[e-1].estados);
				}
				printf("A: ");
				scanf("%i",&a);
				if (a == 999){
				}else if (a == 20){
					FT[contft].altera = a;
					strcpy(FT[contft].alteraft, "#");
				}else if(a > (MAXA+MAXAA)){
					printf("ERRO: Numero dos alfabetos inexistente !\n");
					getch();
					PFT();
				}else if(a == 0){
					FT[contft].altera = a;
					strcpy(FT[contft].alteraft, "<");
				} else {
					FT[contft].altera = a;
					if(a <= MAXA){
						strcpy(FT[contft].alteraft, MT[a].alfabeto);
					}else {
						strcpy(FT[contft].alteraft, MT[a].alfabetoauxiliar);
					}
				}
				printf("M: ");
				scanf("%i",&m);
				if (m == 999){
				}else if (m > 1){
					printf("ERRO: Numero dos movimentos inexistente !\n");
					getch();
					PFT();
				}else {
					FT[contft].movimenta = m;
					if(m == 0){
						char esquerda = {'E'};
						FT[contft].movimentaft = esquerda;
					}else {
						char direita = {'D'};
						FT[contft].movimentaft = direita;
					}
				}
				contft++;
				}else if(cont3 < 1){
					strcpy(FT[contft].nome, MT[i].estados);
					strcat(FT[contft].nome, " , <");
					FT[contft].estadoatual = i;
					FT[contft].simboloatual = 0;
					cont3++;
					printf("[%s] = E, A, M\n", FT[contft].nome);
				printf("E: ");
				scanf("%i",&e);
				if (e == 999){
					strcpy(FT[contft].estadoft, "X");
				}else if (e > (nestados+1)){
					printf("ERRO: Numero de estado inexistente !\n");
					getch();
					PFT();
				} else {
					FT[contft].estado = e-1;
					strcpy(FT[contft].estadoft, MT[e-1].estados);
				}
				printf("A: ");
				scanf("%i",&a);
				if (a == 999){
				}else if (a == 20){
					FT[contft].altera = a;
					strcpy(FT[contft].alteraft, "#");
				}else if(a > (MAXA+MAXAA)){
					printf("ERRO: Numero dos alfabetos inexistente !\n");
					getch();
					PFT();
				}else if(a == 0){
					FT[contft].altera = a;
					strcpy(FT[contft].alteraft, "<");
				} else {
					FT[contft].altera = a;
					if(a <= MAXA){
						strcpy(FT[contft].alteraft, MT[a].alfabeto);
					}else {
						strcpy(FT[contft].alteraft, MT[a].alfabetoauxiliar);
					}
				}
				printf("M: ");
				scanf("%i",&m);
				if (m == 999){
				}else if (m > 1){
					printf("ERRO: Numero dos movimentos inexistente !\n");
					getch();
					PFT();
				}else {
					FT[contft].movimenta = m;
					if(m == 0){
						char esquerda = {'E'};
						FT[contft].movimentaft = esquerda;
					}else {
						char direita = {'D'};
						FT[contft].movimentaft = direita;
					}
				}
				contft++;
				}else {
					strcpy(FT[contft].nome, MT[i].estados);
					strcat(FT[contft].nome, " , #");
					FT[contft].estadoatual = i;
				    FT[contft].simboloatual = 20;
					cont3++;
					printf("[%s] = E, A, M\n", FT[contft].nome);
				printf("E: ");
				scanf("%i",&e);
				if (e == 999){
					strcpy(FT[contft].estadoft, "X");
				}else if (e > (nestados+1)){
					printf("ERRO: Numero de estado inexistente !\n");
					getch();
					PFT();
				} else {
					FT[contft].estado = e-1;
					strcpy(FT[contft].estadoft, MT[e-1].estados);
				}
				printf("A: ");
				scanf("%i",&a);
				if (a == 999){
				}else if (a == 20){
					FT[contft].altera = 20;
					strcpy(FT[contft].alteraft, "#");
				}else if(a > (MAXA+MAXAA)){
					printf("ERRO: Numero dos alfabetos inexistente !\n");
					getch();
					PFT();
				}else if(a == 0){
					FT[contft].altera = 0;
					strcpy(FT[contft].alteraft, "<");
				} else {
					FT[contft].altera = a;
					if(a <= MAXA){
						strcpy(FT[contft].alteraft, MT[a].alfabeto);
					}else {
						strcpy(FT[contft].alteraft, MT[a].alfabetoauxiliar);
					}
				}
				printf("M: ");
				scanf("%i",&m);
				if (m == 999){
				}else if (m > 1){
					printf("ERRO: Numero dos movimentos inexistente !\n");
					getch();
					PFT();
				}else {
					FT[contft].movimenta = m;
					if(m == 0){
						char esquerda = {'E'};
						FT[contft].movimentaft = esquerda;
					}else {
						char direita = {'D'};
						FT[contft].movimentaft = direita;
					}
				}
					parada = 1;
					contft ++;
					} 
		}while (parada != 1);
	}
	
}

//Inicializa uma estrutura par uma fita.
struct fitadealfabeto {
	char fitadealfabeto[2][21];
}; struct fitadealfabeto fda;

//Preenche a fita de alfabeto com os simbolos disponiveis.
void PFDA () {
	for(int i=0;i<21;i++){
		if(i == 0){
			strcpy(fda.fitadealfabeto[i], "<");
		}
		if(i == 20){
			strcpy(fda.fitadealfabeto[i], "#");
		}else {
			if(i <= MAXA){
				strcpy(fda.fitadealfabeto[i], MT[i].alfabeto);
			} else if (i <= (MAXA+MAXAA)){
				strcpy(fda.fitadealfabeto[i], MT[i].alfabetoauxiliar);
			} else {
				strcpy(fda.fitadealfabeto[i], "#");
			}
		}
		
	}
}

//Iniciliza uma fita.
struct Fita {
	char fita[2][21];
}; struct Fita f;

//Preenche a fita com seu inicio e brancos.
void PF () {
	strcpy(f.fita[0], "<");
	for(int i=1;i<21;i++){
		strcpy(f.fita[i], "#");
	}	
}

//contador da posição atual utilizada na fita.
int posicaoatual = 1;

//Realiza o caminho na fita para verificar a palavra e a posição retornada.
void CF (){
	int estadoatual = 0;
	for(int i=0;i<contft;i++){
		if(estadoatual == FT[i].estadoatual){
			if(strcmp(f.fita[posicaoatual], fda.fitadealfabeto[FT[i].simboloatual])){
				if(strcmp(FT[i].estadoft, "X")){
				}else{
				estadoatual = FT[i].estado;
				strcpy(f.fita[posicaoatual], MT[FT[i].altera].estados);
				if(FT[i].altera == 0){
					strcpy(f.fita[posicaoatual], "<");
				}
				if(FT[i].altera == 20){
					strcpy(f.fita[posicaoatual], "#");
				}
				if(FT[i].altera <= MAXA){
					strcpy(f.fita[posicaoatual], MT[FT[i].altera].alfabeto);
				}else {
					strcpy(f.fita[posicaoatual], MT[FT[i].altera].alfabetoauxiliar);
				}
				if(FT[i].movimenta == 0){
					posicaoatual--;
				}
				if(FT[i].movimenta == 1){
					posicaoatual++;
				}
				}
			}
		}
	}
}

//Inicializa uma chamada de simulação de uma mt reconhecedora.
void Reconhecedora (){
	char novosimbolo[2];
	printf("Informe a palavra na fita:\n");
	printf("Obs: digite X para parar, exemplo de novo simbolo: a, 0, c, 1, B, C.\n\n");
	printf("... |");
	for(int i=0;i<3;i++){
		printf(" [%i]%s |", i, f.fita[i]);
	}
	printf(" ...\n\n");
	int cont;
	char parada[2] = {"X"};
	do {
		setbuf(stdin, NULL);
		printf("[%i] = ", cont);
		gets(novosimbolo);
		if(strcmp(novosimbolo, parada)){
			cont=21;
		}else {
			strcpy(f.fita[cont], novosimbolo);
			cont++;
		}
	} while (cont != 21);
	CF();
	CF();
	system("cls");
	if(posicaoatual == 1){
		printf("A Palavra foi aceita !\n");
		getch();
	}else {
		printf("A Palavra nao e aceita !\n");
		getch();
	}
}

//Iniciliza a chamada de um simulador de uma mt transdutora.
void Transdutora () {
	char novosimbolo[2];
	printf("Informe a palavra na fita:\n");
	printf("Obs: digite X para parar, exemplo de novo simbolo: a, 0, c, 1, B, C.\n\n");
	printf("... |");
	int cont;
	char parada[2] = {"X"};
	do {
		setbuf(stdin, NULL);
		printf("[%i] = ", cont);
		gets(novosimbolo);
		if(strcmp(novosimbolo, parada)){
			cont=21;
		}else {
			strcpy(f.fita[cont], novosimbolo);
			cont++;
		}
	} while (cont != 21);
	CF();
	system("cls");
	if(posicaoatual == 1){
		printf("A Palavra na fita retornou como:\n");
		printf("... |");
		for(int i=0;i<21;i++){
		printf(" [i]%s |", i, f.fita[i]);
		}
		printf(" ...\n\n");
		getch();
	}else {
		printf("ERRO: Palavra nao faz parte da funcao de transicao !!!\n");
		getch();
	}
}

//Preenche a maquina de turing com sua descrição formal.
void PMT () {
	NES();
	EI();
	EF();
	TA();
	TAA();
	PIB();
	PFT();
}

//Apresenta a maquina de turing em sua descrição formal.
void MMT () {
	system("cls");
	printf("Estados:\t");
	for(int i=0;i<nestados;i++){
		printf("%s\t", MT[i].estados);
	}
	printf("\nEstado inicial:\t%s", MT[0].estadoinicial);
	printf("\nEstado(s) final(is):\t");
	for(int i=0;i<MAXEF;i++){
		printf("%s\t", MT[i].estadofinal);
	}
	printf("\n\nAlfabeto:\t");
	for(int i=1;i<=MAXA;i++){
		printf("%s\t", MT[i].alfabeto);
	}
	printf("\nAlfabeto auxiliar:\t");
	for(int i=MAXA+1;i<=(MAXAA+MAXA);i++){
		printf("%s\t", MT[i].alfabetoauxiliar);
	}
	printf("\n\nMarcador de inicio: %c", MT[0].marcadorinicio);
	printf("\nSimbolo do branco: %c\n", MT[20].simbolobranco);	
	printf("\nFuncoes de transicoes:\n");
	for(int i=0;i<contft;i++){
		printf("[%s] = %s, %s, %c\n", FT[i].nome, FT[i].estadoft, FT[i].alteraft, FT[i].movimentaft);
	}
	getch();
	system("cls");
}

//Menu de appresentação de opções para teste de simulação.
void Menu () {
	system("cls");
	printf("Simulador de Maquina de Turing Reconhecedora e Transdutora !\n\n");
	printf("Escolha uma opcao para teste:\n");
	printf("[1] Reconhecedora.\n");
	printf("[2] Transdutora.\n");
	printf("[3] Sair.\n");
	int escolha;
	printf(">");
	scanf("%i",&escolha);
	switch (escolha){
		case 1: {
			system("cls");
			Reconhecedora();
			Menu();
			break;
		}
		case 2: {
			system("cls");
			Transdutora();
			Menu();
			break;
		}
		case 3: {
			system("cls");
			printf("Trabalho programado por Henrique Alves da Silva, 2 Ano de ciencias da computacao - UNESPAR\n");
			system("exit");
			break;
		}
		default: {
			
			break;
		}
	}
}

//Chamada inicial do programa.
main () {
	PMT();
	PFDA();
	PF();
	MMT();
	Menu();
}
