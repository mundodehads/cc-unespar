/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Horas;

/**
 *
 * @author Henrique
 */
public class Hora {
    public int horas;
    public int minutos;
    public int segundos;
    
    public Hora (){
        this.horas = 00;
        this.minutos = 00;
        this.segundos = 00;
    }
    
    public Hora (int x, int y, int z){
        this.horas = x;
        this.minutos = y;
        this.segundos = z;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }
    
    public int totalhoras () {
        return segundos + (minutos + (horas*60))*60;
    }
    
    public void diferencahoras (int x, int y, int z) {
        if (x > horas){
            horas = horas - x;
            horas = horas - (2*horas);
        } else {
            horas = horas - x;
        }
        if (y > minutos){
            minutos = minutos - y;
            minutos = minutos - (2*minutos);
        } else {
            minutos = minutos - y;
        }
        if (z > segundos){
            segundos = segundos - z;
            segundos = segundos - (2*segundos);
        } else {
            segundos = segundos - z;
        }
    }
    
    public String transformarstring () {
        String horaatual = (horas+":"+minutos+":"+segundos);
        return horaatual;
    }
}
