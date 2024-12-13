package br.com.trabalho.Classes;

import java.io.IOException;

public class IndiceRemissivo {
	
	private String texto;
	private String palavrasChaves;
	private ManipulacaoArquivos arq;
	
	public IndiceRemissivo() {
		palavrasChaves = "src/br/com/trabalho/Arquivos/palavras-chave.txt";
		texto = "src/br/com/trabalho/Arquivos/texto.txt";
		
		organizarArquivos();
	}
	
	public IndiceRemissivo(String pathTexto, String pathPalavrasChaves) {
		palavrasChaves = pathPalavrasChaves;
		texto = pathTexto;
		
		
		organizarArquivos();
		escreverNosArquivos(pathTexto,pathPalavrasChaves);
	}
	
	private void escreverNosArquivos(String pathTexto, String pathPalavrasChaves) {
		try {
			arq.escritaArquivo("texto.txt", pathTexto);
			arq.escritaArquivo("palavras-chave.txt", pathPalavrasChaves);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void organizarArquivos() {
		try {
			arq = new ManipulacaoArquivos(texto,palavrasChaves);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getIndice() {
		return arq.getIndice();
	}
	
	public void setTextoIndices() throws IOException {
		arq.escrita();
	}
	
}
;