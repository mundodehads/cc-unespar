package AnalisadorLexico;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class analisadorLexico {

	private String caminho;
	private String saida;
	private Estado primeiro;
	private Estado atual;

	public analisadorLexico(String input, String output) {

		Estado e0 = new Estado((Arrays.asList(new Character[] { '@' })), false);
		Estado e1 = new Estado((Arrays.asList(new Character[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
				'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'x', 'z', 'w', 'y', 'A', 'B', 'C', 'D', 'E', 'F',
				'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'X', 'Z', 'W', 'Y' })),
				true);
		Estado e2 = new Estado((Arrays.asList(new Character[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' })),
				true);
		Estado e3 = new Estado((Arrays.asList(new Character[] { ':' })), true);
		Estado e4 = new Estado((Arrays.asList(new Character[] { ';' })), true);
		Estado e1_1 = new Estado((Arrays.asList(new Character[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' })),
				true);
		Estado e1_2 = new Estado((Arrays.asList(new Character[] { '_' })), true);
		Estado e2_1 = new Estado((Arrays.asList(new Character[] { '.' })), false);
		Estado e3_1 = new Estado((Arrays.asList(new Character[] { '=' })), true);
		Estado e5 = new Estado((Arrays.asList(new Character[] { '<' })), true);
		Estado e6 = new Estado((Arrays.asList(new Character[] { '>' })), true);
		Estado e7 = new Estado((Arrays.asList(new Character[] { '/' })), true);
		Estado e8 = new Estado((Arrays.asList(new Character[] { '*' })), true);
		Estado e9 = new Estado((Arrays.asList(new Character[] { '-' })), true);
		Estado e10 = new Estado((Arrays.asList(new Character[] { '+' })), true);
		Estado e11 = new Estado((Arrays.asList(new Character[] { '<' })), false);
		Estado e12 = new Estado((Arrays.asList(new Character[] { '>' })), true);
		Estado e13 = new Estado((Arrays.asList(new Character[] { '{' })), true);
		Estado e14 = new Estado((Arrays.asList(new Character[] { '}' })), true);
		Estado e15 = new Estado((Arrays.asList(new Character[] { '(' })), true);
		Estado e16 = new Estado((Arrays.asList(new Character[] { ')' })), true);
		Estado e17 = new Estado((Arrays.asList(new Character[] { ',' })), true);
		Estado e18 = new Estado((Arrays.asList(new Character[] { '.' })), true);
		
		e0.getProximo().add(e1);
		e0.getProximo().add(e2);
		e0.getProximo().add(e3);
		e0.getProximo().add(e4);
		e0.getProximo().add(e3_1);
		e0.getProximo().add(e5);
		e0.getProximo().add(e6);
		e0.getProximo().add(e7);
		e0.getProximo().add(e8);
		e0.getProximo().add(e9);
		e0.getProximo().add(e10);
		e0.getProximo().add(e11);
		e0.getProximo().add(e13);
		e0.getProximo().add(e14);
		e0.getProximo().add(e15);
		e0.getProximo().add(e16);
		e0.getProximo().add(e17);
		e0.getProximo().add(e18);
		e1.getProximo().add(e1);
		e1.getProximo().add(e1_1);
		e1.getProximo().add(e1_2);
		e1_1.getProximo().add(e1_1);
		e1_1.getProximo().add(e1);
		e1_1.getProximo().add(e1_2);
		e1_2.getProximo().add(e1);
		e1_2.getProximo().add(e1_1);
		e1_2.getProximo().add(e1_2);
		e2.getProximo().add(e2);
		e2.getProximo().add(e2_1);
		e2_1.getProximo().add(e2);
		e3.getProximo().add(e3_1);
		e5.getProximo().add(e3_1);
		e6.getProximo().add(e3_1);
		e7.getProximo().add(e3_1);
		e8.getProximo().add(e3_1);
		e9.getProximo().add(e3_1);
		e10.getProximo().add(e3_1);
		e11.getProximo().add(e12);
		
		this.caminho = input;
		this.saida = output;
		this.primeiro = e0;

	}

	public Token Executar() {
		
		// Boolean stop = false;
		String linha;
		StringTokenizer separador;
		String palavra;
		Token t = new Token();
		BufferedReader bf;
		try {
			bf = new BufferedReader(new FileReader(caminho));
			while ((linha = bf.readLine()) != null) {
				// if (stop)
				// break;
				separador = new StringTokenizer(linha);
				while (separador.hasMoreTokens()) {
					palavra = separador.nextToken(" ");
					if (!testarPalavra(palavra, t)) {
						System.out.println("Palavra não aceita: " + palavra);
						// stop = true;
						// break;
					}
				}
			}
			System.out.println("tokens de palavras aceitas gerados.");
			t.escreverToken(saida);
			bf.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
		
	}

	public Boolean testarPalavra(String palavra, Token t) {
		
		atual = primeiro;
		Estado aux = primeiro;
		int x = 0;
		int y = 0;
		int p = 0;
		while (x < palavra.length()) {
			if (atual.pertence(palavra.charAt(x))) {
				aux = atual;
				p = 0;
				x++;
			} else {
				if (p < aux.getProximo().size()) {
					atual = aux.getProximo().get(p);
					p++;
				} else {
					if (!aux.getTerminal()) {
						return false;
					} else {
						t.adicionarLexema(palavra.substring(y, x));
						y = x;
						p = 0;
						atual = primeiro;
						aux = primeiro;
					}
				}
			}
		}
		if (!aux.getTerminal()) {
			return false;
		}
		t.adicionarLexema(palavra.substring(y, x));
		return true;
		
	}

}
