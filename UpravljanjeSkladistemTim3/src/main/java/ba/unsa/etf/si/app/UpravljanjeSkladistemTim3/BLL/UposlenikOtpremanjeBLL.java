package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.App;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Artikal;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.SkladisteArtikal;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.StavkaDokumenta;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Uposlenik;

public class UposlenikOtpremanjeBLL {
	private List<Artikal> _artikliZaOtprem;
	private List<Integer> _listaKolicina;
	
	public UposlenikOtpremanjeBLL() {
		_artikliZaOtprem = new ArrayList<Artikal>();
		_listaKolicina = new ArrayList<Integer>();
	}
	
	public Artikal dobaviArtikalZaOtprem(String barKod, int kolicina, double prodajnaCijena){
		Artikal a = null;

		String hql = "from Artikal where barKod = :bar_kod";
		Query query = App.session.createQuery(hql);
		query.setParameter("bar_kod", barKod);
		
		try {
		a = (Artikal)query.uniqueResult();
		} catch (NullPointerException e) {
			App.logger.error("Greška - artikal već postoji u bazi.", e);
		}

		
		if(prodajnaCijena != a.getProdajnaCijena())
			a.setProdajnaCijena(prodajnaCijena);
		_artikliZaOtprem.add(a);
		_listaKolicina.add(kolicina);//Kolicine za otpremanje
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
			System.out.println("Greska - stara kolicina");
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
			return 0;
		}	
	}
	
	public int zavrsiOtpremanje(Uposlenik user){
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
			
			
			_artikliZaOtprem.clear();
			_listaKolicina.clear();
			return 1;
		}
		catch(NullPointerException e){
			return 2;
		}
	}
}
