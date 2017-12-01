public class Hora {
    public int horas;
    public int minutos;
    public int segundos;
    
    public void Hora (){
        this.horas = 3;
        this.minutos = 30;
        this.segundos = 1;
    }
    
    public void Hora (int x, int y, int z){
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
        int a = segundos + (minutos + (horas*60))*60;
        int b = z + (y + (x*60))*60;
        int diferenca = a - b;
        segundos = diferenca%60;
        minutos = (diferenca*60)%60;
        horas = ((diferenca*60)*60)%60;
    }
    
    public String transformarstring () {
        String horaatual = (horas+":"+minutos+":"+segundos);
        return horaatual;
    }
}
