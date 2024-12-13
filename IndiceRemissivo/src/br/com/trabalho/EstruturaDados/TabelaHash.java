package br.com.trabalho.EstruturaDados;

import java.text.Normalizer;

public class TabelaHash {
private ArvoreAVL vetor[];
	
	public TabelaHash() {
		vetor = new ArvoreAVL[26];
	}
	
	public void add(String valor) {
		
		int i = funcaoHash(valor);
		
		if(vetor[i] != null) {
			vetor[i].insercao(valor.toLowerCase());
			return;
		}
		
		vetor[i] = new ArvoreAVL();
		vetor[i].insercao(valor.toLowerCase());
	}
	
	private int funcaoHash(String valor) {
		if(valor.toLowerCase().charAt(0) >= 97 && valor.toLowerCase().charAt(0) <= 122) {
			return valor.toLowerCase().charAt(0)-97;
		}
		
        String texto = Normalizer.normalize(valor.toLowerCase().charAt(0)+"", Normalizer.Form.NFD);
        texto = texto.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
		return texto.toLowerCase().charAt(0)-97;
	}

	public void add(String valor,int linha) {
		int i = funcaoHash(valor);
		
		if(vetor[i] != null) {
			vetor[i].pesquisa(valor.toLowerCase(),linha);
			return;
		}
	}
	
	public String toString() {
		String saida = "";
		
		for(int i = 0; i < vetor.length;i++) {
			saida += vetor[i] != null && !vetor[i].toString().equals("") ?  vetor[i]+"\n": "";				
		}
		
		return saida.trim()+"";
	}
}