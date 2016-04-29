package ba.unsa.etf.si.app.SkladisteTim3.Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PregledSkladista {

	private JFrame frmSkladita;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PregledSkladista window = new PregledSkladista();
					window.frmSkladita.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PregledSkladista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSkladita = new JFrame();
		frmSkladita.setTitle("Skladi\u0161ta");
		frmSkladita.setIconImage(Toolkit.getDefaultToolkit().getImage(PregledSkladista.class.getResource("/javax/swing/plaf/metal/icons/ocean/collapsed-rtl.gif")));
		frmSkladita.setBounds(100, 100, 599, 445);
		frmSkladita.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSkladita.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 85, 563, 310);
		frmSkladita.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Naziv skladi\u0161ta", "Adresa skladi\u0161ta", "Radno vrijeme", "Kontakt telefon"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblListaSkladita = new JLabel("Lista skladi\u0161ta");
		lblListaSkladita.setBounds(10, 60, 82, 14);
		frmSkladita.getContentPane().add(lblListaSkladita);
		
		JButton btnDodajSkladite = new JButton("Dodaj skladi\u0161te");
		btnDodajSkladite.setBounds(10, 26, 135, 23);
		frmSkladita.getContentPane().add(btnDodajSkladite);
		
		JButton btnNewButton = new JButton("Obri\u0161i skladi\u0161te");
		btnNewButton.setBounds(155, 26, 135, 23);
		frmSkladita.getContentPane().add(btnNewButton);
	}
}
