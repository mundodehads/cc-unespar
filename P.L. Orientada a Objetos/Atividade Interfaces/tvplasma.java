public class tvplasma extends tv implements controle {
     
    @Override
    public void mudarcanal (){
        
    }
    
    public tvplasma (int x){
        setTam(x);
        setCanal(1);
        setVolume(0);
        setOnoff(0);
    }
}
