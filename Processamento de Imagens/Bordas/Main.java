package Bordas;

import org.opencv.core.Mat;
import OperacoesLogicas.Manipulacao;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manipulacao m = new Manipulacao();
		Mat imagem = m.abrirImagem("imagens/bianca.png");
		Sobel s = new Sobel(imagem);
		s.executar("imagens/biancaBorda.png", 15);

	}

}
