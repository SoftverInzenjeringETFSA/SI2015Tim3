package ba.unsa.etf.si.app.SkladisteTim3.Class;

public abstract class Dokument {
	long id;
	java.util.Date datum;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public java.util.Date getDatum() {
		return datum;
	}
	public void setDatum(java.util.Date datum) {
		this.datum = datum;
	}
	
	// not
	public void dodajArtikal(Artikal _artikal) {}
	public void obrisiArtikal(Artikal _artikal) {}
}
