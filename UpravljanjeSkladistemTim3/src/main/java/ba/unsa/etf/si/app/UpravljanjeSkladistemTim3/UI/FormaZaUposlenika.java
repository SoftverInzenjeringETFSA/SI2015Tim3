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
//import java.awt.List;
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
import org.hibernate.Query;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import java.util.List;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.App;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL.UposlenikUnosPartneraBLL;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL.UposlenikUnosRobeBLL;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.MjernaJedinica;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Skladiste;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Uposlenik;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.PoslovniPartner;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI.TrenutnoStanjeSkladistaUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

public class FormaZaUposlenika {

	public JFrame frmSistemUpravljanjaSkladitem;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTable tabelaArtikli;
	private JTable tableArtikliOtprem;
	private JTable tabelaOtpis;
	private JTable table;
	private JTextField tbOtpremBarKod;
	private JTextField tbOtpremProdajnaCijena;
	private JTextField tbBarKodOtpis;
	public JTextField tbBarKod;
	private JTextField tbNabavnaCijena;
	private JTextField tbNaziv;
	private JTextField tbJedinicnaKolicina;
	private JTextArea taKomentar;
	

	private Uposlenik _user;
	private JTextField tbNabavkaBarKod;
	private JTextField tbProdajnaCijena;
	private ButtonGroup bg;
	private JPanel panel_4;
	private JRadioButton rdbtnPostojeciArtikal;
	private JRadioButton rdbtnNoviArtikal;
	private ChangeListener changeListener;
	private JPanel pnlNovi;
	private JButton btnDodaj;
	private JComboBox cbDobavljac;
	private JLabel lblStatusmsg;
	private JSpinner spinnerKolicina;
	private JSpinner sOtpisKolicina;
	private UposlenikUnosRobeUI ui = new UposlenikUnosRobeUI();
	private UposlenikOtpisUI otp = null;

	private JPanel panel_2;
	private JPanel panel_3;
	private JComboBox comboBoxKupci;
	private JSpinner spinnerKolOtprem;
	private UposlenikOtpremanjeUI uposOtpremUI = new UposlenikOtpremanjeUI();
	
	private void groupButton() {
		bg = new ButtonGroup();
		rdbtnPostojeciArtikal = new JRadioButton("Postojeci artikal");
		rdbtnPostojeciArtikal.setFont(new Font("SansSerif", Font.PLAIN, 11));
		rdbtnPostojeciArtikal.setBounds(22, 7, 109, 23);
		panel_4.add(rdbtnPostojeciArtikal);
		
		rdbtnNoviArtikal = new JRadioButton("Novi artikal");
		rdbtnNoviArtikal.setFont(new Font("SansSerif", Font.PLAIN, 11));
		rdbtnNoviArtikal.setBounds(148, 7, 109, 23);
		panel_4.add(rdbtnNoviArtikal);
		
		bg.add(rdbtnNoviArtikal);
		bg.add(rdbtnPostojeciArtikal);
		rdbtnPostojeciArtikal.setSelected(true);
		
		spinnerKolicina = new JSpinner();
		spinnerKolicina.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinnerKolicina.setBounds(99, 66, 109, 20);
		panel_4.add(spinnerKolicina);
		
		changeListener = new ChangeListener() {
			public void stateChanged(ChangeEvent changEvent) {
				JRadioButton btn = (JRadioButton) changEvent.getSource();
				if(btn.getText().equals("Novi artikal") && btn.isSelected()) {
					pnlNovi.setVisible(true);
					btnDodaj.setVisible(false);
				}
				else if(btn.isSelected()) {
					pnlNovi.setVisible(false);
					btnDodaj.setVisible(true);
				}
			}
		};
		rdbtnNoviArtikal.addChangeListener(changeListener);
		rdbtnPostojeciArtikal.addChangeListener(changeListener);
		
	}
	public Uposlenik get_user() {
		return _user;
	}

	public void set_user(Uposlenik _user) {
		this._user = _user;
		JLabel lblUser = new JLabel(_user.getUser());
		lblUser.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblUser.setBounds(92, 7, 46, 14);
		frmSistemUpravljanjaSkladitem.getContentPane().add(lblUser);
	}

	public FormaZaUposlenika() {
		initialize();
		groupButton();
		initData();
	}

	private void initData() {
		UposlenikUnosRobeBLL getPartneri = new UposlenikUnosRobeBLL();
		List<PoslovniPartner> _partneri = getPartneri.DobaviSvePoslnovnePartnere();
		DefaultComboBoxModel cbm = new DefaultComboBoxModel();
		for(PoslovniPartner p : _partneri) {
			cbm.addElement(p.getNaziv());
		}
		cbDobavljac.setModel(cbm);
	}

	private void initialize() {
		lblStatusmsg = new JLabel("");
		frmSistemUpravljanjaSkladitem = new JFrame();
		frmSistemUpravljanjaSkladitem.setTitle("Sistem upravljanja skladištem - Radnik u skladištu");
		frmSistemUpravljanjaSkladitem.setResizable(false);
		frmSistemUpravljanjaSkladitem.setBounds(100, 100, 783, 593);
		frmSistemUpravljanjaSkladitem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSistemUpravljanjaSkladitem.getContentPane().setLayout(null);
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (tabbedPane.getSelectedIndex()==3)	{
					TrenutnoStanjeSkladistaUI tst = new TrenutnoStanjeSkladistaUI();
					tst.trenutnoStanjeSkladista(_user.get_skladiste().getNaziv(), table, lblStatusmsg);
				}
				lblStatusmsg.setText("");
			}
		});
		tabbedPane.setFont(new Font("SansSerif", Font.BOLD, 12));
		tabbedPane.setBounds(0, 28, 767, 508);
		frmSistemUpravljanjaSkladitem.getContentPane().add(tabbedPane);
		frmSistemUpravljanjaSkladitem.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		tabbedPane.addTab("Unos Robe", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bar kod: ");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblNewLabel.setBounds(72, 12, 43, 16);
		panel.add(lblNewLabel);
		
		JLabel lblDobavlja = new JLabel("Dobavljač: ");
		lblDobavlja.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblDobavlja.setBounds(61, 38, 54, 24);
		panel.add(lblDobavlja);
		
		cbDobavljac = new JComboBox();
		cbDobavljac.setBounds(125, 39, 183, 24);
		panel.add(cbDobavljac);
		
		JButton btnDodajNovogDobavljaa = new JButton("Dodaj novog dobavljača");
		btnDodajNovogDobavljaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RunForms.RunUnosPartneraForm(cbDobavljac);
			}
		});
		btnDodajNovogDobavljaa.setBounds(318, 39, 183, 25);
		panel.add(btnDodajNovogDobavljaa);
		
		JButton btnNewButton = new JButton("Završi unos");
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ui == null) ui = new UposlenikUnosRobeUI();
				ui.SetUser(_user);
				if(ui.UnosNabavke(lblStatusmsg, _user, (String)cbDobavljac.getSelectedItem(), tbNabavkaBarKod.getText()))
					cleanNabavka();
			}
		});
		btnNewButton.setBounds(516, 444, 105, 25);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(125, 247, 592, 192);
		panel.add(scrollPane);
		
		tabelaArtikli = new JTable();
		tabelaArtikli.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Bar kod", "Koli\u010Dina", "Nabavna cijena"
			}
		));
		tabelaArtikli.getColumnModel().getColumn(1).setPreferredWidth(97);
		scrollPane.setViewportView(tabelaArtikli);
		
		panel_4 = new JPanel();
		panel_4.setToolTipText("");
		panel_4.setBounds(125, 74, 291, 162);
		panel_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblBarKod = new JLabel("Bar kod: ");
		lblBarKod.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblBarKod.setBounds(45, 37, 53, 14);
		panel_4.add(lblBarKod);
		
		tbBarKod = new JTextField();
		tbBarKod.setHorizontalAlignment(SwingConstants.RIGHT);
		tbBarKod.setBounds(99, 35, 109, 20);
		panel_4.add(tbBarKod);
		tbBarKod.setColumns(10);
		
		JLabel lblKoliina_1 = new JLabel("Količina: ");
		lblKoliina_1.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblKoliina_1.setBounds(44, 68, 46, 14);
		panel_4.add(lblKoliina_1);
		
		JLabel lblNabavnaCijena = new JLabel("Nabavna cijena: ");
		lblNabavnaCijena.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblNabavnaCijena.setBounds(10, 99, 88, 14);
		panel_4.add(lblNabavnaCijena);
		
		tbNabavnaCijena = new JTextField();
		tbNabavnaCijena.setBounds(100, 97, 109, 20);
		panel_4.add(tbNabavnaCijena);
		tbNabavnaCijena.setColumns(10);
		tbNabavnaCijena.setHorizontalAlignment(SwingConstants.RIGHT);
		
		btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ui == null) ui = new UposlenikUnosRobeUI();
				ui.SetUser(_user);
				if(ui.DodajArtikal(lblStatusmsg, tabelaArtikli, tbBarKod.getText(), (Integer)spinnerKolicina.getValue(), tbNabavnaCijena.getText()))
					clearUnos();
			}
		});
		btnDodaj.setBounds(99, 128, 109, 25);
		panel_4.add(btnDodaj);
		
		
		tbNabavkaBarKod = new JTextField();
		tbNabavkaBarKod.setHorizontalAlignment(SwingConstants.RIGHT);
		tbNabavkaBarKod.setBounds(125, 11, 183, 20);
		panel.add(tbNabavkaBarKod);
		tbNabavkaBarKod.setColumns(10);
		
		JLabel lblUnosArtikla = new JLabel("Unos artikla:");
		lblUnosArtikla.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblUnosArtikla.setBounds(55, 65, 60, 24);
		panel.add(lblUnosArtikla);
		
		pnlNovi = new JPanel();
		pnlNovi.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pnlNovi.setBounds(426, 75, 291, 161);
		panel.add(pnlNovi);
		pnlNovi.setLayout(null);
		
		JLabel lblNaziv = new JLabel("Naziv: ");
		lblNaziv.setBounds(74, 7, 33, 15);
		pnlNovi.add(lblNaziv);
		lblNaziv.setFont(new Font("SansSerif", Font.PLAIN, 11));
		
		tbNaziv = new JTextField();
		tbNaziv.setBounds(117, 5, 153, 20);
		pnlNovi.add(tbNaziv);
		tbNaziv.setColumns(10);
		
		tbJedinicnaKolicina = new JTextField();
		tbJedinicnaKolicina.setHorizontalAlignment(SwingConstants.RIGHT);
		tbJedinicnaKolicina.setBounds(117, 36, 100, 20);
		pnlNovi.add(tbJedinicnaKolicina);
		tbJedinicnaKolicina.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Jedinična količina: ");
		lblNewLabel_5.setBounds(25, 38, 89, 15);
		pnlNovi.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("SansSerif", Font.PLAIN, 11));
		
		JLabel lblProdajnaCijena_1 = new JLabel("Prodajna cijena:");
		lblProdajnaCijena_1.setBounds(31, 100, 76, 15);
		pnlNovi.add(lblProdajnaCijena_1);
		lblProdajnaCijena_1.setFont(new Font("SansSerif", Font.PLAIN, 11));
		
		tbProdajnaCijena = new JTextField();
		tbProdajnaCijena.setHorizontalAlignment(SwingConstants.RIGHT);
		tbProdajnaCijena.setBounds(117, 98, 100, 20);
		pnlNovi.add(tbProdajnaCijena);
		tbProdajnaCijena.setColumns(10);
		
		JLabel lblMjernaJedinica = new JLabel("Mjerna jedinica: ");
		lblMjernaJedinica.setBounds(35, 69, 77, 15);
		pnlNovi.add(lblMjernaJedinica);
		lblMjernaJedinica.setFont(new Font("SansSerif", Font.PLAIN, 11));
		
		final JComboBox cbMjernaJedinica = new JComboBox();
		cbMjernaJedinica.setBounds(118, 67, 99, 20);
		pnlNovi.add(cbMjernaJedinica);
		cbMjernaJedinica.setModel(new DefaultComboBoxModel(MjernaJedinica.values()));
		
		JButton btnDodajNovi = new JButton("Dodaj novi");
		btnDodajNovi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ui == null) ui = new UposlenikUnosRobeUI();
				ui.SetUser(_user);
				if(ui.DodajNoviArtikal(lblStatusmsg, tabelaArtikli, tbBarKod.getText(), (Integer)spinnerKolicina.getValue(), tbNabavnaCijena.getText(), tbNaziv.getText(), tbJedinicnaKolicina.getText(),(MjernaJedinica) cbMjernaJedinica.getSelectedItem(), tbProdajnaCijena.getText()) )
					clearUnos();
			} 
		});
		btnDodajNovi.setBounds(117, 127, 100, 25);
		pnlNovi.add(btnDodajNovi);
		
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cleanNabavka();
				clearUnos();
			}
		});
		btnOdustani.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnOdustani.setBounds(628, 444, 89, 25);
		panel.add(btnOdustani);
		
		JButton btnNewButton_1 = new JButton("Naljepnice");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RunForms.RunWizardForm(null);
			}
		});
		btnNewButton_1.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnNewButton_1.setBounds(125, 445, 89, 25);
		panel.add(btnNewButton_1);
		pnlNovi.setVisible(false);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Otpremanje robe", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Kupac: ");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(60, 21, 37, 25);
		panel_1.add(lblNewLabel_1);
		
		comboBoxKupci = new JComboBox();
		comboBoxKupci.setBounds(116, 21, 200, 25);
		panel_1.add(comboBoxKupci);
		
		JButton btnDodajNovogKupca = new JButton("Dodaj novog kupca");
		btnDodajNovogKupca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UposlenikUnosPartneraUI uposUnosPartneraUI = new UposlenikUnosPartneraUI();
				RunForms.RunUnosPartneraForm(comboBoxKupci);
			}
		});
		btnDodajNovogKupca.setBounds(327, 23, 168, 23);
		panel_1.add(btnDodajNovogKupca);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 204, 742, 222);
		panel_1.add(scrollPane_1);
		
		tableArtikliOtprem = new JTable();
		tableArtikliOtprem.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Bar kod", "Naziv", "Jedini\u010Dna koli\u010Dina", "Mjerna jedinica", "Koli\u010Dina", "Prodajna cijena"
			}
		));
		scrollPane_1.setViewportView(tableArtikliOtprem);
		
		JButton btnZavriOtpremanje = new JButton("Završi otpremanje");
		btnZavriOtpremanje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String poruka = uposOtpremUI.zavrsiOtpremanje(_user, comboBoxKupci.getSelectedIndex());
				if(poruka.equals("  ")){
					DefaultTableModel dtm = (DefaultTableModel)tableArtikliOtprem.getModel();
					dtm.setRowCount(0);
				}
				lblStatusmsg.setText(poruka);
			}
		});
		btnZavriOtpremanje.setBounds(306, 443, 175, 25);
		panel_1.add(btnZavriOtpremanje);
		
		JLabel lblNewLabel_3 = new JLabel("Lista artikala: ");
		lblNewLabel_3.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(10, 180, 72, 25);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Bar kod: ");
		lblNewLabel_4.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(54, 57, 43, 14);
		panel_1.add(lblNewLabel_4);
		
		tbOtpremBarKod = new JTextField();
		tbOtpremBarKod.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				UposlenikOtpremanjeUI uposOtpremUI = new UposlenikOtpremanjeUI();
				String poruka = uposOtpremUI.dobaviProdajnuCijenu(tbOtpremProdajnaCijena, tbOtpremBarKod.getText());
				lblStatusmsg.setText(poruka);
			}
		});
		tbOtpremBarKod.setBounds(116, 55, 200, 20);
		panel_1.add(tbOtpremBarKod);
		tbOtpremBarKod.setColumns(10);
		
		tbOtpremProdajnaCijena = new JTextField();
		tbOtpremProdajnaCijena.setBounds(116, 105, 200, 20);
		panel_1.add(tbOtpremProdajnaCijena);
		tbOtpremProdajnaCijena.setColumns(10);
		
		JLabel lblKoliina = new JLabel("Količina: ");
		lblKoliina.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblKoliina.setBounds(54, 82, 43, 14);
		panel_1.add(lblKoliina);
		
		JLabel lblProdajnaCijena = new JLabel("Prodajna cijena: ");
		lblProdajnaCijena.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblProdajnaCijena.setBounds(18, 107, 79, 14);
		panel_1.add(lblProdajnaCijena);
		
		JButton btnDodajZaOtpremu = new JButton("Dodaj za otpremu");
		btnDodajZaOtpremu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String poruka = uposOtpremUI.dodajArtikalZaOtpremu(tableArtikliOtprem, tbOtpremProdajnaCijena, tbOtpremBarKod.getText(), (Integer)spinnerKolOtprem.getValue());
				lblStatusmsg.setText(poruka);
				if(poruka.equals("  "))
					ocistiPoljaUnosArtikla();
			}
		});
		btnDodajZaOtpremu.setBounds(148, 147, 168, 23);
		panel_1.add(btnDodajZaOtpremu);
		
		spinnerKolOtprem = new JSpinner();
		spinnerKolOtprem.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinnerKolOtprem.setBounds(116, 80, 200, 20);
		panel_1.add(spinnerKolOtprem);
		
		frmSistemUpravljanjaSkladitem.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{tabbedPane, panel, panel_1, panel_2, panel_3}));
		
		panel_2 = new JPanel();
		tabbedPane.addTab("Otpis robe", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 117, 742, 185);
		panel_2.add(scrollPane_2);
		
		tabelaOtpis = new JTable();
		tabelaOtpis.setModel(new DefaultTableModel(
			new Object[][] {

			},
			new String[] {
				"Bar kod", "Naziv", "Jedini\u010Dna koli\u010Dina", "Mjerna jedinica", "Koli\u010Dina", "Ponderirana cijena"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		scrollPane_2.setViewportView(tabelaOtpis);
		
		JButton btnZavriOtpis = new JButton("Završi otpis");
		btnZavriOtpis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(otp == null) {
					lblStatusmsg.setText("Niste unijeli niti jedan artikal za otpis!");
					lblStatusmsg.setForeground(Color.RED);
				}
				else 
				{
					if(taKomentar.getText() == null || taKomentar.getText().length() == 0) {
						lblStatusmsg.setText("Niste unijeli komentar!");
						lblStatusmsg.setForeground(Color.RED);
					}
					else 
					{
						if(otp.ZavrsiOtpis(lblStatusmsg,taKomentar.getText(), _user))
						CleanOtpis();
					}
				}
			}
		});
		btnZavriOtpis.setBounds(491, 444, 162, 23);
		panel_2.add(btnZavriOtpis);
		
		JLabel lblKomentar = new JLabel("Komentar: ");
		lblKomentar.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblKomentar.setBounds(10, 313, 60, 20);
		panel_2.add(lblKomentar);
		
		JLabel lblNewLabel_2 = new JLabel("Lista artikala: ");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(25, 90, 66, 23);
		panel_2.add(lblNewLabel_2);

		JLabel label = new JLabel("Bar kod: ");
		label.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label.setBounds(45, 13, 46, 14);
		panel_2.add(label);
		
		tbBarKodOtpis = new JTextField();
		tbBarKodOtpis.setHorizontalAlignment(SwingConstants.RIGHT);
		tbBarKodOtpis.setColumns(10);
		tbBarKodOtpis.setBounds(97, 11, 112, 20);
		panel_2.add(tbBarKodOtpis);
		
		JLabel label_1 = new JLabel("Količina: ");
		label_1.setFont(new Font("SansSerif", Font.PLAIN, 11));
		label_1.setBounds(45, 40, 46, 14);
		panel_2.add(label_1);
		
		JButton btnDodajZaOtpis = new JButton("Dodaj");
		btnDodajZaOtpis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(otp == null) otp = new UposlenikOtpisUI();
			    if(otp.DodajArtikalZaOtpis(lblStatusmsg, tabelaOtpis, tbBarKodOtpis.getText(), (Integer)sOtpisKolicina.getValue(), _user.get_skladiste()))
			    		cleanOtpisArtikal();
			}
		});
		btnDodajZaOtpis.setBounds(97, 69, 112, 23);
		panel_2.add(btnDodajZaOtpis);
		
		sOtpisKolicina = new JSpinner();
		sOtpisKolicina.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		sOtpisKolicina.setBounds(97, 38, 112, 20);
		panel_2.add(sOtpisKolicina);
		
		taKomentar = new JTextArea();
		taKomentar.setBounds(20, 344, 732, 89);
		panel_2.add(taKomentar);
		
		JButton btnOdustaniOtis = new JButton("Odustani");
		btnOdustaniOtis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CleanOtpis();
			}
		});
		btnOdustaniOtis.setBounds(663, 444, 89, 23);
		panel_2.add(btnOdustaniOtis);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Pregled trenutnog stanja robe", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 11, 742, 457);
		panel_3.add(scrollPane_3);
		
		table = new JTable();
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Bar-kod", "Naziv", "Koli\u010Dina", "Mjerna jedinica", "Prodajna cijena", "Ponderirana cijena"
			}
		));
		scrollPane_3.setViewportView(table);
		
		JLabel lblOdjava = new JLabel("Odjava");
		lblOdjava.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RunForms.RunPrijavaForm();
				frmSistemUpravljanjaSkladitem.dispose();
				
			}
		});
		lblOdjava.setFont(new Font("Sitka Text", Font.BOLD, 11));
		lblOdjava.setBounds(721, 7, 46, 23);
		frmSistemUpravljanjaSkladitem.getContentPane().add(lblOdjava);
		
		
		lblStatusmsg.setForeground(Color.RED);
		lblStatusmsg.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblStatusmsg.setBounds(10, 539, 757, 14);
		frmSistemUpravljanjaSkladitem.getContentPane().add(lblStatusmsg);
		
		JLabel lblDobrodosli = new JLabel("Dobrodošli:");
		lblDobrodosli.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblDobrodosli.setBounds(10, 7, 76, 14);
		frmSistemUpravljanjaSkladitem.getContentPane().add(lblDobrodosli);
		
		frmSistemUpravljanjaSkladitem.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{tabbedPane, panel, panel_1, panel_2, panel_3}));
		dodavanjePartneraUComboBox();
	}
	protected void CleanOtpis() {
		taKomentar.setText("");
		DefaultTableModel dm = (DefaultTableModel)tabelaOtpis.getModel();
		dm.setRowCount(0);
		otp = null;
		lblStatusmsg.setText("");

	}
	protected void cleanOtpisArtikal() {
		tbBarKodOtpis.setText("");
		sOtpisKolicina.setValue(1);
		lblStatusmsg.setText("");


	}
	protected void cleanNabavka() {
		tbNabavkaBarKod.setText("");
		DefaultTableModel dm = (DefaultTableModel)tabelaArtikli.getModel();
		dm.setRowCount(0);
		ui = null;
		lblStatusmsg.setText("");

	}
	protected void clearUnos() {
		tbBarKod.setText("");
		spinnerKolicina.setValue(1);
		tbNabavnaCijena.setText("");
		tbNaziv.setText("");
		tbJedinicnaKolicina.setText("");
		tbProdajnaCijena.setText("");
		lblStatusmsg.setText("");
	}
	//Metoda za dodavanje partnera u listu partnera(combobox)
		private void dodavanjePartneraUComboBox() {
			// TODO Auto-generated method stub
			UposlenikUnosPartneraBLL unosPartneraBLL = new UposlenikUnosPartneraBLL();
			List<String> naziviPartnera = unosPartneraBLL.dodavanjePartneraUComboBox()  ;
			for(String ime : naziviPartnera)
				comboBoxKupci.addItem(ime);
		}
		
		private void ocistiPoljaUnosArtikla(){
			tbOtpremBarKod.setText("");
			spinnerKolOtprem.setValue(1);
			tbOtpremProdajnaCijena.setText("");
		}
















}
