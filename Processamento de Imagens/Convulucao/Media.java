package Convulucao;

import org.opencv.core.Mat;

import OperacoesLogicas.Manipulacao;

public class Media {

	private Mat original1;
	private Mat original2;

	public Media(Mat imagem1, Mat imagem2) {
		this.original1 = imagem1;
		this.original2 = imagem2;
	}

	public void executar(String output1, String output2) {

		int height1 = original1.height();
		int width1 = original1.width();
		
		int height2 = original2.height();
		int width2 = original2.width();

		Mat imgCinza = new Mat(height1, width1, original1.type());
		Mat imgColorida = new Mat(height2, width2, original2.type());

		for (int h = 1; h < height1 - 1; h++) {
			for (int w = 1; w < width1 - 1; w++) {
				int cor1 = getMediaCinza(h, w);
				double[] tom1 = {cor1, cor1, cor1};
				imgCinza.put(h, w, tom1);
			}
		}
		
		for (int h = 1; h < height2 - 1; h++) {
			for (int w = 1; w < width2 - 1; w++) {
				imgColorida.put(h, w, getMediaColorida(h, w));
			}
		}

		Manipulacao m = new Manipulacao();
		m.salvarImagem(output1, imgCinza);
		m.salvarImagem(output2, imgColorida);

	}
	
	public double[] getMediaColorida (int h, int w){		
		double[] x0 = original2.get(h - 1, w - 1);
		double[] x1 = original2.get(h - 1, w);
		double[] x2 = original2.get(h - 1, w + 1);
		double[] x3 = original2.get(h, w - 1);
		double[] x5 = original2.get(h, w + 1);
		double[] x6 = original2.get(h + 1, w - 1);
		double[] x7 = original2.get(h + 1, w);
		double[] x8 = original2.get(h + 1, w + 1);
		
		double r = (x0[0] + x1[0] + x2[0] + x3[0] + x5[0] + x6[0] + x7[0] + x8[0])/9;
		double g = (x0[1] + x1[1] + x2[1] + x3[1] + x5[1] + x6[1] + x7[1] + x8[1])/9;
		double b = (x0[2] + x1[2] + x2[2] + x3[2] + x5[2] + x6[2] + x7[2] + x8[2])/9;
		
		double[] tom = {r, g, b};
		return tom;
	}

	public int getMediaCinza (int h, int w){
		double[] rgb0 = original1.get(h - 1, w - 1);
		double x0 = ((rgb0[0] + rgb0[1] + rgb0[2]) / 3)/9;
		double[] rgb1 = original1.get(h - 1, w);
		double x1 = ((rgb1[0] + rgb1[1] + rgb1[2]) / 3)/9;
		double[] rgb2 = original1.get(h - 1, w + 1);
		double x2 = ((rgb2[0] + rgb2[1] + rgb2[2]) / 3)/9;
		double[] rgb3 = original1.get(h, w - 1);
		double x3 = ((rgb3[0] + rgb3[1] + rgb3[2]) / 3)/9;
		double[] rgb5 = original1.get(h, w + 1);
		double x5 = ((rgb5[0] + rgb5[1] + rgb5[2]) / 3)/9;
		double[] rgb6 = original1.get(h + 1, w - 1);
		double x6 = ((rgb6[0] + rgb6[1] + rgb6[2]) / 3)/9;
		double[] rgb7 = original1.get(h + 1, w);
		double x7 = ((rgb7[0] + rgb7[1] + rgb7[2]) / 3)/9;
		double[] rgb8 = original1.get(h + 1, w + 1);
		double x8 = ((rgb8[0] + rgb8[1] + rgb8[2]) / 3)/9;
		
		return (int) (x0+x1+x2+x3+x5+x6+x7+x8);
	}

}
