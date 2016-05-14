package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import java.awt.Color;
import java.util.Date;

import javax.swing.JLabel;

public class MenadzerDokumentUI {

	public MenadzerDokumentUI() { }

	public boolean PopuniListuDokumenata(JLabel status, Date OD, Date DO) {	

		if(OD.compareTo(DO) == 1) {
			status.setText("Datum DO mora biti veci od datum OD!");
			status.setForeground(Color.RED);
			return false;
		}
		
		status.setText("");
		status.setForeground(Color.GREEN);
		return true;
	}
	
}
				