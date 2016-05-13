package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Nabavka;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NaljepniceWizard {

	public JFrame forma;
	private JTextField tbNabavkaBarKod;
	private JTable table;
	private String barKod;
	
	public void PostaviNabavku(Nabavka nabavka) {
		if(nabavka == null) return;
		tbNabavkaBarKod.setText(nabavka.getBarKod());
		NaljepnicaWizardUI ui = new NaljepnicaWizardUI();
		barKod = ui.SetData(table, nabavka);
	} 
	
	public NaljepniceWizard() {
		initialize();
	}

	private void initialize() {
		forma = new JFrame();
		forma.setTitle("Wizard za kreiranje naljepnica");
		forma.setResizable(false);
		forma.setBounds(100, 100, 353, 529);
		forma.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		forma.getContentPane().setLayout(null);
		forma.setLocationRelativeTo(null);
		
		tbNabavkaBarKod = new JTextField();
		tbNabavkaBarKod.setBounds(115, 9, 108, 20);
		forma.getContentPane().add(tbNabavkaBarKod);
		tbNabavkaBarKod.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Bar kod nabavke:");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblNewLabel.setBounds(25, 11, 91, 14);
		forma.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 40, 297, 415);
		forma.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Bar kod artikla", "Broj naljepnica"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(20);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Odaberi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NaljepnicaWizardUI ui = new NaljepnicaWizardUI();
				barKod = ui.DobaviNabavku(table, tbNabavkaBarKod.getText());
			}
		});
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnNewButton.setBounds(233, 7, 89, 23);
		forma.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Kreiraj naljepnice");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NaljepnicaWizardUI ui = new NaljepnicaWizardUI();
				ui.KreirajNaljepnice(table, barKod);
				forma.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnNewButton_1.setBounds(96, 466, 127, 23);
		forma.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Odustani");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				forma.dispose();
			}
		});
		btnNewButton_2.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnNewButton_2.setBounds(233, 466, 89, 23);
		forma.getContentPane().add(btnNewButton_2);
	}
}
