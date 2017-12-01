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
public class Main {
    public static void main (String[] args){
        Vetor v = new Vetor();
        v.Inserir(0);
        v.Inserir(2);
        v.Inserir(3);
        v.Imprimir();
        System.out.println("Valor da Soma: "+v.Soma());
        v.Inverter();
        System.out.println("Valor Após Inverter:");
        v.Imprimir();
        v.Ordenar();
        System.out.println("Valor Após Ordenar:");
        v.Imprimir();
    }
}
