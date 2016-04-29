package ba.unsa.etf.si.app.SkladisteTim3.Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UnosRobe {

	private JFrame frmUnosRobe;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnosRobe window = new UnosRobe();
					window.frmUnosRobe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UnosRobe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUnosRobe = new JFrame();
		frmUnosRobe.setTitle("Unos robe");
		frmUnosRobe.setIconImage(Toolkit.getDefaultToolkit().getImage(UnosRobe.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		frmUnosRobe.setBounds(100, 100, 571, 447);
		frmUnosRobe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUnosRobe.getContentPane().setLayout(null);
		
		JLabel lblSkladite = new JLabel("Skladi\u0161te:");
		lblSkladite.setBounds(42, 35, 46, 14);
		frmUnosRobe.getContentPane().add(lblSkladite);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(115, 32, 240, 20);
		frmUnosRobe.getContentPane().add(comboBox);
		
		JLabel lblDobavlja = new JLabel("Dobavlja\u010D:");
		lblDobavlja.setBounds(35, 66, 53, 14);
		frmUnosRobe.getContentPane().add(lblDobavlja);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(115, 63, 240, 20);
		frmUnosRobe.getContentPane().add(comboBox_1);
		
		JButton btnDodajNovogDobavljaa = new JButton("Dodaj novog dobavlja\u010Da");
		btnDodajNovogDobavljaa.setBounds(365, 62, 149, 23);
		frmUnosRobe.getContentPane().add(btnDodajNovogDobavljaa);
		
		JButton btnDodajArtikal = new JButton("Dodaj artikal");
		btnDodajArtikal.setBounds(115, 94, 114, 23);
		frmUnosRobe.getContentPane().add(btnDodajArtikal);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 150, 535, 213);
		frmUnosRobe.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Naziv", "Bar kod", "Jedini\u010Dna koli\u010Dina", "Koli\u010Dina", "Cijena", "Nabavna cijena", "Prodajna cijena"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Float.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnZavriUnos = new JButton("Zavr\u0161i unos");
		btnZavriUnos.setBounds(410, 374, 135, 23);
		frmUnosRobe.getContentPane().add(btnZavriUnos);
		
		JLabel lblListaArtikala = new JLabel("Lista artikala");
		lblListaArtikala.setBounds(10, 128, 113, 14);
		frmUnosRobe.getContentPane().add(lblListaArtikala);
	}
}
