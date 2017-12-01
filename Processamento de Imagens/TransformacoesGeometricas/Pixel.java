package TransformacoesGeometricas;

public class Pixel {
	
	private double[] rgb;
	private int x;
	private int y;
	
	public Pixel (double[] rgb, int x, int y){
		this.rgb = rgb;
		this.x = x;
		this.y = y;
	}

	public double[] getRgb() {
		return rgb;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
