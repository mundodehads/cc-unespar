package AnalisadorSemantico;

import AnalisadorLexico.Token;
import AnalisadorLexico.analisadorLexico;
import AnalisadorSintatico.Noh;
import AnalisadorSintatico.analisadorSintatico;

public class Main {

	public static void main(String[] args) {
		
		analisadorLexico aL = new analisadorLexico("testes/sintatico.txt",
				"testes/sintaticotokens.txt");
		Token t = aL.Executar();
		analisadorSintatico aS = new analisadorSintatico(t.getLexemas(), t.getTipos());
		Noh raiz = aS.executar();
		analisadorSemantico aSemantico = new analisadorSemantico(raiz);
		//erro ao identificar expressao simples, problemas para continuar pois nao consegui arrumar o erro de IndexOutofBounds.
	}

}
