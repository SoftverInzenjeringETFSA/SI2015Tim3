package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.App;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Artikal;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Skladiste;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Uposlenik;

import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.Session;

public class UposlenikBLL {
	public static void DodajArtikal() {  }
	public static void DodajNabavku() {}
	public static void GenerisiNaljepnicu() {}
	public static void DodajNoviArtikal(Artikal ar) {}
	public static Skladiste DobaviSkladiste(Uposlenik _user) {
		Transaction t = App.session.beginTransaction();
		String hql = "from Skladiste where id = :skladiste_id";
		Query querry = App.session.createQuery(hql);
		//querry.setParameter("skladiste_id", _user.gets);
		return null;
	}
}
