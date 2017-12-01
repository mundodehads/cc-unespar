/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormaGeometrica;

/**
 *
 * @author Henrique
 */
public class Circulo extends FormaGeometrica implements AlterarForma {
    
    public double raio;
    public static double PI = 3.14;

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public static double getPI() {
        return PI;
    }

    public static void setPI(double PI) {
        Circulo.PI = PI;
    }
    
    @Override
    public double calcularArea(){
        double area = getPI() * (getRaio() * getRaio());
        return area;
    }
    @Override
    public double calcularPerimetro(){
        double perimetro = 2*(getPI() * getRaio());
        return perimetro;
    }
    
    @Override
    public void aumentarForma(double x) {
        double ladoaumentado = getRaio() + x;
        setRaio(ladoaumentado);
    }
    
    @Override
    public void diminuirForma(double x) {
        if(x>getRaio()){
            System.out.println("ERRO: Valor informado maior que lado atual !");
        }else {
            double ladodiminuido = getRaio() - x;
            setRaio(ladodiminuido);
        }
    }
    
}
