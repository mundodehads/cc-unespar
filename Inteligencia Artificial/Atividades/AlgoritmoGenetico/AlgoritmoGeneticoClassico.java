package AlgoritmoGenetico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AlgoritmoGeneticoClassico {

	//Função objetivo: (int) |( d + e / a ) + f + g + b + c | = 1000;

	private static int tam = 20;

	private int numeroGeracoes;
	private List<Individuo> populacao;

	public AlgoritmoGeneticoClassico (){
		numeroGeracoes = 0;
		populacao = new ArrayList<Individuo>();
	}

	public void ExecutarSelecao () {
		GerarPopulacao();
		while(!Apto()){
			OrdenarPopulacao ();
			TorneioCruzamento();
			MutacaoDeformacao();
			numeroGeracoes++;
		}

	}

	private void GerarPopulacao (){
		populacao.removeAll(populacao);
		for(int i=0; i<tam; i++)
			populacao.add(new Individuo());
	}

	private void OrdenarPopulacao (){

		Individuo aux;
		for(int i=0; i<tam; i++)
			for(int j=i; j<tam; j++)
				if(populacao.get(i).getAptidao() > populacao.get(j).getAptidao()){
					aux = populacao.get(i);
					populacao.set(i, populacao.get(j));
					populacao.set(j, aux);
				}
	}

	private void TorneioCruzamento (){
		Random r = new Random();
		int corte = 0;
		List<Individuo> geracao = new ArrayList<Individuo>();
		int[] filho1 = new int[7], filho2 = new int [7];
		//0x1
		corte = r.nextInt(7);
		for(int i=0; i<corte; i++){
			filho1[i] = populacao.get(0).getGenes()[i];
			filho2[i] = populacao.get(1).getGenes()[i];
		}
		for(int j=corte; j<7; j++){
			filho1[j] = populacao.get(1).getGenes()[j];
			filho2[j] = populacao.get(0).getGenes()[j];
		}
		geracao.add(new Individuo(filho1));
		geracao.add(new Individuo(filho2));
		//2x0
		corte = r.nextInt(7);
		for(int i=0; i<corte; i++){
			filho1[i] = populacao.get(2).getGenes()[i];
			filho2[i] = populacao.get(0).getGenes()[i];
		}
		for(int j=corte; j<7; j++){
			filho1[j] = populacao.get(0).getGenes()[j];
			filho2[j] = populacao.get(2).getGenes()[j];
		}
		geracao.add(new Individuo(filho1));
		geracao.add(new Individuo(filho2));
		//0x3
		corte = r.nextInt(7);
		for(int i=0; i<corte; i++){
			filho1[i] = populacao.get(0).getGenes()[i];
			filho2[i] = populacao.get(3).getGenes()[i];
		}
		for(int j=corte; j<7; j++){
			filho1[j] = populacao.get(3).getGenes()[j];
			filho2[j] = populacao.get(0).getGenes()[j];
		}
		geracao.add(new Individuo(filho1));
		geracao.add(new Individuo(filho2));
		//4x0
		corte = r.nextInt(7);
		for(int i=0; i<corte; i++){
			filho1[i] = populacao.get(4).getGenes()[i];
			filho2[i] = populacao.get(0).getGenes()[i];
		}
		for(int j=corte; j<7; j++){
			filho1[j] = populacao.get(0).getGenes()[j];
			filho2[j] = populacao.get(4).getGenes()[j];
		}
		geracao.add(new Individuo(filho1));
		geracao.add(new Individuo(filho2));
		//1x2
		corte = r.nextInt(7);
		for(int i=0; i<corte; i++){
			filho1[i] = populacao.get(1).getGenes()[i];
			filho2[i] = populacao.get(2).getGenes()[i];
		}
		for(int j=corte; j<7; j++){
			filho1[j] = populacao.get(2).getGenes()[j];
			filho2[j] = populacao.get(1).getGenes()[j];
		}
		geracao.add(new Individuo(filho1));
		geracao.add(new Individuo(filho2));
		//3x1
		corte = r.nextInt(7);
		for(int i=0; i<corte; i++){
			filho1[i] = populacao.get(3).getGenes()[i];
			filho2[i] = populacao.get(1).getGenes()[i];
		}
		for(int j=corte; j<7; j++){
			filho1[j] = populacao.get(1).getGenes()[j];
			filho2[j] = populacao.get(3).getGenes()[j];
		}
		geracao.add(new Individuo(filho1));
		geracao.add(new Individuo(filho2));
		//1x4
		corte = r.nextInt(7);
		for(int i=0; i<corte; i++){
			filho1[i] = populacao.get(1).getGenes()[i];
			filho2[i] = populacao.get(4).getGenes()[i];
		}
		for(int j=corte; j<7; j++){
			filho1[j] = populacao.get(4).getGenes()[j];
			filho2[j] = populacao.get(1).getGenes()[j];
		}
		geracao.add(new Individuo(filho1));
		geracao.add(new Individuo(filho2));
		//2x3
		corte = r.nextInt(7);
		for(int i=0; i<corte; i++){
			filho1[i] = populacao.get(2).getGenes()[i];
			filho2[i] = populacao.get(3).getGenes()[i];
		}
		for(int j=corte; j<7; j++){
			filho1[j] = populacao.get(3).getGenes()[j];
			filho2[j] = populacao.get(2).getGenes()[j];
		}
		geracao.add(new Individuo(filho1));
		geracao.add(new Individuo(filho2));
		//4x2
		corte = r.nextInt(7);
		for(int i=0; i<corte; i++){
			filho1[i] = populacao.get(4).getGenes()[i];
			filho2[i] = populacao.get(2).getGenes()[i];
		}
		for(int j=corte; j<7; j++){
			filho1[j] = populacao.get(2).getGenes()[j];
			filho2[j] = populacao.get(4).getGenes()[j];
		}
		geracao.add(new Individuo(filho1));
		geracao.add(new Individuo(filho2));
		//3x4
		corte = r.nextInt(7);
		for(int i=0; i<corte; i++){
			filho1[i] = populacao.get(3).getGenes()[i];
			filho2[i] = populacao.get(4).getGenes()[i];
		}
		for(int j=corte; j<7; j++){
			filho1[j] = populacao.get(4).getGenes()[j];
			filho2[j] = populacao.get(3).getGenes()[j];
		}
		geracao.add(new Individuo(filho1));
		geracao.add(new Individuo(filho2));
		//FIM
		TestarConvergencia(geracao);
	}
	
	private void TestarConvergencia(List<Individuo> geracao){
		double somatoriaPopulacao = 0;
		double somatoriaGeracao = 0;
		for(Individuo ind : populacao)
			somatoriaPopulacao += ind.getAptidao();
		for(Individuo ind : geracao)
			somatoriaGeracao += ind.getAptidao();
		if((somatoriaPopulacao/20) > (somatoriaGeracao/20)){
			populacao = geracao;
		}else {
			//Tinha que fazer altas coisas??
			GerarPopulacao();
		}
	}

	private void MutacaoDeformacao (){
		Random r = new Random();
		for(Individuo ind : populacao){
			int i = r.nextInt(7);
			ind.setGenes(i, ind.getGenes()[i] + (int) (ind.getGenes()[i]*0.1));
		}
	}

	//Função objetivo: ( b + c + d + e + f + g) / a = 300;
	private boolean Apto (){
		for(Individuo ind : populacao){
			if(((ind.getGenes()[1]+ind.getGenes()[2]+ind.getGenes()[3]+ind.getGenes()[4]+ind.getGenes()[5]+ind.getGenes()[6]) / ind.getGenes()[0]) == 300){
				System.out.println("Encontrado individuo apto na "+numeroGeracoes+" geração, dados do individuo:");
				System.out.println("Genes: ");
				System.out.println(Arrays.toString(ind.getGenes()));
				return true;
			}
		}
		return false;
	}
}
