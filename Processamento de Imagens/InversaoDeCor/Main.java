package InversaoDeCor;

public class Main {

	public static void main(String[] args) {
		
		String input = "paisagem.png";
		String output = "paisageminvertida.png";
		
		Inverter inv = new Inverter(input, output);
		inv.gerarInvertida();

	}

}
