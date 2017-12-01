package ZoomIn_ZoomOut;

import static org.opencv.imgcodecs.Imgcodecs.IMREAD_COLOR;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class Main {

	public static void main(String[] args) {
		
		Mat imagem = abrirImagem("teste.png");
		
//		ZoomIn zi = new ZoomIn(imagem, "ZIQ.png", "ZIL.png");
//		zi.Quadrado();
		
		ZoomOut zo = new ZoomOut(imagem, "ZOQ.png", "ZOL.png");
//		zo.Quadrado();
		zo.Linear();
		

	}
	
	public static Mat abrirImagem(String path) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		return Imgcodecs.imread(path, IMREAD_COLOR);
	}
	
}
