package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import javax.swing.JOptionPane;

import org.hibernate.Query;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.App;

import java.awt.Color;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JLabel;


public class MenadzerSkladisteUI {
	private static final String Telefon_PATTERN1 = "([0][6][1-6][0-9]{6})";
	private static final String Telefon_PATTERN2 = "([0][6][0][0-9]{7})";
	private static final String Telefon_PATTERN3 = "([0][3][3][0-9]{6})";
	
	public MenadzerSkladisteUI() { }
	
	public boolean DodajSkladiste(JLabel status, String naziv, String adresa, Integer radnoVrijemeOd, Integer radnoVrijemeDo, String telefon) {
		
		// Provjera da li su svi podaci uneseni
		if(naziv.equals("")) {
			status.setText("Niste unijeli naziv skladista!");
			status.setForeground(Color.RED);
			return false;
		}
		else if(adresa.equals("")) {
			status.setText("Niste unijeli adresu skladista!");
			status.setForeground(Color.RED);
			return false;
		}
		else if(telefon.equals("")) {
			status.setText("Niste unijeli telefon(kontakt) skladista!");
			status.setForeground(Color.RED);
			return false;
		}
		
		// Provjera da li je radno vrijeme zatvaranja vece od radnog vremena otvaranja
		if(radnoVrijemeDo < radnoVrijemeOd) {
			status.setText("Radno vrijeme ne smije zavrsiti prije nego pocne!");
			status.setForeground(Color.RED);
			return false;
		}
		
		// Provjera da li je telefon u ispravnom formatu
		Pattern patern1 = Pattern.compile(Telefon_PATTERN1);
		Pattern patern2 = Pattern.compile(Telefon_PATTERN2);
		Pattern patern3 = Pattern.compile(Telefon_PATTERN3);

		if(!(patern1.matcher(telefon).matches() || patern2.matcher(telefon).matches() || patern3.matcher(telefon).matches())) {
			JOptionPane.showMessageDialog(null, "Telefon mora biti u ispravnom formatu!\n" +
												"033XXXXXX\n" +
												"060XXXXXXX\n" +
					                            "06(1-6)XXXXXX", "Greška", JOptionPane.ERROR_MESSAGE);
			status.setForeground(Color.RED);
			return false;
		}
		
		// Provjera da li naziv i adresa ne pocinju sa brojem
		if(naziv.charAt(0) >= '0' && naziv.charAt(0) <= '9') {
			status.setText("Naziv ne smije pocinjati sa brojem!");
			status.setForeground(Color.RED);
			return false;
		}
		if(adresa.charAt(0) >= '0' && adresa.charAt(0) <= '9') {
			status.setText("Adresa ne smije pocinjati sa brojem!");
			status.setForeground(Color.RED);
			return false;
		}
		
		String query = "from Skladiste where naziv= :naziv";
		Query q = App.session.createQuery(query);
		q.setParameter("naziv", naziv);
		List<?> result = q.list();
		if(!result.isEmpty()) {
			status.setText("Skladište sa unesenim nazivom vec postoji!");
			status.setForeground(Color.RED);
			return false;
		}
		
		status.setText("");
		status.setForeground(Color.GREEN);
		return true;
	}		
	
	public boolean IzbrisiSkladiste(JLabel status, String naziv) {
		return true;
	}
}

