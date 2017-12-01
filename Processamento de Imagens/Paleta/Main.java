package Paleta;

import static org.opencv.imgcodecs.Imgcodecs.IMREAD_COLOR;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Paleta p = new Paleta();
		salvarImagem("PaletaDoPaletaTeste.png", p.CriarPaleta(abrirImagem("PaletaTeste.png")));

	}
	
	public static Mat abrirImagem(String path) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		return Imgcodecs.imread(path, IMREAD_COLOR);
	}
	
	public static void salvarImagem(String path, Mat img) {
		Imgcodecs.imwrite(path, img);
	}

}
