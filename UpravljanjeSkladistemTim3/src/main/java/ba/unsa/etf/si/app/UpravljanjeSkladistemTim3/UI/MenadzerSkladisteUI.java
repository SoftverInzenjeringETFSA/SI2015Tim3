package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import javax.swing.JOptionPane;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL.PrijavaBLL;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.TipUposlenika;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Uposlenik;

import java.awt.Color;
import java.util.regex.Pattern;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MenadzerSkladisteUI {
	private static final String Telefon_PATTERN1 = "([0][6][1-6][0-9]{6})";
	private static final String Telefon_PATTERN2 = "([0][6][0][0-9]{7})";
	private static final String Telefon_PATTERN3 = "([0][3][3][0-9]{6})";
	
	public MenadzerSkladisteUI() { }
	
	public static boolean DodajSkladiste(JLabel status, String naziv, String adresa, Integer radnoVrijemeOd, Integer radnoVrijemeDo, String telefon) {
		
		// Provjera da li su svi podaci uneseni
		if(naziv.equals("")) {
			JOptionPane.showMessageDialog(null, "Niste unijeli naziv skladista!", "Omaška", JOptionPane.ERROR_MESSAGE);
			status.setForeground(Color.RED);
			return false;
		}
		else if(adresa.equals("")) {
			JOptionPane.showMessageDialog(null, "Niste unijeli adresu skladista!", "Omaška", JOptionPane.ERROR_MESSAGE);
			status.setForeground(Color.RED);
			return false;
		}
		else if(telefon.equals("")) {
			JOptionPane.showMessageDialog(null, "Niste unijeli telefon(kontakt) skladista!", "Omaška", JOptionPane.ERROR_MESSAGE);
			status.setForeground(Color.RED);
			return false;
		}
		
		// Provjera da li je radno vrijeme zatvaranja vece od radnog vremena otvaranja
		if(radnoVrijemeDo < radnoVrijemeOd) {
			JOptionPane.showMessageDialog(null, "Radno vrijeme ne smije zavrsiti prije nego pocne!", "Omaška", JOptionPane.ERROR_MESSAGE);
			status.setForeground(Color.RED);
			return false;
		}
		
		// Provjera da li je telefon u ispravnom formatu
		Pattern patern1 = Pattern.compile(Telefon_PATTERN1);
		Pattern patern2 = Pattern.compile(Telefon_PATTERN2);
		Pattern patern3 = Pattern.compile(Telefon_PATTERN3);

		if(!(patern1.matcher(telefon).matches() || patern2.matcher(telefon).matches() || patern1.matcher(telefon).matches())) {
			JOptionPane.showMessageDialog(null, "Telefon mora biti u ispravnom formatu!\n" +
												"033XXXXXX\n" +
												"060XXXXXXX\n" +
					                            "06(1-6)XXXXXX", "Omaška", JOptionPane.ERROR_MESSAGE);
			status.setForeground(Color.RED);
			return false;
		}
		
		// Provjera da li naziv i adresa ne pocinju sa brojem
		if(naziv.charAt(0) >= '0' && naziv.charAt(0) <= '9') {
			JOptionPane.showMessageDialog(null, "Naziv ne smije pocinjati sa brojem!", "Omaška", JOptionPane.ERROR_MESSAGE);
			status.setForeground(Color.RED);
			return false;
		}
		if(adresa.charAt(0) >= '0' && adresa.charAt(0) <= '9') {
			JOptionPane.showMessageDialog(null, "Adresa ne smije pocinjati sa brojem!", "Omaška", JOptionPane.ERROR_MESSAGE);
			status.setForeground(Color.RED);
			return false;
		}
		
		status.setForeground(Color.GREEN);
		return true;
	}		
	
	public boolean IzbrisiSkladiste(JLabel status, String naziv, String adresa, Integer radnoVrijemeOd, Integer radnoVrijemeDo, String telefon) {
		return true;
	}
}

