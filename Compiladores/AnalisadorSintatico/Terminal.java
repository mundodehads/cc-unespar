package AnalisadorSintatico;

import java.util.ArrayList;

public class Terminal extends Noh {

	private String lexema;

	public Terminal(String lexema, String esperado) {
		if (lexema.equals(esperado)) {
			this.lexema = lexema;
		} else {
			System.err.println("Esperando: " + esperado + ", contem: " + lexema);
		}
	}

	public Terminal(String lexema) {
		if (lexema.length() > 0) {
			this.lexema = lexema;
		} else {
			System.err.println("Identificador vazio");
		}
	}

	@Override
	public ArrayList<Noh> getFilhos() {
		return null;
	}

	@Override
	public String getLexema() {
		return lexema;
	}

	@Override
	public String getTipo() {
		return null;
	}

}
