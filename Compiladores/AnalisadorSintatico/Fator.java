package AnalisadorSintatico;

import java.util.ArrayList;

public class Fator extends Noh {

	private ArrayList<Noh> filhos = new ArrayList<Noh>();

	public Fator(Arvore ar) {

		try {
			if(ar.procurarTipo().equals("num")){
				numerico1(ar);
			}else if(ar.procurarTipo().equals("id")){
				identificador1(ar);
				if(ar.procurarLexema().equals("(")){
					simboloSimples1(ar, "(");
					if(ar.desvendar(",")){
						while(!ar.desvendar(")")){
							filhos.add(new Expressao(ar));
							simboloSimples1(ar, ",");
						}
						filhos.add(new Expressao(ar));
					}
					simboloSimples1(ar, ")");
				}
			}else if(ar.procurarLexema().equals("(")){
				simboloSimples1(ar, "(");
				filhos.add(new Expressao(ar));
				simboloSimples1(ar, ")");
			}else if (ar.procurarLexema().equals("not")){
				palavrasReservadas1(ar, "not");
				filhos.add(new Fator(ar));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void numerico1(Arvore a) {
		if (a.getCorrente().getTipo().equals("num")) {
			filhos.add(new NaoTerminal(a.getCorrente().getTipo(), "num", new Terminal(a.getCorrente().getLexema())));
			a.proximo();
		} else {
			System.err.println("Esperando NUM, contem: " + a.getCorrente().getTipo());
		}
	}

	public void identificador1(Arvore a) {
		if (a.getCorrente().getTipo().equals("id")) {
			filhos.add(new NaoTerminal(a.getCorrente().getTipo(), "id", new Terminal(a.getCorrente().getLexema())));
			a.proximo();
		} else {
			System.err.println("Esperando ID, contem: " + a.getCorrente().getTipo());
		}
	}

	public void palavrasReservadas1(Arvore a, String lexema) {
		if (a.getCorrente().getTipo().equals("pr")) {
			filhos.add(new NaoTerminal(a.getCorrente().getTipo(), "pr",
					new Terminal(a.getCorrente().getLexema(), lexema)));
			a.proximo();
		} else {
			System.err.println("Esperando: PR(" + lexema + "), contem: " + a.getCorrente().getTipo());
		}
	}

	public void simboloSimples1(Arvore a, String lexema) {
		if (a.getCorrente().getTipo().equals("ss")) {
			filhos.add(new NaoTerminal(a.getCorrente().getTipo(), "ss",
					new Terminal(a.getCorrente().getLexema(), lexema)));
			a.proximo();
		} else {
			System.err.println("Esperando: SS(" + lexema + "), contem: " + a.getCorrente().getTipo());
		}
	}

	public void simboloComposto1(Arvore a, String lexema) {
		if (a.getCorrente().getTipo().equals("sc")) {
			filhos.add(new NaoTerminal(a.getCorrente().getTipo(), "sc",
					new Terminal(a.getCorrente().getLexema(), lexema)));
			a.proximo();
		} else {
			System.err.println("Esperando: SC(" + lexema + "), contem: " + a.getCorrente().getTipo());
		}
	}

	@Override
	public ArrayList<Noh> getFilhos() {
		return filhos;
	}

	@Override
	public String getLexema() {
		return null;
	}

	@Override
	public String getTipo() {
		return null;
	}

}
