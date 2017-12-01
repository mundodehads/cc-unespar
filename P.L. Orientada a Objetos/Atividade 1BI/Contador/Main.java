/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contador;

/**
 *
 * @author Henrique
 */
public class Main {
    public static void main(String[] args) {
        Contador c1 = new Contador();
        for (c1.Zerar(); c1.getN()<=10; c1.Incrementar()) {
            System.out.println("[c1] Valor de n:"+ c1.getN());
        }
        
        System.out.println("\n");
        
        for (Contador c2 = new Contador(50); c2.getN()<=60; c2.Incrementar()) {
            System.out.println("[c2] Valor de n:"+ c2.getN());
        }
    }
}
