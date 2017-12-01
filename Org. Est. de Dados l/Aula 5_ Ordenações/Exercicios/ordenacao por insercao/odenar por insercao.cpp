void ordenarPorInsercao(int lista[], int tamanho) {
     int i, j, aux;
     for(i=1;i<tamanho;i++){
       j=i;
       aux=lista[j];
       while(j>0 && aux<lista[j-1]){
         lista[j]=lista[j-1];
         j--;
       }
       lista[j]=aux;
     }
}
