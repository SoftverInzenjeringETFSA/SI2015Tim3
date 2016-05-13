package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.App;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.*;

import org.hibernate.Transaction;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Criteria;
import org.hibernate.Query;

public class MenadzerSkladisteBLL {

	public static void DodajSkladiste(String naziv, String adresa, Integer radnoVrijemeOd, Integer radnoVrijemeDo, String telefon) {
		
		Transaction t = App.session.beginTransaction();

		Skladiste skladiste = new Skladiste();
		skladiste.setNaziv(naziv);
		skladiste.setAdresa(adresa);
		skladiste.setRadnoVrijemeDo(radnoVrijemeDo);
		skladiste.setRadnoVrijemeOd(radnoVrijemeOd);
		skladiste.setKontaktTelefon(telefon);
		
		Long id = (Long) App.session.save(skladiste);
		JOptionPane.showMessageDialog(null, "Dodano skladiste sa IDom "+id+"!","Info", JOptionPane.INFORMATION_MESSAGE);
		
		t.commit();
	}
	
	
	public static List<Skladiste> PopuniSkladista() {
		
		Transaction t = App.session.beginTransaction();

		String hql = "from Skladiste";

		Query query = App.session.createQuery(hql);
		
		List<Skladiste> lista = query.list();
		
		return lista;
		}
		
	public static int obrisiSkladiste(int id) {
		
		Transaction t = App.session.beginTransaction();
		
		Skladiste s = (Skladiste) App.session.get(Skladiste.class, id);
		
		for(Dokument d:s.get_dokumenti()) {
			String hql = "DELETE from Dokument WHERE dokument_id = :id";
			Query query = App.session.createQuery(hql);
			query.setParameter("id", d.getId());
			
			int result = query.executeUpdate();
		}
		
		for(Uposlenik u:s.get_uposlenici()) {
			String hql = "DELETE from Uposlenik WHERE uposlenik_id = :id";
			Query query = App.session.createQuery(hql);
			query.setParameter("id", u.getId());
			
			int result = query.executeUpdate();
		}
		
		for(SkladisteArtikal sa:s.get_skladisteArtikli()) {
			String hql = "DELETE from Uposlenik WHERE skladiste_artikal_id = :id";
			Query query = App.session.createQuery(hql);
			query.setParameter("id", sa.getId());
			
			int result = query.executeUpdate();
		}
		
		String hql = "DELETE from Skladiste WHERE naziv = :id";
		Query query = App.session.createQuery(hql);
		query.setParameter("id", id);
		
		int result = query.executeUpdate();
				
		t.commit();

		return 0;
	}
	
	
}

