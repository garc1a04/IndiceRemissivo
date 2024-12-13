package br.com.trabalho.InterfaceGráfica.JPanel;

import javax.swing.JPanel;

import br.com.trabalho.InterfaceGráfica.JFrame.TelaPrincipal;

import java.awt.CardLayout;

public class PainelPrincipal extends JPanel {

	private static final long serialVersionUID = 1L;
	public static TelaEscrita telaEscrita;
	static TelaIndices telaIndices;
	static TelaArrastar telaArrastar;
	static Menu menu;
	/**
	 * Create the panel.
	 */
	public PainelPrincipal() {
		telaEscrita = new TelaEscrita();
		telaIndices = new TelaIndices();
		telaArrastar = new TelaArrastar();
		menu = new Menu();
		
		add(menu);
		telaEscrita.setLayout(null);
		setLayout(new CardLayout(0, 0));
	}
	
	
	public void addPainel(JPanel panel) {
		TelaPrincipal.setViziblemMenu(false);
		updateUI();
		add(telaIndices, "name_38412824041000");
		updateUI();
	}
	
	public void addIndices(JPanel panel) {
		TelaPrincipal.setViziblemMenu(false);
		TelaPrincipal.setVizible(false);
		TelaPrincipal.setVizibleArrastar(false);
		
		add(telaIndices, "name_38412824041000");
		updateUI();
	}
	
	public void addPainelArrastar(JPanel panel) {
		updateUI();
		add(telaArrastar, "name_38412824041000");
		updateUI();
	}
	
	public void addPainel() {
		updateUI();
		TelaPrincipal.setViziblemMenu(false);
		TelaPrincipal.setVizible(true);
		TelaPrincipal.setVizibleArrastar(false);
		updateUI();
	}
	
	public void telaEscritaVizible(boolean isAtivo) {
		telaEscrita.setVisible(isAtivo);
	}
	
	public static boolean telaEscritaIsVizible() {
		return telaEscrita.isVisible();
	}
	
	public static void telaIndicesVizible(boolean isAtivo) {
		telaIndices.setVisible(isAtivo);
	}
	
	public static void telaMenuVizible(boolean isAtivo) {
		menu.setVisible(isAtivo);
	}
	
	public static void telaArrastarVizible(boolean isAtivo) {
		telaArrastar.setVisible(isAtivo);
	}


	public void resetArquivos() {
		telaArrastar.resetTextBotoes();
	}


	public void addPainelEscrita() {
		updateUI();
		TelaPrincipal.setVizible(true);
		add(telaEscrita, "name_38412824041000");
		updateUI();
	}
	
	
}
