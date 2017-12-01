package Paleta;

import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Mat;

public class Paleta {

	private List<Pixel> Paleta;

	public Paleta () {
		this.Paleta = new ArrayList<Pixel>();
	}

	public Mat CriarPaleta (Mat imagem){
		int height = imagem.height();
		int width = imagem.width();


		//Contar as cores
		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				AdicionarPixel(imagem.get(h, w));
			}
		}
		
		System.out.println("Tamanho da paleta"+Paleta.size());

	

		return imagem;
	}

	public void AdicionarPixel (double[] rgb){
		boolean igual = false;
		for(Pixel p : Paleta){
			if(p.GetRgb().equals(rgb)){
				p.AddCont();
				igual = true;
				break;
			}
		}
		if(!igual) Paleta.add(new Pixel(rgb));
	}

}
