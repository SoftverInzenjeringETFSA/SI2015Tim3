package ba.unsa.etf.si.app.SkladisteTim3.Class;

import java.io.Serializable;

public class Otpremnica extends Dokument implements Serializable {
	PoslovniPartner _kupac;
	public PoslovniPartner get_kupac() {
		return _kupac;
	}

	public void set_kupac(PoslovniPartner _kupac) {
		this._kupac = _kupac;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	double total;
	public Otpremnica() {}
	public void izracunajTotal () {}
}
