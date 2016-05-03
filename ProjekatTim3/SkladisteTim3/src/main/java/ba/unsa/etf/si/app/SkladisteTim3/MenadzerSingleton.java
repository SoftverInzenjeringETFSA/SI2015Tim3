package ba.unsa.etf.si.app.SkladisteTim3;

import ba.unsa.etf.si.app.SkladisteTim3.Class.*;
import ba.unsa.etf.si.app.SkladisteTim3.Views.*;

public final class MenadzerSingleton {
	private static MenadzerSingleton instance = new MenadzerSingleton();
	private MenadzerSingleton() {}
	
	public static MenadzerSingleton getInstance() {
		return instance;
	}
	
	public void dodajSkladiste(Skladiste _skladiste) {}
	public void obrisiSkladiste(Skladiste _skladiste) {}
	public void dodajPoslovnogPartnera(PoslovniPartner _partner) {}
	public void obrisiPoslovnogPartnera(PoslovniPartner _partner) {}
}
