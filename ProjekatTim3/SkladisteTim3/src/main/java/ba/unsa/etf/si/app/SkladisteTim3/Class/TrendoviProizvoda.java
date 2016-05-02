package ba.unsa.etf.si.app.SkladisteTim3.Class;

import java.io.Serializable;

public class TrendoviProizvoda extends Izvjestaj implements Serializable {
	Artikal _artikal;

	public Artikal get_artikal() {
		return _artikal;
	}

	public void set_artikal(Artikal _artikal) {
		this._artikal = _artikal;
	}
	
	public TrendoviProizvoda() {}
}
