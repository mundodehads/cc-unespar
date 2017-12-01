/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculadora;

/**
 *
 * @author Henrique
 */
public abstract class Calculadora {
    
    public double Soma (double x, double y){
        double resultado = x + y;
        return resultado;
    }
    
    public double Subtracao (double x, double y){
        double resultado = x - y;
        return resultado;
    }
    
    public double Multiplicacao (double x, double y){
        double resultado = x * y;
        return resultado;
    }
    public double Divisao (double x, double y){
        double resultado = x / y;
        return resultado;
    }
    
}
