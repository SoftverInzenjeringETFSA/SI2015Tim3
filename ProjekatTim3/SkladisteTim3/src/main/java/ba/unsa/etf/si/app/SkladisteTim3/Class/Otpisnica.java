package ba.unsa.etf.si.app.SkladisteTim3.Class;

import java.io.Serializable;

public class Otpisnica extends Dokument implements Serializable {
	String razlogOtpisa;

	public String getRazlogOtpisa() {
		return razlogOtpisa;
	}

	public void setRazlogOtpisa(String razlogOtpisa) {
		this.razlogOtpisa = razlogOtpisa;
	}
	
	public Otpisnica() {}
}
