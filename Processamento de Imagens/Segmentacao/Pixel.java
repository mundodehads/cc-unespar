package Segmentacao;

public class Pixel {

	private double[] cor;
	private int h;
	private int w;

	public Pixel(double[] cor, int h, int w) {

		this.cor = cor;
		this.h = h;
		this.w = w;

	}

	@Override
	public boolean equals(Object o){
		Pixel x  = (Pixel) o;
		if(this.getH() == x.getH() && this.getW() == x.getW()){
			return true;
		}
		return false;
	}

	public double[] getCor() {
		return cor;
	}

	public int getH() {
		return h;
	}

	public int getW() {
		return w;
	}

}
