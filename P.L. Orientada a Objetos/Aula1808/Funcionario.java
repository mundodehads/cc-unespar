/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Henrique
 */
 abstract public class Funcionario {
    protected String nome;
    protected long cpf;
    protected double salario;
    protected int horaentrada;
    protected int horasaida;
    abstract void AumentaSalario ();  

}
