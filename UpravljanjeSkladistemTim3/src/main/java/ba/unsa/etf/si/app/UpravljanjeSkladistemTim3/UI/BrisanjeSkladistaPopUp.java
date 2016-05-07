package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import javax.swing.JButton;

public class BrisanjeSkladistaPopUp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrisanjeSkladistaPopUp window = new BrisanjeSkladistaPopUp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BrisanjeSkladistaPopUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(BrisanjeSkladistaPopUp.class.getResource("/javax/swing/plaf/metal/icons/ocean/warning.png")));
		frame.setBounds(100, 100, 338, 215);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDaLiSte = new JLabel("Da li ste sigurni da \u017Eelite obrisati skladi\u0161te?");
		lblDaLiSte.setBounds(58, 56, 223, 14);
		frame.getContentPane().add(lblDaLiSte);
		
		JButton btnDa = new JButton("Da");
		btnDa.setBounds(52, 95, 89, 23);
		frame.getContentPane().add(btnDa);
		
		JButton btnNe = new JButton("Ne");
		btnNe.setBounds(170, 95, 89, 23);
		frame.getContentPane().add(btnNe);
	}

}
