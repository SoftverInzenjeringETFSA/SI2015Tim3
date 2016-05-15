package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.*;

@Entity
@Table(name="Dokument")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Dokument implements Serializable {
	@Id
	@GeneratedValue
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
	
	public Set<StavkaDokumenta> get_stavke() {
		return _stavke;
	}

	public void set_stavke(Set<StavkaDokumenta> _stavke) {
		this._stavke = _stavke;
	}

	public Uposlenik get_kreirao() {
		return _kreirao;
	}

	public void set_kreirao(Uposlenik _kreirao) {
		this._kreirao = _kreirao;
	}
	
	public Skladiste get_skladiste() {
		return _skladiste;
	}

	public void set_skladiste(Skladiste _skladiste) {
		this._skladiste = _skladiste;
	}

	@Column(name="datum")
	Date datum;
	@ManyToOne
	@JoinColumn(name="uposlenik_id")
	Uposlenik _kreirao;
	@ManyToOne
	@JoinColumn(name="skladiste_id")
	Skladiste _skladiste;
	@OneToMany(mappedBy="_dokument")
	Set<StavkaDokumenta> _stavke;
	
	public Dokument() {}
    
	public String toString()
	{
		return this.getId() + "-[Dokument]-" + this.getDatum().toString().substring(0, 10);
	}
	public String dajTip()
	{
		return "DOK";
	}
}
