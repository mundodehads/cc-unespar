#include <stdio.h>
#include <stdlib.h>

main () {
	int i;
	int vetor[3]={4,7,1};
	int *p = vetor;
	printf("%p\n", vetor);
	printf("%p\n", &vetor);
	printf("%p\n", p);
	printf("%p\n", &p);
	for(i=0;i<3;i++){
		printf("O endereco do indice %d do vetor e %p\n", i, &p[i]);
		printf("O valor do indice %d do vetor e %d\n", i, p[i]);
		printf("O valor do indice %d do vetor e %d\n", i, vetor[i]);
	}
	system("PAUSE");
}
