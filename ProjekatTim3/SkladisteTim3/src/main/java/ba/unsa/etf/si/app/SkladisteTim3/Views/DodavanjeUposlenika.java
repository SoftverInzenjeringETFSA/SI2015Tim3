package ba.unsa.etf.si.app.SkladisteTim3.Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class DodavanjeUposlenika {

	private JFrame frmDodavanjeNovogUposlenika;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodavanjeUposlenika window = new DodavanjeUposlenika();
					window.frmDodavanjeNovogUposlenika.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DodavanjeUposlenika() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDodavanjeNovogUposlenika = new JFrame();
		frmDodavanjeNovogUposlenika.setTitle("Dodavanje novog uposlenika");
		frmDodavanjeNovogUposlenika.setIconImage(Toolkit.getDefaultToolkit().getImage(DodavanjeUposlenika.class.getResource("/javax/swing/plaf/metal/icons/ocean/upFolder.gif")));
		frmDodavanjeNovogUposlenika.setBounds(100, 100, 450, 439);
		frmDodavanjeNovogUposlenika.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDodavanjeNovogUposlenika.getContentPane().setLayout(null);
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setBounds(114, 47, 34, 14);
		frmDodavanjeNovogUposlenika.getContentPane().add(lblIme);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setBounds(96, 72, 52, 14);
		frmDodavanjeNovogUposlenika.getContentPane().add(lblPrezime);
		
		JLabel lblJmbg = new JLabel("JMBG:");
		lblJmbg.setBounds(108, 97, 40, 14);
		frmDodavanjeNovogUposlenika.getContentPane().add(lblJmbg);
		
		JLabel lblDatumRoenja = new JLabel("Datum ro\u0111enja:");
		lblDatumRoenja.setBounds(63, 122, 85, 14);
		frmDodavanjeNovogUposlenika.getContentPane().add(lblDatumRoenja);
		
		JLabel lblMjestoRoenja = new JLabel("Mjesto ro\u0111enja:");
		lblMjestoRoenja.setBounds(63, 147, 85, 14);
		frmDodavanjeNovogUposlenika.getContentPane().add(lblMjestoRoenja);
		
		JLabel lblAdresaStanovanja = new JLabel("Adresa stanovanja:");
		lblAdresaStanovanja.setBounds(45, 172, 104, 14);
		frmDodavanjeNovogUposlenika.getContentPane().add(lblAdresaStanovanja);
		
		JLabel lblBrojTelefona = new JLabel("Broj telefona:");
		lblBrojTelefona.setBounds(73, 197, 75, 14);
		frmDodavanjeNovogUposlenika.getContentPane().add(lblBrojTelefona);
		
		JLabel lblEmailAdresa = new JLabel("E-mail adresa:");
		lblEmailAdresa.setBounds(73, 222, 75, 14);
		frmDodavanjeNovogUposlenika.getContentPane().add(lblEmailAdresa);
		
		JLabel lblStrunaSprema = new JLabel("Stru\u010Dna sprema:");
		lblStrunaSprema.setBounds(63, 247, 85, 14);
		frmDodavanjeNovogUposlenika.getContentPane().add(lblStrunaSprema);
		
		JLabel lblSkladiteUKojem = new JLabel("Skladi\u0161te u kojem je zaposlen:");
		lblSkladiteUKojem.setBounds(65, 295, 153, 14);
		frmDodavanjeNovogUposlenika.getContentPane().add(lblSkladiteUKojem);
		
		textField = new JTextField();
		textField.setBounds(158, 44, 198, 20);
		frmDodavanjeNovogUposlenika.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(158, 69, 198, 20);
		frmDodavanjeNovogUposlenika.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(158, 94, 198, 20);
		frmDodavanjeNovogUposlenika.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(158, 119, 198, 20);
		frmDodavanjeNovogUposlenika.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(158, 144, 198, 20);
		frmDodavanjeNovogUposlenika.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(158, 169, 198, 20);
		frmDodavanjeNovogUposlenika.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(158, 194, 198, 20);
		frmDodavanjeNovogUposlenika.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(158, 219, 198, 20);
		frmDodavanjeNovogUposlenika.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(158, 244, 198, 20);
		frmDodavanjeNovogUposlenika.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(222, 292, 134, 20);
		frmDodavanjeNovogUposlenika.getContentPane().add(comboBox);
		
		JButton btnUnesiUposlenika = new JButton("Unesi uposlenika");
		btnUnesiUposlenika.setBounds(141, 342, 134, 23);
		frmDodavanjeNovogUposlenika.getContentPane().add(btnUnesiUposlenika);
	}
}
