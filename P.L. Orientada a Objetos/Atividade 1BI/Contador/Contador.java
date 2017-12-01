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
public class Contador {
   public int n;
   
   public Contador () {
       this.n = 0;
   }
   
   public Contador (int x) {
       this.n = x;
   }
   
    public void Incrementar() {
        n++;
    }
    
    public void Decrementar() {
        n--;
    }

    public int getN() {
        return n;
    }
    
    public void Zerar() {
        n = 0;
    }
}
