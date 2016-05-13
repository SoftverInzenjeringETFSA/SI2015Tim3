package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.App;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.PoslovniPartner;

public class UposlenikUnosPartneraBLL {
	public int unosPoslovnogPartnera(String naziv, String adresa, String jib){
		try{
			if(postojiPartnerUBaziIme(naziv))
				return 2;
			if(postojiPartnerUBaziJib(jib))
				return 3;
			Transaction t = App.session.beginTransaction();
			PoslovniPartner pp = new PoslovniPartner();
			pp.setNaziv(naziv);
			pp.setAdresa(adresa);
			pp.setJIB(jib);
			
			App.session.save(pp);
			t.commit();
			return 1;
		}
		catch(HibernateException e){
			return 0;
		}
	}
	
	private boolean postojiPartnerUBaziIme(String naziv){
		String query = "from PoslovniPartner where naziv= :partnerNaziv";
		Query q = App.session.createQuery(query);
		q.setParameter("partnerNaziv", naziv);
		List<?> result = q.list();
		if(!result.isEmpty())
			return true;
		return false;
	}
	
	private boolean postojiPartnerUBaziJib(String jib){
		String query = "from PoslovniPartner where naziv= :partnerJib";
		Query q = App.session.createQuery(query);
		q.setParameter("partnerJib", jib);
		List<?> result = q.list();
		if(!result.isEmpty())
			return true;
		return false;
	}
}
