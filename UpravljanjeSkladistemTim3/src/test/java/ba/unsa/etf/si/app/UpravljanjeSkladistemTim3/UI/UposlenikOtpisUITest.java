package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import javax.swing.JLabel;
import javax.swing.JTable;

import org.hibernate.SQLQuery;
import org.hibernate.Transaction;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.App;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Artikal;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.MjernaJedinica;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Skladiste;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.SkladisteArtikal;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Uposlenik;
import junit.framework.TestCase;

public class UposlenikOtpisUITest extends TestCase {

	public void testDodajArtikalZaOtpis_EANnull_False(){
		
		UposlenikOtpisUI ui = new UposlenikOtpisUI();
		JLabel label = new JLabel();
		JTable table = new JTable();
		
		boolean result = ui.DodajArtikalZaOtpis(label, table, null, 5, null);
		
		assertEquals(false, result);
	}
	
	public void testDodajArtikalZaOtpis_NeispravanEAN_False(){
		
		UposlenikOtpisUI ui = new UposlenikOtpisUI();
		JLabel label = new JLabel();
		JTable table = new JTable();
		
		boolean result = ui.DodajArtikalZaOtpis(label, table, "147852369", 5, null);
		
		assertEquals(false, result);
	}
	
	public void testDodajArtikalZaOtpis_NegativnaKolicina_False(){
		
		UposlenikOtpisUI ui = new UposlenikOtpisUI();
		JLabel label = new JLabel();
		JTable table = new JTable();
		
		boolean result = ui.DodajArtikalZaOtpis(label, table, "1234567893698", -1, null);
		
		assertEquals(false, result);
	}
	
	public void testDodajArtikalZaOtpis_NepostojeciArtikal_False(){
		
		UposlenikOtpisUI ui = new UposlenikOtpisUI();
		JLabel label = new JLabel();
		JTable table = new JTable();
		
		boolean result = ui.DodajArtikalZaOtpis(label, table, "3697412580258", -1, null);
		
		assertEquals(false, result);
	}
	
	public void testDodajArtikalZaOtpis_NedovoljnaKolicinaArtikla_False(){	
		Artikal ar = new Artikal();
		ar.setBarKod("1478523690172");
		ar.setNaziv("testArtikal");
		ar.setMjernaJedinica(MjernaJedinica.kg);
		ar.setJedinicnaKolicina(10);
		ar.setProdajnaCijena(1);
		Transaction t = App.session.beginTransaction();
		Long id = (Long)App.session.save(ar);
		t.commit();
		
		Transaction t2 = App.session.beginTransaction();		
		Skladiste skladiste = new Skladiste();
		skladiste.setNaziv("testSkladiste");
		skladiste.setAdresa("TestAdresa");
		skladiste.setRadnoVrijemeDo(1);
		skladiste.setRadnoVrijemeOd(5);
		skladiste.setKontaktTelefon("123456789");		
		Long skladisteId = (Long) App.session.save(skladiste);
		t2.commit();
		
		Transaction t4 = App.session.beginTransaction();
		SkladisteArtikal sa = new SkladisteArtikal();
		sa.set_artikal(App.session.load(Artikal.class, (long)id));
		sa.set_skladiste(App.session.load(Skladiste.class, (long)skladisteId));
		sa.setPonderiranaCijena(2);
		sa.setKolicina(10);
		Long skladisteArtikalId = (Long) App.session.save(sa);
		t4.commit();
		
		UposlenikOtpisUI ui = new UposlenikOtpisUI();
		JLabel label = new JLabel();
		JTable table = new JTable();
		
		boolean result = ui.DodajArtikalZaOtpis(label, table, "1478523690172", 50, App.session.load(Skladiste.class, (long)skladisteId));
		
		Transaction ttt = App.session.beginTransaction();
		String sqla = "DELETE FROM skladiste_artikal WHERE skladiste_artikal_id =:ar_id";
		SQLQuery querry = App.session.createSQLQuery(sqla);
		querry.setParameter("ar_id", skladisteArtikalId);
		querry.executeUpdate();
		ttt.commit();
		
		Transaction tt = App.session.beginTransaction();
		String sql = "DELETE FROM artikal WHERE artikal_id =:ar_id";
		SQLQuery query = App.session.createSQLQuery(sql);
		query.setParameter("ar_id", id);
		query.executeUpdate();
		tt.commit();
		
		
		Transaction t3 = App.session.beginTransaction();	
		String sqlSkladiste = "DELETE FROM skladiste WHERE skladiste_id =:ar_id";
		SQLQuery querySkladiste = App.session.createSQLQuery(sqlSkladiste);
		querySkladiste.setParameter("ar_id", skladisteId);
		querySkladiste.executeUpdate();
		t3.commit();
		
		assertEquals(false, result);
	}
	
	public void testDodajArtikalZaOtpis_ValidniPodaci_True(){	
		Artikal ar = new Artikal();
		ar.setBarKod("1478523690172");
		ar.setNaziv("testArtikal");
		ar.setMjernaJedinica(MjernaJedinica.kg);
		ar.setJedinicnaKolicina(10);
		ar.setProdajnaCijena(1);
		Transaction t = App.session.beginTransaction();
		Long id = (Long)App.session.save(ar);
		t.commit();
		
		Transaction t2 = App.session.beginTransaction();		
		Skladiste skladiste = new Skladiste();
		skladiste.setNaziv("testSkladiste");
		skladiste.setAdresa("TestAdresa");
		skladiste.setRadnoVrijemeDo(1);
		skladiste.setRadnoVrijemeOd(5);
		skladiste.setKontaktTelefon("123456789");		
		Long skladisteId = (Long) App.session.save(skladiste);
		t2.commit();
		
		Transaction t4 = App.session.beginTransaction();
		SkladisteArtikal sa = new SkladisteArtikal();
		sa.set_artikal(App.session.load(Artikal.class, (long)id));
		sa.set_skladiste(App.session.load(Skladiste.class, (long)skladisteId));
		sa.setPonderiranaCijena(2);
		sa.setKolicina(500);
		Long skladisteArtikalId = (Long) App.session.save(sa);
		t4.commit();
		
		UposlenikOtpisUI ui = new UposlenikOtpisUI();
		JLabel label = new JLabel();
		JTable table = new JTable();
		
		boolean result = ui.DodajArtikalZaOtpis(label, table, "1478523690172", 50, App.session.load(Skladiste.class, (long)skladisteId));
		
		Transaction ttt = App.session.beginTransaction();
		String sqla = "DELETE FROM skladiste_artikal WHERE skladiste_artikal_id =:ar_id";
		SQLQuery querry = App.session.createSQLQuery(sqla);
		querry.setParameter("ar_id", skladisteArtikalId);
		querry.executeUpdate();
		ttt.commit();
		
		Transaction tt = App.session.beginTransaction();
		String sql = "DELETE FROM artikal WHERE artikal_id =:ar_id";
		SQLQuery query = App.session.createSQLQuery(sql);
		query.setParameter("ar_id", id);
		query.executeUpdate();
		tt.commit();
		
		
		Transaction t3 = App.session.beginTransaction();	
		String sqlSkladiste = "DELETE FROM skladiste WHERE skladiste_id =:ar_id";
		SQLQuery querySkladiste = App.session.createSQLQuery(sqlSkladiste);
		querySkladiste.setParameter("ar_id", skladisteId);
		querySkladiste.executeUpdate();
		t3.commit();
		
		assertEquals(true, result);
	}
}
