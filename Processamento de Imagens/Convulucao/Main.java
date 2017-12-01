package Convulucao;

import org.opencv.core.Mat;
import OperacoesLogicas.Manipulacao;


public class Main {

	public static void main(String[] args) {

		Manipulacao m = new Manipulacao();
		
		Mat imagem1 = m.abrirImagem("convulacao/lena.png");
		Mat imagem2 = m.abrirImagem("convulacao/lenaColorida.png");
		
		Media media = new Media(imagem1, imagem2);
		media.executar("convulacao/lenaCinzaMedia.png", "convulacao/lenaColoridaMedia.png");
		Mediana mediana = new Mediana(imagem1, imagem2);
		mediana.executar("convulacao/lenaCinzaMediana.png", "convulacao/lenaColoridaMediana.png");

	}

}
