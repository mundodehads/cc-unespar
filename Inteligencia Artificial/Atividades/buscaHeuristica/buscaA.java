package buscaHeuristica;

import java.util.ArrayList;

import buscas.estruturas.*;

public class buscaA {

	private Arvore arv;
	private ArrayList<Noh> fila;
	private int[] hx;
	private int hxi = 0;

	public buscaA(int[] hx) {
		this.arv = new Arvore();
		this.fila = new ArrayList<Noh>();
		this.hx = hx;
	}

	public void addFilhos(Noh x) {
		if (x.getFilhos() != null) {
			for (int i = 0; i < x.getFilhos().size(); i++) {
				x.getFilhos().get(i).setCusto(x.getFilhos().get(i).getCusto() + hx[hxi]);
				hxi++;
				x.getFilhos().get(i).setPai(x);
				fila.add(x.getFilhos().get(i));
			}
		} else {
			return;
		}

	}

	public void organizarFila() {

		for (int i = 0; i < fila.size(); i++) {
			for (int j = 0; j < fila.size(); j++) {
				if (fila.get(i).getCusto() < fila.get(j).getCusto()) {
					Noh aux = fila.get(i);
					fila.set(i, fila.get(j));
					fila.set(j, aux);
				}
			}
		}
	}
	
	public int posicao (Noh x){
		ArrayList<Noh> l = new ArrayList<Noh>();
		int posicao = 0;
		l.add(arv.getRaiz());
		while(l.get(0) != x){
			if(l.get(0).getFilhos() != null){
				for(int i=0; i<l.get(0).getFilhos().size(); i++){
					l.add(l.get(0).getFilhos().get(i));
				}
			}
			posicao++;
			l.remove(0);
		}
		return posicao;
	}

	public void aEstrela(int objetivo) {
		Noh aux = null;
		Noh raiz = arv.getRaiz();
		raiz.setCusto(raiz.getCusto() + hx[hxi]);
		hxi++;
		fila.add(raiz);
		System.out.println("Percurso:");
		while (fila.get(0).getValor() != objetivo) {
			addFilhos(fila.get(0));
			organizarFila();
			addFilhos(fila.get(0));
			System.out.println(fila.get(0).getValor());
			if (fila.get(0).getValor() != objetivo) {
				fila.remove(0);
			}
		}
		aux = fila.get(0);
		System.out.println("Caminho:");
		System.out.println(aux.getValor());
		while (aux.getPai() != null) {
			aux = aux.getPai();
			System.out.println(aux.getValor());
		}
	}

}
