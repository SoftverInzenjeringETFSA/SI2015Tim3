package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL;

import java.io.Serializable;

public class SkladisteArtikal implements Serializable {
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

	public double getPonderiranaCijena() {
		return ponderiranaCijena;
	}

	public void setPonderiranaCijena(double ponderiranaCijena) {
		this.ponderiranaCijena = ponderiranaCijena;
	}

	Artikal _artikal;
	double ponderiranaCijena;
	
	public SkladisteArtikal() {}
}
