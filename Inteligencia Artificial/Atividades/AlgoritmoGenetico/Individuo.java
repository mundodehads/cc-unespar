package AlgoritmoGenetico;

import java.util.Random;

public class Individuo {

	private int aptidao;
	private int[] genes;

	public Individuo (){
		genes = new int[7];
		GerarIndividuo();
	}

	public Individuo (int[] novosGenes){
		genes = new int[7];
		for(int i=0; i<7; i++)
			genes[i] = novosGenes[i];
		TestarNovaAptidao();
	}

	private void GerarIndividuo (){
		Random r = new Random();
		for(int i=0; i<7; i++)
			genes[i] = r.nextInt(100);
		TestarAptidao();
	}

	//Função objetivo: ( b + c + d + e + f + g) / a = 300;

	private void TestarAptidao (){
		if(genes[0] == 0)
			GerarIndividuo();
		else aptidao = (int) Math.abs(((genes[1]+genes[2]+genes[3]+genes[4]+genes[5]+genes[6]) / genes[0]) - 300);
	}

	private void TestarNovaAptidao (){
		Random r = new Random();
		if(genes[0] == 0){
			genes[0] = r.nextInt(100);
			TestarNovaAptidao();
		}else aptidao = (int) Math.abs(((genes[1]+genes[2]+genes[3]+genes[4]+genes[5]+genes[6]) / genes[0]) - 300);
	}

	public int getAptidao(){
		return aptidao;
	}

	public int[] getGenes(){
		return genes;
	}

	public void setGenes(int i, int n){
		genes[i] = n;
	}

}
