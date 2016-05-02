package ba.unsa.etf.si.app.SkladisteTim3.Class;

import java.io.Serializable;

public class Skladiste implements Serializable {
	long id;
	String adresa, kontaktTelefon, naziv;
	RadnoVrijeme radnoVrijeme;
	
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
	public RadnoVrijeme getRadnoVrijeme() {
		return radnoVrijeme;
	}
	public void setRadnoVrijeme(RadnoVrijeme radnoVrijeme) {
		this.radnoVrijeme = radnoVrijeme;
	}
	
	public Skladiste() {}
	
	// nije implementirano
	public void dodajUposlenika(Uposlenik _uposlenik) {}
	public void obrisiUposlenika(Uposlenik _uposlenik) {}
	public void prikaziUposlenike() {}
	public void dodajNabavku(Nabavka _nabavka){}
	public void pregledStanjaRobe() {} 
	public void generisiSumarniIzvjestaj(java.util.Date _od, java.util.Date _do) {}
	public void generisiIzvjestajProizvoda(Artikal proizvod) {}
	
}
