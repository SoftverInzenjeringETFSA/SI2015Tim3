package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.App;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Artikal;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Otpremnica;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.PoslovniPartner;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Skladiste;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.SkladisteArtikal;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.StavkaDokumenta;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Uposlenik;

public class UposlenikOtpremanjeBLL {
	private List<Artikal> _artikliZaOtprem;
	private List<Integer> _listaKolicina;
	private List<StavkaDokumenta> _stavkeOtprema;
	
	public UposlenikOtpremanjeBLL() {
		_artikliZaOtprem = new ArrayList<Artikal>();
		_listaKolicina = new ArrayList<Integer>();
		_stavkeOtprema = new ArrayList<StavkaDokumenta>();
	}
	
	public Artikal dobaviArtikalZaOtprem(String barKod, int kolicina, double prodajnaCijena){
		Artikal a = null;

		String hql = "from Artikal where barKod = :bar_kod";
		Query query = App.session.createQuery(hql);
		query.setParameter("bar_kod", barKod);
		
		try {
		a = (Artikal)query.uniqueResult();
		//Provjera da li je artikal vec odabran za otpremanje
		for(Artikal ar : _artikliZaOtprem){
			if(a.getId() == ar.getId())
				return null;
		}
		} catch (NullPointerException e) {
			App.logger.error("Greška - artikal već postoji u bazi.", e);
		}
		
		if(!(Math.abs(prodajnaCijena - a.getProdajnaCijena()) < 0.000001))
			a.setProdajnaCijena(prodajnaCijena);
		_artikliZaOtprem.add(a);
		_listaKolicina.add(kolicina);//Kolicine za otpremanje
		
		for(StavkaDokumenta sd : _stavkeOtprema) {
			if(sd.get_artikal().getId() == a.getId())
				return null;
		}
		
		StavkaDokumenta sd = new StavkaDokumenta();
		sd.set_artikal(a);
		sd.setCijena(a.getProdajnaCijena());
		sd.setKolicina(kolicina);
		_stavkeOtprema.add(sd);
	
		
		return a;
	}
	
	public int dobaviStaruKolicinuArtikla(Long idArtikla){
		try{
			
			//Transaction t = App.session.beginTransaction();
			String hql = "from SkladisteArtikal where artikal_id = :parArtikalID";
			Query query = App.session.createQuery(hql);
			query.setParameter("parArtikalID", idArtikla);
			List<?> listaSkladisteArtikal = query.list();
			
			SkladisteArtikal sa = (SkladisteArtikal)listaSkladisteArtikal.get(0);
			int staraKolicina = sa.getKolicina();
			System.out.println("stara kolicina   " + staraKolicina);

			return staraKolicina;
		}catch(NullPointerException e){
			App.logger.error("Omaska.", e);
			return 0;
		}
	}
	
	public double dobaviProdajnuCijenu(String barKod){
		try{
			Double cijena;
			
			Transaction t = App.session.beginTransaction();
			String hql = "select prodajnaCijena from Artikal where barKod = :bar_kod";
			Query query = App.session.createQuery(hql);
			query.setParameter("bar_kod", barKod);
			cijena = (Double)query.uniqueResult();
			
			return cijena;
		}catch(NullPointerException e){
			App.logger.error("Omaska.", e);
			return 0;
		}	
	}
	
	public int zavrsiOtpremanje(Uposlenik user, int kupac){
		if(_artikliZaOtprem.isEmpty())
			return 0;
		try{
			Transaction t = App.session.beginTransaction();
			int brojac=0;
			for(Artikal a : _artikliZaOtprem){
				//Mijenjanje prodajne cijene artikla u bazi
				String hql = "update Artikal set prodajnaCijena = :novaProdajnaCijena " + 
							 "where id = :parArtikalID";
				Query query1 = App.session.createQuery(hql);
				query1.setParameter("novaProdajnaCijena", a.getProdajnaCijena());
				System.out.println("Prodajna cijena  " + a.getProdajnaCijena());
				query1.setParameter("parArtikalID", a.getId());
				query1.executeUpdate();
				
				
				//Mijenjanje kolicine artikla u tabeli skladiste_artikal
				String hql2 = "update SkladisteArtikal set kolicina = kolicina - :kolicinaZaOtprem " + 
						      "where artikal_id = :parArtikalID and " +
						      "skladiste_id = :parSkladisteId";
				Query query2 = App.session.createQuery(hql2);
				System.out.println("Kolicina za otprem "+_listaKolicina.get(brojac));
				query2.setParameter("kolicinaZaOtprem", _listaKolicina.get(brojac));
				query2.setParameter("parArtikalID", a.getId());
				query2.setParameter("parSkladisteId", user.get_skladiste().getId());
				query2.executeUpdate();
				brojac++;
			}
			
			t.commit();
			
			
			Otpremnica otp = new Otpremnica();
			otp.set_kreirao(user);
			otp.set_skladiste(user.get_skladiste());
			otp.setDatum(new Date());
			PoslovniPartner pp = App.session.load(PoslovniPartner.class, (long)(kupac+1));
			
			
			
			Transaction t2 = App.session.beginTransaction();
			Long id = (Long) App.session.save(otp);
			
			for(StavkaDokumenta sd : _stavkeOtprema) {
				sd.set_dokument(otp);
				App.session.save(sd);
			}
			t.commit();
			

			_artikliZaOtprem.clear();
			_listaKolicina.clear();
			return 1;
		}
		catch(NullPointerException e){
			App.logger.error("Omaska.", e);
			return 2;
		}
	}
}
