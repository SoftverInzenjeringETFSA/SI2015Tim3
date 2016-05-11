package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.App;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.*;

import org.hibernate.Transaction;

import java.util.Date;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class UposlenikUnosRobeBLL {
	
	public UposlenikUnosRobeBLL() {}
	
	private List<Artikal> _noviArtikli = new ArrayList<Artikal>();
	private List<StavkaDokumenta> _stavkeNabavke = new ArrayList<StavkaDokumenta>();
	
	public int DodajArtikal(String ean, int kolicina, double nabavnaCijena) {
		Transaction t = App.session.beginTransaction();
		String hql = "from Artikal where barKod = :bar_kod";
		Query query = App.session.createQuery(hql);
		query.setParameter("bar_kod", ean);
		Artikal a;
		try {
		a = (Artikal)query.uniqueResult();
		} catch (NullPointerException e) {
			return 1;
		}
		t.commit();
		
		if(a == null) return 1;
		
		for(StavkaDokumenta st:_stavkeNabavke) {
			if (st.get_artikal().getBarKod().equals(ean))
				return 2;
		}
		StavkaDokumenta st = new StavkaDokumenta();
		st.setCijena(nabavnaCijena);
		st.setKolicina(kolicina);
		st.set_artikal(a);
		_stavkeNabavke.add(st);
		return 0;
	}
	
	public int DodajNoviArtikal(String ean, int kolicina, double nabavnaCijena, String naziv, MjernaJedinica mjernaJedinica, double jedinicnaKolicina, double prodajnaCijena) {
		Transaction t = App.session.beginTransaction();
		String hql = "from Artikal where barKod = :bar_kod";
		Query query = App.session.createQuery(hql);
		query.setParameter("bar_kod", ean);
		Artikal a = null;
		try {
		a = (Artikal)query.uniqueResult();
		} catch (NullPointerException e) {
		}
		t.commit();
		if(a != null) return 1;
		
		for(StavkaDokumenta st:_stavkeNabavke) {
			if (st.get_artikal().getBarKod().equals(ean))
				return 2;
		}
		
		Artikal ar = new Artikal();
		ar.setBarKod(ean);
		// na pocetku je kolicina = 0, kolicinu cemo azurirati prilikom unosa stavki narudzbe
		ar.setKolicina(0);
		ar.setNaziv(naziv);
		ar.setMjernaJedinica(mjernaJedinica);
		ar.setJedinicnaKolicina(jedinicnaKolicina);
		ar.setProdajnaCijena(prodajnaCijena);
		
		_noviArtikli.add(ar);
		
		StavkaDokumenta st = new StavkaDokumenta();
		// moze biti kriticno
		st.set_artikal(ar);
		st.setCijena(nabavnaCijena);
		st.setKolicina(kolicina);
		_stavkeNabavke.add(st);
		return 0;
	}
	
	// Vraca poslovnog partnera na osnovu naziva
	public PoslovniPartner DajPoslovnogPartnera(String poslovniPartner) {
		Transaction t = App.session.beginTransaction();
		String hql = "from PoslovniPartner where naziv = :naziv_pp";
		Query query = App.session.createQuery(hql);
		query.setParameter("naziv_pp", poslovniPartner);
		
		PoslovniPartner pp = (PoslovniPartner) query.uniqueResult();
		t.commit();
		
		return pp;
	}
	
	public int DodajNabavku(String barKod, Uposlenik user, String poslovniPartner) {
		if(_stavkeNabavke.isEmpty() && _noviArtikli.isEmpty())
			return 1;
		
		Skladiste skladiste = user.get_skladiste();
		PoslovniPartner dobavljac = this.DajPoslovnogPartnera(poslovniPartner);
		
		Nabavka nabavka = new Nabavka();
		nabavka.set_dobavaljc(dobavljac);
		nabavka.set_kreirao(user);
		nabavka.set_skladiste(skladiste);
		nabavka.setBarKod(barKod);
		nabavka.setDatum(new Date());
		nabavka.set_stavke(new HashSet<StavkaDokumenta>(_stavkeNabavke));
		// Kriticno
		Transaction t = App.session.beginTransaction();
		Long id = (Long) App.session.save(nabavka);
		
		for(Artikal a:_noviArtikli) {
			App.session.save(a);
		}
		for(StavkaDokumenta st:_stavkeNabavke) {
			st.set_dokument(nabavka);
			App.session.save(st);
		}
			
		/*
		
		for(StavkaDokumenta st: _stavkeNabavke) {
		String hql = "UPDATE Artikal set kolicina = kolicina + :kol" +
					  "WHERE id = :ar_id";
		Query query = App.session.createQuery(hql);
		query.setParameter("kol", st.getKolicina());
		query.setParameter("ar_id", st.get_artikal().getId());
		
		int result = query.executeUpdate();
		
		}*/
		t.commit();

		_stavkeNabavke = new ArrayList<StavkaDokumenta>();
		_noviArtikli = new ArrayList<Artikal>();
		
		// to be implemented
		GenerisiNaljepnicu();
		return 0;
	}
	public void GenerisiNaljepnicu() {}
	
	// Dobavljanje skladista u kojem je radnik zaposlen 
	public Skladiste DobaviSkladiste(Uposlenik _user) {
		Transaction t = App.session.beginTransaction();
		Skladiste s = (Skladiste) App.session.get(Skladiste.class, (long)_user.get_skladiste().getId());
		t.commit();
		return s;
	}
	
	// Dobavi sve poslnove partnere -> combobox dobavljac
	public List<PoslovniPartner> DobaviSvePoslnovnePartnere() {
		List<PoslovniPartner> partneri = new ArrayList<PoslovniPartner>();
		
		Transaction t = App.session.beginTransaction();
		String hql = "from PoslovniPartner";
		Query querry = App.session.createQuery(hql);
		partneri = querry.list();	
		t.commit();
		
		return partneri;
	}
}
