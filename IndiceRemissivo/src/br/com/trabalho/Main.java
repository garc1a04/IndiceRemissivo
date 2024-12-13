package br.com.trabalho;

import java.awt.EventQueue;

import br.com.trabalho.Classes.IndiceRemissivo;
import br.com.trabalho.InterfaceGráfica.JFrame.TelaPrincipal;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}