package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.App;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.*;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI.*;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.SQLQuery;


public class TrenutnoStanjeSkladistaBLL {

	public List<Artikal> dajTrenutnoStanje(String skladiste) {
		String hq1 = "from Skladiste where naziv = :naziv_pp";
		Query query = App.session.createQuery(hq1);
		query.setParameter("naziv_pp", skladiste);
		List<Artikal> artikliNaStanju = new ArrayList<Artikal>();
		try {
			Skladiste ss = (Skladiste) query.uniqueResult();
			
			for (SkladisteArtikal sa: ss.get_skladisteArtikli()){
				artikliNaStanju.add(sa.get_artikal());
			}
		}
		catch(NullPointerException e){
			App.logger.error("Omaska", e);
		}
		return artikliNaStanju;
	}
	
	public List<Skladiste> dajSkladista(){
		String hq1 = "from Skladiste";
		Query query = App.session.createQuery(hq1);
		List<Skladiste> skladista = new ArrayList<Skladiste>();
		try {
			skladista = (List<Skladiste>) query.list();
		}
		catch(NullPointerException e){
			App.logger.error("Omaska", e);
		}
		return skladista;
	}
	
	public Skladiste dajSkladiste (String skladiste){
		Skladiste s = new Skladiste();
		
		String hq1 = "from Skladiste where naziv = :naziv_pp";
		Query query = App.session.createQuery(hq1);
		query.setParameter("naziv_pp", skladiste);
		try {
			s = (Skladiste) query.uniqueResult();
		}
		catch(NullPointerException e){
			App.logger.error("Omaska - skladiste ne postoji u bazi.", e);
		}
		
		return s;
	}
	
	public double DajPonderiranu(long artikal_id, long skladiste_id) {
		String sql = "SELECT ponderirana_cijena FROM skladiste_artikal WHERE artikal_id =:ar_id && skladiste_id = :sk_id";
		SQLQuery query = App.session.createSQLQuery(sql);
		query.setParameter("ar_id",	artikal_id);
		query.setParameter("sk_id", skladiste_id);
		
		double cijena = (Double) query.uniqueResult();
		return cijena;
	}
	
	public int DajKolicinu(long artikal_id, long skladiste_id) {
		String sql = "SELECT kolicina FROM skladiste_artikal WHERE artikal_id =:ar_id && skladiste_id = :sk_id";
		SQLQuery query = App.session.createSQLQuery(sql);
		query.setParameter("ar_id", artikal_id);
		query.setParameter("sk_id", skladiste_id);
		int kolicina = (Integer) query.uniqueResult();
		
		return kolicina;
	}
}
