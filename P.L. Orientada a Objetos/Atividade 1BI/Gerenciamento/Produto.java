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
public class Produto {
    public double preco;
    public int quantidade;
    
    public double PrecoTotal (){
        double precototal = preco * quantidade;
        return precototal;        
    }

}
