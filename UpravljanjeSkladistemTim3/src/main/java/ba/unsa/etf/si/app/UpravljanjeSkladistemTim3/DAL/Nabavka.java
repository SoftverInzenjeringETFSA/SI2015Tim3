package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL;

import java.io.Serializable;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="NABAVKA")
@AttributeOverrides({
    @AttributeOverride(name="datum", column=@Column(name="datum")),
    @AttributeOverride(name="_kreirao", column=@Column(name="uposlenik_id")),
    @AttributeOverride(name="_skladiste", column=@Column(name="skladiste_id")),
    @AttributeOverride(name="_stavke", column=@Column(name=""))
})
public class Nabavka extends Dokument implements Serializable {
	@Column(name="bar_kod")
	String barKod;
	public String getBarKod() {
		return barKod;
	}

	public void setBarKod(String barKod) {
		this.barKod = barKod;
	}

	public PoslovniPartner get_dobavaljc() {
		return _dobavaljc;
	}

	public void set_dobavaljc(PoslovniPartner _dobavaljc) {
		this._dobavaljc = _dobavaljc;
	}
	@ManyToOne
	@JoinColumn(name="poslnovi_partner_id")
	PoslovniPartner _dobavaljc;
	
	public Nabavka() {}
	
	public String toString()
	{
		return this.getId() + "-[Nabavka]-" + this.getDatum().toString().substring(0, 10);
	}
}
