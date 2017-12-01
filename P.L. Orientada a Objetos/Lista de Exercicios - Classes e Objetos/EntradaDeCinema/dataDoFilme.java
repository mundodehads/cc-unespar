/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntradaDeCinema;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Henrique
 */
public class dataDoFilme extends horaDoFilme {
    private int hora;
    
    horaDoFilme h = new horaDoFilme();
    public dataDoFilme (){
        this.hora = h.getHoras();
    }
    
    public int Idade(int ano){
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();
    String date_format = dateFormat.format(date);
    String aux[] = date_format.split("/");
    return Integer.parseInt(aux[2]) - ano;
    }

    public int getHora() {
        return hora;
    }
    
    
    
}
