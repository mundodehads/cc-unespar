package OperacoesLogicas;

import static org.opencv.imgcodecs.Imgcodecs.IMREAD_COLOR;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class Manipulacao {
	
	public Mat abrirImagem(String path) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		return Imgcodecs.imread(path, IMREAD_COLOR);
	}
	
	public void salvarImagem(String path, Mat img) {
		Imgcodecs.imwrite(path, img);
	}
	
	public Mat copiarImagem(Mat imagem) {
		return imagem.clone();
	}

}
