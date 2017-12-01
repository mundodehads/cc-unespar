package Segmentacao;

import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class isodata {

	private Mat img;
	private String output;
	private Noh raiz;

	public isodata(Mat imagem, String output) {
		this.img = imagem;
		this.output = output;
		this.raiz = new Noh();
	}

	public void executar(double desvio, double Media){
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Imgproc.cvtColor(img, img, Imgproc.COLOR_RGB2HSV);

		double dAtual = inicializar();

		List<Noh> atual = new ArrayList<Noh>();
		atual.add(raiz);
		while(atual.size() > 0){
			if(dAtual < desvio){
				atual.get(0).getFilho().add(new Noh());
				atual.get(0).getFilho().add(new Noh());
				double m = media(atual.get(0));
				for(int x=0;x<atual.get(0).getGrupo().size();x++){
					if(atual.get(0).getGrupo().get(x).getCor()[0] < m){
						atual.get(0).getFilho().get(0).getGrupo().add(atual.get(0).getGrupo().get(x));
						atual.get(0).getGrupo().remove(x);
					}else {
						atual.get(0).getFilho().get(1).getGrupo().add(atual.get(0).getGrupo().get(x));
						atual.get(0).getGrupo().remove(x);
					}
				}
				atual.add(atual.get(0).getFilho().get(0));
				atual.add(atual.get(0).getFilho().get(1));
				atual.remove(0);
				dAtual = Math.sqrt(variancia(atual.get(0), media(atual.get(0))));
			}else {
				atual.remove(0);
				if(atual.size() > 0) dAtual = Math.sqrt(variancia(atual.get(0), media(atual.get(0))));
			}
		}

		atual.add(raiz);
		List<Noh> folha = new ArrayList<Noh>();
		while(atual.size() > 0){
			if(atual.get(0).getFilho().size() > 0){
				atual.add(atual.get(0).getFilho().get(0));
				atual.add(atual.get(0).getFilho().get(1));
				atual.remove(0);
			}else {
				folha.add(atual.get(0));
				atual.remove(0);
			}
		}


		for(int i=0;i<folha.size();i++){
			for(int j=0;j<folha.size();j++){
				if(Math.abs(media(folha.get(i))- media(folha.get(j))) < Media){
					for(int x=0;x<folha.get(j).getGrupo().size();x++){
						folha.get(i).getGrupo().add(folha.get(j).getGrupo().get(x));
					}
					folha.remove(j);
					if(Math.sqrt(variancia(folha.get(i), media(folha.get(i)))) < desvio){
						Noh aux = new Noh();
						double m = media(folha.get(i));
						for(int y=0;y<folha.get(i).getGrupo().size();y++){
							if(folha.get(i).getGrupo().get(y).getCor()[0] > m){
								aux.getGrupo().add(atual.get(i).getGrupo().get(y));
								folha.get(i).getGrupo().remove(y);
							}
						}
						folha.add(aux);
					}
					j=0;
				}
			}
		}

		Imgproc.cvtColor(img, img, Imgproc.COLOR_HSV2RGB);
		Mat img2 = new Mat(img.height(), img.width(), img.type());
		System.out.println("Quantidade de folhas finais: "+folha.size());
		for(int x=0;x<folha.size();x++){
			for(int y=0;y<folha.get(x).getGrupo().size();y++){
				img2.put(folha.get(x).getGrupo().get(y).getH(), folha.get(x).getGrupo().get(y).getW(), mediargb(folha.get(x).getGrupo()));
			}
		}
		salvarImagem(output, img2);

	}

	public double[] mediargb(List<Pixel> l){
		double[] rgb = {0,0,0};
		for (int y = 0; y < l.size(); y++) {
			rgb[0] += l.get(y).getCor()[0];
			rgb[1] += l.get(y).getCor()[1];
			rgb[2] += l.get(y).getCor()[2];
		}
		rgb[0] = Math.round(rgb[0]/l.size());
		rgb[1] = Math.round(rgb[1]/l.size());
		rgb[2] = Math.round(rgb[2]/l.size());
		return rgb;
	}


	public double media(Noh no){
		double media = 0;
		for(int x=0;x<no.getGrupo().size();x++){
			double[] hsv = no.getGrupo().get(x).getCor();
			media += hsv[0];

		}
		int n = img.height()*img.width();
		media /= n;
		return media;
	}

	public double variancia (Noh no, double media){
		double variancia = 0;
		for(int x=0;x<no.getGrupo().size();x++){
			double[] hsv = no.getGrupo().get(x).getCor();
			variancia += Math.pow(hsv[0]-media, 2);
		}
		variancia /= no.getGrupo().size()-1;
		return variancia;
	}

	public double inicializar (){
		for(int h=0;h<img.height();h++){
			for(int w=0;w<img.width();w++){
				double[] rgb = img.get(h, w);
				raiz.getGrupo().add(new Pixel(rgb, h, w));
			}
		}
		return Math.sqrt(variancia(raiz, media(raiz)));
	}

	public void salvarImagem(String path, Mat img) {
		Imgcodecs.imwrite(path, img);
	}

}
