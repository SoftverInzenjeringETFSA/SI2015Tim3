package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import javax.swing.JOptionPane;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL.PrijavaBLL;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.TipUposlenika;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Uposlenik;

import javax.swing.Icon;
import javax.swing.JFrame;


public class PrijavaUI {
	public PrijavaUI(JFrame prijavaForma, String user, String pass) {
		// Provjera da li su svi podaci uneseni
		if(user.equals("") || pass.equals("")) {
			JOptionPane.showMessageDialog(null, "Niste unijeli sve podatke!", "Omaška", JOptionPane.ERROR_MESSAGE);
			return;
		}
		// Autorizacija
		else {
			PrijavaBLL bll = new PrijavaBLL();
			Uposlenik _user = bll.Autorizacija(user, pass);
			if(_user == null || !_user.getPassword().equals(pass)) {
				JOptionPane.showMessageDialog(null, "Unesena kombinacija user-pass ne postoji u bazi!", "Omaška", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(_user.getTipUposlenika().equals(TipUposlenika.Menadzer)) {
				RunForms.RunMenadzerForm(_user);
				prijavaForma.dispose();
			}
			else {
				prijavaForma.dispose();
				RunForms.RunUposlenikForm(_user);
			}
		}
	}		
}

