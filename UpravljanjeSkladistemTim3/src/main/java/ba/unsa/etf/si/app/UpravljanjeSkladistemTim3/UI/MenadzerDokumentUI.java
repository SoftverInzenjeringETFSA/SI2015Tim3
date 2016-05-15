package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class MenadzerDokumentUI {

	public MenadzerDokumentUI() { }

	public boolean PopuniListuDokumenata(JLabel status, Date OD, Date DO, List<String> trazi) {		
		if(OD.compareTo(DO) == 1) {
			status.setText("Datum DO mora biti veci od datum OD!");
			status.setForeground(Color.RED);
			return false;
		}
		if(trazi == null || trazi.isEmpty()) {
			status.setText("Molimo izaberite vrstu dokumenta!");
			status.setForeground(Color.RED);
			return false;
		}
		
		status.setText("");
		status.setForeground(Color.GREEN);
		return true;
	}
	
	public boolean ProvjeriDatumNull(JLabel status, String d1, String d2) {
		if(d1.isEmpty()) {
			status.setText("Molimo izaberite datum OD!");
			status.setForeground(Color.RED);
			return false;
		}		
		if(d2.isEmpty()) {
			status.setText("Molimo izaberite datum DO!");
			status.setForeground(Color.RED);
			return false;
		}
		
		status.setText("");
		status.setForeground(Color.GREEN);
		return true;
	}
}
				