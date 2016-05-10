package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import java.awt.Component;
import java.sql.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL.MenadzerUposleniciBLL;

public class MenadzerUI {
	public static String dodajUposlenika(JFrame formaMenadzer, String ime, String prezime, String jmbg,
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
			MenadzerUposleniciBLL.DodajUposlenika(ime, prezime, jmbg,
					datumRodjenja, mjestoRodjenja, adresa, telefon, email,
					strucnaSprema, tipUposlenika, user, pass, skladiste);
			
		}

		return "";	
	}
}
