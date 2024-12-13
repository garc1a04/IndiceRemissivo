package br.com.trabalho.InterfaceGráfica.JPanel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import br.com.trabalho.InterfaceGráfica.JFrame.TelaPrincipal;

import javax.swing.JButton;
import javax.swing.DropMode;
import java.awt.Color;
import javax.swing.JTextArea;

public class TelaIndices extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTextArea txtrTextplain = new JTextArea();
	private JButton btnNewButton;
	
	/**
	 * Create the panel.
	 */
	public TelaIndices() {
		setLayout(null);
		
		JLabel lblIndiceRemisiico = new JLabel("ÍNDICE REMISSIVO");
		lblIndiceRemisiico.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblIndiceRemisiico.setBounds(209, 11, 180, 29);
		add(lblIndiceRemisiico);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBounds(31, 142, 538, 426);
		add(scrollPane);
		txtrTextplain.setToolTipText("text/plain");
		scrollPane.setViewportView(txtrTextplain);
		txtrTextplain.setEditable(false);
		
		
		txtrTextplain.setFont(new Font("Monospaced", Font.PLAIN, 20));
		
		JLabel lblndicesDoTexto = new JLabel("ÍNDICES DO TEXTO");
		lblndicesDoTexto.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblndicesDoTexto.setBounds(209, 102, 180, 29);
		add(lblndicesDoTexto);
		
		btnNewButton = new JButton("Escrever denovo");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(242, 579, 134, 23);
		btnNewButton.addActionListener(this);
		add(btnNewButton);
	}
	
	
	public void setTexto(String indices) {
		txtrTextplain.setText(indices);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnNewButton) {
			setVisibleIndices(false);
			TelaPrincipal.setViziblemMenu(true);
			TelaPrincipal.setVizible(false);
			TelaPrincipal.setVizibleArrastar(false);
			TelaPrincipal.setVizibleIndices(false);
			TelaPrincipal.addResetEscrita();
			TelaPrincipal.addResetArquivos();
		}
	}


	public void setVisibleIndices(boolean b) {
		PainelPrincipal.telaIndicesVizible(b);
	}
}
