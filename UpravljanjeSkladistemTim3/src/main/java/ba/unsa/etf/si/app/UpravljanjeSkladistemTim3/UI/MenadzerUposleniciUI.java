package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import java.awt.Color;
import java.awt.Component;
import java.sql.Date;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL.MenadzerUposleniciBLL;

public class MenadzerUposleniciUI {
	private MenadzerUposleniciBLL menUposleniciBLL = new MenadzerUposleniciBLL();
	private final String Telefon_PATTERN1 = "([0][6][1-6][0-9]{6})";
	private final String Telefon_PATTERN2 = "([0][6][0][0-9]{7})";
	private final String Telefon_PATTERN3 = "([0][3][3][0-9]{6})";
	private static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
			
	public String dodajUposlenika(JFrame formaMenadzer, String ime, String prezime, String jmbg,
			java.util.Date datumRodjenja, String mjestoRodjenja, String adresa, String telefon, String email,
			int strucnaSprema, int tipUposlenika, String user, String pass, int skladiste) {
		// TODO Auto-generated method stub
		//Provjera da li su polja prazna

		/*if(ime.equals("") || prezime.equals("")|| jmbg.equals("") || mjestoRodjenja.equals("") || adresa.equals("")
				|| telefon.equals("") || email.equals("") || strucnaSprema==-1 || skladiste==-1){
			JOptionPane.showMessageDialog(null, "Niste unijeli ime!", "Greška!", JOptionPane.ERROR_MESSAGE);
			return;
			//((JLabel)c).setText("Nije uneseno ime!");
		}*/
		
		if(ime.equals(""))
			return "Nije uneseno ime!";
		else if(!ime.matches("^[A-Z][a-z]*$"))
			return "Nije ispravno ime!";
		else if(prezime.equals(""))
			return "Nije uneseno prezime!";
		else if(!prezime.matches("^[A-Z][a-z]*$"))
			return "Nije ispravno prezime!";
		else if(jmbg.equals(""))
			return "Nije unesen JMBG!";
		else if(!jmbg.matches("^[0-9]*$") || jmbg.length() != 13 )
			return "JMBG mora imati 13 cifara!";
		else if(validacijaDatumRodjenja(datumRodjenja)>0)
			return "Datum rođenja nije ispravan!";
		else if(mjestoRodjenja.equals(""))
			return "Nije uneseno mjesto rođenja!";
		else if(!mjestoRodjenja.matches("^[A-Z][a-z]*$"))
			return "Nije ispravno mjesto rođenja!";
		else if(adresa.equals(""))
			return "Nije unesena adresa!";
		else if(!adresa.matches("^[A-Z][a-z]*$"))
			return "Nije ispravna adresa";
		else if(telefon.equals(""))
			return "Nije unesen telefon!";
		else if(!validacijaTelefon(telefon))
			return "Nije ispravan telefon!";
		else if(email.equals(""))
			return "Nije unesen email";
		else if(!validacijaEmail(email))
			return "Nije ispravan email!";
		else if(user.equals(""))
			return "Nije uneseno korisničko ime!";
		else if(pass.equals(""))
			return "Nije unesena korisnička šifra";
		else
		{
			int uspjesno = menUposleniciBLL.dodajUposlenika(ime, prezime, jmbg,
					datumRodjenja, mjestoRodjenja, adresa, telefon, email,
					strucnaSprema, tipUposlenika, user, pass, skladiste);
			if(uspjesno == 1){
				JOptionPane.showMessageDialog(null, "Uspješno ste unijeli uposlenika.");
				return "  ";//Oznaka da je uposlenik uspjesno unesen
			}
			else if(uspjesno == 2) //Oznaka da postoji uposlenik s tim maticnim brojem u bazi
				return "Uposlenik sa tim matičnim brojem već postoji!";
			else if(uspjesno ==3) //Oznaka da postoji uposlenik sa tim username-om u bazi
				return "Uposlenik sa tim korisničkim imenom već postoji!";
			
			JOptionPane.showMessageDialog(null, "Uposlenik nije uspješno unesen!", "Greška", JOptionPane.ERROR_MESSAGE);
			return "";
		}	
	}

	public String obrisiUposlenika(int indeksReda, String jmbg) {
		// TODO Auto-generated method stub
		if(indeksReda == -1)
			return "Nije odabran nijedan uposlenik!";
		int potvrda = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite obrisati uposlenika?",
				"Brisanje uposlenika", JOptionPane.YES_NO_OPTION);

		/*parentComponent - determines the Frame in which the dialog is displayed; 
		 * if null, or if the parentComponent has no Frame, a default Frame is 
		 * usedmessage - the Object to displaytitle - the title string for the
		 *  dialogoptionType - an int designating the options available on the 
		 *  dialog: YES_NO_OPTION, YES_NO_CANCEL_OPTION, or OK_CANCEL_OPTION*/
		if(potvrda == 0){
			//Brisanje
			boolean uspjesno = menUposleniciBLL.obrisiUposlenika(jmbg);
			if(uspjesno){
				JOptionPane.showMessageDialog(null, "Uspjesno ste izbrisali uposlenika.");
				return "  ";//Oznaka da je uposlenik uspjesno izbrisan
			}
			return "Uposlenik nije uspjesno izbrisan!";
		}
			//nije brisanje
		return "";
	}
	
	private boolean validacijaTelefon(String telefon){
		Pattern patern1 = Pattern.compile(Telefon_PATTERN1);
		Pattern patern2 = Pattern.compile(Telefon_PATTERN2);
		Pattern patern3 = Pattern.compile(Telefon_PATTERN3);

		if(!(patern1.matcher(telefon).matches() || patern2.matcher(telefon).matches() || patern3.matcher(telefon).matches())) {
			JOptionPane.showMessageDialog(null, "Telefon mora biti u ispravnom formatu!\n" +
												"033XXXXXX\n" +
												"060XXXXXXX\n" +
					                            "06(1-6)XXXXXX", "Greška", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	public boolean validacijaEmail(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
	}
	
	private int validacijaDatumRodjenja(java.util.Date datumRodjenja){
		/*Calendar cal = Calendar.getInstance();
		Date today = (Date) cal.getTime();
		cal.add(Calendar.YEAR, -18);
		Date pravi = (Date) cal.getTime();
		int uslov = datumRodjenja.compareTo(pravi);
		return uslov;*/
		
		Calendar c = Calendar.getInstance();
		c.add(Calendar.YEAR, -18);

		JDateChooser chooser = new JDateChooser(c.getTime());
		int uslov = datumRodjenja.compareTo(chooser.getDate());
		return uslov;
	}

}

