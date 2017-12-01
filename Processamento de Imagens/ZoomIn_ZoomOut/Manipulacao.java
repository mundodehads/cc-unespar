package ZoomIn_ZoomOut;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public abstract class Manipulacao {
	
	public static void criarImagem(Mat imagem, Mat m) {
		imagem.create(m.width()*2, m.height()*2, m.type());
	}
	
	public void salvarImagem(String path, Mat img) {
		Imgcodecs.imwrite(path, img);
	}
	
	public static Mat copiarImagem(Mat imagem) {
		return imagem.clone();
	}

}
