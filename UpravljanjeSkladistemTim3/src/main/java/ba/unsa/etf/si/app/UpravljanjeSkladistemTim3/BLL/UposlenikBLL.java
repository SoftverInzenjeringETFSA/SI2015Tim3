package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.App;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Artikal;
import org.hibernate.Transaction;
import org.hibernate.*;

public class UposlenikBLL {
	public static void DodajArtikal() {  }
	public static void DodajNabavku() {}
	public static void GenerisiNaljepnicu() {}
	public static void DodajNoviArtikal(Artikal ar) {
		Transaction t = App.session.beginTransaction();
		
		Long id = (Long) App.session.save(ar);
		t.commit();
		
	}
}
