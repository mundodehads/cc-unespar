package AnalisadorSintatico;

import java.util.ArrayList;

public class ParametrosFormais extends Noh {

	private ArrayList<Noh> filhos = new ArrayList<Noh>();

	public ParametrosFormais(Arvore ar) {
		try {
			simboloSimples1(ar, "(");
			parametrosformais(ar);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void parametrosformais(Arvore ar) {
		
		if (ar.procurarLexema().equals("function")) {
			palavrasReservadas1(ar, "function");
			if (ar.desvendar(",")) {
				while (!ar.desvendar(":")) {
					identificador1(ar);
					simboloSimples1(ar, ",");
				}
			}
			identificador1(ar);
			simboloSimples1(ar, ":");
			identificador1(ar);
			if (ar.procurarLexema().equals(";")) {
				parametrosformais(ar);
			}
			simboloSimples1(ar, ")");
		} else if (ar.procurarLexema().equals("procedure")) {
			palavrasReservadas1(ar, "procedure");
			if (ar.desvendar(",")) {
				while (!ar.desvendar(":")) {
					identificador1(ar);
					simboloSimples1(ar, ",");
				}
			}
			identificador1(ar);
			if (ar.procurarLexema().equals(";")) {
				parametrosformais(ar);
			}
			simboloSimples1(ar, ")");
		}else {
			if(ar.procurarLexema().equals("var")){
				palavrasReservadas1(ar, "var");
			}
			if (ar.desvendar(",")) {
				while (!ar.desvendar(":")) {
					identificador1(ar);
					simboloSimples1(ar, ",");
				}
			}
			identificador1(ar);
			simboloSimples1(ar, ":");
			identificador1(ar);
			if (ar.procurarLexema().equals(";")) {
				parametrosformais(ar);
			}
			simboloSimples1(ar, ")");			
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
