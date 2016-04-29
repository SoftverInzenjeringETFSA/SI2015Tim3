package ba.unsa.etf.si.app.SkladisteTim3.Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class SumarniIzvjestajMenadzer {

	private JFrame frmIzvjetaji;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SumarniIzvjestajMenadzer window = new SumarniIzvjestajMenadzer();
					window.frmIzvjetaji.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SumarniIzvjestajMenadzer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIzvjetaji = new JFrame();
		frmIzvjetaji.setTitle("Izvje\u0161taji");
		frmIzvjetaji.setIconImage(Toolkit.getDefaultToolkit().getImage(SumarniIzvjestajMenadzer.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		frmIzvjetaji.setBounds(100, 100, 490, 359);
		frmIzvjetaji.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIzvjetaji.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(179, 67, 234, 60);
		frmIzvjetaji.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JRadioButton radioButton = new JRadioButton("Izvje\u0161taj trendova proizvoda");
		panel.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("Sumarni izvje\u0161taj");
		panel.add(radioButton_1);
		
		JLabel label = new JLabel("Tip izvje\u0161taja:");
		label.setBounds(82, 67, 72, 14);
		frmIzvjetaji.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Skladi\u0161te:");
		label_1.setBounds(102, 39, 52, 14);
		frmIzvjetaji.getContentPane().add(label_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(179, 36, 234, 20);
		frmIzvjetaji.getContentPane().add(comboBox);
		
		JLabel label_2 = new JLabel("Vremenski period:");
		label_2.setBounds(64, 175, 90, 14);
		frmIzvjetaji.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("od");
		label_3.setBounds(179, 175, 19, 14);
		frmIzvjetaji.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("do");
		label_4.setBounds(179, 213, 19, 14);
		frmIzvjetaji.getContentPane().add(label_4);
		
		JCheckBox checkBox = new JCheckBox("Trenutno stanje skladi\u0161ta(zaklju\u010Dno sa dana\u0161njim danom)");
		checkBox.setHorizontalAlignment(SwingConstants.RIGHT);
		checkBox.setBounds(53, 134, 360, 23);
		frmIzvjetaji.getContentPane().add(checkBox);
		
		JButton button = new JButton("Generi\u0161i izvje\u0161taj");
		button.setBounds(287, 268, 126, 23);
		frmIzvjetaji.getContentPane().add(button);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(208, 172, 205, 20);
		frmIzvjetaji.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(208, 210, 205, 20);
		frmIzvjetaji.getContentPane().add(comboBox_2);
	}
}
