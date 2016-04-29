package ba.unsa.etf.si.app.SkladisteTim3.Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DodavanjeArtiklaOtprem {

	private JFrame frmOdabirArtikla;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodavanjeArtiklaOtprem window = new DodavanjeArtiklaOtprem();
					window.frmOdabirArtikla.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DodavanjeArtiklaOtprem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOdabirArtikla = new JFrame();
		frmOdabirArtikla.setIconImage(Toolkit.getDefaultToolkit().getImage(DodavanjeArtiklaOtprem.class.getResource("/javax/swing/plaf/metal/icons/ocean/iconify.gif")));
		frmOdabirArtikla.setTitle("Odabir artikla");
		frmOdabirArtikla.setBounds(100, 100, 355, 189);
		frmOdabirArtikla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOdabirArtikla.getContentPane().setLayout(null);
		
		JLabel lblBarkod = new JLabel("Bar-kod:");
		lblBarkod.setBounds(40, 38, 41, 14);
		frmOdabirArtikla.getContentPane().add(lblBarkod);
		
		JLabel lblKoliina = new JLabel("Koli\u010Dina:");
		lblKoliina.setBounds(40, 66, 41, 14);
		frmOdabirArtikla.getContentPane().add(lblKoliina);
		
		textField = new JTextField();
		textField.setBounds(89, 35, 197, 20);
		frmOdabirArtikla.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(89, 63, 197, 20);
		frmOdabirArtikla.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setBounds(197, 94, 89, 23);
		frmOdabirArtikla.getContentPane().add(btnDodaj);
	}

}
