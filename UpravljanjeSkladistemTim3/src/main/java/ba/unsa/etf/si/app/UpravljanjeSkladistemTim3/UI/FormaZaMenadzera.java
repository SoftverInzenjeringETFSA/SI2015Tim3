package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.hibernate.Query;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.App;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Skladiste;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.StrucnaSprema;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.TipUposlenika;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Uposlenik;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Dokument;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Nabavka;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Otpisnica;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Otpremnica;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Skladiste;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL.MenadzerDokumentBLL;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL.MenadzerSkladisteBLL;

import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.io.Console;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import com.toedter.*;
import com.toedter.calendar.JDateChooser;
import java.awt.Point;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class FormaZaMenadzera {

	public JFrame frmSistemUpravljanjaSkladistem;
	private JTable table;
	private JTable tableUposlenici;
	private JTextField textIme;
	private JTextField textPrezime;
	private JTextField textJmbg;
	private JTextField textMjestoRodjenja;
	private JTextField textAdresa;
	private JTextField textBrojTel;
	private JTextField textEmail;
	private JTable table_2;
	private JTextField tbNaziv;
	private JTextField tbAdresa;
	private JTextField tbKontakt;
	private JTextField textField_11;
	private JDateChooser dateRodjenja;
	private JComboBox comboBoxStrucnaSprema;
	private JComboBox comboBoxSkladiste;
	private JLabel labelStatus;
	private JComboBox comboBoxTipUposlenika;
	private MenadzerUposleniciUI menUposleniciUI = null;
	
	private JTextField textUser;
	private JTextField textPass;
	private Uposlenik _user;
	
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	private JLabel label_4;
	private JLabel label_5;
	
	private TrenutnoStanjeSkladistaUI tst = new TrenutnoStanjeSkladistaUI();
	
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
		
		menUposleniciUI = new MenadzerUposleniciUI();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("SansSerif", Font.BOLD, 12));
		tabbedPane.setBounds(0, 44, 695, 431);
		frmSistemUpravljanjaSkladistem.getContentPane().add(tabbedPane);
		
		final MenadzerDokumentBLL mdbll = new MenadzerDokumentBLL(); 
		final MenadzerSkladisteBLL msbll = new MenadzerSkladisteBLL();
		final MenadzerDokumentUI mdui = new MenadzerDokumentUI();
		final MenadzerSkladisteUI msui = new MenadzerSkladisteUI();
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Pregled trenutnog stanja robe", new ImageIcon(FormaZaMenadzera.class.getResource("/com/sun/java/swing/plaf/windows/icons/DetailsView.gif")), panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(0, 56, 689, 339);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
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
		
		final JComboBox comboBox = new JComboBox();
		tst.napuniComboBoxSkladistima(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tst.trenutnoStanjeSkladistaMenadzer(comboBox.getSelectedItem().toString(), table, labelStatus);
			}
		});
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
		
		final JPanel panel_6 = new JPanel();
		panel_6.setVisible(false);
		
		ButtonGroup bg1 = new ButtonGroup();
		
		JLabel label_2 = new JLabel("Skladi\u0161te:");
		label_2.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_2.setBounds(49, 36, 52, 14);
		panel_14.add(label_2);
		
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(126, 33, 234, 20);
		panel_14.add(comboBox_1);
		tst.napuniComboBoxSkladistima(comboBox_1);
		
		final JPanel panel_16 = new JPanel();
		comboBox_2 = new JComboBox();
		comboBox_3 = new JComboBox();
		
		final JCheckBox checkBox = new JCheckBox("Trenutno stanje skladi\u0161ta(zaklju\u010Dno sa dana\u0161njim danom)");
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (checkBox.isSelected()){
					panel_16.disable();	
					comboBox_2.disable();
					comboBox_3.disable();
					label_4.disable();
					label_5.disable();
					
					panel_16.setForeground(Color.gray);
				}
				else {
					panel_16.enable();
					comboBox_2.enable();
					comboBox_3.enable();
					
					panel_16.setForeground(Color.white);
					label_4.enable();
					label_5.enable();
				}
			}
		});
		checkBox.setFont(new Font("SansSerif", Font.PLAIN, 11));
		checkBox.setBounds(18, 151, 342, 23);
		panel_14.add(checkBox);
		checkBox.setHorizontalAlignment(SwingConstants.RIGHT);
		
		/*JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(155, 169, 205, 20);
		panel_14.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(155, 207, 205, 20);
		panel_14.add(comboBox_3);*/
		
		//JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Dodatne opcije", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(18, 268, 342, 72);
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
		
		
		final JRadioButton radioButton = new JRadioButton("Izvje\u0161taj trendova proizvoda");
		final JRadioButton radioButton_1 = new JRadioButton("Sumarni izvje\u0161taj");
		
		JButton button = new JButton("Generi\u0161i izvje\u0161taj");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormaZaMenadzeraGenerisanjeIzvjestajaUI ui = new FormaZaMenadzeraGenerisanjeIzvjestajaUI();
				ui.generisiIzvjestaj(comboBox_1, radioButton, radioButton_1, checkBox, comboBox_2, comboBox_3, textField_11, labelStatus);
			}
		});
		button.setBounds(190, 341, 170, 23);
		panel_14.add(button);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tip izvje\u0161taja:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_15.setBounds(18, 56, 344, 94);
		panel_14.add(panel_15);
		panel_15.setLayout(null);
		
		
		radioButton_1.setBounds(104, 51, 234, 30);
		panel_15.add(radioButton_1);
		radioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_6.setVisible(false);
			}
		});
		radioButton_1.setFont(new Font("SansSerif", Font.PLAIN, 11));
		bg1.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("Sumarni izvještaj");
		radioButton_2.setFont(new Font("SansSerif", Font.PLAIN, 11));
		radioButton_2.setBounds(104, 56, 234, 30);
		panel_15.add(radioButton_2);
		
		
		radioButton.setBounds(104, 11, 234, 42);
		panel_15.add(radioButton);
		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_6.setVisible(true);
			}
		});
		radioButton.setFont(new Font("SansSerif", Font.PLAIN, 11));
		bg1.add(radioButton);
		
		
		panel_16.setBorder(new TitledBorder(null, "Vremenski period:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_16.setBounds(21, 181, 339, 88);
		panel_14.add(panel_16);
		panel_16.setLayout(null);
		
		
		comboBox_3.setBounds(124, 57, 205, 20);
		panel_16.add(comboBox_3);
		
		
		comboBox_2.setBounds(124, 26, 205, 20);
		panel_16.add(comboBox_2);
		label_4 = new JLabel("od");
		label_4.setBounds(79, 32, 19, 14);
		panel_16.add(label_4);
		
		//JLabel label_4 = new JLabel("od");
		label_4.setFont(new Font("SansSerif", Font.PLAIN, 11));
		//panel_16.add(label_4);
		label_4.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_5 = new JLabel("do");
		label_5.setBounds(79, 63, 19, 14);
		panel_16.add(label_5);
		
		//JLabel label_5 = new JLabel("do");
		label_5.setFont(new Font("SansSerif", Font.PLAIN, 11));
		//panel_16.add(label_5);
		label_5.setFont(new Font("SansSerif", Font.PLAIN, 11));
		
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
		label_9.setBounds(80, 23, 22, 14);
		panel_7.add(label_9);
		
		JLabel label_10 = new JLabel("Prezime:");
		label_10.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_10.setBounds(61, 48, 41, 14);
		panel_7.add(label_10);
		
		JLabel label_11 = new JLabel("JMBG:");
		label_11.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_11.setBounds(71, 73, 31, 14);
		panel_7.add(label_11);
		
		JLabel label_12 = new JLabel("Datum ro\u0111enja:");
		label_12.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_12.setBounds(28, 98, 80, 14);
		panel_7.add(label_12);
		
		JLabel label_13 = new JLabel("Mjesto ro\u0111enja:");
		label_13.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_13.setBounds(28, 125, 80, 14);
		panel_7.add(label_13);
		
		JLabel label_14 = new JLabel("Adresa stanovanja:");
		label_14.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_14.setBounds(7, 152, 95, 14);
		panel_7.add(label_14);
		
		JLabel label_15 = new JLabel("Broj telefona:");
		label_15.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_15.setBounds(38, 179, 66, 14);
		panel_7.add(label_15);
		
		JLabel label_16 = new JLabel("E-mail adresa:");
		label_16.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_16.setBounds(34, 206, 68, 14);
		panel_7.add(label_16);
		
		JLabel label_17 = new JLabel("Stru\u010Dna sprema:");
		label_17.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_17.setBounds(22, 233, 80, 14);
		panel_7.add(label_17);
		
		JLabel label_18 = new JLabel("Skladi\u0161te u kojem je zaposlen:");
		label_18.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_18.setBounds(28, 312, 147, 14);
		panel_7.add(label_18);
		
		textIme = new JTextField();
		textIme.setBounds(123, 21, 191, 20);
		panel_7.add(textIme);
		textIme.setColumns(10);
		
		textPrezime = new JTextField();
		textPrezime.setBounds(123, 46, 191, 20);
		panel_7.add(textPrezime);
		textPrezime.setColumns(10);
		
		textJmbg = new JTextField();
		textJmbg.setBounds(123, 71, 191, 20);
		panel_7.add(textJmbg);
		textJmbg.setColumns(10);
		
		textMjestoRodjenja = new JTextField();
		textMjestoRodjenja.setBounds(123, 123, 191, 20);
		panel_7.add(textMjestoRodjenja);
		textMjestoRodjenja.setColumns(10);
		
		textAdresa = new JTextField();
		textAdresa.setBounds(123, 150, 191, 20);
		panel_7.add(textAdresa);
		textAdresa.setColumns(10);
		
		textBrojTel = new JTextField();
		textBrojTel.setBounds(123, 177, 191, 20);
		panel_7.add(textBrojTel);
		textBrojTel.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(123, 204, 191, 20);
		panel_7.add(textEmail);
		textEmail.setColumns(10);
		
		comboBoxSkladiste = new JComboBox();
		comboBoxSkladiste.setBounds(185, 310, 129, 20);
		panel_7.add(comboBoxSkladiste);
		
		comboBoxStrucnaSprema = new JComboBox(StrucnaSprema.values());
		comboBoxStrucnaSprema.setBounds(123, 231, 191, 20);
		panel_7.add(comboBoxStrucnaSprema);
		
		JButton buttonDodajUposlenika = new JButton("Dodaj novog uposlenika");
		buttonDodajUposlenika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Poziv");
				//if(dateRodjenja.getDate().equals(null))
				//	System.out.println("Date nije oke");
				
				if(comboBoxStrucnaSprema.getSelectedIndex()<0)
					labelStatus.setText("Nije odabrana strucna sprema!");
					//JOptionPane.showMessageDialog(null, "Combobox null", "greska", JOptionPane.ERROR_MESSAGE);
				else if(comboBoxTipUposlenika.getSelectedIndex()<0)
					labelStatus.setText("Nije odabran tip uposlenika!");
				else if(comboBoxSkladiste.getSelectedIndex()<0)
					labelStatus.setText("Nije odabrano skladiste!");
				
				if(menUposleniciUI == null)
					menUposleniciUI = new MenadzerUposleniciUI();
				String poruka = menUposleniciUI.dodajUposlenika(frmSistemUpravljanjaSkladistem,
textIme.getText(),textPrezime.getText(),textJmbg.getText(), dateRodjenja.getDate(),
textMjestoRodjenja.getText(),textAdresa.getText(),textBrojTel.getText(),textEmail.getText(),
comboBoxStrucnaSprema.getSelectedIndex(),comboBoxTipUposlenika.getSelectedIndex(),
textUser.getText(),textPass.getText(), comboBoxSkladiste.getSelectedIndex());
				
				labelStatus.setText(poruka);

				if(poruka.equals("  ")){
					azurirajListuUposlenika(textIme.getText(),textPrezime.getText(),textJmbg.getText());
					ocistiFormu();
				}
			}
		});
		buttonDodajUposlenika.setBounds(123, 341, 191, 23);
		panel_7.add(buttonDodajUposlenika);
		
		dateRodjenja = new JDateChooser();
		dateRodjenja.setBounds(123, 98, 191, 20);
		panel_7.add(dateRodjenja);
		
		comboBoxTipUposlenika = new JComboBox(TipUposlenika.values());
		comboBoxTipUposlenika.setBounds(123, 257, 191, 20);
		panel_7.add(comboBoxTipUposlenika);
		
		JLabel lblTipUposlenika = new JLabel("Tip uposlenika:");
		lblTipUposlenika.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblTipUposlenika.setBounds(28, 259, 74, 14);
		panel_7.add(lblTipUposlenika);
		
		JLabel lblKorisnikoIme = new JLabel("Korisničko ime:");
		lblKorisnikoIme.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblKorisnikoIme.setBounds(7, 284, 74, 14);
		panel_7.add(lblKorisnikoIme);
		
		final JComboBox comboBox_6 = new JComboBox();
		panel_7.add(comboBox_6);
		
		
		JLabel lblifra = new JLabel("Šifra:");
		lblifra.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblifra.setBounds(185, 285, 33, 14);
		panel_7.add(lblifra);
		
		textUser = new JTextField();
		textUser.setBounds(89, 282, 86, 20);
		panel_7.add(textUser);
		textUser.setColumns(10);
		
		textPass = new JTextField();
		textPass.setBounds(228, 282, 86, 20);
		panel_7.add(textPass);
		textPass.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(null, "Lista uposlenika", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_8.setBounds(344, 11, 336, 373);
		panel_2.add(panel_8);
		panel_8.setLayout(null);
		
		JButton btnObriiUposlenika = new JButton("Obriši uposlenika");
		btnObriiUposlenika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int indeksReda = tableUposlenici.getSelectedRow();
				String jmbg = "";
				if(indeksReda != -1)
					jmbg = (String) tableUposlenici.getModel().getValueAt(indeksReda, 2);
				if(menUposleniciUI == null)
					menUposleniciUI = new MenadzerUposleniciUI();
				String poruka = menUposleniciUI.obrisiUposlenika(indeksReda, jmbg);
				if(poruka.equals("  "))
					izbrisiUposlenikaIzTabele(indeksReda);
				labelStatus.setText(poruka);
			}
		});
		btnObriiUposlenika.setBounds(136, 339, 190, 23);
		panel_8.add(btnObriiUposlenika);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 30, 316, 298);
		panel_8.add(scrollPane_1);
		
		tableUposlenici = new JTable();
		tableUposlenici.setModel(new DefaultTableModel(
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
		scrollPane_1.setViewportView(tableUposlenici);
		
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
		
		tbNaziv = new JTextField();
		tbNaziv.setColumns(10);
		tbNaziv.setBounds(106, 32, 212, 20);
		panel_9.add(tbNaziv);
		
		tbAdresa = new JTextField();
		tbAdresa.setColumns(10);
		tbAdresa.setBounds(106, 63, 212, 20);
		panel_9.add(tbAdresa);
		
		JLabel label_21 = new JLabel("Adresa:");
		label_21.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_21.setBounds(44, 66, 41, 14);
		panel_9.add(label_21);
		
		JLabel label_25 = new JLabel("Kontakt telefon:");
		label_25.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_25.setBounds(10, 190, 78, 14);
		panel_9.add(label_25);
		
		tbKontakt = new JTextField();
		tbKontakt.setColumns(10);
		tbKontakt.setBounds(106, 187, 212, 20);
		panel_9.add(tbKontakt);
		
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
		
		final JComboBox cbDoH = new JComboBox();
		cbDoH.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		cbDoH.setBounds(98, 51, 47, 20);
		panel_11.add(cbDoH);
		
		final JComboBox cbOdH = new JComboBox();
		cbOdH.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		cbOdH.setBounds(98, 26, 47, 20);
		panel_11.add(cbOdH);
		
		final JComboBox cbOdMin = new JComboBox();
		cbOdMin.setModel(new DefaultComboBoxModel(new String[] {"0", "10", "20", "30", "40", "50"}));
		cbOdMin.setBounds(185, 26, 47, 20);
		panel_11.add(cbOdMin);
		
		final JComboBox cbDoMin = new JComboBox();
		cbDoMin.setModel(new DefaultComboBoxModel(new String[] {"0", "10", "20", "30", "40", "50"}));
		cbDoMin.setBounds(185, 51, 47, 20);
		panel_11.add(cbDoMin);
		
		JLabel lblH = new JLabel("h");
		lblH.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblH.setBounds(155, 29, 16, 14);
		panel_11.add(lblH);
		
		JLabel lblH_1 = new JLabel("h");
		lblH_1.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblH_1.setBounds(155, 54, 16, 14);
		panel_11.add(lblH_1);
		
		JLabel lblMin = new JLabel("min");
		lblMin.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblMin.setBounds(242, 29, 16, 14);
		panel_11.add(lblMin);
		
		JLabel lblMin_1 = new JLabel("min");
		lblMin_1.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblMin_1.setBounds(242, 54, 16, 14);
		panel_11.add(lblMin_1);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new TitledBorder(null, "Lista skladi\u0161ta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_10.setBounds(348, 11, 332, 373);
		panel_3.add(panel_10);
		panel_10.setLayout(null);
			

		final JLabel lStatusDokument = new JLabel("");
		lStatusDokument.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lStatusDokument.setBounds(10, 472, 685, 25);
		frmSistemUpravljanjaSkladistem.getContentPane().add(lStatusDokument);

		final JLabel label_8 = new JLabel("");
		label_8.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_8.setBounds(10, 472, 685, 25);
		frmSistemUpravljanjaSkladistem.getContentPane().add(label_8);

		
		
		
		final JScrollPane spLista = new JScrollPane();
		spLista.setBounds(10, 31, 312, 302);
		panel_10.add(spLista);
		
		table_2 = new JTable();
		
		final DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Naziv skladi\u0161ta");
		model.addColumn("Adresa skladi\u0161ta");
		table_2.setModel(model);
		spLista.setViewportView(table_2);
		
		List<Skladiste> lista = msbll.PopuniSkladista();
		for(Skladiste s:lista)
			model.addRow(new Object[] { s.getNaziv(), s.getAdresa() });
		
		JButton btnDodajSkladite = new JButton("Dodaj skladište");
		btnDodajSkladite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int rvOD = Integer.parseInt(cbOdH.getSelectedItem().toString()) * 100 + Integer.parseInt(cbOdMin.getSelectedItem().toString());
				int rvDO = Integer.parseInt(cbDoH.getSelectedItem().toString()) * 100 + Integer.parseInt(cbDoMin.getSelectedItem().toString());
				if(msui.DodajSkladiste(lStatusDokument, tbNaziv.getText(), tbAdresa.getText(), rvOD, rvDO, tbKontakt.getText())) {
					msbll.DodajSkladiste(tbNaziv.getText(), tbAdresa.getText(), rvOD, rvDO, tbKontakt.getText());
					model.addRow(new Object[] { tbNaziv.getText(), tbAdresa.getText()});
				    ocistiFormuSkladiste();
				}
			}
		});
		btnDodajSkladite.setBounds(183, 339, 135, 23);
		panel_9.add(btnDodajSkladite);
		
		JLabel label_19 = new JLabel("Lista skladi\u0161ta");
		label_19.setBounds(-165, 6, 82, 14);
		panel_10.add(label_19);
		
		JButton bObrisiSkladiste = new JButton("Obri\u0161i skladi\u0161te");
		bObrisiSkladiste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table_2.getSelectedRow() != -1) {
					msbll.ObrisiSkladiste(table_2.getValueAt(table_2.getSelectedRow(), 0).toString());
					model.removeRow(table_2.getSelectedRow());
				}
				else
					JOptionPane.showMessageDialog(null, "Izaberite dokument!", "Greška",  JOptionPane.INFORMATION_MESSAGE);
			}
		});
		bObrisiSkladiste.setBounds(187, 339, 135, 23);
		panel_10.add(bObrisiSkladiste);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Dokumenti", new ImageIcon(FormaZaMenadzera.class.getResource("/com/sun/java/swing/plaf/windows/icons/Directory.gif")), panel_4, null);
		panel_4.setLayout(null);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new TitledBorder(null, "Tip dokumenta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_12.setBounds(10, 21, 224, 112);
		panel_4.add(panel_12);
		panel_12.setLayout(null);
		
		final JCheckBox chckbxNabavka = new JCheckBox("Nabavka");
		chckbxNabavka.setFont(new Font("SansSerif", Font.PLAIN, 11));
		chckbxNabavka.setBounds(64, 18, 97, 23);
		panel_12.add(chckbxNabavka);
		
		final JCheckBox chckbxOtpremnica = new JCheckBox("Otpremnica");
		chckbxOtpremnica.setFont(new Font("SansSerif", Font.PLAIN, 11));
		chckbxOtpremnica.setBounds(64, 44, 97, 23);
		panel_12.add(chckbxOtpremnica);
		
		final JCheckBox chckbxOtpisnica = new JCheckBox("Otpisnica");
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
		label_26.setBounds(35, 41, 16, 14);
		panel_13.add(label_26);
		
		JLabel label_27 = new JLabel("do:");
		label_27.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_27.setBounds(34, 78, 17, 14);
		panel_13.add(label_27);
		
		final JDateChooser dcOd = new JDateChooser();
		dcOd.setBounds(81, 39, 168, 20);
		panel_13.add(dcOd);
		
		final JDateChooser dcDo = new JDateChooser();
		dcDo.setBounds(81, 76, 168, 20);
		panel_13.add(dcDo);

		final DefaultListModel listModel = new DefaultListModel();
		
		final JList list = new JList();
		list.setModel(listModel);
		list.setBounds(10, 170, 670, 188);
		panel_4.add(list);
		
		JLabel lblListaOdabranihDokumenata = new JLabel("Lista odabranih dokumenata");
		lblListaOdabranihDokumenata.setFont(new Font("SansSerif", Font.BOLD, 11));
		lblListaOdabranihDokumenata.setBounds(10, 145, 164, 14);
		panel_4.add(lblListaOdabranihDokumenata);
		
		JButton btnPrikaiDokument = new JButton("Prikaži dokument");
		btnPrikaiDokument.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(list.getSelectedValue() != null)			
					mdbll.PrikaziPDF((Dokument)list.getSelectedValue());
				else
					JOptionPane.showMessageDialog(null, "Izaberite dokument!", "Greška",  JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnPrikaiDokument.setBounds(525, 361, 155, 23);
		panel_4.add(btnPrikaiDokument);
		
		final List<Dokument> listaDokumenata = mdbll.PopuniListuDokumenata();
		for(Dokument d:listaDokumenata) 
				listModel.addElement(d);

		JButton btnPretrai = new JButton("Pretraži");
		btnPretrai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listModel.removeAllElements();
				String dateOD = ((JTextField)dcOd.getDateEditor().getUiComponent()).getText();
				String dateDO = ((JTextField)dcDo.getDateEditor().getUiComponent()).getText();
				if(mdui.ProvjeriDatumNull(lStatusDokument, dateOD, dateDO)) {
					java.sql.Date sqlDateOd = new java.sql.Date(dcOd.getDate().getTime());
					java.sql.Date sqlDateDo = new java.sql.Date(dcDo.getDate().getTime());
					List<String> trazi = new ArrayList<String>();
					if(chckbxNabavka.isSelected()) trazi.add("NAB");
					if(chckbxOtpremnica.isSelected()) trazi.add("OTP");
					if(chckbxOtpisnica.isSelected()) trazi.add("OTS");
					
					if(mdui.PopuniListuDokumenata(lStatusDokument, sqlDateOd, sqlDateDo, trazi)) {
						List<Dokument> listaDokumenata2 =  mdbll.PopuniListuDokumenata(trazi, sqlDateOd, sqlDateDo);
						if(listaDokumenata2.isEmpty())
							JOptionPane.showMessageDialog(null, "Ne postoji dokument generisan u traženom periodu!", "Greška",  JOptionPane.INFORMATION_MESSAGE);
						else {
							for(Dokument d:listaDokumenata2) {
							listModel.addElement(d);
							}
							JOptionPane.showMessageDialog(null, "Pretraga zavrsena!", "Greška",  JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			}
		});
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
		
		labelStatus = new JLabel("");
		labelStatus.setForeground(Color.RED);
		labelStatus.setFont(new Font("SansSerif", Font.PLAIN, 11));
		labelStatus.setBounds(10, 472, 503, 25);
		frmSistemUpravljanjaSkladistem.getContentPane().add(labelStatus);
		
		//Dodavanje skladista u listu skladista(combobox)
		dodavanjeSkladistaUComboBox();
		dodavanjeUposlenikaUTabelu();
	}
	
	//Metoda za dodavanje skladista u listu skladista(combobox)
		private void dodavanjeSkladistaUComboBox() {
			// TODO Auto-generated method stub
			String query = "select naziv from Skladiste";
			Query q = App.session.createQuery(query);
			List<String> naziviSkladista = q.list();
			//System.out.println(naziviSkladista.isEmpty());
			for(String ime : naziviSkladista)
				comboBoxSkladiste.addItem(ime);
		}
	
	//Metoda za dodavanje uposlenika u tabelu
		private void dodavanjeUposlenikaUTabelu(){
			String query = "select ime, prezime, JMBG from Uposlenik";
			Query q = App.session.createQuery(query);
			List<Object[]> listaUposlenika = q.list();
			System.out.println(listaUposlenika.isEmpty());
			
			DefaultTableModel tableModel = (DefaultTableModel)tableUposlenici.getModel();
			for(Object [] u : listaUposlenika){
				tableModel.addRow(u);
			}
		}
	
		
	//Metoda za brisanje unosa u polja
		private void ocistiFormu(){
			System.out.println("poziv ciscenja");
			textIme.setText("");
			textPrezime.setText("");
			textJmbg.setText("");
			dateRodjenja.setDate(null);
			textMjestoRodjenja.setText("");
			textAdresa.setText("");
			textBrojTel.setText("");
			textEmail.setText("");
			comboBoxStrucnaSprema.setSelectedIndex(0);
			comboBoxTipUposlenika.setSelectedIndex(0);
			textUser.setText("");
			textPass.setText("");
			comboBoxSkladiste.setSelectedIndex(0);
		}
		
		private void ocistiFormuSkladiste() {
			System.out.println("Poziv ciscenja");
			tbNaziv.setText("");
			tbAdresa.setText("");
			tbKontakt.setText("");
		}
		
	//Metoda za azuriranje tabele nakon unosa uposlenika
		private void azurirajListuUposlenika(String ime, String prezime, String jmbg){
			Object[] novi = {ime, prezime, jmbg};
			DefaultTableModel tableModel = (DefaultTableModel)tableUposlenici.getModel();
			tableModel.addRow(novi);
		}
	//Metoda za azuriranje tabele nakon brisanja uposlenika	
		private void izbrisiUposlenikaIzTabele(int indeksReda){
			DefaultTableModel tableModel = (DefaultTableModel)tableUposlenici.getModel();
			tableModel.removeRow(indeksReda);
		}
}
