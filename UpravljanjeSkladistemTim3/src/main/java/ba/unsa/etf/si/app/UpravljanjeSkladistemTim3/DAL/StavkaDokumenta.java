package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL;

import java.io.Serializable;

public class StavkaDokumenta implements Serializable {
	long id;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Artikal get_artikal() {
		return _artikal;
	}

	public void set_artikal(Artikal _artikal) {
		this._artikal = _artikal;
	}

	public double getCijena() {
		return cijena;
	}

	public void setCijena(double cijena) {
		this.cijena = cijena;
	}

	public int getKolicina() {
		return kolicina;
	}

	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}
	
	Artikal _artikal;
	int kolicina;
	double cijena;
	
	public StavkaDokumenta() {}
	
}
