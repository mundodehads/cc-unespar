package AnalisadorSemantico;

import java.util.ArrayList;
import java.util.List;

public class Variaveis {
	
	private List<String> variaveis;
	private List<String> tipo;
	
	public Variaveis(){
		this.variaveis = new ArrayList<String>();
		this.tipo = new ArrayList<String>();
	}

	public List<String> getVariaveis() {
		return variaveis;
	}

	public List<String> getTipo() {
		return tipo;
	}

}
