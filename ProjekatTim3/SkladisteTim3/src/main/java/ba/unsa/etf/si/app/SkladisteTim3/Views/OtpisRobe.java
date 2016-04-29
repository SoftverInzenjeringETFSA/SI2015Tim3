package ba.unsa.etf.si.app.SkladisteTim3.Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class OtpisRobe {

	private JFrame frmOtpisRobe;
	private JTable table;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OtpisRobe window = new OtpisRobe();
					window.frmOtpisRobe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OtpisRobe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOtpisRobe = new JFrame();
		frmOtpisRobe.setIconImage(Toolkit.getDefaultToolkit().getImage(OtpisRobe.class.getResource("/javax/swing/plaf/metal/icons/ocean/maximize.gif")));
		frmOtpisRobe.setTitle("Otpis robe");
		frmOtpisRobe.setBounds(100, 100, 688, 496);
		frmOtpisRobe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOtpisRobe.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Skladi\u0161te:");
		label.setBounds(36, 31, 46, 14);
		frmOtpisRobe.getContentPane().add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(101, 28, 193, 20);
		frmOtpisRobe.getContentPane().add(comboBox);
		
		JLabel label_3 = new JLabel("Lista artikala");
		label_3.setBounds(10, 93, 113, 14);
		frmOtpisRobe.getContentPane().add(label_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 112, 652, 199);
		frmOtpisRobe.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Naziv", "Bar kod", "Jedini\u010Dna koli\u010Dina", "Koli\u010Dina", "Cijena"
			}
		));
		scrollPane.setViewportView(table);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 344, 652, 73);
		frmOtpisRobe.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblKomentar = new JLabel("Komentar");
		lblKomentar.setBounds(10, 322, 54, 14);
		frmOtpisRobe.getContentPane().add(lblKomentar);
		
		JButton btnZavriOtpis = new JButton("Zavr\u0161i otpis");
		btnZavriOtpis.setBounds(542, 428, 120, 23);
		frmOtpisRobe.getContentPane().add(btnZavriOtpis);
		
		JButton button = new JButton("Dodaj artikal");
		button.setBounds(101, 59, 114, 23);
		frmOtpisRobe.getContentPane().add(button);
	}

}
