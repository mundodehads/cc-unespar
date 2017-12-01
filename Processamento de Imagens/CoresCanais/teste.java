package CoresCanais;

import org.opencv.core.Mat;

import Histogramas.manipulacao;

public class teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		manipulacao m = new manipulacao();
		Mat teste = m.abrirImagem("canaiscores/original.png");
		corescanais cc = new corescanais(teste);
		cc.red("canaiscores/red.png", "canaiscores/redgray.png");
		cc.blue("canaiscores/blue.png", "canaiscores/bluegray.png");
		cc.green("canaiscores/green.png", "canaiscores/greengray.png");
	}

}
