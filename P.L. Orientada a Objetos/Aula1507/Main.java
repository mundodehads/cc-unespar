/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Aula1507;

import java.util.Scanner;

/**
 *
 * @author LAB SALA39
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Funcionario g1 = new Gerente();
        Scanner scanf = new Scanner(System.in);
        System.out.println("Informe o nome:");
        String nome = scanf.nextLine();
        g1.setNome(nome);
        System.out.println("Informe seu cpf:");
        long cpf = scanf.nextInt();
        g1.setCpf(cpf);
        
        System.out.println("Nome: "+g1.getNome());
        System.out.println("CPF: "+g1.getCpf());
        System.out.println("Valor do salario: "+g1.getSalario());
        g1.AumentaSalario();
        System.out.println("Valor do salario com aumento: "+g1.getSalario());
        
    }
    
}
