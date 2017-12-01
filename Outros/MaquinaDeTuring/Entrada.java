package MaquinaDeTuring;

import java.util.Scanner;

public class Entrada {
    
    public static void menu () {
        String[] Palavra = new String[100];
        DescriçãoFormal df = new DescriçãoFormal();
        FunçãoDeTransição fdt = new FunçãoDeTransição();
        Saida s = new Saida();
        Scanner scanf = new Scanner(System.in);
        int escolha;
        String novoestado;
        String novoalfabeto;
        String novoalfabetoa;
        System.out.println("Simulador de Maquina de Turing, escolha uma operação:\n");
        System.out.println("[1]Informar novo estado");
        System.out.println("[2]Informar novo estado final");
        System.out.println("[3]Informar novo alfabeto");
        System.out.println("[4]Informar novo alfabeto auxiliar");
        System.out.println("[5]Informar nova Função de Transição");
        System.out.println("[6]Verificar palavra reconhecedora");
        System.out.println("[7]Verificar palavra transdutora");
        escolha = scanf.nextInt();
        scanf.nextLine();
        switch (escolha){
            case 1:
                System.out.println("\nInforme o nome do estado: ");
                novoestado = scanf.nextLine();
                if(df.getTamanhoestados() == 0){
                    df.setInicial(0);
                }
                df.setEstados(novoestado);
                menu();
            case 2:
                System.out.println("\nInforme o nome do estado final: ");
                novoestado = scanf.nextLine();
                df.setFinal(df.getTamanhoestados());
                if(df.getTamanhoestados() == 0){
                    df.setInicial(0);
                }
                df.setEstados(novoestado);
                menu();
            case 3:
                System.out.println("\nInforme o simbolo do alfabeto: ");
                novoalfabeto = scanf.nextLine();
                df.setAlfabeto(novoalfabeto);
                menu();                
            case 4:
                System.out.println("\nInforme o simbolo do alfabeto auxiliar: ");
                novoalfabetoa = scanf.nextLine();
                df.setAlfabeto(novoalfabetoa);
                menu();
            case 5:
                System.out.println("\nEstados disponiveis: ");
                for(int i=0;i<df.getTamanhoestados();i++){
                    System.out.println("\t["+i+"]"+df.getEstados(i));
                }
                fdt.PreencherFitasimbolos();
                System.out.println("\nSimbolos Diponiveis: ");
                for(int i=0;i<fdt.getTamanhofitasimbolos();i++){
                    System.out.println("\t"+fdt.getFitasimbolos(i));
                }
                System.out.println("Movimentos diponiveis: 0 Esquerda e 1 Direita.\n");
                int estadofdt;
                System.out.println("Escolha o estado:");
                estadofdt = scanf.nextInt();
                scanf.nextLine();
                String simbolofdt;
                System.out.println("Escolha o simbolo:");
                simbolofdt = scanf.nextLine();
                int movimentofdt;
                System.out.println("Escolha o movimento:");
                movimentofdt = scanf.nextInt();
                fdt.PreencherFunçãoDeTransição(estadofdt, simbolofdt, movimentofdt);
                menu();
            case 6:
                int tamanho;
                System.out.println("Informe o tamanho da palavra:");
                tamanho = scanf.nextInt();
                int cont = 0;
                do {
                    System.out.println("Informe o"+cont+"º simoblo da palavra:");
                    Palavra[cont] = scanf.nextLine();
                    cont++;
                }while(cont != tamanho);
                s.Verifica(Palavra);
                s.resultados(0, Palavra);
                menu();
            case 7:
                int tamanho2;
                System.out.println("Informe o tamanho da palavra:");
                tamanho2 = scanf.nextInt();
                scanf.nextLine();
                int cont2 = 0;
                do {
                    System.out.println("Informe o "+cont2+" simoblo da palavra:");
                    Palavra[cont2] = scanf.nextLine();
                    cont2++;
                }while(cont2 != tamanho2);
                s.Verifica(Palavra);
                s.resultados(1, Palavra);
                menu();
            default: 
                System.out.println("Opção invalida !");
        }
    }

    public static void main(String[] args) {
        menu();

    }
    
}
