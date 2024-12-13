package br.com.trabalho.InterfaceGráfica.JFrame;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import br.com.trabalho.InterfaceGráfica.JPanel.PainelPrincipal;
import java.awt.Toolkit;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	public static PainelPrincipal painelPrincipal;

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setResizable(false);
		setTitle("Índice Remissivo");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\guiga\\eclipse-workspace\\IndiceRemissivo2\\src\\br\\com\\trabalho\\img\\images.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 663);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		painelPrincipal = new PainelPrincipal();
		painelPrincipal.setBounds(0, 0, 628, 631);
		contentPane.add(painelPrincipal);
	}
	
	public static void addPainelPrincipal(JPanel panel) {
		painelPrincipal.addPainel(panel);
	}
	
	public static void addIndices(JPanel panel) {
		painelPrincipal.addIndices(panel);
	}
	
	public static void addPainelPrincipal() {
		painelPrincipal.addPainelEscrita();
	}
	
	public static void addPainelArrastar() {
		painelPrincipal.addPainelArrastar(null);
	}
	
	@SuppressWarnings("static-access")
	public static void addResetEscrita() {
		PainelPrincipal.telaEscrita.resetText();
	}
	
	public static void setVizible(boolean isAtivo) {
		painelPrincipal.telaEscritaVizible(isAtivo);
	}
	
	public static void setViziblemMenu(boolean isAtivo) {
		painelPrincipal.telaMenuVizible(isAtivo);
	}
	
	public static void setVizibleArrastar(boolean isAtivo) {
		painelPrincipal.telaArrastarVizible(isAtivo);
	}
	
	public static void setVizibleIndices(boolean isAtivo) {
		painelPrincipal.telaIndicesVizible(isAtivo);
	}
	
	public static boolean isVizibleEscrita() {
		return PainelPrincipal.telaEscritaIsVizible();
	}

	public static void addResetArquivos() {
		painelPrincipal.resetArquivos();
		
	}
}
