package Segmentacao;

import java.util.ArrayList;
import java.util.List;

public class Centroide {
	
	private List<Pixel> grupo;
	private double[] cor;
	private int h;
	private int w;
	
	public Centroide (double[] cor, int h, int w){
		this.cor = cor;
		this.grupo = new ArrayList<Pixel>();
		this.h = h;
		this.w = w;
		
	}
	
	public int getH () {
		return this.h;
	}
	
	public int getW () {
		return this.w;
	}
	
	public double[] getCor () {
		return this.cor;
	}
	
	public List<Pixel> getGrupo () {
		return this.grupo;
	}

	public void setCor(double[] cor) {
		this.cor = cor;
	}

}
