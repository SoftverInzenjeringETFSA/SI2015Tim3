package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.App;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.*;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI.RunForms;

import org.hibernate.Transaction;

import java.util.Date;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class UposlenikUnosRobeBLL {
	
	public UposlenikUnosRobeBLL() {
		_noviArtikli = new ArrayList<Artikal>();
		_stavkeNabavke = new ArrayList<StavkaDokumenta>();
		_skladisteArtikli = new ArrayList<SkladisteArtikal>();
	}
	private Uposlenik user2;
	public void SetUser(Uposlenik _user) {
		user2 = _user;
	}
	private List<Artikal> _noviArtikli;
	private List<StavkaDokumenta> _stavkeNabavke;
	private List<SkladisteArtikal> _skladisteArtikli;
	
	public int DodajArtikal(String ean, int kolicina, double nabavnaCijena) {
		Transaction t = App.session.beginTransaction();
		String hql = "from Artikal where barKod = :bar_kod";
		Query query = App.session.createQuery(hql);
		query.setParameter("bar_kod", ean);
		Artikal a;
		try {
		a = (Artikal)query.uniqueResult();
		} catch (NullPointerException e) {
			App.logger.error("Omaska - artikal ne postoji u bazi.", e);
			return 1;
		}
		t.commit();
		if (a == null) return 1;
		
		t = App.session.getTransaction();
		String sql = "SELECT kolicina FROM skladiste_artikal WHERE artikal_id = :ar_id && skladiste_id = :sk_id";
		SQLQuery query3 = App.session.createSQLQuery(sql);
		query3.setParameter("ar_id", a.getId());
		query3.setParameter("sk_id", user2.get_skladiste().getId());
		
		int dummy;
		try
		{
			dummy = (Integer)query3.uniqueResult();
		} catch (Exception e) 
		{
			App.logger.error("Omaska.", e);
			SkladisteArtikal sa = new SkladisteArtikal();
			sa.set_artikal(a);
			sa.set_skladiste(user2.get_skladiste());
			sa.setKolicina(0);
			sa.setPonderiranaCijena(0);
			_skladisteArtikli.add(sa);
		}
		
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
			App.logger.error("Omaska - artikal vec postoji u bazi.", e);
		}
		t.commit();
		if(a != null) return 1;
		
		for(StavkaDokumenta st:_stavkeNabavke) {
			if (st.get_artikal().getBarKod().equals(ean))
				return 2;
		}
		
		Artikal ar = new Artikal();
		ar.setBarKod(ean);
		ar.setNaziv(naziv);
		ar.setMjernaJedinica(mjernaJedinica);
		ar.setJedinicnaKolicina(jedinicnaKolicina);
		ar.setProdajnaCijena(prodajnaCijena);
		
		_noviArtikli.add(ar);
		
		StavkaDokumenta st = new StavkaDokumenta();
		st.set_artikal(ar);
		st.setCijena(nabavnaCijena);
		st.setKolicina(kolicina);
		_stavkeNabavke.add(st);
		
		SkladisteArtikal sa = new SkladisteArtikal();
		sa.set_artikal(ar);
		sa.setPonderiranaCijena(nabavnaCijena);
		sa.setKolicina(kolicina);
		_skladisteArtikli.add(sa);
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
		
		Transaction t = App.session.beginTransaction();
		String hql = "from Dokument where barKod = :bar_kod";
		Query q = App.session.createQuery(hql);
		q.setParameter("bar_kod", barKod);
		Nabavka n = null;
		try {
		n = (Nabavka)q.uniqueResult();
		} catch (NullPointerException e) {
			App.logger.error("Dokument ne postoji u bazi.", e);
		}
		t.commit();
		if(n != null) return 2;
		
		Skladiste skladiste = user.get_skladiste();
		PoslovniPartner dobavljac = this.DajPoslovnogPartnera(poslovniPartner);
		
		Nabavka nabavka = new Nabavka();
		nabavka.set_dobavaljc(dobavljac);
		nabavka.set_kreirao(user);
		nabavka.set_skladiste(skladiste);
		nabavka.setBarKod(barKod);
		nabavka.setDatum(new Date());
		nabavka.set_stavke(new HashSet<StavkaDokumenta>(_stavkeNabavke));
		
		// Unos nove nabavke u bp
		t = App.session.beginTransaction();
		Long id = (Long) App.session.save(nabavka);
		
		// Unos svih novih artikala u bp
		for(Artikal a:_noviArtikli) {
			App.session.save(a);
		}
		
		// Unos stavki nove nabavke u bp
		for(StavkaDokumenta st:_stavkeNabavke) {
			st.set_dokument(nabavka);
			App.session.save(st);
		}
		
		// Unos skladiste-artikal za nove artikle u bp
		for(SkladisteArtikal sa:_skladisteArtikli) {
			sa.set_skladiste(skladiste);
			App.session.save(sa);
		}	
		t.commit();
		t = App.session.beginTransaction();
		
		// Update ponderirane cijene za sve postojece artikle sa nove nabavke
		for(StavkaDokumenta st:_stavkeNabavke) {
			String sql1 = "SELECT kolicina FROM skladiste_artikal WHERE skladiste_id =:s_id && artikal_id = :a_id";
			SQLQuery query1 = App.session.createSQLQuery(sql1);
			query1.setParameter("s_id", skladiste.getId());
			query1.setParameter("a_id", st.get_artikal().getId());
			int stara_kolicina = (Integer) query1.uniqueResult();
		
			String sql = "UPDATE skladiste_artikal " +
						 "set ponderirana_cijena = (ponderirana_cijena * :stara_kolicina + :nova_nabavna * :nova_kolicina)/(:stara_kolicina + :nova_kolicina) " +
						 "WHERE artikal_id = :ar_id && skladiste_id = :sk_id";
			SQLQuery query = App.session.createSQLQuery(sql);
			
			query.setParameter("stara_kolicina", stara_kolicina); 	
			query.setParameter("nova_nabavna", st.getCijena());	
			query.setParameter("nova_kolicina", st.getKolicina());
			query.setParameter("sk_id", user.get_skladiste().getId());
			// Ne treba vrsiti update novih artikala, posto je njihova nabavna cijena ujedino i ponderirana
			long ar_id;
			if(_noviArtikli.contains(st.get_artikal())) ar_id = -1;
			else ar_id = st.get_artikal().getId();
			
			query.setParameter("ar_id", ar_id);
		
			int result = query.executeUpdate();
		}
		
		// Update kolicine artikala, za sve artikle sa nove nabavke
		for(StavkaDokumenta st: _stavkeNabavke) {
		// Ne treba vrsiti update kolicine za nove artikle, jer je njihova kolicina unesena pri unosu novih artikala
		long ar_id2;
		if(_noviArtikli.contains(st.get_artikal())) ar_id2 = -1;
		else ar_id2 = st.get_artikal().getId();
		
		String sql = "UPDATE skladiste_artikal set kolicina = kolicina + :kol" +
					  " WHERE artikal_id = :ar_id && skladiste_id = :s_id";
		SQLQuery query = App.session.createSQLQuery(sql);
		query.setParameter("kol", st.getKolicina());
		query.setParameter("ar_id", ar_id2);
		query.setParameter("s_id", skladiste.getId());
		
		int result = query.executeUpdate();
		}
		
		
		t.commit();

		RunForms.RunWizardForm(nabavka);
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
