/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Aula1507;

/**
 *
 * @author LAB SALA39
 */
public class Funcionario {
    private String nome;
    private long cpf;
    private double salario;
    
    public Funcionario () {
        //salario = 1000;
        this.salario = 1000;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }
    
    public void AumentaSalario (){
        salario = salario + salario*0.1;
    }
}