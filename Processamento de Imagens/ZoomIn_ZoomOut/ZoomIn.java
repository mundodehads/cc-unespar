package ZoomIn_ZoomOut;

import org.opencv.core.Mat;

public class ZoomIn extends Manipulacao {

	private Mat original;
	private String output;

	public ZoomIn(Mat imagem, String output) {
		this.original = imagem;
		this.output = output;
	}

	public void Quadrado() {
		Mat inquadrado = new Mat(original.height()*2, original.width()*2, original.type());
		System.out.println(original.height()+"/"+original.width());
		System.out.println(inquadrado.height()+"/"+inquadrado.width());

		
		int height = original.height(); //altura
		int width = original.width(); //largura
		
		int x = 0;
		int y = 0;

		for (int h = 0; h < height; h++) {
			if(h!=0){
				y+=2;
				x=0;
			}
			for (int w = 0; w < width; w++) {
				double[] rgb = original.get(h, w);
				inquadrado.put(y, x, rgb);
				inquadrado.put(y+1, x, rgb);
				inquadrado.put(y, x+1, rgb);
				inquadrado.put(y+1, x+1, rgb);
				x+=2;
			}
		}
		
		
		salvarImagem(output, inquadrado);
	}

	public void Linear() {

	}

}
