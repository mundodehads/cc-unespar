#include<stdio.h>
#include<conio.h>
#include<process.h>
#include<math.h>

//get
int Receber(int n){
	char ab = 'B';
	int flag = 0;
	if(n == 1){
		ab='A';
	}
	do {
		printf("Informe o valor de %c: ", ab);
		scanf("%d",&n);
		if(n < 0){
			n = n * -1;
			flag = 1;
		}
		if(9 <= n){
			printf("\nERRO: Informe um numero entre -9 e 9 !");	
		}
	} while(9 <= n);
	if(flag){
		n = n*-1;
	}
	return(n);
}

void Adicionar(int *a, int *b){
	int aux;
	int cont = 0;
	for(int i=3;i>=0;i--){
		aux = a[i];
		a[i] = cont^aux^b[i];
		if(cont == 1 && aux == 1 || aux == 1 && b[i] == 1|| b[i] == 1 && cont == 1){
			cont = 1;	
		} else {
			cont = 0;
		}
	}
}

void BinarioEquivalente(int n, int*arr){
	int i;
	int aux = n;
	int cont[4] = {0,0,0,1};
	for(i=0;i<4;i++){
		arr[i] = 0;
	}
	if(n < 0){
		n = n *-1;
	}
	i = 3;
	do {
		arr[i] = n%2;
		n = n/2;
		i--;
	} while(n != 0);
	if(aux < 0){
		for(i=0;i<4;i++){
			arr[i]=1-arr[i];	
		}
		Adicionar(arr,cont);
	}
	printf("\n\nO binario equivalente do %d e: ", aux);
	for(i=0;i<4;i++){
		printf("%d",arr[i]);
	}
}

void RetornarTroca(int x,int *y){
	for(int i=3;i>0;i--)
	y[i] = y[i-1];
	y[0] = x;
}

void Multiplicacao(){
	int q=0, s=0, z=0, x=0, c=0;
	int i, j,temp, y;
	int Q[4], M[4], temp1[4], ans[8];
	int A[4]={0,0,0,0}, C[4]={0,0,0,1}, C1[8]={0,0,0,0,0,0,0,1};
	
	int a = Receber(1);
	int b = Receber(0);
	BinarioEquivalente(a,M);
	BinarioEquivalente(b,Q);
	
	printf("\n\nOperacao:\t\t A\t Q\tQ'\t M");
	printf("\n\n Inicial\t\t");
	for(i=0;i<4;i++){
		printf("%d", A[i]);
	}
	printf("\t");
	for(i=0;i<4;i++){
		printf("%d", Q[i]);	
	}
	printf("\t");
	printf("%d\t", q);
	for(i=0;i<4;i++){
		printf("%d", M[i]);	
	}
	for(j=0;j<4;j++){
		if(Q[3] == 0 && q == 1){
			printf("\n A:=A+M \t\t");
			Adicionar(A,M);
			for(i=0;i<4;i++){
				printf("%d", A[i]);	
			}
			printf("\t");
			for(i=0;i<4;i++){
				printf("%d", Q[i]);	
			}
			printf("\t%d\t", q);
			for(i=0;i<4;i++){
				printf("%d", M[i]);
			}
		}
		if(Q[3] == 1 && q == 0){
			printf("\n A:=A-M \t\t");
			for(i=0;i< 4;i++){
				temp1[i] = 1-M[i];
			}
			Adicionar(temp1,C);
			Adicionar(A,temp1);
			for(i=0;i<4;i++){
				printf("%d", A[i]);	
			}
			printf("\t");
			for(i=0;i<4;i++){
				printf("%d", Q[i]);
			}
			printf("\t%d\t",q);
			for(i=0;i<4;i++){
				printf("%d", M[i]);
			}
		}
		printf("\n Troca \t\t\t");
		y = A[3];
		q = Q[3];
		RetornarTroca(A[0],A);
		RetornarTroca(y,Q);
		for(i=0;i<4;i++){
			printf("%d", A[i]);
		}
		printf("\t");
		for(i=0;i<4;i++){
			printf("%d", Q[i]);
		}
		printf("\t");
		printf("%d\t",q);
		for(i=0;i<4;i++){
			printf("%d", M[i]);
		}
	}
	printf("\n\nResultado em binario: ");
	for(i=0;i<4;i++){
		ans[i]=A[i];
	}
	for(i=0;i<4;i++){
		ans[i+4]=Q[i];
	}
	if(a < 0 && b > 0 || a > 0 && b < 0){
		for(i=0;i<8;i++){
			ans[i]=1-ans[i];
		}
		for(i=7;i>=0;i--){
			x = ans[i];
			ans[i]=c^x^C1[i];
			if(c == 1 && x == 1 || x == 1 && C1[i] == 1 || C1[i] == 1 && c == 1){
				c=1;
			} else {
				c=0;
			}
		}
	}
	for(i=0;i<8;i++){
		printf("%d", ans[i]);
	}
	for(i=7;i>=0;i--){
		s = s + (pow(2,z) * ans[i]);
		z = z+1;
	}
	if(a < 0 && b > 0 || a > 0 && b < 0){
		printf("\nResultado em decimal: -%d\n", s);
	} else {
		printf("\nResultado em decimal: %d\n", s);
	}

	getch();
}

void Menu (){
	printf("Multiplicacao e Divisao em Complemento de 2.\n\n");
	printf("Escolha a operacao:\n");
	printf("[1] Multiplicacao.\n");
	printf("[2] Divisao.\n");
	printf("[3] Sair.\n");
	
	int escolha;
	printf(">");
	scanf("%i",&escolha);
	
	switch (escolha){
		case 1: {
			setbuf(stdin, NULL);
			system("cls");
			Multiplicacao();
			system("cls");
			Menu();
			break;
		}
		case 2: {
			printf("\nERRO: Divisao nao implementada no sistema !\n");
			getch();
			system("cls");
			Menu();
			break;
		}
		case 3: {
			system("cls");
			printf("Programado por: Henrique Alves da Silva, 2 Ano em Ciencia da Computacao.\n\n");
			printf("Obrigado !\n");
			getch();
			exit(0);
			break;
		}
		default: {
			printf("\nERRO: Opcao inexistente !\n");
			getch();
			system("cls");
			Menu();
			break;
		}
	}
}

main (){
	Menu();
}
