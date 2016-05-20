package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL;

import java.util.List;

import javax.management.QueryEval;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Date;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.App;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Artikal;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Otpisnica;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.StavkaDokumenta;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Uposlenik;

public class UposlenikOtpisBLL {
	public UposlenikOtpisBLL() {
		this._stavkeOtpisa = new ArrayList<StavkaDokumenta>();
	}
	private List<StavkaDokumenta> _stavkeOtpisa;
	
	public Artikal DajArtikal(String barKod) {
	Transaction t = App.session.beginTransaction();
	String hql = "from Artikal where barKod = :bar_kod";
	Query query = App.session.createQuery(hql);
	query.setParameter("bar_kod", barKod);
	
	Artikal ar = (Artikal) query.uniqueResult();
	t.commit();
	return ar;
	}

	public double DajPonderiranu(long artikal_id, long skladiste_id) {
		Transaction t = App.session.beginTransaction();
		String sql = "SELECT ponderirana_cijena FROM skladiste_artikal WHERE artikal_id =:ar_id && skladiste_id = :sk_id";
		SQLQuery query = App.session.createSQLQuery(sql);
		query.setParameter("ar_id",	artikal_id);
		query.setParameter("sk_id", skladiste_id);
		double cijena = 0;
		try {
		cijena = (Double) query.uniqueResult();
		} catch(Exception e) {
			App.logger.error("Omaska", e);
		}
		return cijena;
	}

	public boolean DodajZaOtpis(Artikal ar, double ponderirana, int kolicina) {
		for(StavkaDokumenta sd:_stavkeOtpisa) {
			if(sd.get_artikal().getId() == ar.getId())
				return false;
		}
		StavkaDokumenta sd = new StavkaDokumenta();
		sd.set_artikal(ar);
		sd.setCijena(ponderirana);
		sd.setKolicina(kolicina);
		_stavkeOtpisa.add(sd);
		return true;
	}

	public int DajKolicinu(long artikal_id, long skladiste_id) {
		Transaction t = App.session.beginTransaction();
		String sql = "SELECT kolicina FROM skladiste_artikal WHERE artikal_id =:ar_id && skladiste_id = :sk_id";
		SQLQuery query = App.session.createSQLQuery(sql);
		query.setParameter("ar_id", artikal_id);
		query.setParameter("sk_id", skladiste_id);
		
		int kolicina = 0;
		try {
		kolicina = (Integer) query.uniqueResult();
		} catch (Exception e) {
			App.logger.error("Omaska", e);
		}
		
		return kolicina;
	}

	public int ZavrsiOtpis(String komentar, Uposlenik user) {
		if(_stavkeOtpisa.isEmpty()) return 1;
		
		Otpisnica otp = new Otpisnica();
		otp.set_kreirao(user);
		otp.set_skladiste(user.get_skladiste());
		otp.setDatum(new Date());
		otp.setRazlogOtpisa(komentar);
		
		Transaction t = App.session.beginTransaction();
		Long id = (Long) App.session.save(otp);
		
		
		for(StavkaDokumenta sd:_stavkeOtpisa) {
			sd.set_dokument(otp);
			App.session.save(sd);
		}
		t.commit();
		
		t = App.session.beginTransaction();
		for(StavkaDokumenta sd:_stavkeOtpisa) {
			
		String sql = "UPDATE skladiste_artikal set kolicina = kolicina - :kol WHERE artikal_id =:ar_id && skladiste_id = :sk_id";
		SQLQuery query = App.session.createSQLQuery(sql);
		query.setParameter("ar_id", sd.get_artikal().getId());
		query.setParameter("sk_id", user.get_skladiste().getId());
		query.setParameter("kol", sd.getKolicina());
		query.executeUpdate();
		}
		t.commit();
		return 0;
	}
}
