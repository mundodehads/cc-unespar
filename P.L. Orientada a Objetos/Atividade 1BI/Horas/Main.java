/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Horas;

/**
 *
 * @author Henrique
 */
public class Main {
    public static void main(String[] args) {
        Hora h = new Hora(10,30,40);
        System.out.println("Horas em segundos: "+h.totalhoras());
        h.diferencahoras (3,30,40);
        System.out.println("Horas após a diferenca: "+h.transformarstring());
    }
    
}

