/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vetor;

/**
 *
 * @author Henrique
 */
public class Vetor {
    public int tamanho;
    public int[] v = new int[100];
    
    public Vetor () {
        this.tamanho = 0;
    }
    
    public Vetor (int x[], int y){
        this.tamanho = y;
        for(int i=0;i<tamanho;i++){
            this.v[i] = x[i];
        }
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int[] getV() {
        return v;
    }

    public void setV(int[] v) {
        this.v = v;
    }
    
    public void Inserir (int x) {
        this.v[tamanho] = x;
        this.tamanho++;
    }
    
    public int Soma (){
        int soma = 0;
        for(int i=0;i<tamanho;i++){
            soma = soma + v[i];
        }
        return soma;
    }
    
    public void Inverter () {
       int i = 0;
       int j = tamanho-1;
       int aux;
       do {
           aux = v[i];
           v[i] = v[j];
           v[j] = aux;
           i++;
           j--;
       } while (i > j);
    }
    
    public void Ordenar () {
        int aux;
        for (int i=0;i<tamanho;i++){
         for(int j=i+1;j<tamanho;j++){
           if(v[i]>v[j]){
             aux = v[i];
             v[i]=v[j];
             v[j]=aux;
             }
           }
         }
    }
    
    public void Imprimir () {
        for(int i=0;i<tamanho;i++){
            System.out.println("Valor na posição ["+(i+1)+"]: "+v[i]);
        }
    }
}