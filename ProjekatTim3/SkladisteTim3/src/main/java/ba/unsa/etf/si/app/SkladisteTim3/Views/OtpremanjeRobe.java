package ba.unsa.etf.si.app.SkladisteTim3.Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;

public class OtpremanjeRobe {

	private JFrame frmOtpremanjeRobe;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OtpremanjeRobe window = new OtpremanjeRobe();
					window.frmOtpremanjeRobe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OtpremanjeRobe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOtpremanjeRobe = new JFrame();
		frmOtpremanjeRobe.setIconImage(Toolkit.getDefaultToolkit().getImage(OtpremanjeRobe.class.getResource("/javax/swing/plaf/metal/icons/ocean/maximize.gif")));
		frmOtpremanjeRobe.setTitle("Otpremanje robe");
		frmOtpremanjeRobe.setBounds(100, 100, 673, 452);
		frmOtpremanjeRobe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOtpremanjeRobe.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 144, 637, 224);
		frmOtpremanjeRobe.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Naziv", "Bar kod", "Jedini\u010Dna koli\u010Dina", "Koli\u010Dina", "Cijena", "Prodajna cijena"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblListaArtikala = new JLabel("Lista artikala");
		lblListaArtikala.setBounds(10, 119, 113, 14);
		frmOtpremanjeRobe.getContentPane().add(lblListaArtikala);
		
		JLabel lblSkladite = new JLabel("Skladi\u0161te:");
		lblSkladite.setBounds(48, 26, 46, 14);
		frmOtpremanjeRobe.getContentPane().add(lblSkladite);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(113, 23, 193, 20);
		frmOtpremanjeRobe.getContentPane().add(comboBox);
		
		JLabel lblKupac = new JLabel("Kupac:");
		lblKupac.setBounds(58, 57, 33, 14);
		frmOtpremanjeRobe.getContentPane().add(lblKupac);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(113, 54, 193, 20);
		frmOtpremanjeRobe.getContentPane().add(comboBox_1);
		
		JButton btnDodajNovogKupca = new JButton("Dodaj novog kupca");
		btnDodajNovogKupca.setBounds(322, 53, 142, 23);
		frmOtpremanjeRobe.getContentPane().add(btnDodajNovogKupca);
		
		JButton btnZavriOtpremanje = new JButton("Zavr\u0161i otpremanje");
		btnZavriOtpremanje.setBounds(505, 379, 142, 23);
		frmOtpremanjeRobe.getContentPane().add(btnZavriOtpremanje);
		
		JButton button = new JButton("Dodaj artikal");
		button.setBounds(113, 85, 114, 23);
		frmOtpremanjeRobe.getContentPane().add(button);
	}
}
