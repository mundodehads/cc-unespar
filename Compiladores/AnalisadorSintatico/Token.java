package AnalisadorSintatico;

public class Token {
	
	private String lexema;
	private String tipo;
	
	public Token (String lexema, String tipo){
		this.lexema = lexema;
		this.tipo = tipo;
	}

	public String getLexema() {
		return lexema;
	}

	public String getTipo() {
		return tipo;
	}
	
	

}
