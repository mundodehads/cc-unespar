package OperacoesLogicas;

import org.opencv.core.Mat;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manipulacao m = new Manipulacao();
		Mat imagem1 = m.abrirImagem("binaria1.png");
		Mat imagem2 = m.abrirImagem("binaria2.png");
		Operacoes op = new Operacoes(imagem1, imagem2);
		op.logicaE("binariaE.png");
		op.logicaOU("binariaOU.png");
		op.complemento("binariaCOM.png");

	}

}
