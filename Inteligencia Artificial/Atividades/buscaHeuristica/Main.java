package buscaHeuristica;

public class Main {

	public static void main(String[] args) {
		
		//vetor teste
		int[] teste = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
				13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 25};
		System.out.println("Busca A:");
		buscaA b = new buscaA(teste);	
		b.aEstrela(14);

	}

}
