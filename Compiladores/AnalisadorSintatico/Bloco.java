package AnalisadorSintatico;

import java.util.ArrayList;

public class Bloco extends Noh {

	private ArrayList<Noh> filhos = new ArrayList<Noh>();

	public Bloco(Arvore ar) {
		try {
			if (ar.procurarLexema().equals("label")) {
				palavrasReservadas1(ar, "label");
				if (ar.desvendar(",")) {
					while (!ar.desvendar(";")) {
						numerico1(ar);
						simboloSimples1(ar, ",");
					}
					numerico1(ar);
				} else {
					numerico1(ar);
				}
				simboloSimples1(ar, ";");
			}
			if (ar.procurarLexema().equals("var")) {
				palavrasReservadas1(ar, "var");
				if (ar.desvendar(",")) {
					while (!ar.desvendar(":")) {
						identificador1(ar);
						simboloSimples1(ar, ",");
					}
					identificador1(ar);
				} else {
					identificador1(ar);
				}
				simboloSimples1(ar, ":");
				// palavrasReservadas sem um lexema esperado 'tipo'
				filhos.add(
						new NaoTerminal(ar.getCorrente().getTipo(), "pr", new Terminal(ar.getCorrente().getLexema())));
				ar.proximo();
				//
				simboloSimples1(ar, ";");
			}
			if (ar.procurarLexema().equals("procedure")) {
				palavrasReservadas1(ar, "procedure");
				identificador1(ar);
				if (!ar.procurarLexema().equals(";")) {
					filhos.add(new ParametrosFormais(ar));
				}
				simboloSimples1(ar, ";");
				filhos.add(new Bloco(ar));
				// simboloSimples1(ar, ";");
			}
			if (ar.procurarLexema().equals("function")) {
				palavrasReservadas1(ar, "function");
				identificador1(ar);
				if (ar.procurarLexema().equals(":")) {
					filhos.add(new ParametrosFormais(ar));
				}
				simboloSimples1(ar, ":");
				identificador1(ar);
				simboloSimples1(ar, ";");
				filhos.add(new Bloco(ar));
				// simboloSimples1(ar, ";");
			}
			palavrasReservadas1(ar, "begin");
			while (!ar.procurarLexema().equals("end")) {
				// Comando
				if (ar.procurarTipo().equals("num")) {
					numerico1(ar);
					simboloSimples1(ar, ":");
				}
				//
				filhos.add(new ComandoSemRotulo(ar));
				simboloSimples1(ar, ";");

			}
			palavrasReservadas1(ar, "end");
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
