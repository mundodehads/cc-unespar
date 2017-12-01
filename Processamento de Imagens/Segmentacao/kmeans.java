package Segmentacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class kmeans {

	private Mat img;
	private String output;
	private List<Centroide> centroide;

	public kmeans(Mat imagem, String output, int quant) {
		this.img = imagem;
		this.output = output;
		this.centroide = new ArrayList<>();
		Random r = new Random();
		for (int x = 0; x < quant; x++) {
			int h = r.nextInt(img.height());
			int w = r.nextInt(img.width());
			centroide.add(new Centroide(img.get(h, w), h, w));
		}
	}

	public void executar() {

		for(int h=0;h<img.height();h++){
			for(int w=0;w<img.width();w++){
				centroide.get(menor(h, w)).getGrupo().add(new Pixel(img.get(h, w), h, w));
			}
		}
		
		int cont = 0;
		Mat img2 = new Mat(img.height(), img.width(), img.type());	

		while(trocar()){	
			//Para salvar as etapas
			/*for (int x = 0; x < centroide.size(); x++) {
				for (int y = 0; y < centroide.get(x).getGrupo().size(); y++) {
					img2.put(centroide.get(x).getGrupo().get(y).getH(),
							centroide.get(x).getGrupo().get(y).getW(),
							centroide.get(x).getCor());
				}
			}
			String path = "kmeans/teste"+cont+".png";
			salvarImagem(path, img2);*/
			cont++;
		};
		
		System.out.println("Testes realizados: "+cont);
		
		for (int x = 0; x < centroide.size(); x++) {
			for (int y = 0; y < centroide.get(x).getGrupo().size(); y++) {
				img2.put(centroide.get(x).getGrupo().get(y).getH(),
						centroide.get(x).getGrupo().get(y).getW(),
						centroide.get(x).getCor());
			}
		}
		salvarImagem(output, img2);
	}

	public boolean trocar(){
		media();
		int cont = 0;
		for (int x = 0; x < centroide.size(); x++) {
			for (int y = 0; y < centroide.get(x).getGrupo().size(); y++) {
				int z = menor(centroide.get(x).getGrupo().get(y).getH(),centroide.get(x).getGrupo().get(y).getW());
				if(z != x){
					centroide.get(z).getGrupo().add(centroide.get(x).getGrupo().get(y));
					centroide.get(x).getGrupo().remove(y);
					cont++;
				}
			}
		}
		if (cont > 0) return true;
		return false;
	}
	
	public void media(){
		for (int x = 0; x < centroide.size(); x++) {
			double[] rgb = {0,0,0};
			for (int y = 0; y < centroide.get(x).getGrupo().size(); y++) {
				rgb[0] += centroide.get(x).getGrupo().get(y).getCor()[0];
				rgb[1] += centroide.get(x).getGrupo().get(y).getCor()[1];
				rgb[2] += centroide.get(x).getGrupo().get(y).getCor()[2];
			}
			rgb[0] = Math.round(rgb[0]/centroide.get(x).getGrupo().size());
			rgb[1] = Math.round(rgb[1]/centroide.get(x).getGrupo().size());
			rgb[2] = Math.round(rgb[2]/centroide.get(x).getGrupo().size());
			centroide.get(x).setCor(rgb);
		}
	}

	public int menor(int h, int w) {
		int menor = 0;
		double menordistancia = 0;
		double[] rgba = img.get(h, w);
		for (int x = 0; x < centroide.size(); x++) {
			double[] rgbb = centroide.get(x).getCor();
			double formula = Math.sqrt(
					Math.pow(rgbb[0] - rgba[0], 2) + Math.pow(rgbb[1] - rgba[1], 2) + Math.pow(rgbb[2] - rgba[2], 2));
			if (x == 0) {
				menordistancia = formula;
			}
			if (formula < menordistancia) {
				menordistancia = formula;
				menor = x;
			}
		}
		return menor;
	}

	public void salvarImagem(String path, Mat img) {
		Imgcodecs.imwrite(path, img);
	}

}
