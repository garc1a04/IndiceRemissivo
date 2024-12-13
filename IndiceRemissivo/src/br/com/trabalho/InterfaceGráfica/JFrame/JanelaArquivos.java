package br.com.trabalho.InterfaceGráfica.JFrame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import br.com.trabalho.InterfaceGráfica.JPanel.PainelPrincipal;

import javax.swing.JFileChooser;

public class JanelaArquivos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFileChooser fileChooser;
	private File arquivo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	}

	/**
	 * Create the frame.
	 */
	public JanelaArquivos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		fileChooser = new JFileChooser();
		
		fileChooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = fileChooser.showOpenDialog(null);
				 if(i == JFileChooser.APPROVE_OPTION) {
		            String caminho = fileChooser.getSelectedFile().getPath();
		            PainelPrincipal.telaArrastarVizible(false);
				 }
			}
		});
		
		fileChooser = new JFileChooser();
		int i = fileChooser.showOpenDialog(null);
		 if(i == JFileChooser.APPROVE_OPTION) {
	            String caminho = fileChooser.getSelectedFile().getPath();
	            System.out.println(caminho);
	            setVisible(false);
			 }
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setFileFilter(new FileNameExtensionFilter("txt", "txt"));
	}
	
	public void coisas() {
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setFileFilter(new FileNameExtensionFilter("txt", "txt"));
	}
	
}
