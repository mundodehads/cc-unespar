package TransformacoesGeometricas;

import org.opencv.core.Mat;

import OperacoesLogicas.Manipulacao;

public class Translacao {
	
	private Mat original;
	
	public Translacao (Mat imagem){
		this.original = imagem;
	}
	
	public void executar (String output, int nx, int ny){
		
		int height = original.height();
		int width = original.width();

		Mat img = new Mat(height, width, original.type());

		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				double[] rgb = original.get(h, w);
				img.put(h-ny, w+nx, rgb);
			}
		}
		
		Manipulacao m = new Manipulacao();
		m.salvarImagem(output, img);
		
	}

}
