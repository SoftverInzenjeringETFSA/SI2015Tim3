package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public abstract class Dokument implements Serializable {
	long id;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public double getVrijednost() {
		return vrijednost;
	}

	public void setVrijednost(double vrijednost) {
		this.vrijednost = vrijednost;
	}

	public List<StavkaDokumenta> get_stavke() {
		return _stavke;
	}

	public void set_stavke(List<StavkaDokumenta> _stavke) {
		this._stavke = _stavke;
	}
	
	Date datum;
	double vrijednost;
	List<StavkaDokumenta> _stavke;
	
	public Dokument() {}
}
