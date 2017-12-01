package TransformacoesGeometricas;

import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Mat;

import OperacoesLogicas.Manipulacao;

public class Rotacao {
	
	private Mat original;
	
	public Rotacao (Mat imagem){
		this.original = imagem;
	}
	
	public void executar (String output, double x){
		
		List<Pixel> lista = new ArrayList<Pixel>();
		int maiorx = 0, maiory = 0;
		
		double a = x*Math.PI/180.0;
		
		int height = original.height();
		int width = original.width();

		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				double[] rgb = original.get(h, w);
				lista.add(new Pixel(rgb, getX(h, w, a), getY(h, w, a)));
				if(getX(h, w, a) > maiorx) maiorx = getX(h, w, a);
				if(getY(h, w, a) > maiory) maiory = getY(h, w, a);
			}
		}
		
		Mat img = new Mat(maiorx, maiory, original.type());
		
		for(int i=0; i<lista.size(); i++){
			img.put(lista.get(i).getX(), lista.get(i).getY(), lista.get(i).getRgb());
		}

		Manipulacao m = new Manipulacao();
		m.salvarImagem(output, img);
		
	}
	
	//TODO Math.abs causa perda de pixel, mas da bom, mas tem que arrumar.
	public int getX(int x, int y, double a){
		return (int) Math.abs(x*Math.cos(a)-y*Math.sin(a));
	}
	
	public int getY(int x, int y, double a){
		return (int) Math.abs(x*Math.sin(a)+y*Math.cos(a));
	}
	
}
