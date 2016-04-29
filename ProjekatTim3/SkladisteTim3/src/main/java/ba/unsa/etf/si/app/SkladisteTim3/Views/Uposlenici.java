package ba.unsa.etf.si.app.SkladisteTim3.Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class Uposlenici {

	private JFrame frmUposlenici;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Uposlenici window = new Uposlenici();
					window.frmUposlenici.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Uposlenici() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUposlenici = new JFrame();
		frmUposlenici.setTitle("Uposlenici");
		frmUposlenici.setIconImage(Toolkit.getDefaultToolkit().getImage(Uposlenici.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		frmUposlenici.setBounds(100, 100, 599, 444);
		frmUposlenici.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUposlenici.getContentPane().setLayout(null);
		
		JButton btnDodajNovogUposlenika = new JButton("Dodaj novog uposlenika");
		btnDodajNovogUposlenika.setBounds(10, 30, 162, 23);
		frmUposlenici.getContentPane().add(btnDodajNovogUposlenika);
		
		JButton btnObrisiUposlenika = new JButton("Obrisi uposlenika");
		btnObrisiUposlenika.setBounds(182, 30, 162, 23);
		frmUposlenici.getContentPane().add(btnObrisiUposlenika);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 83, 563, 311);
		frmUposlenici.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Ime", "Prezime", "JMBG", "Datum ro\u0111enja", "Mjesto ro\u0111enja", "Adresa stanovanja", "Broj telefona", "E-mail", "Strucna sprema"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, Object.class, String.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JLabel lblListaUposlenika = new JLabel("Lista uposlenika");
		lblListaUposlenika.setBounds(10, 64, 84, 14);
		frmUposlenici.getContentPane().add(lblListaUposlenika);
	}
}
