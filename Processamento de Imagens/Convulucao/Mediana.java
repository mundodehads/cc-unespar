package Convulucao;

import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import OperacoesLogicas.Manipulacao;

public class Mediana {
	
	private Mat original;
	private Mat HSV;

	public Mediana(Mat imagem, Mat imagem2) {
		this.original = imagem;
		this.HSV = new Mat(imagem2.height(), imagem2.width(), imagem2.type());
		Imgproc.cvtColor(imagem2, HSV, Imgproc.COLOR_RGB2HSV);
	}
	
	public void executar(String output1, String output2){
		
		int height1 = original.height();
		int width1 = original.width();

		Mat imgCinza = new Mat(height1, width1, original.type());
		
		for (int h = 1; h < height1 - 1; h++) {
			for (int w = 1; w < width1 - 1; w++) {
				int cor = getMedianaCinza(h, w);
				double[] tom = {cor, cor, cor};
				imgCinza.put(h, w, tom);
			}
		}
		
		int height2 = HSV.height();
		int width2 = HSV.width();

		Mat imgColorida = new Mat(height2, width2, HSV.type());
		
		for (int h = 1; h < height2 - 1; h++) {
			for (int w = 1; w < width2 - 1; w++) {
				imgColorida.put(h, w, getMedianaColorida(h, w));
			}
		}
		
		
		Imgproc.cvtColor(imgColorida, imgColorida, Imgproc.COLOR_HSV2RGB);
		
		Manipulacao m = new Manipulacao();
		m.salvarImagem(output1, imgCinza);
		m.salvarImagem(output2, imgColorida);
		
	}
	
	public double[] getMedianaColorida (int h, int w){
		List<double[]> lista = new ArrayList<double[]>();
		lista.add(HSV.get(h - 1, w - 1));
		lista.add(HSV.get(h - 1, w));
		lista.add(HSV.get(h - 1, w + 1));
		lista.add(HSV.get(h, w - 1));
		lista.add(HSV.get(h, w));
		lista.add(HSV.get(h, w + 1));
		lista.add(HSV.get(h + 1, w - 1));
		lista.add(HSV.get(h + 1, w));
		lista.add(HSV.get(h + 1, w + 1));
		
		for(int i=0;i<lista.size();i++){
			for(int j=0; j<lista.size();j++){
				double[] a = lista.get(i);
				double[] b = lista.get(j);
				if(a[0] > b[0]){
					double[] aux = lista.get(i);
					lista.set(i, lista.get(j));
					lista.set(j, aux);
				}
			}
		}
		
		return lista.get(4);
	}
	
	public int getMedianaCinza (int h, int w){
		
		double[] vetor = new double[9];
		double[] rgb0 = original.get(h - 1, w - 1);
		vetor[0] = ((rgb0[0] + rgb0[1] + rgb0[2]) / 3);
		double[] rgb1 = original.get(h - 1, w);
		vetor[1] = ((rgb1[0] + rgb1[1] + rgb1[2]) / 3);
		double[] rgb2 = original.get(h - 1, w + 1);
		vetor[2] = ((rgb2[0] + rgb2[1] + rgb2[2]) / 3);
		double[] rgb3 = original.get(h, w - 1);
		vetor[3] = ((rgb3[0] + rgb3[1] + rgb3[2]) / 3);
		double[] rgb4 = original.get(h, w);
		vetor[4] = ((rgb4[0] + rgb4[1] + rgb4[2]) / 3);
		double[] rgb5 = original.get(h, w + 1);
		vetor[5] = ((rgb5[0] + rgb5[1] + rgb5[2]) / 3);
		double[] rgb6 = original.get(h + 1, w - 1);
		vetor[6] = ((rgb6[0] + rgb6[1] + rgb6[2]) / 3);
		double[] rgb7 = original.get(h + 1, w);
		vetor[7] = ((rgb7[0] + rgb7[1] + rgb7[2]) / 3);
		double[] rgb8 = original.get(h + 1, w + 1);
		vetor[8] = ((rgb8[0] + rgb8[1] + rgb8[2]) / 3);
		
		for(int i=0;i<vetor.length;i++){
			for(int j=i; j<vetor.length;j++){
				if(vetor[i] > vetor[j]){
					double aux = vetor[i];
					vetor[i] = vetor[j];
					vetor[j] = aux;
				}
			}
		}
		
		return (int) vetor[4];
	}

}
