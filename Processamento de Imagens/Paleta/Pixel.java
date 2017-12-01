package Paleta;

public class Pixel {

	private double[] rgb;
	private int cont;

	public Pixel (double[] rgb) {
		this.rgb = rgb;
		this.cont = 0;
	}
	
	private static int tolerancia  = 10;

	@Override
	public boolean equals(Object o){
		Pixel p  = (Pixel) o;
		if(this.GetRgb()[0] < p.GetRgb()[0] + tolerancia &&
				this.GetRgb()[0] > p.GetRgb()[0] - tolerancia &&
				this.GetRgb()[1] < p.GetRgb()[1] + tolerancia &&
				this.GetRgb()[1] > p.GetRgb()[1] - tolerancia &&
				this.GetRgb()[2] < p.GetRgb()[2] + tolerancia &&
				this.GetRgb()[2] > p.GetRgb()[2] - tolerancia ) {
			return true;
		}
		return false;
	}

	public double[] GetRgb (){
		return this.rgb;
	}

	public void SetRgb (double[] newRgb){
		this.rgb = newRgb;
	}

	public int GetCont () {
		return this.cont;
	}

	public void AddCont (){
		this.cont++;
	}

}
