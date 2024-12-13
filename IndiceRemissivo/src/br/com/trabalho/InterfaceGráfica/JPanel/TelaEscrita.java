package br.com.trabalho.InterfaceGráfica.JPanel;

import javax.swing.JPanel;
import javax.swing.JTextPane;

import br.com.trabalho.Classes.IndiceRemissivo;
import br.com.trabalho.InterfaceGráfica.JFrame.TelaPrincipal;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JToolBar;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.DropMode;

public class TelaEscrita extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JButton btnNewButton;
	private static JTextPane textPane;
	private static JTextPane textPane_1;
	private File dir;
	private File arq;
	private JLabel lblNewLabel_1;
	private IndiceRemissivo indice;
	
	public TelaEscrita() {
		indice = new IndiceRemissivo();
		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DIGITE O TEXTO ");
		lblNewLabel.setBounds(66, 89, 157, 29);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(lblNewLabel);
		
		JLabel lblDigiteAsPalavras = new JLabel("DIGITE AS PALAVRAS CHAVES");
		lblDigiteAsPalavras.setBounds(313, 89, 282, 29);
		lblDigiteAsPalavras.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(lblDigiteAsPalavras);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBounds(10, 122, 277, 432);
		add(scrollPane);
		
		textPane = new JTextPane();
		textPane.setDropMode(DropMode.INSERT);
		textPane.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
		scrollPane.setViewportView(textPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane_1.setBounds(313, 122, 277, 432);
		add(scrollPane_1);
		
		textPane_1 = new JTextPane();
		textPane_1.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
		scrollPane_1.setViewportView(textPane_1);
		
		JLabel lblIndiceRemisiico = new JLabel("ÍNDICE REMISSIVO");
		lblIndiceRemisiico.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblIndiceRemisiico.setBounds(216, 11, 180, 29);
		add(lblIndiceRemisiico);
		
		btnNewButton = new JButton("GERAR ÍNDICE");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(246, 584, 114, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Menu");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal.setViziblemMenu(true);
				TelaPrincipal.setVizible(false);
				TelaPrincipal.setVizibleArrastar(false);
			}
		});
		
		btnNewButton_1.setBounds(0, 0, 89, 23);
		add(btnNewButton_1);
		
		lblNewLabel_1 = new JLabel("Por favor, digite algo no texto e nas palavras chaves");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnNewButton) {
			try {
				
				if(!textPane.getText().equals("") && !textPane_1.getText().equals("")) {
					escrita(textPane.getText().trim(),"texto.txt");
					escrita(textPane_1.getText().trim(),"palavras-chave.txt");
					lblNewLabel_1.setVisible(false);
					indice = new IndiceRemissivo();
					
					PainelPrincipal.telaIndices.setTexto(indice.getIndice());
					addPainel(PainelPrincipal.telaIndices);
					
				} else {
					lblNewLabel_1.setVisible(true);
					lblNewLabel_1.setForeground(new Color(255, 0, 0));
					lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
					lblNewLabel_1.setBounds(170, 559, 304, 23);
					PainelPrincipal.telaEscrita.add(lblNewLabel_1);
					PainelPrincipal.telaEscrita.updateUI();
				}
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
		
		if(e.getSource() == textPane || e.getSource() == textPane_1) {
			lblNewLabel_1.setVisible(false);
			PainelPrincipal.telaEscrita.updateUI();
		}
		
	}

	private void addPainel(TelaIndices telaIndices) {
		updateUI();
		TelaPrincipal.addIndices(telaIndices);
		PainelPrincipal.telaIndicesVizible(true);
		updateUI();
	}

	public static void resetText() {
		textPane.setText("");
		textPane_1.setText("");
	}
	
	public void escrita(String texto,String nome) throws IOException {
		dir = new File("src/br/com/trabalho/Arquivos/");
		arq = new File(dir, nome);
		
		if(!arq.exists()) {
			arq.createNewFile();			
		}
		
		PrintWriter printWriter = new PrintWriter(new FileWriter(arq, false));
		printWriter.println(texto);
		printWriter.flush();
		printWriter.close();
	}
}
