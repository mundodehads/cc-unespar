package AnalisadorLexico;

public class Main {

	public static void main(String[] args) {

		analisadorLexico aL = new analisadorLexico("testes/p2.txt",
				"testes/p2tokens.txt");
		aL.Executar();

	}

}
