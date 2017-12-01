#include <stdio.h>
#include <stdlib.h>

main(){
int a, b;
int *pa, *pb;
a = 10;
b = 20;
pa = &a;
pb = &b;
printf("Valor da variavel a: %d\n", a);
printf("Endereco da memoria da variavel a: %p\n", &a);
printf("Valor da variavel b: %d\n", b);
printf("Endereco da memoria da variavel b: %p\n", &b);
printf("Endereco da memoria do ponteiro pa: %p\n", &pa);
printf("Endereco da memoria da variavel apontada por pa: %p\n", pa);
printf("Valor contido na variavel apontada pelo ponteiro pa: %p\n", *pa);
printf("Endereco da memoria do ponteiro pb: %p\n", &pb);
printf("Endereco da memoria da variavel apontada por pb: %p\n", pb);
printf("Valor contido na variavel apontada pelo ponteiro pb: %p\n\n", *pb);
system("PAUSE");
}
