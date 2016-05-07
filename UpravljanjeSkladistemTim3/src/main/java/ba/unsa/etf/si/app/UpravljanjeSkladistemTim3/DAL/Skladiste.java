package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Skladiste implements Serializable {
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

	public Date getRadnoVrijemeOd() {
		return radnoVrijemeOd;
	}

	public void setRadnoVrijemeOd(Date radnoVrijemeOd) {
		this.radnoVrijemeOd = radnoVrijemeOd;
	}

	public Date getRadnoVijemeDo() {
		return radnoVijemeDo;
	}

	public void setRadnoVijemeDo(Date radnoVijemeDo) {
		this.radnoVijemeDo = radnoVijemeDo;
	}

	public List<Uposlenik> get_uposlenici() {
		return _uposlenici;
	}

	public void set_uposlenici(List<Uposlenik> _uposlenici) {
		this._uposlenici = _uposlenici;
	}

	public List<SkladisteArtikal> get_skladisteArtikli() {
		return _skladisteArtikli;
	}

	public void set_skladisteArtikli(List<SkladisteArtikal> _skladisteArtikli) {
		this._skladisteArtikli = _skladisteArtikli;
	}

	public List<Dokument> get_dokumenti() {
		return _dokumenti;
	}

	public void set_dokumenti(List<Dokument> _dokumenti) {
		this._dokumenti = _dokumenti;
	}

	String adresa;
	String kontaktTelefon;
	String naziv;
	Date radnoVrijemeOd;
	Date radnoVijemeDo;
	List<Uposlenik> _uposlenici;
	List<SkladisteArtikal> _skladisteArtikli;
	List<Dokument> _dokumenti;
	
	public Skladiste() {}
}
