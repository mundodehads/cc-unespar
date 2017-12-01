package Preenchimento;

import static org.opencv.imgcodecs.Imgcodecs.IMREAD_COLOR;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class Main {
	
	public static void main(String[] args) {
		
		Mat imagem = abrirImagem("preenchimento/teste.png");
		Preenchimento p = new Preenchimento(imagem, "preenchimento/testePREENCHIDO.png");
		//p.executar(50, 50);
		Mouse m = new Mouse();
		m.start(p);
		
	}
	
	public static Mat abrirImagem(String path) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		return Imgcodecs.imread(path, IMREAD_COLOR);
	}

}
