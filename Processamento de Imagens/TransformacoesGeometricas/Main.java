package TransformacoesGeometricas;

import org.opencv.core.Mat;

import OperacoesLogicas.Manipulacao;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manipulacao m = new Manipulacao();
		Mat imagem = m.abrirImagem("imagens/ABCD.png");
		Rotacao r = new Rotacao(imagem);
		r.executar("imagens/ABCDRotacao.png", 45);
		Translacao t = new Translacao(imagem);
		t.executar("imagens/ABCDTransladado.png", 20, 50);
	}

}
