package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL;

import java.io.Serializable;

public class Otpremnica extends Dokument implements Serializable {
	PoslovniPartner _kupac;
	
	public PoslovniPartner get_kupac() {
		return _kupac;
	}

	public void set_kupac(PoslovniPartner _kupac) {
		this._kupac = _kupac;
	}

	public Otpremnica() {}
}
