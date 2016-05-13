package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="SKLADISTE")
public class Skladiste implements Serializable {
	@Id
	@GeneratedValue
	@Column(name="skladiste_id")
	long id;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getKontaktTelefon() {
		return kontaktTelefon;
	}

	public void setKontaktTelefon(String kontaktTelefon) {
		this.kontaktTelefon = kontaktTelefon;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getRadnoVrijemeOd() {
		return radnoVrijemeOd;
	}

	public void setRadnoVrijemeOd(int radnoVrijemeOd) {
		this.radnoVrijemeOd = radnoVrijemeOd;
	}

	public int getRadnoVrijemeDo() {
		return radnoVrijemeDo;
	}

	public void setRadnoVrijemeDo(int radnoVrijemeDo) {
		this.radnoVrijemeDo = radnoVrijemeDo;
	}

	public Set<Uposlenik> get_uposlenici() {
		return _uposlenici;
	}

	public void set_uposlenici(Set<Uposlenik> _uposlenici) {
		this._uposlenici = _uposlenici;
	}

	public Set<SkladisteArtikal> get_skladisteArtikli() {
		return _skladisteArtikli;
	}

	public void set_skladisteArtikli(Set<SkladisteArtikal> _skladisteArtikli) {
		this._skladisteArtikli = _skladisteArtikli;
	}

	public Set<Dokument> get_dokumenti() {
		return _dokumenti;
	}

	public void set_dokumenti(Set<Dokument> _dokumenti) {
		this._dokumenti = _dokumenti;
	}
	@Column(name="adresa")
	String adresa;
	@Column(name="kontakt_telefon")
	String kontaktTelefon;
	@Column(name="naziv")
	String naziv;
	@Column(name="radno_vrijeme_od")
	int radnoVrijemeOd;
	@Column(name="radno_vrijeme_do")
	int radnoVrijemeDo;
	@OneToMany(mappedBy="_skladiste")
	Set<Uposlenik> _uposlenici;
	@OneToMany(mappedBy="_skladiste")
	Set<SkladisteArtikal> _skladisteArtikli;
	@OneToMany(mappedBy="_skladiste")
	Set<Dokument> _dokumenti;
	
	public Skladiste() {}
}
