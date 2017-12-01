package AnalisadorSintatico;

import java.util.ArrayList;

public abstract class Noh {
	
	public abstract ArrayList<Noh> getFilhos();
	public abstract String getLexema();
	public abstract String getTipo();
	
}
