package AnalisadorSemantico;

import java.util.ArrayList;
import java.util.List;

import AnalisadorSintatico.Noh;

public class analisadorSemantico {

	private List<Variaveis> nivel;
	private boolean achou = false;
	private boolean erro = false;
	private List<Noh> pilha;

	public analisadorSemantico (Noh r){
		this.nivel = new ArrayList<Variaveis>();
		this.pilha = new ArrayList<Noh>();
		profundidade(r);
	}
	
	int x = 0;

	public void profundidade (Noh atual){
		pilha.add(atual);
		if(atual.getFilhos() != null && !achou){
			if(!erro){
				erro = true;
				profundidade(atual.getFilhos().get(x));
			}else {
				profundidade(atual.getFilhos().get(0));
			}
			
		}else {
			achou = true;
		}
		if(atual.getLexema() != null){
			if(atual.getLexema().equals("var")){
				addLista();
				return;
			}
		}
		if(atual.getFilhos() != null){
			if(atual.getFilhos().size() > 1){
				//System.out.println(atual);
				achou = false;
				erro = false;
				if(x < atual.getFilhos().size()){
					x++;
				}else {
					x=0;
				}
				profundidade(atual);
			}
		}else {
			return;
		}
	}


	public void addLista (){
		nivel.add(new Variaveis());
		int i = nivel.size()-1;
		int j = 0;
		int n = pilha.size()-3;
		for(int x=0;x<pilha.get(n).getFilhos().size();x++){
			if(pilha.get(n).getFilhos().get(x).getTipo() != null){
				if(pilha.get(n).getFilhos().get(x).getTipo().equals("id")){
					nivel.get(i).getVariaveis().add(pilha.get(n).getFilhos().get(x).getFilhos().get(0).getLexema());
					j++;
				}
				if(pilha.get(n).getFilhos().get(x).getTipo().equals("pr")){
					for(int y=0;y<j;y++){
						nivel.get(i).getTipo().add(pilha.get(n).getFilhos().get(x).getFilhos().get(0).getLexema());
					}
				}
			}
		}
//		System.out.println("Mostrando tabela de variaveis encontradas no nivel: "+i);
//		for(int x=0;x<nivel.get(i).getVariaveis().size();x++){
//			System.out.println("Variavel "+nivel.get(i).getVariaveis().get(x)+" é do tipo "+nivel.get(i).getTipo().get(x));
//		}
//		System.out.println("fim");
	}

}
