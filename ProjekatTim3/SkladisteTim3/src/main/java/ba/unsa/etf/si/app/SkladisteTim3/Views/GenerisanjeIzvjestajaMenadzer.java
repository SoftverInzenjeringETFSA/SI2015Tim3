package ba.unsa.etf.si.app.SkladisteTim3.Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class GenerisanjeIzvjestajaMenadzer {

	private JFrame frmIzvjetaji;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerisanjeIzvjestajaMenadzer window = new GenerisanjeIzvjestajaMenadzer();
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
	public GenerisanjeIzvjestajaMenadzer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIzvjetaji = new JFrame();
		frmIzvjetaji.setTitle("Izvje\u0161taji");
		frmIzvjetaji.setIconImage(Toolkit.getDefaultToolkit().getImage(GenerisanjeIzvjestajaMenadzer.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		frmIzvjetaji.setBounds(100, 100, 525, 401);
		frmIzvjetaji.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIzvjetaji.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(197, 62, 234, 60);
		frmIzvjetaji.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JRadioButton rdbtnIzvjetajTrendovaProizvoda = new JRadioButton("Izvje\u0161taj trendova proizvoda");
		panel.add(rdbtnIzvjetajTrendovaProizvoda);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Sumarni izvje\u0161taj");
		panel.add(rdbtnNewRadioButton);
		
		JLabel lblTipIzvjetaja = new JLabel("Tip izvje\u0161taja:");
		lblTipIzvjetaja.setBounds(100, 62, 72, 14);
		frmIzvjetaji.getContentPane().add(lblTipIzvjetaja);
		
		JLabel lblOdaberiteSkladite = new JLabel("Skladi\u0161te:");
		lblOdaberiteSkladite.setBounds(120, 34, 52, 14);
		frmIzvjetaji.getContentPane().add(lblOdaberiteSkladite);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(197, 31, 234, 20);
		frmIzvjetaji.getContentPane().add(comboBox);
		
		JLabel lblVremenskiPeriod = new JLabel("Vremenski period:");
		lblVremenskiPeriod.setBounds(82, 170, 90, 14);
		frmIzvjetaji.getContentPane().add(lblVremenskiPeriod);
		
		JLabel lblOd = new JLabel("od");
		lblOd.setBounds(197, 170, 19, 14);
		frmIzvjetaji.getContentPane().add(lblOd);
		
		JLabel lblDo = new JLabel("do");
		lblDo.setBounds(197, 208, 19, 14);
		frmIzvjetaji.getContentPane().add(lblDo);
		
		JCheckBox chckbxTrenutnoStanjeSkladitazakljuno = new JCheckBox("Trenutno stanje skladi\u0161ta(zaklju\u010Dno sa dana\u0161njim danom)");
		chckbxTrenutnoStanjeSkladitazakljuno.setHorizontalAlignment(SwingConstants.RIGHT);
		chckbxTrenutnoStanjeSkladitazakljuno.setBounds(71, 129, 360, 23);
		frmIzvjetaji.getContentPane().add(chckbxTrenutnoStanjeSkladitazakljuno);
		
		JButton btnGeneriiIzvjetaj = new JButton("Generi\u0161i izvje\u0161taj");
		btnGeneriiIzvjetaj.setBounds(305, 328, 126, 23);
		frmIzvjetaji.getContentPane().add(btnGeneriiIzvjetaj);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(226, 167, 205, 20);
		frmIzvjetaji.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(226, 205, 205, 20);
		frmIzvjetaji.getContentPane().add(comboBox_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(71, 233, 370, 72);
		frmIzvjetaji.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDodatneOpcije = new JLabel("Dodatne opcije");
		lblDodatneOpcije.setBounds(10, 11, 72, 14);
		lblDodatneOpcije.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_1.add(lblDodatneOpcije);
		
		JLabel lblOdaberiteArtikal = new JLabel("Odaberite artikal:");
		lblOdaberiteArtikal.setBounds(10, 42, 90, 14);
		panel_1.add(lblOdaberiteArtikal);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(127, 39, 233, 20);
		panel_1.add(comboBox_3);
	}
}
