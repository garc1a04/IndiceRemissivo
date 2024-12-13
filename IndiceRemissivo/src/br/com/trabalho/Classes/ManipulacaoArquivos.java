package br.com.trabalho.Classes;

import java.io.*;
import java.nio.file.*;
import java.util.regex.*;
import java.util.List;
import br.com.trabalho.EstruturaDados.TabelaHash;

public class ManipulacaoArquivos {

	private TabelaHash indiceRemissivo;
	private BufferedReader bufferedReader;
	private File dir;
	private File arq;
	private List<String> linhas;
	
    public ManipulacaoArquivos(String texto, String palavrasChave) throws IOException {
    	this.indiceRemissivo = new TabelaHash();
    	
    	leitura(texto, palavrasChave);
    	escrita();
    }


	private void leitura(String texto, String palavrasChave) throws IOException {
    	addPalavrasChaves(palavrasChave);
    	addPalavrasTexto(texto);
	}

	
	private void addPalavrasChaves(String palavrasChave) throws IOException {
		bufferedReader = new BufferedReader(new FileReader(palavrasChave));
		
		String palavras = "";
		while ((palavras = bufferedReader.readLine()) != null) {
			if(!palavras.equals("") || !palavras.isEmpty()) {
				indiceRemissivo.add(palavras);				
			}
        }
	}
    
	private void addPalavrasTexto(String texto) throws IOException {
		linhas = Files.readAllLines(Paths.get(texto));
		String regex = "\\b(?!\\d)[\\p{L}0-9]+(?:[-'\\p{L}0-9]+)*(?<![ªº])";
		
		for (int i = 0; i < linhas.size(); i++) {
    		Pattern pattern = Pattern.compile(regex);
    		Matcher matcher = pattern.matcher(linhas.get(i));
    		
    		while(matcher.find()) {
    			indiceRemissivo.add(matcher.group(),i+1);
    		}
    	}
	}
	
	public void escrita() throws IOException {
		dir = new File("src/br/com/trabalho/Arquivos/");
		arq = new File(dir, "Indice-remissivo.txt");
		
		if(!arq.exists()) {
			arq.createNewFile();			
		}
		
		PrintWriter printWriter = new PrintWriter(new FileWriter(arq, false));
		printWriter.println(indiceRemissivo);
		printWriter.flush();
		printWriter.close();
	}
	
	public void escritaArquivo(String nome,String arquivo) throws IOException {
		dir = new File("src/br/com/trabalho/Arquivos/");
		arq = new File(dir, nome);
		
		PrintWriter printWriter = new PrintWriter(new FileWriter(arq, false));
		printWriter.println(Files.readString(Paths.get(arquivo)));
		printWriter.flush();
		printWriter.close();
	}
	
	public String getIndice() {
		return indiceRemissivo.toString();
	}
}
