/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HenriqueSilva
 */
public class Secretaria extends Funcionario {
    public int ramal;
    
    @Override
    public void AumentaSalario () {
        salario = salario + salario*0.1;
    }
}
