package ZoomIn_ZoomOut;

import org.opencv.core.Mat;

public class ZoomOut extends Manipulacao {

	private Mat original;
	private String output1;
	private String output2;

	public ZoomOut(Mat imagem, String output1, String output2) {
		this.original = imagem;
		this.output1 = output1;
		this.output2 = output2;
	}

	public void Quadrado() {
		Mat outquadrado = new Mat(original.height() / 2, original.width() / 2, original.type());

		int height = original.height(); // altura
		int width = original.width(); // largura

		int x = 0;
		int y = 0;

		for (int h = 0; h < height; h++) {
			if (h != 0) {
				x = 0;
				y++;
			}
			for (int w = 0; w < width; w++) {
				double[] rgb = original.get(h, w);
				outquadrado.put(y, x, rgb);
				if (w != 0)
					x++;
				if (w < width - 2)
					w++;
			}
			h++;
		}

		salvarImagem(output1, outquadrado);

	}

	public void Linear() {

		Mat outlinear = new Mat(original.height() / 2, original.width() / 2, original.type());

		int height = original.height(); // altura
		int width = original.width(); // largura

		// (rgb1[0]+rgb2[0]+rgb3[0]+rgb4[0])/4,
		// (rgb1[1]+rgb2[1]+rgb3[1]+rgb4[1])/4,
		// (rgb1[2]+rgb2[2]+rgb3[2]+rgb4[2])/4

		double cor1 = 0, cor2 = 0, cor3 = 0;

		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				double[] rgb1 = original.get(h, w);
				double[] rgb2 = original.get(h + 1, w);
				double[] rgb3 = original.get(h, w + 1);
				double[] rgb4 = original.get(h + 1, w + 1);
				if (original.get(h, w) != null 
						&& original.get(h + 1, w) != null 
						&& original.get(h, w + 1) != null
						&& original.get(h + 1, w + 1) != null){
					cor1 = (rgb1[0]+rgb2[0]+rgb3[0]+rgb4[0])/4;
					cor2 = (rgb1[1]+rgb2[1]+rgb3[1]+rgb4[1])/4;
					cor3 = (rgb1[2]+rgb2[2]+rgb3[2]+rgb4[2])/4;
				}
				if (original.get(h + 1, w) == null && original.get(h, w + 1) == null
						&& original.get(h + 1, w + 1) == null) {
					cor1 = rgb1[0];
					cor2 = rgb1[1];
					cor3 = rgb1[2];
				}
				if (original.get(h + 1, w + 1) == null && original.get(h + 1, w) == null) {
					cor1 = (rgb1[0] + rgb3[0]) / 2;
					cor2 = (rgb1[1] + rgb3[1]) / 2;
					cor3 = (rgb1[2] + rgb3[2]) / 2;
				}
				if (original.get(h, w + 1) == null && original.get(h + 1, w + 1) == null) {
					cor1 = (rgb1[0] + rgb2[0]) / 2;
					cor2 = (rgb1[1] + rgb2[1]) / 2;
					cor3 = (rgb1[2] + rgb2[2]) / 2;
				}
				double[] tom = { cor1, cor2, cor3 };
				outlinear.put(h, w, tom);
				w++;
			}
			h++;
		}

		salvarImagem(output2, outlinear);

	}

}
