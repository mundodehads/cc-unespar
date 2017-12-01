package EscalaDeCinza_Binarizacao;

import static org.opencv.imgcodecs.Imgcodecs.IMREAD_COLOR;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class Manipulacao {
	
	public Mat original;
	public Mat cinza;
	public Mat binaria;
	
	public Manipulacao(String path) {
		this.original = abrirImagem(path);
		this.cinza = copiarImagem(original);
		this.binaria = copiarImagem(cinza);
	}
	
	public void gerarCinza(Mat original, Mat cinza) {

		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		int width = original.width(); //largura
		int height = original.height(); //altura
//		System.out.println(width+"/"+height);

		for (int w = 0; w < width; w++) {
			for (int h = 0; h < height; h++) {
//				System.out.println(w+"/"+h);
				double[] rgb = cinza.get(h, w);
				double cor = ((rgb[0] + rgb[1] + rgb[2]) / 3);
				double[] tom = { cor, cor, cor };
				cinza.put(h, w, tom);
			}
		}
		
		salvarImagem("paisagemcinza.png", cinza);

	}

	public void gerarBinarizacao(Mat cinza, Mat binaria) {

		int width = cinza.width();
		int height = cinza.height();

		for (int w = 0; w < width; w++) {
			for (int h = 0; h < height; h++) {
				double cor = 0;
				double[] pixel = cinza.get(h, w);
				if (pixel[0] > 100)
					cor = 255;
				double[] tom = { cor, cor, cor };
				binaria.put(h, w, tom);

			}
		}
		
		salvarImagem("paisagembinaria.png", binaria);

	}
	
	public static Mat abrirImagem(String path) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		return Imgcodecs.imread(path, IMREAD_COLOR);
	}

	public static Mat copiarImagem(Mat imagem) {
		return imagem.clone();
	}
	
	public void salvarImagem(String path, Mat img) {
		Imgcodecs.imwrite(path, img);
	}

	public Mat getOriginal() {
		return original;
	}

	public Mat getCinza() {
		return cinza;
	}

	public Mat getBinaria() {
		return binaria;
	}
	
	
}
