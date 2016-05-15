package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.App;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.*;

import org.hibernate.Transaction;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;

public class MenadzerSkladisteBLL {

	public void DodajSkladiste(String naziv, String adresa, Integer radnoVrijemeOd, Integer radnoVrijemeDo, String telefon) {
		
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
		
	public List<Skladiste> PopuniSkladista() {
		Transaction t = App.session.beginTransaction();

		String hql = "from Skladiste";

		Query query = App.session.createQuery(hql);
		
		List<Skladiste> lista = query.list();
		
		return lista;
		}
		
	public int ObrisiSkladiste(String naziv) {		
		int result;
		Transaction t;
		
		t = App.session.beginTransaction();
		String hql = "from Skladiste WHERE naziv = :naziv";
		Query query = App.session.createQuery(hql);
		query.setParameter("naziv", naziv);
		Skladiste s = (Skladiste)query.uniqueResult();
		t.commit();
		
		t = App.session.beginTransaction();
		if(s.get_dokumenti() != null)
			for(Dokument d:s.get_dokumenti()) {
				hql = "DELETE from Dokument WHERE dokument_id = :id";
				query = App.session.createQuery(hql);
				query.setParameter("id", d.getId());
				
				result = query.executeUpdate();
			}
		t.commit();
		
		t = App.session.beginTransaction();
		if(s.get_uposlenici() != null)
			for(Uposlenik u:s.get_uposlenici()) {
				hql = "DELETE from Uposlenik WHERE uposlenik_id = :id";
				query = App.session.createQuery(hql);
				query.setParameter("id", u.getId());
				
				result = query.executeUpdate();
			}
		t.commit();
		
		t = App.session.beginTransaction();
		if(s.get_skladisteArtikli() != null)
			for(SkladisteArtikal sa:s.get_skladisteArtikli()) {
				hql = "DELETE from Uposlenik WHERE skladiste_artikal_id = :id";
				query = App.session.createQuery(hql);
				query.setParameter("id", sa.getId());
				
				result = query.executeUpdate();
			}
		t.commit();
		
		t = App.session.beginTransaction();
		App.session.delete(s);
		JOptionPane.showMessageDialog(null, "Obrisano skladište " + s.getNaziv() + "!","Info", JOptionPane.INFORMATION_MESSAGE);
		t.commit();

		return 0;
	}	
}

