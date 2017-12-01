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
public class Pedido extends Produto {
    public Produto[] produto = new Produto[100];
    public int tamanho = 0;
    
    public void Adicionar (double x, int y){
        produto[tamanho] = new Produto();
        this.produto[tamanho].preco = x;
        this.produto[tamanho].quantidade = y;
        this.tamanho++;
    }
    
    public double Pagar () {
        double valor = 0;
        for(int i=0;i<tamanho;i++){
            valor = valor + produto[i].PrecoTotal();
        }
        return valor;
    }
    
}
