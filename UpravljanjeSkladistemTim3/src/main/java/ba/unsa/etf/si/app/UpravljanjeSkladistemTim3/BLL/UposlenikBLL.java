package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.App;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Artikal;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Skladiste;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Uposlenik;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.PoslovniPartner;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.SkladisteArtikal;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.StavkaDokumenta;

import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class UposlenikBLL {
	public static List<Artikal> _noviArtikli = new ArrayList<Artikal>();
	public static List<SkladisteArtikal> _stariArtikli = new ArrayList<SkladisteArtikal>();
	public static List<StavkaDokumenta> _stavkeNabavke = new ArrayList<StavkaDokumenta>();
	
	public static boolean DodajArtikal(String ean, int kolicina, double nabavnaCijena) {
		Transaction t = App.session.beginTransaction();
		String hql = "from Artikal where barKod = :bar_kod";
		Query query = App.session.createQuery(hql);
		query.setParameter("bar_kod", ean);
		try {
		Artikal a = (Artikal)query.uniqueResult();
		} catch (NullPointerException e) {
			return false;
		}
		
		StavkaDokumenta st = new StavkaDokumenta();
		st.setCijena(nabavnaCijena);
		st.setKolicina(kolicina);
		_stavkeNabavke.add(st);
		return true;
	}
	
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
		String hql = "from PoslovniPartner";
		Query querry = App.session.createQuery(hql);
		partneri = querry.list();	
		t.commit();
		
		return partneri;
	}
}
