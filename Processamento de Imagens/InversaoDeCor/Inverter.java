package InversaoDeCor;

import org.opencv.core.Mat;

public class Inverter extends Manipular {

	//private String input;
	private String output;
	private Mat original;

	public Inverter(String input, String output) {
		//this.input = input;
		this.output = output;
		this.original = abrirImagem(input);
	}

	public void gerarInvertida() {
		Mat invertida = new Mat(original.height(), original.width(), original.type());
		int height = original.height(); // altura
		int width = original.width(); // largura
		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				double[] rgb = original.get(h, w);
				double[] cor = {255 - rgb[0], 255 - rgb[1], 255 - rgb[2]};
				invertida.put(h, w, cor);
			}
		}
		salvarImagem(output, invertida);
	}
	
}