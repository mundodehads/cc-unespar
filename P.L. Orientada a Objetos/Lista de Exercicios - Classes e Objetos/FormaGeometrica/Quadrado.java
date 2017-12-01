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
public class Quadrado extends FormaGeometrica implements AlterarForma {
    
    public double lado;
    
    public Quadrado (double x){
        this.lado = x;
    }
    
    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }
    
    @Override
    public double calcularArea(){
        double area = getLado() * getLado();
        return area;
    }

    @Override
    public double calcularPerimetro(){
        double perimetro = getLado() * 4;
        return perimetro;
    }
    
    @Override
    public void aumentarForma(double x) {
        double ladoaumentado = getLado() + x;
        setLado(ladoaumentado);
    }
    
    @Override
    public void diminuirForma(double x) {
        if(x>getLado()){
            System.out.println("ERRO: Valor informado maior que lado atual !");
        }else {
            double ladodiminuido = getLado() - x;
            setLado(ladodiminuido);
        }
    }
    
}
