package ba.unsa.etf.si.app.SkladisteTim3.Class;

import java.io.Serializable;

public class Artikal implements Serializable {
	long id;
	String barKod, naziv;
	double jedinicnaKolicina, nabavnaCijena, cijena, prodajnaCijena;
	MjernaJedinica mjernaJedinica;
	int kolicina;
	
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
	public double getNabavnaCijena() {
		return nabavnaCijena;
	}
	public void setNabavnaCijena(double nabavnaCijena) {
		this.nabavnaCijena = nabavnaCijena;
	}
	public double getCijena() {
		return cijena;
	}
	public void setCijena(double cijena) {
		this.cijena = cijena;
	}
	public double getProdajnaCijena() {
		return prodajnaCijena;
	}
	public void setProdajnaCijena(double prodajnaCijena) {
		this.prodajnaCijena = prodajnaCijena;
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
	
	public Artikal() {}
}
