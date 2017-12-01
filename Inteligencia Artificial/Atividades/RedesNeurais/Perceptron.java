package RedesNeurais;

import java.util.Random;

public class Perceptron {
	
	private double[] w;
	
	private double aprendizado;
	
	public Perceptron (double aprendizado){
		this.aprendizado = aprendizado;
	}
	
	
public void Treino (double[][] amostras, int maxepocas){
		
		int epocas = 0;
		Random r = new Random();
		
		this.w = new double[amostras[0].length-1];
		
		for(int x=0; x<w.length; x++){
			w[x] = r.nextDouble();
		}
		
		while(epocas < maxepocas){
			
			int erros = 0;
			
			for(int x=0; x<amostras.length; x++){
				
				double y = Saida(amostras[x]);
				
				if (y != amostras[x][amostras[0].length-1]){
					erros++;
					for(int i=0; i<w.length; i++){
						w[i] += aprendizado*(amostras[x][amostras[0].length-1] - y)*amostras[x][i];
					}
					
				}
			}
			
			if(erros == 0) break;
	
			epocas++;
		}
		
		System.out.println("Quantidade de epocas: "+epocas);
		for(int y=0; y<w.length; y++){
			System.out.println(w[y]);
		}
		
	}
	
	public double Saida (double[] entrada){
		double somatoria = 0;
		for(int i=0; i<w.length; i++){
			somatoria += w[i]*entrada[i];
		}
		
		return (somatoria>=0) ? 1 : -1;
	}

}
