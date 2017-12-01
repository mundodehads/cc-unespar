package Histogramas;

import org.opencv.core.Mat;

public class cores {
	
	private Mat original;
	private String output;
	
	private double[] cores;

	
	public cores (Mat imagem, String output){
		
		this.original = imagem;
		this.output = output;
		this.cores = new double[256];
	
	}
	
	public void Equalizar() {
		manipulacao m = new manipulacao();
		Mat equalizada = m.copiarImagem(original);

		int height = original.height();
		int width = original.width();

		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				double[] rgb = original.get(h, w);
				double[] yiq = Yiq(rgb);
				original.put(h, w, yiq);
				cores[(int) yiq[0]]++;
			}
		}
		
		for(int x=0; x<256;x++){
			cores[x] = (cores[x] / (height*width));
		}
		
		for(int i=1; i<256; i++){
			cores[i] = (cores[i] + cores[i-1]);
		}
		
		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				double[] yiq = original.get(h, w);
				double[] newyiq = {cores[(int) yiq[0]]*255, yiq[1], yiq[2]};
				double[] rgb = Rgb(newyiq);
				equalizada.put(h, w, rgb);
			}
		}
		
		m.salvarImagem(output, equalizada);
	}
	
	public double[] Rgb (double[] yiq){
		double[] rgb = {(1*yiq[0])+(0.956*yiq[1])+(0.620*yiq[2]),
				(1*yiq[0])-(0.272*yiq[1])-(0.647*yiq[2]),
				(1*yiq[0])-(1.108*yiq[1])+(1.705*yiq[2])};
		return rgb;
	}
	
	public double[] Yiq (double[] rgb){
		double[] yiq = {(0.299*rgb[0])+(0.587*rgb[1])+(0.114*rgb[2]),
				(0.596*rgb[0])-(0.275*rgb[1])-(0.321*rgb[2]),
				(0.212*rgb[0])-(0.523*rgb[1])+(0.311*rgb[2])};
		return yiq;
	}

}