package AnalisadorSintatico;

import java.util.ArrayList;
import java.util.List;

public class NaoTerminal extends Noh {
	private String tipo;
	private List<Noh> filhos;

	public NaoTerminal(String tipo, String esperado, Noh filho) {
		if (tipo.equals(esperado)) {
			this.filhos = new ArrayList<Noh>();
			filhos.add(filho);
			this.tipo = tipo;
		}
	}

	public NaoTerminal(String tipo, String esperado, ArrayList<Noh> filhos) {
		if (tipo.equals(esperado)) {
			this.filhos = filhos;
			this.tipo = tipo;
		}
	}

	@Override
	public ArrayList<Noh> getFilhos() {
		return (ArrayList<Noh>) filhos;
	}

	@Override
	public String getTipo() {
		return tipo;
	}

	@Override
	public String getLexema() {
		return null;
	}

}
