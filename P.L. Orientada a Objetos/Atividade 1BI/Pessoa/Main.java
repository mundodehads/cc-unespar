/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pessoa;

/**
 *
 * @author Henrique
 */
public class Main {
    public static void main (String[] args){
        Aluno a = new Aluno();
        a.setNome("Henrique");
        a.setCpf("45028423890");
        a.setData("19/01/1996");
        System.out.println("Nome: "+a.getNome()+", Cpf: "+a.getCpf()+", Data de nascimento: "+a.getData());
    }
}
