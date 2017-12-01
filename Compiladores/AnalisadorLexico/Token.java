package AnalisadorLexico;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Token {

	private ArrayList<String> lexemas;
	private ArrayList<String> tipos;

	public Token() {
		this.lexemas = new ArrayList<String>();
		this.tipos = new ArrayList<String>();
	}

	public void adicionarLexema(String palavra) {
		lexemas.add(palavra);
		verificarTipo(palavra);
	}

	public void verificarTipo(String palavra) {
		PalavrasReservadas pr = new PalavrasReservadas();
		SimbolosCompostos sc = new SimbolosCompostos();

		if (palavra.charAt(0) >= 97 && palavra.charAt(0) <= 122 || palavra.charAt(0) >= 65 && palavra.charAt(0) <= 90) {
			if (pr.pertence(palavra)) {
				tipos.add("pr");
			} else {
				tipos.add("id");
			}
		} else if (palavra.charAt(0) >= 48 && palavra.charAt(0) <= 57) {
			tipos.add("num");
		} else if (sc.pertence(palavra)){
			tipos.add("sc");
		}else {
			tipos.add("ss");
		}
	}

	public void escreverToken(String path) throws IOException {
		BufferedWriter bf = new BufferedWriter(new FileWriter(path));
		for (int x = 0; x < lexemas.size(); x++) {
			bf.append(lexemas.get(x) + " / " + tipos.get(x));
			bf.newLine();
		}
		bf.close();
	}

	public ArrayList<String> getLexemas() {
		return lexemas;
	}

	public ArrayList<String> getTipos() {
		return tipos;
	}
	
	

}
