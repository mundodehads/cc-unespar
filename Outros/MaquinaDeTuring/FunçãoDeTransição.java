package MaquinaDeTuring;

public class FunçãoDeTransição extends DescriçãoFormal {
    public int totaldetransição;
    public int[] direçãoestado = new int[getMAX()];
    public String[] alterafita = new String[getMAX()];
    public int[] movimentafita = new int[getMAX()];
    public int[] estadoatual = new int[getMAX()];
    
    public String[] fitasimbolos = new String[getMAX()];
    public int tamanhofitasimbolos;
    
    public void FunçãoDeTransição (){
        this.totaldetransição = 0;
        this.tamanhofitasimbolos = 0;
    }
    
    int cont1 = 0;
    int cont2 = 0;
    public void PreencherFunçãoDeTransição (int x, String y, int z){
        this.direçãoestado[totaldetransição] = x;
        this.alterafita[totaldetransição] = y;
        this.movimentafita[totaldetransição] = z;
        this.estadoatual[totaldetransição] = cont2;
        this.totaldetransição++;
        this.cont1++;
        if(cont1 == (getTamanhoalfabeto()+getTamanhoalfabetoa()+2)){
            this.cont2++;
            this.cont1 = 0;
        }
    }
    
    public void PreencherFitasimbolos () {
        int parada = 0;
        do{
            if(tamanhofitasimbolos == 0){
              fitasimbolos[tamanhofitasimbolos] = getSimboloInicio(); 
            }else if (getAlfabeto(tamanhofitasimbolos) != null){
               fitasimbolos[tamanhofitasimbolos] =  getAlfabeto(tamanhofitasimbolos);
            }else if (getAlfabetoauxiliar(tamanhofitasimbolos) != null){
               fitasimbolos[tamanhofitasimbolos] =  getAlfabetoauxiliar(tamanhofitasimbolos); 
            }else {
               fitasimbolos[tamanhofitasimbolos] =  getSimboloBranco();
            }
            if(tamanhofitasimbolos <= totaldetransição){
                this.tamanhofitasimbolos++;
            }else {
                parada = 1;
            }
        } while (parada != 1);        
    }

    public int getTotaldetransição() {
        return totaldetransição;
    }

    public int getEstadoatual(int x) {
        return estadoatual[x];
    }

    public String getFitasimbolos(int x) {
        return fitasimbolos[x];
    }

    public int getDireçãoestado(int x) {
        return direçãoestado[x];
    }
    
    public String getAlterafita(int x) {
        return alterafita[x];
    }

    public int getMovimentafita(int x) {
        return movimentafita[x];
    }

    public int getTamanhofitasimbolos() {
        return tamanhofitasimbolos;
    }
    
}
