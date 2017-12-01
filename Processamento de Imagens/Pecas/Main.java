package Pecas;

import static org.opencv.imgcodecs.Imgcodecs.IMREAD_COLOR;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mat imagem = abrirImagem("furos.png");
		Busca b = new Busca(imagem);
		b.executar();

	}
	
	public static Mat abrirImagem(String path) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		return Imgcodecs.imread(path, IMREAD_COLOR);
	}

}
