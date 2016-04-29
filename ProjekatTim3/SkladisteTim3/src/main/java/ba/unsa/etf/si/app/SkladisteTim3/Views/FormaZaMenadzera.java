package ba.unsa.etf.si.app.SkladisteTim3.Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class FormaZaMenadzera {

	private JFrame frmSistemUpravljanjaSkladitem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormaZaMenadzera window = new FormaZaMenadzera();
					window.frmSistemUpravljanjaSkladitem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormaZaMenadzera() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSistemUpravljanjaSkladitem = new JFrame();
		frmSistemUpravljanjaSkladitem.setIconImage(Toolkit.getDefaultToolkit().getImage(FormaZaMenadzera.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		frmSistemUpravljanjaSkladitem.setFont(new Font("Century", Font.PLAIN, 12));
		frmSistemUpravljanjaSkladitem.setTitle("Sistem upravljanja skladi\u0161tem");
		frmSistemUpravljanjaSkladitem.setBounds(100, 100, 581, 478);
		frmSistemUpravljanjaSkladitem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSistemUpravljanjaSkladitem.getContentPane().setLayout(null);
		
		JLabel lblDobrodoli = new JLabel("Dobrodo\u0161li:");
		lblDobrodoli.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblDobrodoli.setBounds(40, 38, 73, 24);
		frmSistemUpravljanjaSkladitem.getContentPane().add(lblDobrodoli);
		
		JLabel label = new JLabel(" ");
		label.setBounds(120, 41, 142, 20);
		frmSistemUpravljanjaSkladitem.getContentPane().add(label);
		
		JButton btnGenerisanjeIzvjetaja = new JButton("Generisanje izvje\u0161taja");
		btnGenerisanjeIzvjetaja.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnGenerisanjeIzvjetaja.setIcon(new ImageIcon(FormaZaMenadzera.class.getResource("/com/sun/java/swing/plaf/windows/icons/File.gif")));
		btnGenerisanjeIzvjetaja.setBounds(73, 179, 406, 67);
		frmSistemUpravljanjaSkladitem.getContentPane().add(btnGenerisanjeIzvjetaja);
		
		JButton btnPregledTrenutnogStanja = new JButton("Pregled trenutnog stanja robe");
		btnPregledTrenutnogStanja.setIcon(new ImageIcon(FormaZaMenadzera.class.getResource("/com/sun/java/swing/plaf/windows/icons/DetailsView.gif")));
		btnPregledTrenutnogStanja.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnPregledTrenutnogStanja.setToolTipText("");
		btnPregledTrenutnogStanja.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnPregledTrenutnogStanja.setBounds(73, 100, 406, 67);
		frmSistemUpravljanjaSkladitem.getContentPane().add(btnPregledTrenutnogStanja);
		
		JLabel lblOdjava = new JLabel("Odjava");
		lblOdjava.setFont(new Font("Sitka Text", Font.BOLD, 11));
		lblOdjava.setBounds(484, 38, 53, 24);
		frmSistemUpravljanjaSkladitem.getContentPane().add(lblOdjava);
		
		JButton btnNewButton = new JButton("Uposlenici");
		btnNewButton.setIcon(new ImageIcon(FormaZaMenadzera.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnNewButton.setBounds(73, 257, 406, 67);
		frmSistemUpravljanjaSkladitem.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Skladi\u0161ta");
		btnNewButton_1.setIcon(new ImageIcon(FormaZaMenadzera.class.getResource("/javax/swing/plaf/metal/icons/ocean/collapsed-rtl.gif")));
		btnNewButton_1.setBounds(73, 335, 406, 67);
		frmSistemUpravljanjaSkladitem.getContentPane().add(btnNewButton_1);
	}
}
