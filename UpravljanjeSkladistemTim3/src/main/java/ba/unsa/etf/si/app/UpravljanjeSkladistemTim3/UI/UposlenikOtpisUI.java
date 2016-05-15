package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTable;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL.UposlenikOtpisBLL;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Artikal;

public class UposlenikOtpisUI {
	private UposlenikOtpisBLL bll;
	
	public UposlenikOtpisUI() {
		bll = new UposlenikOtpisBLL();
	}
	
	public boolean DodajArtikalZaOtpis(JLabel status, JTable tabela, String barKod, int kolicina) {
		if(barKod == null || barKod.length() == 0) {
			status.setText("Niste unijeli bar kod!");
			status.setForeground(Color.RED);
			return false;
		}
		if(!ValidateEan(barKod)) {
			status.setText("Neispravan bar kod!");
			status.setForeground(Color.RED);
			return false;
		}
		if(kolicina < 1) {
			status.setText("Ne mozete otpisati manje od jednog artikla!");
			status.setForeground(Color.RED);
			return false;
		}
		Artikal ar = bll.DajArtikal(barKod, kolicina);
		
		if(ar == null) {
			status.setText("Artikal sa unesenim bar kodom ne postoji u bazi!");
			status.setForeground(Color.RED);
			return false;
		}
		// promjena kolicina
		/*if(ar.getKolicina() < kolicina) {
			status.setText("Prevelika kolicina!");
			status.setForeground(Color.RED);
			return false;
		}*/
		double ponderirana = bll.DajPonderiranu(ar.getId());
		bll.DodajZaOtpis(ar, ponderirana);
		return false;
	}
	
	public boolean ValidateEan(String eanBarCode) {
		if(eanBarCode.length() != 13) return false;
		
		String validChars = "0123456789";
		for(int i = 0; i < eanBarCode.length(); i++) {
			char cifra = eanBarCode.charAt(i);
			if(validChars.indexOf(cifra) == -1) return false;
		}
		return true;
	}
}
