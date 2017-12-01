/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HenriqueSilva
 */
public class Gerente extends Funcionario {
    protected int senha_servidor;
    protected String login_servidor;
    
    @Override
    public void AumentaSalario () {
       salario = salario + salario*0.2;
    }
}
