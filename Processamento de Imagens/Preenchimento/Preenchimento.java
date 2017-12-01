package Preenchimento;

import java.util.Random;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class Preenchimento {

	private Mat img;
	private String output;
	private static double[] nova;
	private static double[] atual;

	public Preenchimento(Mat imagem, String output) {
		this.output = output;
		this.img = imagem;
	}
	
	public double[] getNova (){
		Random random = new Random();
		double r = random.nextDouble() * 255;
		double g = random.nextDouble() * 255;
		double b = random.nextDouble() * 255;
		double[] cor = {r, g, b};
		if(cor[0] != atual[0] &&
				cor[1] != atual[1] &&
				cor[2] != atual[2]){
			return cor;
		}else {
			getNova();
		}
		return null;
	}

	public void executar(int h, int w) {
		atual = img.get(h, w);
		nova = getNova();
		img.put(h, w, nova);
		preencher(h-1, w, atual);
		salvarImagem(output, img);
		System.out.println("Terminou");
	}

	public void preencher(int h, int w, double[] a) {
		if(img.get(h, w) != null){
			if(img.get(h, w)[0] == atual[0] &&
					img.get(h, w)[1] == atual[1] &&
					img.get(h, w)[2] == atual[2]){
				img.put(h, w, nova);
				//salvarImagem(output, img);
				preencher(h-1, w, atual);
				preencher(h, w+1, atual);
				preencher(h+1, w, atual);
				preencher(h, w-1, atual);
			}
		}
	}

	public void salvarImagem(String path, Mat img) {
		Imgcodecs.imwrite(path, img);
	}

}
