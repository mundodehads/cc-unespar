package Bordas;

import org.opencv.core.Mat;
import OperacoesLogicas.Manipulacao;

public class Sobel {
	
	private Mat original;
	
	public Sobel (Mat imagem){
		this.original = imagem;
	}
	
public void executar (String output, int limiar){
		
		int height = original.height();
		int width = original.width();
		double[] branco = {255,255,255};
		
		Mat img = new Mat(height, width, original.type());

		for (int h = 1; h < height-1; h++) {
			for (int w = 1; w < width-1; w++) {
				
				double[] rgb = original.get(h, w);
				
				double[] rgb0 = original.get(h-1, w-1);
				double x0 = (rgb0[0] + rgb0[1] + rgb0[2])/3;
				double[] rgb1 = original.get(h-1, w);
				double x1 = (rgb1[0] + rgb1[1] + rgb1[2])/3;
				double[] rgb2 = original.get(h-1, w+1);
				double x2 = (rgb2[0] + rgb2[1] + rgb2[2])/3;
				double[] rgb3 = original.get(h, w-1);
				double x3 = (rgb3[0] + rgb3[1] + rgb3[2])/3;
				double[] rgb4 = original.get(h, w);
				double x4 = (rgb4[0] + rgb4[1] + rgb4[2])/3;
				double[] rgb5 = original.get(h, w+1);
				double x5 = (rgb5[0] + rgb5[1] + rgb5[2])/3;
				double[] rgb6 = original.get(h+1, w-1);
				double x6 = (rgb6[0] + rgb6[1] + rgb6[2])/3;
				double[] rgb7 = original.get(h+1, w);
				double x7 = (rgb7[0] + rgb7[1] + rgb7[2])/3;
				double[] rgb8 = original.get(h+1, w+1);
				double x8 = (rgb8[0] + rgb8[1] + rgb8[2])/3;
				
				if(limiar < sobel(x0, x1, x2, x3, x4, x5, x6, x7, x8)){
					double[] tom = {0,0,0};
					img.put(h, w, tom);
				}else {
					img.put(h, w, branco);
				}
			}
		}
		
		Manipulacao m = new Manipulacao();
		m.salvarImagem(output, img);
		
	}

	public int sobel (double x0, double x1, double x2, double x3, double x4, double x5, double x6, double x7, double x8){
		double r1 = (x0*(-1))-(x1*2)-x2+x6+(x7*2)+x8;
		double r2 = (x0*(-1))+x2-(x3*2)+(x5*2)-x6+x8;
		return (int) Math.sqrt((r1*r1) + (r2*r2));
	}

}
