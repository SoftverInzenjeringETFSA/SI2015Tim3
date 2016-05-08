package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.App;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL.UposlenikBLL;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.*;

public class UposlenikUI {
	public static void DodajNoviArtikal(String barKod, String naziv, String jedinicnaKolicina, MjernaJedinica mjernaJedinica, String kolicina)
	{
		// validate
		Artikal ar = new Artikal();
		ar.setBarKod(barKod);
		ar.setNaziv(naziv);
		ar.setJedinicnaKolicina(Double.parseDouble(jedinicnaKolicina));
		ar.setMjernaJedinica(mjernaJedinica);
		ar.setKolicina(Integer.parseInt(kolicina));
		UposlenikBLL.DodajNoviArtikal(ar);
		App.session.close();
	}
}
