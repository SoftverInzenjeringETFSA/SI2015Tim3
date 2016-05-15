package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL;

import java.io.Serializable;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="OTPISNICA")
@AttributeOverrides({
    @AttributeOverride(name="datum", column=@Column(name="datum")),
    @AttributeOverride(name="_kreirao", column=@Column(name="uposlenik_id")),
    @AttributeOverride(name="_skladiste", column=@Column(name="skladiste_id")),
    @AttributeOverride(name="_stavke", column=@Column(name=""))
})
public class Otpisnica extends Dokument implements Serializable {
	@Column(name="razlog_otpisa")
	String razlogOtpisa;
	
	public String getRazlogOtpisa() {
		return razlogOtpisa;
	}

	public void setRazlogOtpisa(String razlogOtpisa) {
		this.razlogOtpisa = razlogOtpisa;
	}

	public Otpisnica() {}
	
	public String toString()
	{
		return this.getId() + "-[Otpisnica]-" + this.getDatum().toString().substring(0, 10);
	}
	public String dajTip()
	{
		return "OTS";
	}
}
