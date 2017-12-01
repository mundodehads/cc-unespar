package OperacoesLogicas;

import org.opencv.core.Mat;

import Histogramas.manipulacao;

public class Operacoes {
	
	private Mat imagem1;
	private Mat imagem2;
	
	public Operacoes (Mat imagem1, Mat imagem2){
		this.imagem1 = imagem1;
		this.imagem2 = imagem2;
	}
	
	public void logicaE (String output){
		
		manipulacao m = new manipulacao();
		Mat e = m.copiarImagem(imagem1);
		
		int height = e.height();
		int width = e.width();

		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				double[] rgb1 = imagem1.get(h, w);
				double[] rgb2 = imagem2.get(h, w);
				double[] branco = {255,255,255};
				e.put(h, w, branco);
				if(rgb1[0] == 0 && rgb2[0] == 0){
					double[] preto = {0,0,0};
					e.put(h, w, preto);
				}
			}
		}
		
		m.salvarImagem(output, e);
		
	}
	
	public void logicaOU (String output){
		
		manipulacao m = new manipulacao();
		Mat ou = m.copiarImagem(imagem1);
		
		int height = ou.height();
		int width = ou.width();

		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				double[] rgb1 = imagem1.get(h, w);
				double[] rgb2 = imagem2.get(h, w);
				double[] branco = {255,255,255};
				ou.put(h, w, branco);
				if(rgb1[0] == 0 || rgb2[0] == 0){
					double[] preto = {0,0,0};
					ou.put(h, w, preto);
				}
			}
		}
		
		m.salvarImagem(output, ou);
		
	}
	
	public void complemento (String output){
		
		manipulacao m = new manipulacao();
		Mat com = m.copiarImagem(imagem2);
		
		int height = com.height();
		int width = com.width();

		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				double[] rgb = imagem2.get(h, w);
				double[] branco = {255,255,255};
				double[] preto = {0,0,0};
				if(rgb[0] == 0){
					com.put(h, w, branco);
				}else {
					com.put(h, w, preto);
				}
			}
		}
		
		m.salvarImagem(output, com);
		
	}

}
