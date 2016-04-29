package ba.unsa.etf.si.app.SkladisteTim3.Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class BrisanjeUposlenikaPopUp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrisanjeUposlenikaPopUp window = new BrisanjeUposlenikaPopUp();
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
	public BrisanjeUposlenikaPopUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(BrisanjeUposlenikaPopUp.class.getResource("/javax/swing/plaf/metal/icons/ocean/warning.png")));
		frame.setBounds(100, 100, 346, 209);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDaLiSte = new JLabel("Da li ste sigurni da \u017Eelite obrisati uposlenika?");
		lblDaLiSte.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDaLiSte.setBounds(43, 46, 245, 22);
		frame.getContentPane().add(lblDaLiSte);
		
		JButton btnDa = new JButton("Da");
		btnDa.setBounds(59, 102, 89, 23);
		frame.getContentPane().add(btnDa);
		
		JButton btnNe = new JButton("Ne");
		btnNe.setBounds(169, 102, 89, 23);
		frame.getContentPane().add(btnNe);
	}

}
