package Aula2107;

public class Main  {
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

//import java.util.Scanner; 

//public class Main {
//    public static void main(String[] args) {
//     Scanner scanf = new Scanner(System.in);
//     System.out.println("[1] Inicializa n com 0");
//     System.out.println("[2] Inicializa n com valor x");
//     int escolha = scanf.nextInt();
//     if (escolha == 1) {
//         Contador contador = new Contador();
//         System.out.println("n = "+contador.getN());
//         contador.Incrementar();
//         System.out.println("incrementado, n = "+contador.getN());
//         contador.Decrementar();
//         System.out.println("decrementado, n = "+contador.getN());
//         contador.Zerar();
//         System.out.println("Valor de n zerado, n = "+contador.getN());
//     }
//     if (escolha == 2) {
//         System.out.println("Informe o valor x: ");
//         int x = scanf.nextInt();
//         Contador contador = new Contador(x);
//         contador.Incrementar();
//         System.out.println("incrementado, n = "+contador.getN());
//         contador.Decrementar();
//         System.out.println("decrementado, n = "+contador.getN());
//         contador.Zerar();
//         System.out.println("Valor de n zerado, n = "+contador.getN());
//     }
//    }   
//}

// math.sqrt(math.PONTENCIA() + Math.POTENCIA();