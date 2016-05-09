package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.List;
import javax.swing.JTable;
import javax.swing.JList;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.MjernaJedinica;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Uposlenik;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormaZaUposlenika {

	public JFrame frame;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTable table_2;
	private JTable table_1;
	private JTable table_3;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	public JTextField tbBarKod;
	private JTextField tbKolicina;
	private JTextField tbNabavnaCijena;
	private JTextField tbNaziv;
	private JTextField tbJedinicnaKolicina;

	private Uposlenik _user;
	
	
	public Uposlenik get_user() {
		return _user;
	}

	public void set_user(Uposlenik _user) {
		this._user = _user;
		JLabel lblUser = new JLabel(_user.getUser());
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUser.setBounds(92, 7, 46, 14);
		frame.getContentPane().add(lblUser);
	}

	public FormaZaUposlenika() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 783, 593);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		tabbedPane.setFont(new Font("SansSerif", Font.BOLD, 12));
		tabbedPane.setBounds(0, 28, 767, 508);
		frame.getContentPane().add(tabbedPane);
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		tabbedPane.addTab("Unos Robe", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Skladište: ");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblNewLabel.setBounds(24, 32, 66, 14);
		panel.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(86, 27, 195, 24);
		panel.add(comboBox);
		
		JLabel lblDobavlja = new JLabel("Dobavljač: ");
		lblDobavlja.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblDobavlja.setBounds(24, 76, 54, 24);
		panel.add(lblDobavlja);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(86, 76, 195, 24);
		panel.add(comboBox_1);
		
		JButton btnDodajNovogDobavljaa = new JButton("Dodaj novog dobavljača");
		btnDodajNovogDobavljaa.setBounds(86, 127, 183, 23);
		panel.add(btnDodajNovogDobavljaa);
		
		JButton btnNewButton = new JButton("Završi unos");
		btnNewButton.setBounds(288, 445, 131, 23);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 221, 742, 218);
		panel.add(scrollPane);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, "", "", null},
			},
			new String[] {
				"Bar kod", "Naziv", "Jedini\u010Dna koli\u010Dina", "Mjerna jedinica", "Koli\u010Dina", "Prodajna cijena", "Nabavna cijena"
			}
		));
		table_2.getColumnModel().getColumn(2).setPreferredWidth(93);
		table_2.getColumnModel().getColumn(3).setPreferredWidth(110);
		table_2.getColumnModel().getColumn(4).setPreferredWidth(97);
		scrollPane.setViewportView(table_2);
		
		JLabel lblListaArtikala = new JLabel("Lista artikala: ");
		lblListaArtikala.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblListaArtikala.setBounds(10, 196, 89, 24);
		panel.add(lblListaArtikala);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(306, 3, 435, 210);
		panel_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JRadioButton rdbtnPostojeiArtikal = new JRadioButton("Postojeći artikal");
		rdbtnPostojeiArtikal.setFont(new Font("SansSerif", Font.PLAIN, 11));
		rdbtnPostojeiArtikal.setBounds(70, 6, 109, 23);
		panel_4.add(rdbtnPostojeiArtikal);
		
		JRadioButton rdbtnNoviArtikal = new JRadioButton("Novi artikal");
		rdbtnNoviArtikal.setFont(new Font("SansSerif", Font.PLAIN, 11));
		rdbtnNoviArtikal.setBounds(259, 6, 109, 23);
		panel_4.add(rdbtnNoviArtikal);
		
		JLabel lblBarKod = new JLabel("Bar kod: ");
		lblBarKod.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblBarKod.setBounds(10, 48, 53, 14);
		panel_4.add(lblBarKod);
		
		tbBarKod = new JTextField();
		tbBarKod.setBounds(70, 45, 122, 20);
		panel_4.add(tbBarKod);
		tbBarKod.setColumns(10);
		
		JLabel lblKoliina_1 = new JLabel("Količina: ");
		lblKoliina_1.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblKoliina_1.setBounds(10, 93, 46, 14);
		panel_4.add(lblKoliina_1);
		
		tbKolicina = new JTextField();
		tbKolicina.setBounds(70, 90, 122, 20);
		panel_4.add(tbKolicina);
		tbKolicina.setColumns(10);
		
		JLabel lblNabavnaCijena = new JLabel("Nabavna cijena: ");
		lblNabavnaCijena.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblNabavnaCijena.setBounds(10, 139, 88, 14);
		panel_4.add(lblNabavnaCijena);
		
		tbNabavnaCijena = new JTextField();
		tbNabavnaCijena.setBounds(106, 136, 86, 20);
		panel_4.add(tbNabavnaCijena);
		tbNabavnaCijena.setColumns(10);
		
		JLabel lblNaziv = new JLabel("Naziv: ");
		lblNaziv.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblNaziv.setBounds(216, 48, 39, 14);
		panel_4.add(lblNaziv);
		
		tbNaziv = new JTextField();
		tbNaziv.setBounds(259, 45, 155, 20);
		panel_4.add(tbNaziv);
		tbNaziv.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Jedinična količina: ");
		lblNewLabel_5.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblNewLabel_5.setBounds(209, 93, 94, 14);
		panel_4.add(lblNewLabel_5);
		
		tbJedinicnaKolicina = new JTextField();
		tbJedinicnaKolicina.setBounds(299, 90, 115, 20);
		panel_4.add(tbJedinicnaKolicina);
		tbJedinicnaKolicina.setColumns(10);
		
		JLabel lblMjernaJedinica = new JLabel("Mjerna jedinica: ");
		lblMjernaJedinica.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblMjernaJedinica.setBounds(216, 139, 79, 14);
		panel_4.add(lblMjernaJedinica);
		
		final JComboBox cbMjernaJedinica = new JComboBox();
		cbMjernaJedinica.setModel(new DefaultComboBoxModel(MjernaJedinica.values()));
		cbMjernaJedinica.setBounds(299, 136, 115, 20);
		panel_4.add(cbMjernaJedinica);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(null);
		panel_5.setBounds(202, 36, 223, 143);
		panel_4.add(panel_5);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UposlenikUI.DodajNoviArtikal(tbBarKod.getText(), tbNaziv.getText(), tbJedinicnaKolicina.getText(), (MjernaJedinica)cbMjernaJedinica.getSelectedItem(), tbKolicina.getText());
			}
		});
		btnDodaj.setBounds(9, 176, 89, 23);
		panel_4.add(btnDodaj);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Otpremanje robe", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblSkladite = new JLabel("Skladište: ");
		lblSkladite.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblSkladite.setBounds(10, 46, 49, 25);
		panel_1.add(lblSkladite);
		
		JLabel lblNewLabel_1 = new JLabel("Kupac: ");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(10, 105, 49, 25);
		panel_1.add(lblNewLabel_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(66, 46, 200, 25);
		panel_1.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(66, 105, 200, 25);
		panel_1.add(comboBox_3);
		
		JButton btnDodajNovogKupca = new JButton("Dodaj novog kupca");
		btnDodajNovogKupca.setBounds(79, 158, 168, 23);
		panel_1.add(btnDodajNovogKupca);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 227, 742, 199);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Bar kod", "Naziv", "Jedini\u010Dna koli\u010Dina", "Mjerna jedinica", "Koli\u010Dina", "Prodajna cijena"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JButton btnZavriOtpremanje = new JButton("Završi otpremanje");
		btnZavriOtpremanje.setBounds(306, 443, 175, 25);
		panel_1.add(btnZavriOtpremanje);
		
		JLabel lblNewLabel_3 = new JLabel("Lista artikala: ");
		lblNewLabel_3.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(10, 202, 72, 25);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Bar kod: ");
		lblNewLabel_4.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(386, 21, 46, 14);
		panel_1.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(442, 18, 112, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(442, 64, 112, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(442, 110, 112, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblKoliina = new JLabel("Količina: ");
		lblKoliina.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblKoliina.setBounds(386, 67, 46, 14);
		panel_1.add(lblKoliina);
		
		JLabel lblProdajnaCijena = new JLabel("Prodajna cijena: ");
		lblProdajnaCijena.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblProdajnaCijena.setBounds(346, 113, 86, 14);
		panel_1.add(lblProdajnaCijena);
		
		JButton btnDodajZaOtpremu = new JButton("Dodaj za otpremu");
		btnDodajZaOtpremu.setBounds(386, 158, 168, 23);
		panel_1.add(btnDodajZaOtpremu);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Otpis robe", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblSkladite_1 = new JLabel("Skladište: ");
		lblSkladite_1.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblSkladite_1.setBounds(12, 67, 60, 32);
		panel_2.add(lblSkladite_1);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(82, 73, 200, 20);
		panel_2.add(comboBox_4);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 170, 742, 132);
		panel_2.add(scrollPane_2);
		
		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Bar kod", "Naziv", "Jedini\u010Dna koli\u010Dina", "Mjerna jedinica", "Koli\u010Dina", "Cijena"
			}
		));
		scrollPane_2.setViewportView(table_3);
		
		JButton btnZavriOtpis = new JButton("Završi otpis");
		btnZavriOtpis.setBounds(290, 444, 162, 23);
		panel_2.add(btnZavriOtpis);
		
		JLabel lblKomentar = new JLabel("Komentar: ");
		lblKomentar.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblKomentar.setBounds(10, 313, 60, 20);
		panel_2.add(lblKomentar);
		
		JLabel lblNewLabel_2 = new JLabel("Lista artikala: ");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(10, 144, 81, 23);
		panel_2.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(10, 334, 742, 99);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("Bar kod: ");
		label.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label.setBounds(439, 14, 46, 14);
		panel_2.add(label);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(495, 11, 112, 20);
		panel_2.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(495, 42, 112, 20);
		panel_2.add(textField_5);
		
		JLabel label_1 = new JLabel("Količina: ");
		label_1.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_1.setBounds(439, 45, 46, 14);
		panel_2.add(label_1);
		
		JButton btnDodajZaOtpis = new JButton("Dodaj za otpis");
		btnDodajZaOtpis.setBounds(460, 86, 148, 23);
		panel_2.add(btnDodajZaOtpis);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Pregled trenutnog stanja robe", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 11, 742, 457);
		panel_3.add(scrollPane_3);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Bar kod", "Naziv", "Jedini\u010Dna koli\u010Dina", "Ukupna koli\u010Dina", "Nabavna cijena", "Cijena"
			}
		));
		scrollPane_3.setViewportView(table);
		
		JLabel lblOdjava = new JLabel("Odjava");
		lblOdjava.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RunForms.RunPrijavaForm();
				frame.dispose();
				
			}
		});
		lblOdjava.setFont(new Font("Sitka Text", Font.BOLD, 11));
		lblOdjava.setBounds(721, 7, 46, 23);
		frame.getContentPane().add(lblOdjava);
		
		JLabel lblStatusmsg = new JLabel("StatusMSG");
		lblStatusmsg.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblStatusmsg.setBounds(10, 539, 63, 14);
		frame.getContentPane().add(lblStatusmsg);
		
		JLabel lblDobrodosli = new JLabel("Dobrodošli:");
		lblDobrodosli.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblDobrodosli.setBounds(10, 7, 84, 14);
		frame.getContentPane().add(lblDobrodosli);
		
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{tabbedPane, panel, panel_1, panel_2, panel_3}));
	}
}
