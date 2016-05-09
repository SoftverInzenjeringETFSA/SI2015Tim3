package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SKLADISTE_ARTIKAL")
public class SkladisteArtikal implements Serializable {
	@Id
	@GeneratedValue
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
	
	public Skladiste get_skladiste() {
		return _skladiste;
	}

	public void set_skladiste(Skladiste _skladiste) {
		this._skladiste = _skladiste;
	}
	@ManyToOne
	@JoinColumn(name="artikal_id")
	Artikal _artikal;
	@ManyToOne
	@JoinColumn(name="skladiste_id")
	Skladiste _skladiste;
	@Column(name="ponderirana_cijena")
	double ponderiranaCijena;
	
	public SkladisteArtikal() {}
}
