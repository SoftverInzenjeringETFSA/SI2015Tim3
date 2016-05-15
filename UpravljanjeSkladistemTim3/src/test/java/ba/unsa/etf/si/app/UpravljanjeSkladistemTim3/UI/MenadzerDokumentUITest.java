package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;

import junit.framework.TestCase;

public class MenadzerDokumentUITest extends TestCase {

	public void testMenadzerDokumentUI() {
		MenadzerDokumentUI dsui = new MenadzerDokumentUI();
		boolean result = true;
		if(dsui == null) {
			result = false;
		}
		assertTrue(result);
	}
	
	public void testPopuniListuDokumenata() {
		MenadzerDokumentUI mdui = new MenadzerDokumentUI();
		JLabel dummyStatus = new JLabel();
	    try {
	    	//Datum OD > Datum DO
		    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Date OD = format.parse("17/07/2013");
			Date DO = format.parse("17/07/2010");
			List<String> trazi = null;
			boolean result = mdui.PopuniListuDokumenata(dummyStatus, OD, DO, trazi);
			assertFalse(result);
			
			//Lista trazi je prazna
			DO = format.parse("17/07/2014");
			result = mdui.PopuniListuDokumenata(dummyStatus, OD, DO, trazi);
			assertFalse(result);
			
			//Sve je uredu
			trazi = new ArrayList<String>();
			trazi.add("NAB");
			trazi.add("OTP");
			trazi.add("OTS");
			result = mdui.PopuniListuDokumenata(dummyStatus, OD, DO, trazi);
			assertTrue(result);			
	    }
	    catch (ParseException e) {
	    	e.printStackTrace();
	    }
	}

	public void testProvjeriDatumNull() {
		MenadzerDokumentUI mdui = new MenadzerDokumentUI();
		JLabel dummyStatus = new JLabel();
		String d1 = "";
		String d2 = "";
		
		//Datum OD nije odabran
		boolean result = mdui.ProvjeriDatumNull(dummyStatus, d1, d2);
		assertFalse(result);
		
		//Datum DO nije odabran
		d1 = "17/07/2014";
		result = mdui.ProvjeriDatumNull(dummyStatus, d1, d2);
		assertFalse(result);
		
		//Sve je uredu
		d2 = "17/07/2014";
		result = mdui.ProvjeriDatumNull(dummyStatus, d1, d2);
		assertTrue(result);
	}

}
