package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL;

import org.hibernate.Query;
import org.hibernate.Transaction;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.App;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Nabavka;

public class NaljepnicaWizardBLL {
	public Nabavka DajNabavku(String barKod) {
		Transaction t = App.session.beginTransaction();
		String hql = "from Nabavka where barKod = :bar_kod";
		Query querry = App.session.createQuery(hql);
		querry.setParameter("bar_kod", barKod);
		
		Nabavka n = (Nabavka) querry.uniqueResult();
		return n;
	}
}
