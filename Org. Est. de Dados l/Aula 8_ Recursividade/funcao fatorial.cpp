#include <stdio.h>
#include <stdlib.h>

int fatorial (int n){
	if(n == 0){
		return 1;
	}else{
		n=n*fatorial(n-1);
	}
	return n;
}

main () {
	int num, result;
	printf("Digite o numero:");
	scanf("%d",&num);
	result=fatorial(num);
	printf("Resultado Do Fatorial = %d\n", result);
	system("PAUSE");
}
