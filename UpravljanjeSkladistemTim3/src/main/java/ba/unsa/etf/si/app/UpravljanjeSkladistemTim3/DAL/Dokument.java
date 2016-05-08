package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.persistence.*;

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

	public Uposlenik get_kreirao() {
		return _kreirao;
	}

	public void set_kreirao(Uposlenik _kreirao) {
		this._kreirao = _kreirao;
	}
	
	Date datum;
	double vrijednost;
	Uposlenik _kreirao;
	List<StavkaDokumenta> _stavke;
	
	public Dokument() {}
}
