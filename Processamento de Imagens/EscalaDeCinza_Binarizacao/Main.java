package EscalaDeCinza_Binarizacao;

public class Main {
	
	public static void main(String[] args) {
		
		//"C:\\Users\\henri\\Desktop\\paisagem.jpg"
		
		Manipulacao m = new Manipulacao("paisagem.png");
		m.gerarCinza(m.getOriginal(), m.getCinza());
		m.gerarBinarizacao(m.getCinza(), m.getBinaria());
		
	}

}
