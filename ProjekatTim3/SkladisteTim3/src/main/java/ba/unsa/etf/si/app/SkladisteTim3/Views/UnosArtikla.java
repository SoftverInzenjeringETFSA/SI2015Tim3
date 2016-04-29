package ba.unsa.etf.si.app.SkladisteTim3.Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;

public class UnosArtikla {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnosArtikla window = new UnosArtikla();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UnosArtikla() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 425, 336);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(37, 38, 333, 193);
		frame.getContentPane().add(panel);
		
		JLabel label = new JLabel("Naziv:");
		label.setBounds(75, 11, 30, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Jedini\u010Dna koli\u010Dina:");
		label_1.setBounds(20, 61, 85, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Mjerna jedinica:");
		label_2.setBounds(29, 86, 76, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Koli\u010Dina:");
		label_3.setBounds(65, 111, 40, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Bar kod:");
		label_4.setBounds(65, 36, 40, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Nabavna cijena:");
		label_5.setBounds(25, 136, 80, 14);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Prodajna cijena:");
		label_6.setBounds(25, 161, 80, 14);
		panel.add(label_6);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(115, 8, 208, 20);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(115, 33, 208, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(115, 58, 208, 20);
		panel.add(textField_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(115, 108, 208, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(115, 133, 208, 20);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(115, 158, 208, 20);
		panel.add(textField_6);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(115, 83, 208, 20);
		panel.add(comboBox);
		
		JButton btnUnesiArtikal = new JButton("Unesi artikal");
		btnUnesiArtikal.setBounds(101, 242, 99, 23);
		frame.getContentPane().add(btnUnesiArtikal);
		
		JButton btnZavriUnos = new JButton("Zavr\u0161i unos");
		btnZavriUnos.setBounds(210, 242, 99, 23);
		frame.getContentPane().add(btnZavriUnos);
		
		JLabel lblMjestoZaPoruku = new JLabel("Mjesto za poruku");
		lblMjestoZaPoruku.setForeground(Color.LIGHT_GRAY);
		lblMjestoZaPoruku.setBounds(0, 283, 113, 14);
		frame.getContentPane().add(lblMjestoZaPoruku);
	}

}
