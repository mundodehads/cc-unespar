package EntradaDeCinema;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Henrique
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntradaDeCinema EntradaNormal = new EntradaDeCinema(2010);
        System.out.println(EntradaNormal.Imprimir());
        
        EntradaDeCinema EntradaEstudante = new EntradaDeCinema(1996, 1234);
        System.out.println("\n\n\n"+EntradaEstudante.Imprimir());
        
    }
    
}
