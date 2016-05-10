package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.App;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Artikal;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Skladiste;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Uposlenik;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.PoslovniPartner;

import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class UposlenikBLL {
	public static void DodajArtikal() {  }
	public static void DodajNabavku() {}
	public static void GenerisiNaljepnicu() {}
	public static void DodajNoviArtikal(Artikal ar) {}
	
	// Dobavljanje skladista u kojem je radnik zaposlen 
	// Pronaci pravi event
	public static Skladiste DobaviSkladiste(Uposlenik _user) {
		Transaction t = App.session.beginTransaction();
		Skladiste s = (Skladiste) App.session.get(Skladiste.class, (long)_user.get_skladiste().getId());
		t.commit();
		return s;
	}
	
	// Dobavi sve poslnove partnere -> combobox dobavljac
	public static List<PoslovniPartner> DobaviSvePoslnovnePartnere() {
		List<PoslovniPartner> partneri = new ArrayList<PoslovniPartner>();
		
		Transaction t = App.session.beginTransaction();
		String hql = "from poslovni_partner";
		Query querry = App.session.createQuery(hql);
		partneri = querry.list();	
		
		return partneri;
	}
}
