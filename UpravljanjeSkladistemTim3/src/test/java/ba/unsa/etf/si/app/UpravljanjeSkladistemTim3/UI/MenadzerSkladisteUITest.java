package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import javax.swing.JLabel;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL.MenadzerSkladisteBLL;
import junit.framework.TestCase;

public class MenadzerSkladisteUITest extends TestCase {

	public void testMenadzerSkladisteUI() {
		MenadzerSkladisteUI msui = new MenadzerSkladisteUI();
		boolean result = true;
		if(msui == null) {
			result = false;
		}
		assertTrue(result);
	}

	public void testDodajSkladiste() {
		MenadzerSkladisteUI msui = new MenadzerSkladisteUI();
		MenadzerSkladisteBLL msbll = new MenadzerSkladisteBLL();
		JLabel dummyStatus = new JLabel();
		String naziv = "", adresa = "", telefon = "";
		int radnoVrijemeOd = 2, radnoVrijemeDo = 1; 
		
		//Naziv nije unesen
		boolean result = msui.DodajSkladiste(dummyStatus, naziv, adresa, radnoVrijemeOd, radnoVrijemeDo, telefon);
		assertFalse(result);
		
		//Adresa nije unesena
		naziv = "1naziv";
		result = msui.DodajSkladiste(dummyStatus, naziv, adresa, radnoVrijemeOd, radnoVrijemeDo, telefon);
		assertFalse(result);
		
		//Telefon nije unesen
		adresa = "1adresa";
		result = msui.DodajSkladiste(dummyStatus, naziv, adresa, radnoVrijemeOd, radnoVrijemeDo, telefon);
		assertFalse(result);
		
		//Radno vrijeme otvaranja vece od radnog vremena zatvaranja
		telefon = "123456789";
		result = msui.DodajSkladiste(dummyStatus, naziv, adresa, radnoVrijemeOd, radnoVrijemeDo, telefon);
		assertFalse(result);
		
		//Telefon nije u odgovarajucem formatu
		radnoVrijemeDo = 3;
		result = msui.DodajSkladiste(dummyStatus, naziv, adresa, radnoVrijemeOd, radnoVrijemeDo, telefon);
		assertFalse(result);
		
		//Naziv pocinje brojem
		telefon = "062123456";
		result = msui.DodajSkladiste(dummyStatus, naziv, adresa, radnoVrijemeOd, radnoVrijemeDo, telefon);
		assertFalse(result);
		
		//Adresa pocinje brojem
		naziv = "nazivv";
		result = msui.DodajSkladiste(dummyStatus, naziv, adresa, radnoVrijemeOd, radnoVrijemeDo, telefon);
		assertFalse(result);
		
		//Skladiste vec postoji u bazi
		adresa = "adresa";
		msbll.DodajSkladiste(naziv, adresa, radnoVrijemeOd, radnoVrijemeDo, telefon);
		result = msui.DodajSkladiste(dummyStatus, naziv, adresa, radnoVrijemeOd, radnoVrijemeDo, telefon);
		msbll.ObrisiSkladiste(naziv);
		assertFalse(result);
		
		//Sve je uredu
		result = msui.DodajSkladiste(dummyStatus, naziv+"dodatak", adresa, radnoVrijemeOd, radnoVrijemeDo, telefon);
		assertTrue(result);
	}

	public void testIzbrisiSkladiste() {
		MenadzerSkladisteUI msui = new MenadzerSkladisteUI();
		MenadzerSkladisteBLL msbll = new MenadzerSkladisteBLL();
		JLabel dummyStatus = new JLabel();
		String naziv = "nazivv", adresa = "adresa", telefon = "062908445";
		int radnoVrijemeOd = 1, radnoVrijemeDo = 2; 

		//Skladiste ne postoji u bazi 
		boolean result = msui.IzbrisiSkladiste(dummyStatus, naziv);
		assertFalse(result);
		
		//Sve je uredu 
		msbll.DodajSkladiste(naziv, adresa, radnoVrijemeOd, radnoVrijemeDo, telefon);
		result = msui.IzbrisiSkladiste(dummyStatus, naziv);
		msbll.ObrisiSkladiste(naziv);
		assertTrue(result);
		
	}

}
