package Pedido;
import Produto.Cadastro;
import Produto.Produto;

public class Pedido {
    private int codPedido;
    private String nomeCliente;
    private int quantidade;
    
    public Pedido () {
        System.out.println("Informe um produto:");
        for (int i=0;i<100;i++){
           System.out.println(""+produtos[i].getNome()); 
        }
    }
}
