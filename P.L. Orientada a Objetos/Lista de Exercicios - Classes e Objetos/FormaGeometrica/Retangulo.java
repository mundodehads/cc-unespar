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
public class Retangulo extends FormaGeometrica implements AlterarForma  {
    
    public double ladox;
    public double ladoy;

    public double getLadox() {
        return ladox;
    }

    public void setLadox(double ladox) {
        this.ladox = ladox;
    }

    public double getLadoy() {
        return ladoy;
    }

    public void setLadoy(double ladoy) {
        this.ladoy = ladoy;
    }
    
    @Override
    public double calcularArea(){
        double area = getLadox() * getLadoy();
        return area;
    }
    @Override
    public double calcularPerimetro(){
        double perimetro = (2*getLadox()) + (2*getLadoy());
        return perimetro;
    }
    
    @Override
    public void aumentarForma(double x) {
        double ladoxaumentado = getLadox() + x;
        setLadox(ladoxaumentado);
        double ladoyaumentado = getLadoy() + x;
        setLadoy(ladoyaumentado);
    }
    
    @Override
    public void diminuirForma(double x) {
        if(x>getLadox() && x>getLadoy()){
            System.out.println("ERRO: Valor informado maior que lado atual !");
        }else {
            double ladoxaumentado = getLadox() - x;
            setLadox(ladoxaumentado);
            double ladoyaumentado = getLadoy() - x;
            setLadoy(ladoyaumentado);
        }
    }
    
}
