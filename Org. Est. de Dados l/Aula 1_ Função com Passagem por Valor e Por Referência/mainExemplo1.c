#include <stdio.h>
#include <stdlib.h>

float sqr (float num) {
	 num = (num * num) / 3; 
 	 return num; 
 }

void main (){ 
 	float num;
     float sq; 
 	printf ("Entre com um numero: "); 
 	scanf ("%f", &num); 
 	sq = sqr(num); 
 	printf ("\n\n O numero original: %.2f\n", num); 
 	printf ("O seu quadrado vale: %f\n", sq); 
    system("PAUSE");
 }
