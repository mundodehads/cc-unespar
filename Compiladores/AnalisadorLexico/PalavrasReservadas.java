package AnalisadorLexico;

public class PalavrasReservadas {
	
	private static final String[] lista = {"and","array","end","for","Program","div","procedure",
			"begin","nil", "const", "do", "downto", "file", "in", "label", "mod", "if",
			"package", "record", "repeat", "set", "then", "to", "type", "until", "wit", "var", 
			"function", "read", "write", "integer", "boolean", "double"};
	
	public boolean pertence(String a){
		for(String b: lista){
			if(b.equals(a)) return true;
		}
		return false;
	}

}
