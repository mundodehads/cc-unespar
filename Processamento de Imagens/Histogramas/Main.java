package Histogramas;

import org.opencv.core.Mat;

public class Main {
	
	public static void main(String[] args) {
	
	manipulacao m = new manipulacao();
	Mat blur = m.abrirImagem("imagens/blur.bmp");
	//Mat paisagem = m.abrirImagem("paisagem.png");
	Mat img = m.abrirImagem("imagens/teste.png");
	
	cinza c1 = new cinza(blur, "imagens/blurFIXED.bmp");
	c1.Equalizar();
	
	//cores c2 = new cores(paisagem, "paisagemequalizada.png");
	cores c2 = new cores(img, "imagens/testeHistograma.png");
	c2.Equalizar();
	
	}

}
