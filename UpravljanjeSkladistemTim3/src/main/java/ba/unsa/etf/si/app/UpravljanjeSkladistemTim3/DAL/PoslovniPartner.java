package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL;

import java.io.Serializable;

public class PoslovniPartner implements Serializable {
	long id;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getJIB() {
		return JIB;
	}

	public void setJIB(String jIB) {
		JIB = jIB;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	String JIB;
	String naziv;
	String adresa;
	public PoslovniPartner() {}
}
