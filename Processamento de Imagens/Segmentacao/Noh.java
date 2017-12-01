package Segmentacao;

import java.util.ArrayList;
import java.util.List;

public class Noh {
	
	private List<Pixel> grupo;
	private List<Noh> filho;
	
	public Noh (){
		this.grupo = new ArrayList<Pixel>();
		this.filho = new ArrayList<Noh>();
	}

	public List<Pixel> getGrupo() {
		return grupo;
	}

	public List<Noh> getFilho() {
		return filho;
	}

}
