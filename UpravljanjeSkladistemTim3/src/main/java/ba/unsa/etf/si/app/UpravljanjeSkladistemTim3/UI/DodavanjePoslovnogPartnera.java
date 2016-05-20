package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL.UposlenikUnosRobeBLL;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.PoslovniPartner;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DodavanjePoslovnogPartnera {

	public JFrame frmDodavanjePoslovnogPartnera;
	private JTextField textNaziv;
	private JTextField textAdresa;
	private JTextField textJib;
	private JLabel lblStatus;
	private JComboBox cbDobavljac;
	
	private void initData() {
		UposlenikUnosRobeBLL getPartneri = new UposlenikUnosRobeBLL();
		List<PoslovniPartner> _partneri = getPartneri.DobaviSvePoslnovnePartnere();
		DefaultComboBoxModel cbm = new DefaultComboBoxModel();
		for(PoslovniPartner p : _partneri) {
			cbm.addElement(p.getNaziv());
		}
		cbDobavljac.setModel(cbm);
	}
	public void SetComboBox(JComboBox cb) {
		cbDobavljac = cb;
	}
	
	public DodavanjePoslovnogPartnera() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDodavanjePoslovnogPartnera = new JFrame();
		frmDodavanjePoslovnogPartnera.setTitle("Unos poslovnog partnera");
		frmDodavanjePoslovnogPartnera.setIconImage(Toolkit.getDefaultToolkit().getImage(DodavanjePoslovnogPartnera.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
		frmDodavanjePoslovnogPartnera.setBounds(100, 100, 347, 254);
		frmDodavanjePoslovnogPartnera.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmDodavanjePoslovnogPartnera.setLocationRelativeTo(null);
		frmDodavanjePoslovnogPartnera.getContentPane().setLayout(null);
		
		JLabel lblNaziv = new JLabel("Naziv:");
		lblNaziv.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblNaziv.setBounds(54, 49, 30, 14);
		frmDodavanjePoslovnogPartnera.getContentPane().add(lblNaziv);
		
		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblAdresa.setBounds(45, 80, 39, 14);
		frmDodavanjePoslovnogPartnera.getContentPane().add(lblAdresa);
		
		JLabel lblJib = new JLabel("JIB:");
		lblJib.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblJib.setBounds(65, 111, 19, 14);
		frmDodavanjePoslovnogPartnera.getContentPane().add(lblJib);
		
		textNaziv = new JTextField();
		textNaziv.setBounds(94, 46, 188, 20);
		frmDodavanjePoslovnogPartnera.getContentPane().add(textNaziv);
		textNaziv.setColumns(10);
		
		textAdresa = new JTextField();
		textAdresa.setBounds(94, 77, 188, 20);
		frmDodavanjePoslovnogPartnera.getContentPane().add(textAdresa);
		textAdresa.setColumns(10);
		
		textJib = new JTextField();
		textJib.setBounds(94, 108, 188, 20);
		frmDodavanjePoslovnogPartnera.getContentPane().add(textJib);
		textJib.setColumns(10);
		
		JButton btnDodaj = new JButton("Unesi");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UposlenikUnosPartneraUI uposUnosPartneraUI = new UposlenikUnosPartneraUI();
				String poruka = uposUnosPartneraUI.unosPartnera(textNaziv.getText(), textAdresa.getText(), textJib.getText());
				
				if(poruka.equals("  "))
					frmDodavanjePoslovnogPartnera.dispose();
				else
					lblStatus.setText(poruka);
				initData();
			}
		});
		btnDodaj.setBounds(193, 154, 89, 23);
		frmDodavanjePoslovnogPartnera.getContentPane().add(btnDodaj);
		
		lblStatus = new JLabel("");
		lblStatus.setForeground(Color.RED);
		lblStatus.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblStatus.setBounds(10, 190, 272, 14);
		frmDodavanjePoslovnogPartnera.getContentPane().add(lblStatus);
	}
}
