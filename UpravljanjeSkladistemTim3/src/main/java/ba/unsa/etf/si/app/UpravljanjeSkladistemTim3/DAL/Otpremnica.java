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
@Table(name="OTPREMNICA")
@AttributeOverrides({
    @AttributeOverride(name="datum", column=@Column(name="datum")),
    @AttributeOverride(name="_kreirao", column=@Column(name="uposlenik_id")),
    @AttributeOverride(name="_skladiste", column=@Column(name="skladiste_id")),
    @AttributeOverride(name="_stavke", column=@Column(name=""))
})
public class Otpremnica extends Dokument implements Serializable {
	@ManyToOne
	@JoinColumn(name="poslnovni_partner_id")
	PoslovniPartner _kupac;
	
	public PoslovniPartner get_kupac() {
		return _kupac;
	}

	public void set_kupac(PoslovniPartner _kupac) {
		this._kupac = _kupac;
	}

	public Otpremnica() {}
	
	public String toString()
	{
		return this.getId() + "-[Otpremnica]-" + this.getDatum().toString().substring(0, 10);
	}
	public String dajTip()
	{
		return "OTP";
	}
}
