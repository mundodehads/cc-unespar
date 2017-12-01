/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntradaDeCinema;


/**
 *
 * @author Henrique
 */
public class EntradaDeCinema extends dataDoFilme {
    private int sala;
    private double valor;
    private String horario;
    private int RA;

    dataDoFilme d = new dataDoFilme();
    
    public EntradaDeCinema (int ano){
        int idade = d.Idade(ano);
        this.horario = d.transformarstring();
        this.valor = 60;
        this.sala = 1;
        if (idade < 12){
            this.valor -= (valor*0.5);
        }
        if(d.getHora() < 16){
            this.valor -= (valor*0.1);
        }
    }
    
    public EntradaDeCinema (int ano, int RAc){
        int idade = d.Idade(ano);
        this.horario = d.transformarstring();
        this.valor = 60;
        this.sala = 1;
        this.RA = RAc;
        if (idade >= 12 && idade <= 15){
            this.valor -= (valor*0.4);
        }else if (idade >= 16 && idade <= 20){
            this.valor -= (valor*0.3);
        } else {
            this.valor -= (valor*0.2);
        }
        if(d.getHora() < 16){
            this.valor -= (valor*0.1);
        }
    }

    public int getSala() {
        return sala;
    }

    public double getValor() {
        return valor;
    }

    public String getHorario() {
        return horario;
    }

    public String getRA() {
        String aux = Integer.toString(RA);
        return aux;
    }
    
    public String Imprimir (){
        if(getRA().length() ==  0){
            return ("Sala: "+getSala()+"\nHorario: "+getHorario()+"\n\nValor a pagar: "+getValor()+"\nRA: "+getRA());
    }else {
            return ("Sala: "+getSala()+"\nHorario: "+getHorario()+"\n\nValor a pagar: "+getValor());
        }
    }
}
