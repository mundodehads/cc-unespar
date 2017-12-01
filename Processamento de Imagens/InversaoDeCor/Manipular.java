package InversaoDeCor;

import static org.opencv.imgcodecs.Imgcodecs.IMREAD_COLOR;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class Manipular {
	
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

}
