package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL;

import java.awt.List;
import java.util.Date;

import org.hibernate.SQLQuery;
import org.hibernate.Transaction;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.App;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Artikal;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.MjernaJedinica;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.PoslovniPartner;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Skladiste;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.StrucnaSprema;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.TipUposlenika;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Uposlenik;
import junit.framework.TestCase;

public class UposlenikUnosRobeBLLTest extends TestCase {

	public void testDajPoslovnogPartnera_ValidniPodaci() {
		Transaction t = App.session.beginTransaction();	
		PoslovniPartner pp = new PoslovniPartner();
		pp.setNaziv("1596324780365");
		pp.setAdresa("testAdresa");
		pp.setJIB("1596324780365");		
		long id = (Long)App.session.save(pp);
		t.commit();
		
		UposlenikUnosRobeBLL ui = new UposlenikUnosRobeBLL();
		PoslovniPartner partner = ui.DajPoslovnogPartnera("1596324780365");
		boolean result = partner != null;
		
		Transaction t1 = App.session.beginTransaction();	
		String sql = "DELETE FROM poslovni_partner WHERE poslovni_partner_id =:ar_id";
		SQLQuery query = App.session.createSQLQuery(sql);
		query.setParameter("ar_id", id);
		query.executeUpdate();
		t1.commit();
		
		assertEquals(true, result);
	}

	public void testDobaviSkladiste_ValidniPodaci() {
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
		
		UposlenikUnosRobeBLL ui = new UposlenikUnosRobeBLL();
		Skladiste sk = ui.DobaviSkladiste(App.session.load(Uposlenik.class, (long)userId));
		boolean result = sk != null;
		
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

	public void testDobaviSvePoslnovnePartnere_ValidniPodaci() {
		Transaction t = App.session.beginTransaction();	
		PoslovniPartner pp = new PoslovniPartner();
		pp.setNaziv("1596324780365");
		pp.setAdresa("testAdresa");
		pp.setJIB("1596324780365");		
		long id = (Long)App.session.save(pp);
		t.commit();
		
		UposlenikUnosRobeBLL ui = new UposlenikUnosRobeBLL();
		boolean result = ui.DobaviSvePoslnovnePartnere().contains(App.session.load(PoslovniPartner.class, (long)id));
		
		Transaction t1 = App.session.beginTransaction();	
		String sql = "DELETE FROM poslovni_partner WHERE poslovni_partner_id =:ar_id";
		SQLQuery query = App.session.createSQLQuery(sql);
		query.setParameter("ar_id", id);
		query.executeUpdate();
		t1.commit();
		
		assertEquals(true, result);
	}
}
