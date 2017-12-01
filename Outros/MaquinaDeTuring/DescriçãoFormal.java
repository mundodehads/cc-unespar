package MaquinaDeTuring;

public class DescriçãoFormal {
    private static final int MAX = 100;
    
    public int tamanhoalfabeto;
    public String[] Alfabeto = new String[MAX];
    public int tamanhoalfabetoa;
    public String[] Alfabetoauxiliar = new String[MAX];;
    public int Inicial;
    public int[] Final = new int[MAX];
    public int tamanhoestados;
    public String[] Estados = new String[MAX];
    public String SimboloInicio;
    public String SimboloBranco;
    
    public void DescriçãoFormal (){
        this.tamanhoalfabeto = 0;
        this.tamanhoalfabetoa = 0;
        this.tamanhoestados = 0;
        this.SimboloInicio = "*";
        this.SimboloBranco = "<";
    }

     public static int getMAX() {
        return MAX;
    }
    
    public String getAlfabeto(int x) {
        return Alfabeto[x];
    }

    public void setAlfabeto(String Alfabeto) {
        this.Alfabeto[tamanhoalfabeto] = Alfabeto;
        this.tamanhoalfabeto++;
    }

    public String getAlfabetoauxiliar(int x) {
        return Alfabetoauxiliar[x];
    }

    public void setAlfabetoauxiliar(String Alfabetoauxiliar) {
        this.Alfabetoauxiliar[tamanhoalfabetoa] = Alfabetoauxiliar;
        this.tamanhoalfabetoa++;
    }

    public String getSimboloInicio() {
        return SimboloInicio;
    }

    public void setSimboloInicio(String SimboloInicio) {
        this.SimboloInicio = SimboloInicio;
    }

    public String getSimboloBranco() {
        return SimboloBranco;
    }

    public void setSimboloBranco(String SimboloBranco) {
        this.SimboloBranco = SimboloBranco;
    }

    public int getTamanhoalfabeto() {
        return tamanhoalfabeto;
    }

    public void setTamanhoalfabeto(int tamanhoalfabeto) {
        this.tamanhoalfabeto = tamanhoalfabeto;
    }

    public int getTamanhoalfabetoa() {
        return tamanhoalfabetoa;
    }

    public void setTamanhoalfabetoa(int tamanhoalfabetoa) {
        this.tamanhoalfabetoa = tamanhoalfabetoa;
    }

    public int getTamanhoestados() {
        return tamanhoestados;
    }
    
    
    
    public String getEstados(int x) {
        return Estados[x];
    }

    public void setEstados(String Estados) {
        this.Estados[tamanhoestados] = Estados;
        this.tamanhoestados++;
    }

    public int getInicial() {
        return Inicial;
    }

    public void setInicial(int Inicial) {
        this.Inicial = Inicial;
    }

    public int getFinal(int x) {
        return Final[x];
    }

    public void setFinal(int Final) {
        this.Final[tamanhoestados] = Final;
    }  
    
}
