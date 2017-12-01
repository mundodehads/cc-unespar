package AnalisadorSintatico;

import AnalisadorLexico.Token;
import AnalisadorLexico.analisadorLexico;

public class Main {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		analisadorLexico aL = new analisadorLexico("testes/sintatico.txt",
				"testes/sintaticotokens.txt");
		Token t = aL.Executar();
		analisadorSintatico aS = new analisadorSintatico(t.getLexemas(), t.getTipos());
		aS.executar();
	}

}
