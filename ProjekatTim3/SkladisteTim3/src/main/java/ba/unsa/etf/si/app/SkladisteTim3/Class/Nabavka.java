package ba.unsa.etf.si.app.SkladisteTim3.Class;

import java.io.Serializable;

public class Nabavka extends Dokument implements Serializable {
	String barKod;
	PoslovniPartner _dobavljac;
	public String getBarKod() {
		return barKod;
	}
	public void setBarKod(String barKod) {
		this.barKod = barKod;
	}
	public PoslovniPartner get_dobavljac() {
		return _dobavljac;
	}
	public void set_dobavljac(PoslovniPartner _dobavljac) {
		this._dobavljac = _dobavljac;
	}
	
	public Nabavka() {}
	public String kreirajNaljepnicu() {
		return null;
	}
}
