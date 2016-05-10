package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL.UposlenikBLL;

public class UnosRobeUI {
	// Za sada se provjerava samo duzina i da su svi elementi cifre
	public static boolean ValidateEan(String eanBarCode) {
		if(eanBarCode.length() != 13) return false;
		
		String validChars = "0123456789";
		for(int i = 0; i < eanBarCode.length(); i++) {
			char cifra = eanBarCode.charAt(i);
			if(validChars.indexOf(cifra) == -1) return false;
		}
		return true;
	}
	
	public static void DodajArtikal(JLabel status, JTable tabela, String ean, int kolicina, String nabavnaCijena) {
		if(!ValidateEan(ean)) {
			status.setText("Neispravan EAN bar kod!");
			status.setForeground(Color.RED);
			return;
		}
		if(nabavnaCijena.length() == 0) {
			status.setText("Niste unijeli nabavnu cijenu!");
			status.setForeground(Color.RED);
			return;
		}
		try {
			Double.parseDouble(nabavnaCijena);
		}
		catch (NumberFormatException e) {
			status.setText("Nabavna cijena nije broj!");
			status.setForeground(Color.RED);
			return;
		}
		if(Double.parseDouble(nabavnaCijena) <= 0) {
			status.setText("Nabavna cijena ne moze biti negativna!");
			status.setForeground(Color.RED);
			return;
		}
		
		if(!UposlenikBLL.DodajArtikal(ean, kolicina, Double.parseDouble(nabavnaCijena))) {
			status.setText("Navedeni artikal ne postoji u bazi!");
			status.setForeground(Color.RED);
			return;
		}
		
		DefaultTableModel model = (DefaultTableModel) tabela.getModel();
		model.addRow(new Object[] {ean, kolicina, nabavnaCijena});
	}		
}
