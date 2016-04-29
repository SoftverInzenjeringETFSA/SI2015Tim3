package ba.unsa.etf.si.app.SkladisteTim3.Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class DodavanjeSkladista {

	private JFrame frmDodavanjeNovogSkladita;
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
					DodavanjeSkladista window = new DodavanjeSkladista();
					window.frmDodavanjeNovogSkladita.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DodavanjeSkladista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDodavanjeNovogSkladita = new JFrame();
		frmDodavanjeNovogSkladita.setTitle("Dodavanje novog skladi\u0161ta");
		frmDodavanjeNovogSkladita.setIconImage(Toolkit.getDefaultToolkit().getImage(DodavanjeSkladista.class.getResource("/javax/swing/plaf/metal/icons/ocean/upFolder.gif")));
		frmDodavanjeNovogSkladita.setBounds(100, 100, 450, 284);
		frmDodavanjeNovogSkladita.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDodavanjeNovogSkladita.getContentPane().setLayout(null);
		
		JLabel lblNaziv = new JLabel("Naziv:");
		lblNaziv.setBounds(81, 44, 41, 14);
		frmDodavanjeNovogSkladita.getContentPane().add(lblNaziv);
		
		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setBounds(76, 69, 46, 14);
		frmDodavanjeNovogSkladita.getContentPane().add(lblAdresa);
		
		JLabel lblRadnoVrijeme = new JLabel("Radno vrijeme");
		lblRadnoVrijeme.setBounds(45, 94, 77, 14);
		frmDodavanjeNovogSkladita.getContentPane().add(lblRadnoVrijeme);
		
		JLabel lblOd = new JLabel("od:");
		lblOd.setBounds(132, 94, 46, 14);
		frmDodavanjeNovogSkladita.getContentPane().add(lblOd);
		
		JLabel lblDo = new JLabel("do:");
		lblDo.setBounds(132, 122, 46, 14);
		frmDodavanjeNovogSkladita.getContentPane().add(lblDo);
		
		JLabel lblKontaktTelefon = new JLabel("Kontakt telefon:");
		lblKontaktTelefon.setBounds(36, 150, 86, 14);
		frmDodavanjeNovogSkladita.getContentPane().add(lblKontaktTelefon);
		
		textField = new JTextField();
		textField.setBounds(132, 41, 238, 20);
		frmDodavanjeNovogSkladita.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(132, 66, 238, 20);
		frmDodavanjeNovogSkladita.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(165, 91, 205, 20);
		frmDodavanjeNovogSkladita.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(165, 119, 205, 20);
		frmDodavanjeNovogSkladita.getContentPane().add(comboBox_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(128, 147, 242, 20);
		frmDodavanjeNovogSkladita.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setBounds(281, 195, 89, 23);
		frmDodavanjeNovogSkladita.getContentPane().add(btnDodaj);
	}
}
