package Aula2107;

public class Contador {
   public int n;
   
   public Contador () {
       this.n = 0;
   }
   
   public Contador (int x) {
       this.n = x;
   }
   
    public void Incrementar() {
        n++;
    }
    
    public void Decrementar() {
        n--;
    }

    public int getN() {
        return n;
    }
    
    public void Zerar() {
        n = 0;
    }
}
