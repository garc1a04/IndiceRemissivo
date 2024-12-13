package br.com.trabalho.InterfaceGráfica.JPanel;

import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import br.com.trabalho.Classes.IndiceRemissivo;
import br.com.trabalho.InterfaceGráfica.JFrame.JanelaArquivos;
import br.com.trabalho.InterfaceGráfica.JFrame.TelaPrincipal;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;

public class TelaArrastar extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JFileChooser fileChooser;
	private JFileChooser fileChooser2;
	private JButton btnNewButton;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private String caminho1;
	private String caminho2;
	private IndiceRemissivo indice;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	
	public TelaArrastar() {
		setBackground(SystemColor.menu);
		setLayout(null);
		lblNewLabel_2 = new JLabel();
		lblNewLabel_3 = new JLabel();
		
		JLabel lblIndiceRemisiico = new JLabel("ÍNDICE REMISSIVO");
		lblIndiceRemisiico.setBounds(207, 11, 173, 24);
		lblIndiceRemisiico.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(lblIndiceRemisiico);
		
		JLabel lblNewLabel = new JLabel("COLOQUE O TEXTO\r\n");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(37, 221, 179, 29);
		add(lblNewLabel);
		
		JLabel lblDigiteAsPalavras = new JLabel("COLOQUE\r\n AS PALAVRAS CHAVES");
		lblDigiteAsPalavras.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDigiteAsPalavras.setBounds(278, 221, 312, 29);
		add(lblDigiteAsPalavras);
		
		btnNewButton = new JButton("CARREGAR ARQUIVO\r\n");
		btnNewButton.setBackground(Color.WHITE);
		//Texto
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fileChooser.setFileFilter(new FileNameExtensionFilter("TEXT FILES", "txt", "text"));
				
				int i = fileChooser.showOpenDialog(null);
				 if(i == JFileChooser.APPROVE_OPTION) {
					 	
					 	String aux = fileChooser.getSelectedFile().getPath();
			            caminho2 = aux.substring(aux.length()-3,aux.length()).equals("txt") ? fileChooser.getSelectedFile().getPath() : "";
			            
			            lblNewLabel_1.setVisible(false);
				        PainelPrincipal.telaArrastar.updateUI();
				         
			            if(!caminho2.equals("")) {
			            	String[] arquivos = fileChooser.getSelectedFile().getPath().split("\\\\");
			            	
 			            	for (String arquivo: arquivos) {
 			            		if(arquivo.contains(".txt")) {
 			            			lblNewLabel_2.setText("Arquivo carregado: "+ arquivo);
 			            		}
			            	}
 			            	
 			            	lblNewLabel_2.setVisible(true);
 			            	lblNewLabel_2.setBounds(30, 325, 300, 14);
 			            	add(lblNewLabel_2);	
 			       		
 			    
			            	btnNewButton.setText("ARQUIVO CARREGADO...");
			            	
			            	
			            } else {
			            	lblNewLabel_1.setVisible(true);
							lblNewLabel_1.setBounds(181, 573, 298, 14);
							lblNewLabel_1.setForeground(new Color(255, 0, 0));
							lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
							PainelPrincipal.telaArrastar.add(lblNewLabel_1);
							PainelPrincipal.telaArrastar.updateUI();
			            }
				}
			}
		});
		
		btnNewButton.setBounds(37, 261, 195, 53);
		add(btnNewButton);
		
		//Palavras chaves
		btnNewButton_2 = new JButton("CARREGAR ARQUIVO\r\n");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				fileChooser2 = new JFileChooser();
				fileChooser2.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fileChooser2.setFileFilter(new FileNameExtensionFilter("TEXT FILES", "txt", "text"));
				
				int i = fileChooser2.showOpenDialog(null);
				 if(i == JFileChooser.APPROVE_OPTION) {

					 String aux = fileChooser2.getSelectedFile().getPath();
			         caminho1 = aux.substring(aux.length()-3,aux.length()).equals("txt") 
			        		 ? fileChooser2.getSelectedFile().getPath() : "";
			         
			         lblNewLabel_1.setVisible(false);
			         PainelPrincipal.telaArrastar.updateUI();
			         
			         if(!caminho1.equals("")) {
			        	 
			        	 String[] arquivos = fileChooser2.getSelectedFile().getPath().split("\\\\");
			        	 
		            	for (String arquivo: arquivos) {
		            		if(arquivo.contains(".txt")) {
		            			lblNewLabel_3.setText("Arquivo carregado: "+ arquivo);
		            		}
		            	}
		            	
		            	lblNewLabel_3.setVisible(true);	
		            	lblNewLabel_3.setBounds(300, 325, 300, 14);
		            	add(lblNewLabel_3);
		            	
	 			       	btnNewButton_2.setText("ARQUIVO CARREGADO...");
			        	 
			         }else {
			            	lblNewLabel_1.setVisible(true);
							lblNewLabel_1.setBounds(181, 573, 298, 14);
							lblNewLabel_1.setForeground(new Color(255, 0, 0));
							lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
							PainelPrincipal.telaArrastar.add(lblNewLabel_1);
							PainelPrincipal.telaArrastar.updateUI();
			            }
			         
				}
			}
		});
		
		btnNewButton_2.setBounds(347, 261, 195, 53);
		add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Menu");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(0, 0, 76, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal.setViziblemMenu(true);
				TelaPrincipal.setVizible(false);
				TelaPrincipal.setVizibleArrastar(false);
				lblNewLabel_2.setVisible(false);
				lblNewLabel_3.setVisible(false);
			}
		});
		
		add(btnNewButton_1);
		
		btnNewButton_3 = new JButton("GERAR ÍNDICE");
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.addActionListener(this);
		btnNewButton_3.setBounds(234, 590, 114, 23);
		add(btnNewButton_3);
		
		lblNewLabel_1 = new JLabel("Por favor, coloque somente arquivos .txt");
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnNewButton_3) {
			if(btnNewButton_2.getText().equals("ARQUIVO CARREGADO...") && btnNewButton.getText().equals("ARQUIVO CARREGADO...")) {
				
				if(!(caminho2.equals("")) && !(caminho1.equals(""))) {
					indice = new IndiceRemissivo(caminho2,caminho1);
					
					PainelPrincipal.telaIndices.setTexto(indice.getIndice());
					TelaPrincipal.addIndices(PainelPrincipal.telaIndices);
					
					TelaPrincipal.setViziblemMenu(false);
					TelaPrincipal.setVizible(false);
					TelaPrincipal.setVizibleArrastar(false);
					TelaPrincipal.setVizibleIndices(true);
					
					indiceSetTexto();
					resetTextBotoes();					
				} else {
					lblNewLabel_1.setVisible(true);
					lblNewLabel_1.setBounds(181, 573, 298, 14);
					lblNewLabel_1.setForeground(new Color(255, 0, 0));
					lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
					PainelPrincipal.telaArrastar.add(lblNewLabel_1);
					PainelPrincipal.telaArrastar.updateUI();
				}
				
				
				
			}
			
			lblNewLabel_2.setVisible(false);
			lblNewLabel_3.setVisible(false);
		}
		
	}
	
	public void indiceSetTexto() {
		try {
			indice.setTextoIndices();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void resetTextBotoes() {
		btnNewButton.setText("CARREGAR ARQUIVO\r\n");
		btnNewButton_2.setText("CARREGAR ARQUIVO\r\n");
	}
}
