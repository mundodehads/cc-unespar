package AnalisadorSintatico;

import java.util.ArrayList;

public class analisadorSintatico {

	private ArrayList<Token> lista = new ArrayList<Token>();

	public analisadorSintatico(ArrayList<String> lexemas, ArrayList<String> tipos) {
		for (int x = 0; x < lexemas.size(); x++) {
			lista.add(new Token(lexemas.get(x), tipos.get(x)));
		}
	}

	public Noh executar() {
		Arvore ar = new Arvore(lista);
		if (ar.getLista().size() == 0) {
			System.out.println("lista vazia, 0 erros sintaticos.");
		}
		return ar.getRaiz();
	}

}
