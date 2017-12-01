    package Produto;
    import java.util.Scanner;

    public class Cadastro {
        


    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Produto[] produtos = new Produto[100];
        for (int i = 0; i < 100; i++){
            System.out.println("Informe o nome do produto:");
            String nome = leitor.nextLine();
            produtos[i].setNome(nome);
            System.out.println("Informe o preço do produto:");
            double preco = leitor.nextDouble();
            produtos[i].setPreco(preco);
        }
    }
    
}
