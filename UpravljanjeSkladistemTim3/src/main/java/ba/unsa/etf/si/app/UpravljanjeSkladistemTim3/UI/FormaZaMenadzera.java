package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Uposlenik;

import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.AbstractListModel;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormaZaMenadzera {

	public JFrame frmSistemUpravljanjaSkladistem;
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTable table_2;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	
	private Uposlenik _user;
	
	public Uposlenik get_user() {
		return _user;
	}

	public void set_user(Uposlenik _user) {
		this._user = _user;
		JLabel userName = new JLabel(_user.getUser());
		userName.setFont(new Font("Tahoma", Font.BOLD, 12));
		userName.setBounds(90, 14, 46, 14);
		frmSistemUpravljanjaSkladistem.getContentPane().add(userName);
		}

	public FormaZaMenadzera() {
		initialize();
	}

	private void initialize() {
		frmSistemUpravljanjaSkladistem = new JFrame();
		frmSistemUpravljanjaSkladistem.setResizable(false);
		frmSistemUpravljanjaSkladistem.setIconImage(Toolkit.getDefaultToolkit().getImage(FormaZaMenadzera.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		frmSistemUpravljanjaSkladistem.setTitle("Sistem upravljanja skladištem - Menadžer");
		frmSistemUpravljanjaSkladistem.setBounds(100, 100, 711, 526);
		frmSistemUpravljanjaSkladistem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSistemUpravljanjaSkladistem.getContentPane().setLayout(null);
		frmSistemUpravljanjaSkladistem.setLocationRelativeTo(null);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("SansSerif", Font.BOLD, 12));
		tabbedPane.setBounds(0, 44, 695, 431);
		frmSistemUpravljanjaSkladistem.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Pregled trenutnog stanja robe", new ImageIcon(FormaZaMenadzera.class.getResource("/com/sun/java/swing/plaf/windows/icons/DetailsView.gif")), panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 56, 689, 339);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Bar kod", "Naziv", "Jedini\u010Dna koli\u010Dina", "Ukupna koli\u010Dina", "Cijena"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Float.class, Float.class, Float.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("Skladi\u0161te:");
		label.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label.setBounds(27, 29, 54, 14);
		panel.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(91, 26, 204, 20);
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Generisanje izvještaja", new ImageIcon(FormaZaMenadzera.class.getResource("/com/sun/java/swing/plaf/windows/icons/File.gif")), panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBorder(new TitledBorder(null, "Generisanje izvje\u0161taja", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_14.setBounds(151, 11, 372, 375);
		panel_1.add(panel_14);
		panel_14.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(126, 64, 234, 60);
		panel_14.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		JRadioButton radioButton = new JRadioButton("Izvje\u0161taj trendova proizvoda");
		radioButton.setFont(new Font("SansSerif", Font.PLAIN, 11));
		panel_5.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("Sumarni izvje\u0161taj");
		radioButton_1.setFont(new Font("SansSerif", Font.PLAIN, 11));
		panel_5.add(radioButton_1);
		
		JLabel label_1 = new JLabel("Tip izvje\u0161taja:");
		label_1.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_1.setBounds(29, 64, 72, 14);
		panel_14.add(label_1);
		
		JLabel label_2 = new JLabel("Skladi\u0161te:");
		label_2.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_2.setBounds(49, 36, 52, 14);
		panel_14.add(label_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(126, 33, 234, 20);
		panel_14.add(comboBox_1);
		
		JCheckBox checkBox = new JCheckBox("Trenutno stanje skladi\u0161ta(zaklju\u010Dno sa dana\u0161njim danom)");
		checkBox.setFont(new Font("SansSerif", Font.PLAIN, 11));
		checkBox.setBounds(18, 131, 342, 23);
		panel_14.add(checkBox);
		checkBox.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_3 = new JLabel("Vremenski period:");
		label_3.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_3.setBounds(11, 172, 90, 14);
		panel_14.add(label_3);
		
		JLabel label_4 = new JLabel("od");
		label_4.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_4.setBounds(126, 172, 19, 14);
		panel_14.add(label_4);
		
		JLabel label_5 = new JLabel("do");
		label_5.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_5.setBounds(126, 210, 19, 14);
		panel_14.add(label_5);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(155, 169, 205, 20);
		panel_14.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(155, 207, 205, 20);
		panel_14.add(comboBox_3);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Dodatne opcije", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(10, 235, 352, 72);
		panel_14.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblUnesiteBarKod = new JLabel("Unesite bar kod artikla:");
		lblUnesiteBarKod.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblUnesiteBarKod.setBounds(10, 30, 111, 14);
		panel_6.add(lblUnesiteBarKod);
		
		textField_11 = new JTextField();
		textField_11.setBounds(131, 27, 211, 20);
		panel_6.add(textField_11);
		textField_11.setColumns(10);
		
		JButton button = new JButton("Generi\u0161i izvje\u0161taj");
		button.setBounds(192, 318, 170, 23);
		panel_14.add(button);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Uposlenici", new ImageIcon(FormaZaMenadzera.class.getResource("/com/sun/java/swing/plaf/windows/icons/Directory.gif")), panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "Dodavanje novog uposlenika", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.setBounds(10, 11, 324, 373);
		panel_2.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel label_9 = new JLabel("Ime:");
		label_9.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_9.setBounds(79, 33, 22, 14);
		panel_7.add(label_9);
		
		JLabel label_10 = new JLabel("Prezime:");
		label_10.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_10.setBounds(61, 61, 41, 14);
		panel_7.add(label_10);
		
		JLabel label_11 = new JLabel("JMBG:");
		label_11.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_11.setBounds(73, 89, 40, 14);
		panel_7.add(label_11);
		
		JLabel label_12 = new JLabel("Datum ro\u0111enja:");
		label_12.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_12.setBounds(28, 117, 80, 14);
		panel_7.add(label_12);
		
		JLabel label_13 = new JLabel("Mjesto ro\u0111enja:");
		label_13.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_13.setBounds(28, 148, 80, 14);
		panel_7.add(label_13);
		
		JLabel label_14 = new JLabel("Adresa stanovanja:");
		label_14.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_14.setBounds(10, 176, 95, 14);
		panel_7.add(label_14);
		
		JLabel label_15 = new JLabel("Broj telefona:");
		label_15.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_15.setBounds(38, 207, 66, 14);
		panel_7.add(label_15);
		
		JLabel label_16 = new JLabel("E-mail adresa:");
		label_16.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_16.setBounds(38, 238, 75, 14);
		panel_7.add(label_16);
		
		JLabel label_17 = new JLabel("Stru\u010Dna sprema:");
		label_17.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_17.setBounds(28, 269, 85, 14);
		panel_7.add(label_17);
		
		JLabel label_18 = new JLabel("Skladi\u0161te u kojem je zaposlen:");
		label_18.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_18.setBounds(28, 312, 147, 14);
		panel_7.add(label_18);
		
		textField = new JTextField();
		textField.setBounds(123, 30, 191, 20);
		panel_7.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(123, 58, 191, 20);
		panel_7.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(123, 86, 191, 20);
		panel_7.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(123, 114, 191, 20);
		panel_7.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(123, 145, 191, 20);
		panel_7.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(123, 173, 191, 20);
		panel_7.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(123, 204, 191, 20);
		panel_7.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(123, 235, 191, 20);
		panel_7.add(textField_7);
		textField_7.setColumns(10);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(185, 309, 129, 20);
		panel_7.add(comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBounds(123, 266, 191, 20);
		panel_7.add(comboBox_6);
		
		JButton button_1 = new JButton("Dodaj novog uposlenika");
		button_1.setBounds(123, 339, 191, 23);
		panel_7.add(button_1);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(null, "Lista uposlenika", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_8.setBounds(344, 11, 336, 373);
		panel_2.add(panel_8);
		panel_8.setLayout(null);
		
		JButton btnObriiUposlenika = new JButton("Obriši uposlenika");
		btnObriiUposlenika.setBounds(136, 339, 190, 23);
		panel_8.add(btnObriiUposlenika);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 30, 316, 298);
		panel_8.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Ime", "Prezime", "JMBG"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Skladišta", new ImageIcon(FormaZaMenadzera.class.getResource("/javax/swing/plaf/metal/icons/ocean/collapsed-rtl.gif")), panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new TitledBorder(null, "Dodavanje novog skladi\u0161ta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_9.setBounds(10, 11, 328, 373);
		panel_3.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel label_20 = new JLabel("Naziv:");
		label_20.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_20.setBounds(55, 35, 30, 14);
		panel_9.add(label_20);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(106, 32, 212, 20);
		panel_9.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(106, 63, 212, 20);
		panel_9.add(textField_9);
		
		JLabel label_21 = new JLabel("Adresa:");
		label_21.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_21.setBounds(44, 66, 41, 14);
		panel_9.add(label_21);
		
		JLabel label_25 = new JLabel("Kontakt telefon:");
		label_25.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_25.setBounds(10, 190, 78, 14);
		panel_9.add(label_25);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(106, 187, 212, 20);
		panel_9.add(textField_10);
		
		JButton btnDodajSkladite = new JButton("Dodaj skladište");
		btnDodajSkladite.setBounds(183, 339, 135, 23);
		panel_9.add(btnDodajSkladite);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new TitledBorder(null, "Radno vrijeme", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_11.setBounds(10, 94, 308, 82);
		panel_9.add(panel_11);
		panel_11.setLayout(null);
		
		JLabel label_23 = new JLabel("od:");
		label_23.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_23.setBounds(59, 28, 16, 14);
		panel_11.add(label_23);
		
		JLabel label_24 = new JLabel("do:");
		label_24.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_24.setBounds(58, 53, 17, 14);
		panel_11.add(label_24);
		
		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setBounds(98, 51, 200, 20);
		panel_11.add(comboBox_8);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setBounds(98, 26, 200, 20);
		panel_11.add(comboBox_7);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new TitledBorder(null, "Lista skladi\u0161ta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_10.setBounds(348, 11, 332, 373);
		panel_3.add(panel_10);
		panel_10.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 31, 312, 302);
		panel_10.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Naziv skladi\u0161ta", "Adresa skladi\u0161ta"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_2.setViewportView(table_2);
		
		JLabel label_19 = new JLabel("Lista skladi\u0161ta");
		label_19.setBounds(-165, 6, 82, 14);
		panel_10.add(label_19);
		
		JButton button_3 = new JButton("Obri\u0161i skladi\u0161te");
		button_3.setBounds(187, 339, 135, 23);
		panel_10.add(button_3);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Dokumenti", new ImageIcon(FormaZaMenadzera.class.getResource("/com/sun/java/swing/plaf/windows/icons/Directory.gif")), panel_4, null);
		panel_4.setLayout(null);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new TitledBorder(null, "Tip dokumenta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_12.setBounds(10, 21, 224, 112);
		panel_4.add(panel_12);
		panel_12.setLayout(null);
		
		JCheckBox chckbxNabavka = new JCheckBox("Nabavka");
		chckbxNabavka.setFont(new Font("SansSerif", Font.PLAIN, 11));
		chckbxNabavka.setBounds(64, 18, 97, 23);
		panel_12.add(chckbxNabavka);
		
		JCheckBox chckbxOtpremnica = new JCheckBox("Otpremnica");
		chckbxOtpremnica.setFont(new Font("SansSerif", Font.PLAIN, 11));
		chckbxOtpremnica.setBounds(64, 44, 97, 23);
		panel_12.add(chckbxOtpremnica);
		
		JCheckBox chckbxOtpisnica = new JCheckBox("Otpisnica");
		chckbxOtpisnica.setFont(new Font("SansSerif", Font.PLAIN, 11));
		chckbxOtpisnica.setBounds(64, 70, 97, 23);
		panel_12.add(chckbxOtpisnica);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new TitledBorder(null, "Vremenski period", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_13.setBounds(244, 21, 307, 112);
		panel_4.add(panel_13);
		panel_13.setLayout(null);
		
		JLabel label_26 = new JLabel("od:");
		label_26.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_26.setBounds(26, 51, 16, 14);
		panel_13.add(label_26);
		
		JLabel label_27 = new JLabel("do:");
		label_27.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_27.setBounds(26, 76, 17, 14);
		panel_13.add(label_27);
		
		JComboBox comboBox_9 = new JComboBox();
		comboBox_9.setBounds(64, 73, 212, 20);
		panel_13.add(comboBox_9);
		
		JComboBox comboBox_10 = new JComboBox();
		comboBox_10.setBounds(64, 48, 212, 20);
		panel_13.add(comboBox_10);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Primjer1", "Primjer2"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(10, 170, 670, 188);
		panel_4.add(list);
		
		JLabel lblListaOdabranihDokumenata = new JLabel("Lista odabranih dokumenata");
		lblListaOdabranihDokumenata.setFont(new Font("SansSerif", Font.BOLD, 11));
		lblListaOdabranihDokumenata.setBounds(10, 145, 164, 14);
		panel_4.add(lblListaOdabranihDokumenata);
		
		JButton btnPrikaiDokument = new JButton("Prikaži dokument");
		btnPrikaiDokument.setBounds(525, 361, 155, 23);
		panel_4.add(btnPrikaiDokument);
		
		JButton btnPretrai = new JButton("Pretraži");
		btnPretrai.setBounds(561, 62, 119, 23);
		panel_4.add(btnPretrai);
		
		JLabel label_7 = new JLabel("Odjava");
		label_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				RunForms.RunPrijavaForm();
				frmSistemUpravljanjaSkladistem.dispose();
			}
		});
		label_7.setFont(new Font("Sitka Text", Font.BOLD, 11));
		label_7.setBounds(632, 11, 53, 24);
		frmSistemUpravljanjaSkladistem.getContentPane().add(label_7);
		
		JLabel label_28 = new JLabel("Dobrodo\u0161li:");
		label_28.setFont(new Font("Verdana", Font.PLAIN, 11));
		label_28.setBounds(10, 9, 73, 24);
		frmSistemUpravljanjaSkladistem.getContentPane().add(label_28);
		
		
		
		JLabel label_8 = new JLabel("StatusMSG");
		label_8.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_8.setBounds(10, 472, 63, 25);
		frmSistemUpravljanjaSkladistem.getContentPane().add(label_8);
	}
}
