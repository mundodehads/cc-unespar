package MaquinaDeTuring;

import java.util.Arrays;

public class Saida extends FunçãoDeTransição{
    
    int estadoatualv = getInicial();
    int posicaoatualv = 1;
    
    public String[] Verifica(String[] Palavra){
        for(int i=0;i<=getTamanhoestados();i++){
            for(int j=0;j<(getTamanhoalfabeto()+getTamanhoalfabetoa()+2);j++){
               if(estadoatualv == getEstadoatual(j)){
                   if(Palavra[posicaoatualv].equals(getFitasimbolos(j+1))){
                       i = getDireçãoestado(j);
                       estadoatualv = getDireçãoestado(j);
                       Palavra[posicaoatualv]= getAlterafita(j);
                       if(getMovimentafita(j) == 0){
                           posicaoatualv--;
                       }
                       if(getMovimentafita(j) == 1){
                           posicaoatualv++;
                       }
                   }
               }
            }
        }
        return Palavra;
    }
    
    public void resultados(int n, String[] Palavra){
        if(n == 0){
            String[] resultado1 = Verifica(Palavra);
            if(posicaoatualv == 1){
                System.out.println("A Palavra foi aceita !!!");
            }else {
                System.out.println("A Palavra não foi aceita !!!");
            }
        }else {
            String[] resultado2 = Verifica(Palavra);
            if(posicaoatualv == 1){
                System.out.println(Arrays.toString(resultado2));
            }else {
                System.out.println("A Palavra não foi aceita !!!");
            }
        }
    }
}
