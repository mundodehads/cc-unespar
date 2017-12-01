package Histogramas;

import org.opencv.core.Mat;

public class cinza {

	private Mat original;
	private String output;
	
	private double[] cores;

	public cinza(Mat imagem, String output) {
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
				cores[(int) rgb[0]]++;
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
				double[] rgb = original.get(h, w);
				double[] tom= {cores[(int) rgb[0]]*255,cores[(int) rgb[0]]*255,cores[(int) rgb[0]]*255};
				equalizada.put(h, w, tom);
			}
		}
		
		m.salvarImagem(output, equalizada);
	}

}