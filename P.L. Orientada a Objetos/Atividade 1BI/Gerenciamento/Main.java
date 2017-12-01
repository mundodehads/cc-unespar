/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gerenciamento;

/**
 *
 * @author Henrique
 */
public class Main {
    public static void main (String[] args){
        Pedido p = new Pedido();
        p.Adicionar(12.50,1);
        p.Adicionar(5,2);
        p.Adicionar(3.25,3);
        System.out.println("Valor total a pagar: "+p.Pagar());
    }
}
