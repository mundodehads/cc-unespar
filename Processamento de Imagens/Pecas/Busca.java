package Pecas;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class Busca {

	private static double[] preto = { 0, 0, 0 };
	private Mat img;
	private int cont;
	private int furos = 0;

	public Busca(Mat imagem) {
		this.img = imagem;
	}

	public void executar() {

		for (int h = 0; h < img.height(); h++) {
			for (int w = 0; w < img.width(); w++) {
				cont = 0;
				preencher(h, w);
				if (cont > 0) {
					furos++;
				}
			}
		}
		salvarImagem("furossasadsasda.png", img);
		System.out.println("Quantidade de furos: " + (furos - 1));
	}
	
	public void salvarImagem(String path, Mat img) {
		Imgcodecs.imwrite(path, img);
	}

	public void preencher(int h, int w) {
		if (img.get(h, w) != null) {
			if (img.get(h, w)[0] == 255) {
				//System.out.println(img.get(h, w)[0]+"/"+h+"/"+w);
				cont++;
				img.put(h, w, preto);
				preencher(h - 1, w);
				preencher(h, w + 1);
				preencher(h + 1, w);
				preencher(h, w - 1);
			}
		}
	}

}
