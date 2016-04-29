package ba.unsa.etf.si.app.SkladisteTim3.Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class PregledTrenutnoStanje {

	private JFrame frmPregledTrenutnogStanja;
	private JTable table;
	private JLabel lblSkladite;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PregledTrenutnoStanje window = new PregledTrenutnoStanje();
					window.frmPregledTrenutnogStanja.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PregledTrenutnoStanje() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPregledTrenutnogStanja = new JFrame();
		frmPregledTrenutnogStanja.setIconImage(Toolkit.getDefaultToolkit().getImage(PregledTrenutnoStanje.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		frmPregledTrenutnogStanja.setTitle("Pregled trenutnog stanja skladi\u0161ta");
		frmPregledTrenutnogStanja.setBounds(100, 100, 725, 458);
		frmPregledTrenutnogStanja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPregledTrenutnogStanja.getContentPane().setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 54, 689, 339);
		frmPregledTrenutnogStanja.getContentPane().add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Bar kod", "Naziv", "Jedini\u010Dna koli\u010Dina", "Ukupna koli\u010Dina", "Nabavna cijena", "Cijena"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Float.class, Float.class, Float.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_1.setViewportView(table);
		
		lblSkladite = new JLabel("Skladi\u0161te:");
		lblSkladite.setBounds(10, 29, 54, 14);
		frmPregledTrenutnogStanja.getContentPane().add(lblSkladite);
		
		comboBox = new JComboBox();
		comboBox.setBounds(74, 26, 204, 20);
		frmPregledTrenutnogStanja.getContentPane().add(comboBox);
	}
}
