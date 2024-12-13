package br.com.trabalho.InterfaceGráfica.JPanel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;

import br.com.trabalho.InterfaceGráfica.JFrame.TelaPrincipal;

import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.Canvas;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Menu extends JPanel {

	private static final long serialVersionUID = 1L;

	public Menu() {
		setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setLayout(null);
		
		JLabel lblIndiceRemisiico = new JLabel("ÍNDICE REMISSIVO");
		lblIndiceRemisiico.setBounds(202, 11, 173, 24);
		lblIndiceRemisiico.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(lblIndiceRemisiico);
		
		JLabel lblEscolhaAMelhor = new JLabel("ESCOLHA A OPÇÃO PARA TER SEUS ÍNDICES\r\n");
		lblEscolhaAMelhor.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEscolhaAMelhor.setBounds(101, 158, 411, 24);
		add(lblEscolhaAMelhor);
		
		JButton btnNewButton = new JButton("Escrever arquivos\r\n");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal.addPainelPrincipal();
				TelaPrincipal.setViziblemMenu(false);
				TelaPrincipal.setVizibleIndices(false);
				TelaPrincipal.setVizible(true);
				TelaPrincipal.setVizibleArrastar(false);
				TelaPrincipal.painelPrincipal.updateUI();
			}
		});
		
		btnNewButton.setBounds(213, 241, 152, 54);
		add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("Carregar arquivos");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal.setViziblemMenu(false);
				TelaPrincipal.setVizibleIndices(false);
				TelaPrincipal.addPainelArrastar();
				TelaPrincipal.setVizibleArrastar(true);
				TelaPrincipal.painelPrincipal.updateUI();
			}
		});
		
		btnNewButton_1.setBounds(213, 431, 152, 54);
		add(btnNewButton_1);
		
		JLabel lblTrabalhoEstruturaDe = new JLabel("Trabalho Estrutura de Dados 24.2\r\n\r\n");
		lblTrabalhoEstruturaDe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTrabalhoEstruturaDe.setBounds(168, 559, 280, 24);
		add(lblTrabalhoEstruturaDe);
	}
}
