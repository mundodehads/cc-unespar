package CoresCanais;

import org.opencv.core.Mat;

import Histogramas.manipulacao;

public class corescanais {

	private Mat original;

	public corescanais(Mat imagem) {
		this.original = imagem;
	}

	public void red(String output1, String output2) {

		manipulacao m = new manipulacao();
		Mat vermelha = m.copiarImagem(original);
		Mat cinza = m.copiarImagem(original);

		int height = original.height();
		int width = original.width();

		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				double[] rgb = original.get(h, w);
				double[] tom = { 0, 0, rgb[2] };
				double[] tomcinza = { rgb[2], rgb[2], rgb[2] };
				vermelha.put(h, w, tom);
				cinza.put(h, w, tomcinza);
			}
		}

		m.salvarImagem(output1, vermelha);
		m.salvarImagem(output2, cinza);

	}

	public void green(String output1, String output2) {

		manipulacao m = new manipulacao();
		Mat verde = m.copiarImagem(original);
		Mat cinza = m.copiarImagem(original);

		int height = original.height();
		int width = original.width();

		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				double[] rgb = original.get(h, w);
				double[] tom = { 0, rgb[1], 0 };
				double[] tomcinza = { rgb[1], rgb[1], rgb[1] };
				verde.put(h, w, tom);
				cinza.put(h, w, tomcinza);
			}
		}

		m.salvarImagem(output1, verde);
		m.salvarImagem(output2, cinza);

	}

	public void blue(String output1, String output2) {

		manipulacao m = new manipulacao();
		Mat azul = m.copiarImagem(original);
		Mat cinza = m.copiarImagem(original);

		int height = original.height();
		int width = original.width();

		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				double[] rgb = original.get(h, w);
				double[] tom = { rgb[0], 0, 0 };
				double[] tomcinza = { rgb[0], rgb[0], rgb[0] };
				azul.put(h, w, tom);
				cinza.put(h, w, tomcinza);
			}
		}

		m.salvarImagem(output1, azul);
		m.salvarImagem(output2, cinza);

	}

}
