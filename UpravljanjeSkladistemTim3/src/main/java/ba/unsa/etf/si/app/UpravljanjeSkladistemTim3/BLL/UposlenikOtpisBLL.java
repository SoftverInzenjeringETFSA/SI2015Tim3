package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;

import java.util.ArrayList;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.App;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Artikal;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.StavkaDokumenta;

public class UposlenikOtpisBLL {
	public UposlenikOtpisBLL() {
		this._stavkeOtpisa = new ArrayList<StavkaDokumenta>();
	}
	private List<StavkaDokumenta> _stavkeOtpisa;
	
	public Artikal DajArtikal(String barKod, int kolicina) {
	Transaction t = App.session.beginTransaction();
	String hql = "from Artikal where barKod = :bar_kod";
	Query query = App.session.createQuery(hql);
	query.setParameter("bar_kod", barKod);
	
	Artikal ar = (Artikal) query.uniqueResult();
	t.commit();
	return ar;
	}

	public double DajPonderiranu(long id) {
		Transaction t = App.session.beginTransaction();
		String sql = "SELECT ponderirana_cijena FROM skladiste_artikal WHERE artikal_id =:ar_id";
		SQLQuery query = App.session.createSQLQuery(sql);
		query.setParameter("ar_id",	id);
		
		double cijena = (Double) query.uniqueResult();
		return cijena;
	}

	public void DodajZaOtpis(Artikal ar, double ponderirana) {
		// TODO Auto-generated method stub
		
	}
	
}
