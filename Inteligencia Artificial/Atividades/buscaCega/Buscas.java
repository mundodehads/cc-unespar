package buscaCega;

import java.util.ArrayList;
import buscas.estruturas.*;

public class Buscas {

	Arvore arv;
	ArrayList<Noh> filauniforme;
	ArrayList<Noh> filalargura;

	public Buscas() {
		this.arv = new Arvore();
		this.filauniforme = new ArrayList<Noh>();
		this.filalargura = new ArrayList<Noh>();
	}

	public void addFilhosUniforme (Noh x){
		if(x.getFilhos() != null){
			for(int i=0; i<x.getFilhos().size(); i++){
				filauniforme.add(x.getFilhos().get(i));
			}
		}else {
			return;
		}
		
	}
	
	public void addFilhosLargura (Noh x){
		if(x.getFilhos() != null){
			for(int i=0; i<x.getFilhos().size(); i++){
				filalargura.add(x.getFilhos().get(i));
			}
		}else {
			return;
		}
		
	}
	
	public void organizarfilauniforme (){
		for(int i=0;i<filauniforme.size(); i++){
			for(int j=0;j<filauniforme.size(); j++){
				if(filauniforme.get(i).getCusto() < filauniforme.get(j).getCusto()){
					Noh aux = filauniforme.get(i);
					filauniforme.set(i, filauniforme.get(j));
					filauniforme.set(j, aux);
				}
			}
		}
		
		int a=1,b=1, c=0, d=0;
		Noh aux = null;
		for(int i=0;i<filauniforme.size()-1; i++){
			if(filauniforme.get(i).getCusto() == filauniforme.get(i+1).getCusto()){
				Noh auxa = filauniforme.get(i).getPai();
				while(auxa != null){
					a++;
					if(auxa.getPai() != null) auxa = auxa.getPai();
					else break;
				}
				Noh auxb = filauniforme.get(i+1).getPai();
				while(auxb != null){
					b++;
					if(auxb.getPai() != null) auxb = auxb.getPai();
					else break;
				}
				if(b > a){
					aux = filauniforme.get(i);
					filauniforme.set(i, filauniforme.get(i+1));
					filauniforme.set(i+1, aux);
				}
					else if ( a == b){
					for(int j=0; j < filauniforme.get(i).getPai().getFilhos().size(); j++){
						if(filauniforme.get(i).getPai().getFilhos().get(j) == filauniforme.get(i))c = j;
						if(filauniforme.get(i).getPai().getFilhos().get(j) == filauniforme.get(i+1))d = j;
					}
					if(c < d){
						aux = filauniforme.get(i);
						filauniforme.set(i, filauniforme.get(i+1));
						filauniforme.set(i+1, aux);
					}else if (c > d){
						aux = filauniforme.get(i+1);
						filauniforme.set(i+1, filauniforme.get(i));
						filauniforme.set(i, aux);
					}
				}
			}
		}
	}

	public void CustoUniforme(int objetivo) {
		Noh aux = null;
		Boolean acabou = false;
		filauniforme.add(arv.getRaiz());
		System.out.println("Percurso:");
		while (!acabou) {
			System.out.println(filauniforme.get(0).getValor());
			if (filauniforme.get(0).getValor() == objetivo) {
				aux = filauniforme.get(0);
				acabou = true;
			} else {
				addFilhosUniforme(filauniforme.get(0));
				filauniforme.remove(0);
				organizarfilauniforme();
			}

		}
		System.out.println("Caminho:");
		System.out.println(aux.getValor());
		while (aux.getPai() != null) {
			aux = aux.getPai();
			System.out.println(aux.getValor());
		}
	}

	public void Largura(int objetivo) {
		Noh aux = null;
		Boolean acabou = false;
		filalargura.add(arv.getRaiz());
		System.out.println("Percurso:");
		while(!acabou){
			System.out.println(filalargura.get(0).getValor());
			if(filalargura.get(0).getValor() == objetivo){
				aux = filalargura.get(0);
				acabou = true;
			}else {
				addFilhosLargura(filalargura.get(0));
				filalargura.remove(0);
			}
		}
		System.out.println("Caminho:");
		System.out.println(aux.getValor());
		while (aux.getPai() != null) {
			aux = aux.getPai();
			System.out.println(aux.getValor());
		}

	}

}
