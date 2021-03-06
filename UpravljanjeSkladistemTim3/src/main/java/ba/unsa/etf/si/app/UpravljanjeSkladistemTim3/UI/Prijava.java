package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Window.Type;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Prijava {

	public JFrame frmPrijava;
	private JTextField tbUser;
	private JPasswordField tbSifra;

	public Prijava() {
		initialize();
	}

	private void initialize() {
		frmPrijava = new JFrame();
		frmPrijava.setResizable(false);
		frmPrijava.setIconImage(Toolkit.getDefaultToolkit().getImage(Prijava.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		frmPrijava.setTitle("Prijava");
		frmPrijava.setBounds(100, 100, 350, 232);
		frmPrijava.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrijava.getContentPane().setLayout(null);
		frmPrijava.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Dobrodo\u0161li!");
		lblNewLabel.setBounds(86, 46, 150, 25);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 18));
		frmPrijava.getContentPane().add(lblNewLabel);
		
		JLabel lblKorisnikoIme = new JLabel("Korisni\u010Dko ime:");
		lblKorisnikoIme.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblKorisnikoIme.setBounds(27, 82, 98, 25);
		lblKorisnikoIme.setHorizontalAlignment(SwingConstants.RIGHT);
		frmPrijava.getContentPane().add(lblKorisnikoIme);
		
		JLabel lblifra = new JLabel("\u0160ifra:");
		lblifra.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblifra.setBounds(93, 118, 32, 25);
		frmPrijava.getContentPane().add(lblifra);
		
		tbUser = new JTextField();
		tbUser.setBounds(135, 85, 161, 20);
		frmPrijava.getContentPane().add(tbUser);
		tbUser.setColumns(10);
		
		JButton btnNewButton = new JButton("Potvrdi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PrijavaUI prijava = new PrijavaUI(frmPrijava, tbUser.getText(), tbSifra.getText());
			}
		});
		btnNewButton.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 11));
		btnNewButton.setBounds(212, 152, 84, 23);
		frmPrijava.getContentPane().add(btnNewButton);
		
		tbSifra = new JPasswordField();
		tbSifra.setBounds(135, 121, 161, 20);
		frmPrijava.getContentPane().add(tbSifra);
	}
}
