package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="STAVKA_DOKUMENTA")
public class StavkaDokumenta implements Serializable {
	@Id
	@GeneratedValue
	@Column(name="stavka_dokumenta_id")
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
	public Dokument get_dokument() {
		return _dokument;
	}

	public void set_dokument(Dokument _dokument) {
		this._dokument = _dokument;
	}
	@ManyToOne
	@JoinColumn(name="artikal_id")
	Artikal _artikal;
	@ManyToOne
	@JoinColumn(name="dokument_id")
	Dokument _dokument;
	@Column(name="kolicina")
	int kolicina;
	@Column(name="cijena")
	double cijena;
	
	public StavkaDokumenta() {}
	
}
