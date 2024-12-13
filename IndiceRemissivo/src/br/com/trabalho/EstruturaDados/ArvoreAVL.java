package br.com.trabalho.EstruturaDados;

class ArvoreAVL {
	private Node raiz;
	private String saida;
	private boolean balanceou;
	private boolean zerou;
	private static int maiorString;
	
	public ArvoreAVL() {
		raiz = null;
		saida = "";
	}
	
	public void insercao(String valor) {
		if(raiz == null) {
			raiz = new Node(valor);
			maiorString = maiorString < valor.length() ? valor.length() : maiorString;
			return;
		}
		
		
		if(!pesquisa(valor)) {
			balanceou = false;
			zerou = false;
			maiorString = maiorString < valor.length() ? valor.length() : maiorString;
			insercao(valor,raiz,null);
		}
	}
	
	private void insercao(String valor, Node atual,Node pai) {
		
		if(atual.valor.compareTo(valor) > 0) {
			if(atual.filhoEsq == null) {
				atual.fatorBalanceamento+=1;
				atual.filhoEsq = new Node(valor);
				return;
			}
			
			insercao(valor,atual.filhoEsq,atual);
			FatorBalanceamento(atual.filhoEsq,atual);
		
		} else if(atual.valor.compareTo(valor) < 0) {
			if(atual.filhoDir == null) {
				atual.fatorBalanceamento-=1;
				atual.filhoDir = new Node(valor);
				return;
			}
			
			insercao(valor,atual.filhoDir,atual);
			FatorBalanceamento(atual.filhoDir,atual);
		}
		
		
		if(Math.abs(atual.fatorBalanceamento) > 1) {
			balancear(atual,pai);
		}
	}
	
	private void FatorBalanceamento(Node atual,Node pai) {
		if(atual.fatorBalanceamento == 0) {
			zerou = true;
			return;
		} else if(balanceou || zerou || atual == null) {
			return;
		}
		
		pai.fatorBalanceamento = pai.filhoDir == atual ? (pai.fatorBalanceamento-=1) : (pai.fatorBalanceamento+=1);	
	}
	
	private void balancear(Node atual,Node pai) {
		if(atual.fatorBalanceamento < 0) {
			
			if(atual.filhoDir.fatorBalanceamento <= 0) {
				Node aux = rotacaoEsquerda(atual);
				
				pai = pai == null ? raiz = aux : 
				(pai = pai.filhoDir == atual ? pai.filhoDir = aux : (pai.filhoEsq = aux));
				
				trocarFatorSimples(aux);
				return;
			}
			
			Node aux = rotacaoEsquerdaDupla(atual);
			pai = pai == null ? raiz = 	aux : 
			(pai = pai.filhoDir == atual ? pai.filhoDir = aux  : (pai.filhoEsq = aux ));
			
			trocarFatorDupla(aux);
		} else if(atual.fatorBalanceamento > 0) {
			
			if(atual.filhoEsq.fatorBalanceamento >= 0) {
				Node aux = rotacaoDireita(atual);
				
				pai = pai == null ? raiz = aux : 
				(pai = pai.filhoDir == atual ? pai.filhoDir = aux : (pai.filhoEsq = aux));
				
				
				trocarFatorSimples(aux);
				return;
			}
			
			
			Node aux = rotacaoDireitaDupla(atual);
			pai = pai == null ? raiz = aux : 
			(pai = pai.filhoDir == atual ? pai.filhoDir = aux : (pai.filhoEsq = aux));
			
			trocarFatorDupla(aux);
		}
		
		balanceou = true;
	}
	
	private Node rotacaoEsquerda(Node atual) {
		Node aux = atual.filhoDir;
		atual.filhoDir = aux.filhoEsq;
		aux.filhoEsq = atual;
		
		return aux;
	}
	
	private Node rotacaoEsquerdaDupla(Node atual) {
		atual.filhoDir = rotacaoDireita(atual.filhoDir);
		atual = rotacaoEsquerda(atual);
		return atual;
	}
	
	private Node rotacaoDireita(Node atual) {
		Node aux = atual.filhoEsq;
		atual.filhoEsq = aux.filhoDir;
		aux.filhoDir = atual;
		
		return aux;
	}
	
	private Node rotacaoDireitaDupla(Node atual) {		
		atual.filhoEsq = rotacaoEsquerda(atual.filhoEsq);
		atual = rotacaoDireita(atual);
		return atual;
	}
	
	private void trocarFatorSimples(Node atual) {
		
		switch(atual.fatorBalanceamento) {
			case 1:
				atual.filhoDir.fatorBalanceamento = 0;
				break;
			case -1:
				atual.filhoEsq.fatorBalanceamento = 0;
				break;
		}
		
		atual.fatorBalanceamento = 0;
	}
	
	private void trocarFatorDupla(Node atual) {
		switch(atual.fatorBalanceamento) {
		case 1:
			atual.filhoEsq.fatorBalanceamento = 0;
			atual.filhoDir.fatorBalanceamento = -1;
			break;
			
			
		case 0:
			atual.filhoEsq.fatorBalanceamento = 0;
			atual.filhoDir.fatorBalanceamento = 0;
			break;
			
		case -1:
			atual.filhoEsq.fatorBalanceamento = 1;
			atual.filhoDir.fatorBalanceamento = 0;
			break;
		}
		
		atual.fatorBalanceamento = 0;
	}
	
	public boolean pesquisa(String valor) {
		return pesquisa(valor, raiz);
	}
	
	private boolean pesquisa(String valor, Node atual) {
		if(atual == null) return false;
		
		if(atual.valor.compareTo(valor) == 0) return true;
		
		return pesquisa(valor,atual.valor.compareTo(valor) > 0 ? atual.filhoEsq: atual.filhoDir);
	}
	
	public boolean pesquisa(String valor,int linha) {
		return pesquisa(valor, raiz,linha);
	}
	
	private boolean pesquisa(String valor, Node atual,int linha) {
		if(atual == null) return false;
		
		if(atual.valor.compareTo(valor) == 0) {
			atual.addIndices(linha);
			return true;
		}
		
		return pesquisa(valor,atual.valor.compareTo(valor) > 0 ? atual.filhoEsq: atual.filhoDir,linha);
	}
	
	public String toString() {
		saida = "";
		emOrdem(raiz);
		
		return saida.trim();
	}
	
	private void emOrdem(Node raiz) {
		
		if(raiz.filhoEsq != null) {
			emOrdem(raiz.filhoEsq);
		}
		
		saida+= raiz.toString() != null ? raiz+"\n" : "";			
		
		if(raiz.filhoDir != null) {		
			emOrdem(raiz.filhoDir);
		}
	}
	
	public static int getMaiorString() {
		return maiorString;
	}
	
	public boolean temMaisValores() {
		return raiz.isDir() || raiz.isEsq();
	}
}

class Node{
	String valor;
	Node filhoDir;
	Node filhoEsq;
	ListaDinamica<Integer> indices;
	int fatorBalanceamento;
	
	
	public Node(String valor) {
		indices = new ListaDinamica<Integer>();
		this.valor = valor;
	}
	
	public Node(String valor, int linha) {
		indices = new ListaDinamica<Integer>();
		this.valor = valor;
		addIndices(linha);
	}
	
	public void addIndices(int linha) {
		if(!indices.contais(linha)) {
			indices.add(linha);			
		}
	}

	public boolean isEsq() {
		return filhoEsq != null;
	}
	
	public boolean isDir() {
		return filhoDir != null;
	}
	
	public String toString() {
		int maiorValor = ArvoreAVL.getMaiorString() == valor.length() ? 5 : ArvoreAVL.getMaiorString();
		
		String formato ="%"+(-maiorValor)+"s "+"%s";
		return indices.size() != 0 ? String.format(formato, valor,indices) : null;
	}
}
