package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL;

import java.io.Serializable;

public class Artikal implements Serializable {
	long id;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBarKod() {
		return barKod;
	}

	public void setBarKod(String barKod) {
		this.barKod = barKod;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public double getJedinicnaKolicina() {
		return jedinicnaKolicina;
	}

	public void setJedinicnaKolicina(double jedinicnaKolicina) {
		this.jedinicnaKolicina = jedinicnaKolicina;
	}

	public MjernaJedinica getMjernaJedinica() {
		return mjernaJedinica;
	}

	public void setMjernaJedinica(MjernaJedinica mjernaJedinica) {
		this.mjernaJedinica = mjernaJedinica;
	}

	public int getKolicina() {
		return kolicina;
	}

	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}

	public double getProdajnaCijena() {
		return prodajnaCijena;
	}

	public void setProdajnaCijena(double prodajnaCijena) {
		this.prodajnaCijena = prodajnaCijena;
	}

	String barKod;
	String naziv;
	double jedinicnaKolicina;
	MjernaJedinica mjernaJedinica;
	int kolicina;
	double prodajnaCijena;
	
	public Artikal() {}
}
