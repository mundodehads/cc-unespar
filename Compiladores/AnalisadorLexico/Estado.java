package AnalisadorLexico;

import java.util.List;
import java.util.ArrayList;

public class Estado {

	private List<Character> entrada;
	private Boolean terminal;
	private List<Estado> proximo;

	public Estado(List<Character> entrada, Boolean terminal) {
		this.entrada = entrada;
		this.terminal = terminal;
		this.proximo = new ArrayList<Estado>();
	}
	
	public boolean pertence(char a){
		for(Character b: entrada){
			if(b.equals(a)) return true;
		}
		return false;
	}

	public List<Character> getEntrada() {
		return entrada;
	}

	public void setEntrada(List<Character> entrada) {
		this.entrada = entrada;
	}

	public Boolean getTerminal() {
		return terminal;
	}

	public void setTerminal(Boolean terminal) {
		this.terminal = terminal;
	}

	public List<Estado> getProximo() {
		return proximo;
	}

	public void setProximo(List<Estado> proximo) {
		this.proximo = proximo;
	}	

}
