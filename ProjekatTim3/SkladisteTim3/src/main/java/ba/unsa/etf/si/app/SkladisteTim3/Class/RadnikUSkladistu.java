package ba.unsa.etf.si.app.SkladisteTim3.Class;

import java.io.Serializable;

public class RadnikUSkladistu extends Uposlenik implements Serializable {
	long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public RadnikUSkladistu() {}
}
