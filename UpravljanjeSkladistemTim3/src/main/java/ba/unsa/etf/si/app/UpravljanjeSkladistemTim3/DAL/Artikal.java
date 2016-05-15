package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ARTIKAL")
public class Artikal implements Serializable {
	@Id
	@GeneratedValue
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

	public double getProdajnaCijena() {
		return prodajnaCijena;
	}

	public void setProdajnaCijena(double prodajnaCijena) {
		this.prodajnaCijena = prodajnaCijena;
	}
	
	@Column(name="bar_kod")
	String barKod;
	@Column(name="naziv")
	String naziv;
	@Column(name="jedinicna_kolicina")
	double jedinicnaKolicina;
	@Column(name="mjerna_jedinica")
	MjernaJedinica mjernaJedinica;
	@Column(name="prodajna_cijena")
	double prodajnaCijena;
	
	public Artikal() {}
}
