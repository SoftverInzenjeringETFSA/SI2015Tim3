package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JTable;

import org.hibernate.SQLQuery;
import org.hibernate.Transaction;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.App;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Artikal;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.MjernaJedinica;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.PoslovniPartner;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Skladiste;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.SkladisteArtikal;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.StrucnaSprema;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.TipUposlenika;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Uposlenik;
import junit.framework.TestCase;

public class UposlenikUnosRobeUITest extends TestCase {
	
	public void testValidateEan_NeispravanEan_False() {
		UposlenikUnosRobeUI ui = new UposlenikUnosRobeUI();
		assertEquals(false, ui.ValidateEan("14587220000h"));
	}
	
	public void testValidateEan_ValidanBarkod_true() {
		UposlenikUnosRobeUI ui = new UposlenikUnosRobeUI();
		assertEquals(true, ui.ValidateEan("0123456789123"));
	}
	
	public void testDodajArtikal_NabavnaCijenaNull_false() {
		UposlenikUnosRobeUI ui = new UposlenikUnosRobeUI();
		JLabel dummyLabel = new JLabel();
		JTable dummyTable = new JTable();
		
		boolean result = ui.DodajArtikal(dummyLabel, dummyTable, "1234567890123", 5, null);
		assertEquals(false, result);
	}
	
	public void testDodajArtikal_NegativnaKolicina_False() {
		UposlenikUnosRobeUI ui = new UposlenikUnosRobeUI();
		JLabel dummyLabel = new JLabel();
		JTable dummyTable = new JTable();
		
		boolean result = ui.DodajArtikal(dummyLabel, dummyTable, "1111111111111", -1, "55");
		assertEquals(false, result);
	}

	public void testDodajArtikal_NeispravanEan_False() {
		UposlenikUnosRobeUI ui = new UposlenikUnosRobeUI();
		JLabel dummyLabel = new JLabel();
		JTable dummyTable = new JTable();
		
		boolean result = ui.DodajArtikal(dummyLabel, dummyTable, "01234567891234", 1, "55");
		assertEquals(false, result);
	}
	
	public void testDodajArtikal_NijeValidnaNabavnaCijenan_False() {
		UposlenikUnosRobeUI ui = new UposlenikUnosRobeUI();
		JLabel dummyLabel = new JLabel();
		JTable dummyTable = new JTable();
		
		boolean result = ui.DodajArtikal(dummyLabel, dummyTable, "0123456789123", 1, "#55");
		assertEquals(false, result);
	}
	
	public void testDodajArtikal_NabavnaCijenaNegativna_False() {
		UposlenikUnosRobeUI ui = new UposlenikUnosRobeUI();
		JLabel dummyLabel = new JLabel();
		JTable dummyTable = new JTable();
		
		boolean result = ui.DodajArtikal(dummyLabel, dummyTable, "0123456789123", 1, "-55");
		assertEquals(false, result);
	}
	
	public void testDodajArtikal_ArtikalNePostojiUBazi_False() {
		UposlenikUnosRobeUI ui = new UposlenikUnosRobeUI();
		JLabel dummyLabel = new JLabel();
		JTable dummyTable = new JTable();
		
		boolean result = ui.DodajArtikal(dummyLabel, dummyTable, "9999999999999", 1, "55");
		assertEquals(false, result);
	}
	
	public void testDodajArtikal_ArtikalVecDodanUNabavci_False() {
		Artikal ar = new Artikal();
		ar.setBarKod("1478523690127");
		ar.setNaziv("testArtikal");
		ar.setMjernaJedinica(MjernaJedinica.kg);
		ar.setJedinicnaKolicina(100);
		ar.setProdajnaCijena(1);
		Transaction t = App.session.beginTransaction();
		Long id = (Long)App.session.save(ar);
		t.commit();
		
		UposlenikUnosRobeUI ui = new UposlenikUnosRobeUI();
		JLabel dummyLabel = new JLabel();
		JTable dummyTable = new JTable();
		
		ui.DodajArtikal(dummyLabel, dummyTable, ar.getBarKod(), 1, "22");
		
		boolean result = ui.DodajArtikal(dummyLabel, dummyTable, ar.getBarKod(), 1, "22");
		assertEquals(false, result);
		
		Transaction tt = App.session.beginTransaction();
		String sql = "DELETE FROM artikal WHERE artikal_id =:ar_id";
		SQLQuery query = App.session.createSQLQuery(sql);
		query.setParameter("ar_id", id);
		query.executeUpdate();
		tt.commit();
	}
	
	public void testDodajArtikal_ValidniPodaci_True() {
		Artikal ar = new Artikal();
		ar.setBarKod("1478523690117");
		ar.setNaziv("testArtikal");
		ar.setMjernaJedinica(MjernaJedinica.kg);
		ar.setJedinicnaKolicina(100);
		ar.setProdajnaCijena(1);
		Transaction t = App.session.beginTransaction();
		Long id = (Long)App.session.save(ar);
		t.commit();
		
		UposlenikUnosRobeUI ui = new UposlenikUnosRobeUI();
		JLabel dummyLabel = new JLabel();
		JTable dummyTable = new JTable();
		
		boolean result = ui.DodajArtikal(dummyLabel, dummyTable, ar.getBarKod(), 1, "22");
		assertEquals(true, result);
		
		Transaction tt = App.session.beginTransaction();
		String sql = "DELETE FROM artikal WHERE artikal_id =:ar_id";
		SQLQuery query = App.session.createSQLQuery(sql);
		query.setParameter("ar_id", id);
		query.executeUpdate();
		tt.commit();
	}
	
	public void testDodajNoviArtikal_NazivNull_False() {
		UposlenikUnosRobeUI ui = new UposlenikUnosRobeUI();
		JLabel dummyLabel = new JLabel();
		JTable dummyTable = new JTable();
		
		boolean result = ui.DodajNoviArtikal(dummyLabel, dummyTable, "1234567890123", 1, "2", null, "100", MjernaJedinica.kg, "2");
		assertEquals(false, result);
	}
	
	public void testDodajNoviArtikal_NeisparavnaJedinicnaKolicina_False() {
		UposlenikUnosRobeUI ui = new UposlenikUnosRobeUI();
		JLabel dummyLabel = new JLabel();
		JTable dummyTable = new JTable();
		
		boolean result = ui.DodajNoviArtikal(dummyLabel, dummyTable, "1234567890123", 1, "2", "testArtikal", "", MjernaJedinica.kg, "2");
		assertEquals(false, result);
	}
	
	public void testDodajNoviArtikal_JedinicnaKolicinaNijeBroj_False() {
		UposlenikUnosRobeUI ui = new UposlenikUnosRobeUI();
		JLabel dummyLabel = new JLabel();
		JTable dummyTable = new JTable();
		
		boolean result = ui.DodajNoviArtikal(dummyLabel, dummyTable, "1234567890123", 1, "2", "testArtikal", "hh", MjernaJedinica.kg, "2");
		assertEquals(false, result);
	}
	
	public void testDodajNoviArtikal_NegativnaJedinicnaKolicina_False() {
		UposlenikUnosRobeUI ui = new UposlenikUnosRobeUI();
		JLabel dummyLabel = new JLabel();
		JTable dummyTable = new JTable();
		
		boolean result = ui.DodajNoviArtikal(dummyLabel, dummyTable, "1234567890123", 1, "2", "testArtikal", "-5", MjernaJedinica.kg, "2");
		assertEquals(false, result);
	}
	
	public void testDodajNoviArtikal_NeisparavnaProdajnaCijena_False() {
		UposlenikUnosRobeUI ui = new UposlenikUnosRobeUI();
		JLabel dummyLabel = new JLabel();
		JTable dummyTable = new JTable();
		
		boolean result = ui.DodajNoviArtikal(dummyLabel, dummyTable, "1234567890123", 1, "2", "testArtikal", "5", MjernaJedinica.kg, "");
		assertEquals(false, result);
	}
	
	public void testDodajNoviArtikal_ProdajnaCijenaNijeBroj_False() {
		UposlenikUnosRobeUI ui = new UposlenikUnosRobeUI();
		JLabel dummyLabel = new JLabel();
		JTable dummyTable = new JTable();
		
		boolean result = ui.DodajNoviArtikal(dummyLabel, dummyTable, "1234567890123", 1, "2", "testArtikal", "5", MjernaJedinica.kg, "gg");
		assertEquals(false, result);
	}
	
	public void testDodajNoviArtikal_NegativnaProdajnaCijena_False() {
		UposlenikUnosRobeUI ui = new UposlenikUnosRobeUI();
		JLabel dummyLabel = new JLabel();
		JTable dummyTable = new JTable();
		
		boolean result = ui.DodajNoviArtikal(dummyLabel, dummyTable, "1234567890123", 1, "2", "testArtikal", "5", MjernaJedinica.kg, "-5");
		assertEquals(false, result);
	}
	
	public void testDodajNoviArtikal_ArtikalPostojiUBazi_False() {
		Artikal ar = new Artikal();
		ar.setBarKod("1478523690741");
		ar.setNaziv("testArtikal");
		ar.setMjernaJedinica(MjernaJedinica.kg);
		ar.setJedinicnaKolicina(100);
		ar.setProdajnaCijena(1);
		Transaction t = App.session.beginTransaction();
		Long id = (Long)App.session.save(ar);
		t.commit();
		
		UposlenikUnosRobeUI ui = new UposlenikUnosRobeUI();
		JLabel dummyLabel = new JLabel();
		JTable dummyTable = new JTable();
		
		boolean result = ui.DodajNoviArtikal(dummyLabel, dummyTable, "1478523690741", 1, "2", "testArtikal", "5", MjernaJedinica.kg, "5");
		assertEquals(false, result);
		
		Transaction tt = App.session.beginTransaction();
		String sql = "DELETE FROM artikal WHERE artikal_id =:ar_id";
		SQLQuery query = App.session.createSQLQuery(sql);
		query.setParameter("ar_id", id);
		query.executeUpdate();
		tt.commit();
	}
	
	public void testDodajNoviArtikal_ValidniPodaci_True() {	
		
		UposlenikUnosRobeUI ui = new UposlenikUnosRobeUI();
		JLabel dummyLabel = new JLabel();
		JTable dummyTable = new JTable();
		
		boolean result = ui.DodajNoviArtikal(dummyLabel, dummyTable, "1478523690223", 1, "2", "testArtikal", "5", MjernaJedinica.kg, "5");
		assertEquals(true, result);
		
		Transaction tt = App.session.beginTransaction();
		String sql = "DELETE FROM artikal WHERE BARKOD =:ar_id";
		SQLQuery query = App.session.createSQLQuery(sql);
		query.setParameter("ar_id", "1478523690223");
		query.executeUpdate();
		tt.commit();
	}
	
	public void testDodajNabavku_NeispravanPoslovniPartner_false(){
		
		UposlenikUnosRobeUI ui = new UposlenikUnosRobeUI();
		JLabel dummyLabel = new JLabel();
		
		boolean result = ui.UnosNabavke(dummyLabel, null, null, "9874563210258");
		assertEquals(false, result);
	}
	
	public void testDodajNabavku_NeispravanEAN_false(){
	  
		Transaction t = App.session.beginTransaction();
		PoslovniPartner pp = new PoslovniPartner();
		pp.setNaziv("testPartner");
		pp.setAdresa("testAdresa");
		pp.setJIB("3698523698521");		
		App.session.save(pp);
		t.commit();
		
		UposlenikUnosRobeUI ui = new UposlenikUnosRobeUI();
		JLabel dummyLabel = new JLabel();
		
		boolean result = ui.UnosNabavke(dummyLabel, null, "3698523698521", "9874563210258a");
		assertEquals(false, result);
		
		Transaction tt = App.session.beginTransaction();
		String sql = "DELETE FROM poslovni_partner WHERE JIB =:ar_id";
		SQLQuery query = App.session.createSQLQuery(sql);
		query.setParameter("ar_id", "3698523698521");
		query.executeUpdate();
		tt.commit();
	}
	
	public void testDodajNabavku_NijeUmesenArtikal_false(){
		  
		Transaction t = App.session.beginTransaction();
		PoslovniPartner pp = new PoslovniPartner();
		pp.setNaziv("testPartner");
		pp.setAdresa("testAdresa");
		pp.setJIB("3698523698521");		
		App.session.save(pp);
		t.commit();
		
		UposlenikUnosRobeUI ui = new UposlenikUnosRobeUI();
		JLabel dummyLabel = new JLabel();
		
		boolean result = ui.UnosNabavke(dummyLabel, null, "3698523698521", "9874563210258");
		assertEquals(false, result);
		
		Transaction tt = App.session.beginTransaction();
		String sql = "DELETE FROM poslovni_partner WHERE JIB =:ar_id";
		SQLQuery query = App.session.createSQLQuery(sql);
		query.setParameter("ar_id", "3698523698521");
		query.executeUpdate();
		tt.commit();
	}
	
	public void testDodajNabavku_ValidniPodaci_True(){
		
		Transaction t = App.session.beginTransaction();		
		Skladiste skladiste = new Skladiste();
		skladiste.setNaziv("testSkladiste");
		skladiste.setAdresa("TestAdresa");
		skladiste.setRadnoVrijemeDo(1);
		skladiste.setRadnoVrijemeOd(5);
		skladiste.setKontaktTelefon("123456789");		
		Long skladisteId = (Long) App.session.save(skladiste);
		t.commit();
		
		Transaction tt = App.session.beginTransaction();	
		Uposlenik noviUposlenik = new Uposlenik();		
		noviUposlenik.setIme("as");
		noviUposlenik.setPrezime("");
		noviUposlenik.setJMBG("1234569874125");
		noviUposlenik.setDatumRodjenja(new Date());
		noviUposlenik.setMjestoRodjenja("asc");
		noviUposlenik.setAdresaStanovanja("asas");
		noviUposlenik.setBrojTelefona("asdasc");
		noviUposlenik.setEmail("nekimail@domena.ba");
		noviUposlenik.setStrucnaSprema(StrucnaSprema.values()[0]);
		noviUposlenik.setDatumZaposlenja(new Date());
		noviUposlenik.setUser("user");
		noviUposlenik.setPassword("pw");
		noviUposlenik.setTipUposlenika(TipUposlenika.values()[1]);	
		Skladiste s = App.session.load(Skladiste.class, (long)skladisteId);
		noviUposlenik.set_skladiste(s);
		long userId = (Long)App.session.save(noviUposlenik);
		tt.commit();
		
		Transaction ttt = App.session.beginTransaction();	
		Artikal ar = new Artikal();
		ar.setBarKod("1378523690154");
		ar.setNaziv("testArtikal");
		ar.setMjernaJedinica(MjernaJedinica.kg);
		ar.setJedinicnaKolicina(100);
		ar.setProdajnaCijena(1);
		Long id = (Long)App.session.save(ar);
		ttt.commit();
		
		Transaction t4 = App.session.beginTransaction();
		SkladisteArtikal sa = new SkladisteArtikal();
		sa.set_artikal(App.session.load(Artikal.class, (long)id));
		sa.set_skladiste(App.session.load(Skladiste.class, (long)skladisteId));
		sa.setPonderiranaCijena(2);
		sa.setKolicina(500);
		Long skladisteArtikalId = (Long) App.session.save(sa);
		t4.commit();
		
		UposlenikUnosRobeUI ui = new UposlenikUnosRobeUI();
		JLabel dummyLabel = new JLabel();
		JTable dummyTable = new JTable();
		
		ui.DodajArtikal(dummyLabel, dummyTable, "1378523690154", 1, "22");
		
		Transaction tttt = App.session.beginTransaction();	
		PoslovniPartner pp = new PoslovniPartner();
		pp.setNaziv("testPartner");
		pp.setAdresa("testAdresa");
		pp.setJIB("3698523698544");		
		App.session.save(pp);
		tttt.commit();
		
		boolean result = ui.UnosNabavke(dummyLabel, App.session.load(Uposlenik.class, (long)userId), "3698523698544", "1378523690154");
		
		Transaction t57 = App.session.beginTransaction();
		String sqla1 = "DELETE FROM stavka_dokumenta WHERE ARTIKAL_ID =:ar_id";
		SQLQuery querry1 = App.session.createSQLQuery(sqla1);
		querry1.setParameter("ar_id", id);
		querry1.executeUpdate();
		t57.commit();
		
		Transaction t76 = App.session.beginTransaction();
		String sqlaa = "DELETE FROM dokument WHERE SKLADISTE_ID =:ar_id";
		SQLQuery querryy = App.session.createSQLQuery(sqlaa);
		querryy.setParameter("ar_id", skladisteId);
		querryy.executeUpdate();
		t76.commit();
		
		Transaction t56 = App.session.beginTransaction();
		String sqla = "DELETE FROM skladiste_artikal WHERE skladiste_artikal_id =:ar_id";
		SQLQuery querry = App.session.createSQLQuery(sqla);
		querry.setParameter("ar_id", skladisteArtikalId);
		querry.executeUpdate();
		t56.commit();
		
		Transaction t1 = App.session.beginTransaction();	
		String sql = "DELETE FROM poslovni_partner WHERE JIB =:ar_id";
		SQLQuery query = App.session.createSQLQuery(sql);
		query.setParameter("ar_id", "3698523698521");
		query.executeUpdate();
		t1.commit();
		
		Transaction tt1 = App.session.beginTransaction();	
		String sql1 = "DELETE FROM artikal WHERE artikal_id =:ar_id";
		SQLQuery query1 = App.session.createSQLQuery(sql1);
		query1.setParameter("ar_id", id);
		query1.executeUpdate();
		tt1.commit();
		
		Transaction t2 = App.session.beginTransaction();	
		String sqluser = "DELETE FROM uposlenik WHERE uposlenik_id =:ar_id";
		SQLQuery queryUser = App.session.createSQLQuery(sqluser);
		queryUser.setParameter("ar_id", userId);
		queryUser.executeUpdate();
		t2.commit();
		
		Transaction t3 = App.session.beginTransaction();	
		String sqlSkladiste = "DELETE FROM skladiste WHERE skladiste_id =:ar_id";
		SQLQuery querySkladiste = App.session.createSQLQuery(sqlSkladiste);
		querySkladiste.setParameter("ar_id", skladisteId);
		querySkladiste.executeUpdate();
		t3.commit();
		
		assertEquals(true, result);
	}
}
