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
public class calculadoraCientifica extends Calculadora implements Trigonometria {
    
    public double Potencia (double x, double y) {
        double resultado = Math.pow(x, y);
        return resultado;
    }
    
    public double Logaritmo (double x) {
        double resultado = Math.log(x);
        return resultado;
    }

    @Override
    public double Seno(double x) {
        double resultado = Math.sin(x);
        return resultado;
    }

    @Override
    public double Cosseno(double x) {
        double resultado = Math.cos(x);
        return resultado;
    }

    @Override
    public double Tangente(double x) {
        double resultado = Math.tan(x);
        return resultado;
    }
    
}
