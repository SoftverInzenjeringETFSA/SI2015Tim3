package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import java.awt.Component;
import java.sql.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL.MenadzerUposleniciBLL;

public class MenadzerUposleniciUI {
	private MenadzerUposleniciBLL menUposleniciBLL = new MenadzerUposleniciBLL();
			
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
		else if(prezime.equals(""))
			return "Nije uneseno prezime!";
		else if(jmbg.equals(""))
			return "Nije unesen JMBG!";
		else if(mjestoRodjenja.equals(""))
			return "Nije uneseno mjesto rodjenja!";
		else if(adresa.equals(""))
			return "Nije unesena adresa!";
		else if(telefon.equals(""))
			return "Nije unesen telefon!";
		else if(email.equals(""))
			return "Nije unesen email";
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
				JOptionPane.showMessageDialog(null, "Uspjesno ste unijeli uposlenika.");
				return "  ";//Oznaka da je uposlenik uspjesno unesen
			}
			else if(uspjesno == 2) //Oznaka da postoji uposlenik s tim maticnim brojem u bazi
				return "Uposlenik sa tim maticnim brojem vec postoji!";
			else if(uspjesno ==3) //Oznaka da postoji uposlenik sa tim username-om u bazi
				return "Uposlenik sa tim korisničkim imenom već postoji!";
			return "Uposlenik nije uspjesno unesen!";
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

}

