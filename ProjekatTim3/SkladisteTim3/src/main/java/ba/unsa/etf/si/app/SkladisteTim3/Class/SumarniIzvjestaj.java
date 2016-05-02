package ba.unsa.etf.si.app.SkladisteTim3.Class;

import java.io.Serializable;

public class SumarniIzvjestaj extends Izvjestaj implements Serializable {
	java.util.List<Artikal> _artikli;
	
	public java.util.List<Artikal> get_artikli() {
		return _artikli;
	}

	public void set_artikli(java.util.List<Artikal> _artikli) {
		this._artikli = _artikli;
	}

	public SumarniIzvjestaj() {}
}
