package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL.UposlenikOtpisBLL;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Artikal;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.MjernaJedinica;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Otpisnica;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Skladiste;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Uposlenik;

public class UposlenikOtpisUI {
	private UposlenikOtpisBLL bll;
	
	public UposlenikOtpisUI() {
		bll = new UposlenikOtpisBLL();
	}
	
	public boolean DodajArtikalZaOtpis(JLabel status, JTable tabela, String barKod, int kolicina, Skladiste skladiste) {
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
		Artikal ar = bll.DajArtikal(barKod);
		
		if(ar == null) {
			status.setText("Artikal sa unesenim bar kodom ne postoji u bazi!");
			status.setForeground(Color.RED);
			return false;
		}
		int kolicinaNaStanju = bll.DajKolicinu(ar.getId(), skladiste.getId());
		if(kolicinaNaStanju < kolicina) {
			status.setText("Prevelika kolicina!");
			status.setForeground(Color.RED);
			return false;
		}
		
		double ponderirana = bll.DajPonderiranu(ar.getId(), skladiste.getId());
		if(!bll.DodajZaOtpis(ar, ponderirana, kolicina)) {
			status.setText("Artikal se vec nalazi na listi za otpis!");
			status.setForeground(Color.RED);
			return false;
		}
		DefaultTableModel model = (DefaultTableModel) tabela.getModel();
		model.addRow(new Object[] {barKod, ar.getNaziv(), ar.getJedinicnaKolicina(), (MjernaJedinica)ar.getMjernaJedinica(), kolicina, ponderirana});
		return true;
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

	public void ZavrsiOtpis(String komentar, Uposlenik user) {
		bll.ZavrsiOtpis(komentar, user);		
	}
}
