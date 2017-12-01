package AnalisadorSintatico;

import java.util.ArrayList;

public class Arvore {

	private Noh raiz;
	private Token corrente;
	private ArrayList<Token> lista;

	public Arvore(ArrayList<Token> lista) {
		this.lista = lista;
		corrente = lista.get(0);
		this.raiz = new Programa(this);
	}

	public void proximo() {
		lista.remove(0);
		if (lista.size() > 0) {
			corrente = lista.get(0);
		}
	}

	public String procurarLexema() {
		return corrente.getLexema();
	}

	public String procurarTipo() {
		return corrente.getTipo();
	}

	public Boolean desvendar(String lexema) {
		if (lista.get(1).getLexema().equals(lexema)) {
			return true;
		}
		return false;
	}

	public Token getCorrente() {
		return corrente;
	}

	public ArrayList<Token> getLista() {
		return lista;
	}

	public Noh getRaiz() {
		return raiz;
	}

}
