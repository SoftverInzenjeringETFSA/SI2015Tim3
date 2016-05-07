package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL;

import java.io.Serializable;

public class Nabavka extends Dokument implements Serializable {
	String barKod;
	public String getBarKod() {
		return barKod;
	}

	public void setBarKod(String barKod) {
		this.barKod = barKod;
	}

	public PoslovniPartner get_dobavaljc() {
		return _dobavaljc;
	}

	public void set_dobavaljc(PoslovniPartner _dobavaljc) {
		this._dobavaljc = _dobavaljc;
	}

	PoslovniPartner _dobavaljc;
	
	public Nabavka() {}
}
