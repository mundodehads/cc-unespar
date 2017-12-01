#include <stdio.h>
#include <stdlib.h>
#include<string.h>

main (){
	char *string = NULL;
	string=(char*) malloc(sizeof(char)*strlen("UMA STRING"));
	strcpy(string, "UMA STRING");
	printf("%s\n", string);
	string=(char*) realloc(string, sizeof(char)*strlen("UMA STRING QUALQUER"));
	strcpy(string, "UMA STRING QUALQUER");
	printf("%s\n", string);
	free(string);
	system("PAUSE");
}
