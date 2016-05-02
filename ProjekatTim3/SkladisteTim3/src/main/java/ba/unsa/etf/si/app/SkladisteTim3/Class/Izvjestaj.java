package ba.unsa.etf.si.app.SkladisteTim3.Class;

public abstract class Izvjestaj {
	long id;
	java.util.Date datumGnerisanja, datumOd, datumDo;
	Menadzer generisao;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public java.util.Date getDatumGnerisanja() {
		return datumGnerisanja;
	}
	public void setDatumGnerisanja(java.util.Date datumGnerisanja) {
		this.datumGnerisanja = datumGnerisanja;
	}
	public java.util.Date getDatumOd() {
		return datumOd;
	}
	public void setDatumOd(java.util.Date datumOd) {
		this.datumOd = datumOd;
	}
	public java.util.Date getDatumDo() {
		return datumDo;
	}
	public void setDatumDo(java.util.Date datumDo) {
		this.datumDo = datumDo;
	}
	public Menadzer getGenerisao() {
		return generisao;
	}
	public void setGenerisao(Menadzer generisao) {
		this.generisao = generisao;
	}
	
	public Izvjestaj() {}
}
