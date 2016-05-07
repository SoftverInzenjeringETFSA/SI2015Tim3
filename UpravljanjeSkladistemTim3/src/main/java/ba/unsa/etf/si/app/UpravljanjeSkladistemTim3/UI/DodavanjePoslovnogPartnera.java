package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DodavanjePoslovnogPartnera {

	private JFrame frmDodavanjePoslovnogPartnera;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodavanjePoslovnogPartnera window = new DodavanjePoslovnogPartnera();
					window.frmDodavanjePoslovnogPartnera.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DodavanjePoslovnogPartnera() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDodavanjePoslovnogPartnera = new JFrame();
		frmDodavanjePoslovnogPartnera.setTitle("Unos poslovnog partnera");
		frmDodavanjePoslovnogPartnera.setIconImage(Toolkit.getDefaultToolkit().getImage(DodavanjePoslovnogPartnera.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
		frmDodavanjePoslovnogPartnera.setBounds(100, 100, 347, 254);
		frmDodavanjePoslovnogPartnera.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDodavanjePoslovnogPartnera.getContentPane().setLayout(null);
		
		JLabel lblNaziv = new JLabel("Naziv:");
		lblNaziv.setBounds(54, 49, 30, 14);
		frmDodavanjePoslovnogPartnera.getContentPane().add(lblNaziv);
		
		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setBounds(46, 80, 38, 14);
		frmDodavanjePoslovnogPartnera.getContentPane().add(lblAdresa);
		
		JLabel lblJib = new JLabel("JIB:");
		lblJib.setBounds(65, 111, 19, 14);
		frmDodavanjePoslovnogPartnera.getContentPane().add(lblJib);
		
		textField = new JTextField();
		textField.setBounds(94, 46, 188, 20);
		frmDodavanjePoslovnogPartnera.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(94, 77, 188, 20);
		frmDodavanjePoslovnogPartnera.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(97, 108, 185, 20);
		frmDodavanjePoslovnogPartnera.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnDodaj = new JButton("Unesi");
		btnDodaj.setBounds(193, 154, 89, 23);
		frmDodavanjePoslovnogPartnera.getContentPane().add(btnDodaj);
	}
}
