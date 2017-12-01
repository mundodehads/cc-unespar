package AnalisadorLexico;

public class SimbolosCompostos {
	
	private static final String[] lista = {":=",">=", "<>", "/=", "+=", "-="};
	
	public boolean pertence(String a){
		for(String b: lista){
			if(b.equals(a)) return true;
		}
		return false;
	}
	
}
