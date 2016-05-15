package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL;

import java.util.List;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Skladiste;
import junit.framework.TestCase;

public class MenadzerSkladisteBLLTest extends TestCase {

	//Dodavanje i Brisanje skladista je provjereno kroz sljedeci test
	
	public void testPopuniSkladista() {
		MenadzerSkladisteBLL msbll = new MenadzerSkladisteBLL();
		msbll.DodajSkladiste("nazivvv", "adresa", 2000, 3000, "062123456");
		List<Skladiste> lista = msbll.PopuniSkladista();
		msbll.ObrisiSkladiste("nazivvv");
		boolean result = true;
		if(lista == null || lista.isEmpty())
			result = false;
		assertTrue(result);
	}

}
