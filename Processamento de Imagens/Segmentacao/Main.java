package Segmentacao;

import static org.opencv.imgcodecs.Imgcodecs.IMREAD_COLOR;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class Main {

	public static void main(String[] args) {
		
		Mat imagem = abrirImagem("kmeans/colorida.png");
		kmeans k = new kmeans(imagem, "kmeans/coloridaKMEANS.png", 20);
		k.executar();
		//isodata i = new isodata(imagem, "kmeans/coloridaISODATA.png");
		//i.executar(50, 40);
	}
	
	public static Mat abrirImagem(String path) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		return Imgcodecs.imread(path, IMREAD_COLOR);
	}

}
