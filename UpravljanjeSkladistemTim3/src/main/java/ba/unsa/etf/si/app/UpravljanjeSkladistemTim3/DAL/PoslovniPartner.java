package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="POSLOVNI_PARTNER")
public class PoslovniPartner implements Serializable {
	@Id
	@GeneratedValue
	@Column(name="poslovni_partner_id")
	long id;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getJIB() {
		return JIB;
	}

	public void setJIB(String jIB) {
		JIB = jIB;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	@Column(name="jib")
	String JIB;
	@Column(name="naziv")
	String naziv;
	@Column(name="adresa")
	String adresa;
	public PoslovniPartner() {}
}
