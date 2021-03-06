package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL.UposlenikUnosRobeBLL;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.MjernaJedinica;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Skladiste;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Uposlenik;

public class UposlenikUnosRobeUI {
	
	public UposlenikUnosRobeUI() {
		bll = new UposlenikUnosRobeBLL();
	}
	public void SetUser(Uposlenik user) {
		bll.SetUser(user);
	}
	private UposlenikUnosRobeBLL bll;
	
	// Za sada se provjerava samo duzina i da su svi elementi cifre
	public boolean ValidateEan(String eanBarCode) {
		if(eanBarCode.length() != 13) return false;
		
		String validChars = "0123456789";
		for(int i = 0; i < eanBarCode.length(); i++) {
			char cifra = eanBarCode.charAt(i);
			if(validChars.indexOf(cifra) == -1) return false;
		}
		return true;
	}
	
	public boolean DodajArtikal(JLabel status, JTable tabela, String ean, int kolicina, String nabavnaCijena) {
		if(!ValidateCommon(status, ean, nabavnaCijena, kolicina))
			return false;
		int res = bll.DodajArtikal(ean, kolicina, Double.parseDouble(nabavnaCijena));
		
		if(res == 1) {
			status.setText("Navedeni artikal ne postoji u bazi!");
			status.setForeground(Color.RED);
			return false;
		} 
		else if(res == 2) {
			status.setText("Navedeni artikal je vec unesen u ovoj narudzbi!");
			status.setForeground(Color.RED);
			return false;
		}
		
		DefaultTableModel model = (DefaultTableModel) tabela.getModel();
		model.addRow(new Object[] {ean, kolicina, nabavnaCijena});
		return true;
	}
	
	public boolean DodajNoviArtikal(JLabel status, JTable tabela, String ean, int kolicina, String nabavnaCijena, String naziv, String jedinicnaKolicina, MjernaJedinica mjernaJedinica, String prodajnaCijena) {
		if(!ValidateCommon(status, ean, nabavnaCijena, kolicina))
			return false;
		if(naziv == null || naziv.length() == 0) {
			status.setText("Niste unijeli naziv!");
			status.setForeground(Color.RED);
			return false;
		}
		if(jedinicnaKolicina.length() == 0) {
			status.setText("Niste unijeli jedinicnu kolicinu!");
			status.setForeground(Color.RED);
			return false;
		}
		try {
			Double.parseDouble(jedinicnaKolicina);
		}
		catch (NumberFormatException e) {
			status.setText("Jedinicna kolicina nije broj!");
			status.setForeground(Color.RED);
			return false;
		}
		if(Double.parseDouble(jedinicnaKolicina) <= 0) {
			status.setText("Jedinicna kolicina ne moze biti negativna!");
			status.setForeground(Color.RED);
			return false;
		}
		if(prodajnaCijena.length() == 0) {
			status.setText("Niste unijeli prodajnu cijenu!");
			status.setForeground(Color.RED);
			return false;
		}
		try {
			Double.parseDouble(prodajnaCijena);
		}
		catch (NumberFormatException e) {
			status.setText("Prodajna cijena nije broj!");
			status.setForeground(Color.RED);
			return false;
		}
		if(Double.parseDouble(prodajnaCijena) <= 0) {
			status.setText("Prodajna cijena ne moze biti negativna!");
			status.setForeground(Color.RED);
			return false;
		}
		int res = bll.DodajNoviArtikal(ean, kolicina, Double.parseDouble(nabavnaCijena), naziv, mjernaJedinica, Double.parseDouble(jedinicnaKolicina), Double.parseDouble(prodajnaCijena));
		
		if(res == 1) {
			status.setText("Navedeni artikal vec postoji u bazi!");
			status.setForeground(Color.RED);
			return false;
		}
		else if(res == 2) {
			status.setText("Navedeni artikal je vec unesen u ovoj narudzbi!");
			status.setForeground(Color.RED);
			return false;
		}
		
		DefaultTableModel model = (DefaultTableModel) tabela.getModel();
		model.addRow(new Object[] {ean, kolicina, nabavnaCijena});
		return true;
	}
	
	public boolean UnosNabavke(JLabel status, Uposlenik user, String poslovniPartner, String barKod) {
		if (poslovniPartner == null || poslovniPartner.length() == 0) {
			status.setText("Niste odabrali dobavljaca!");
			status.setForeground(Color.RED);
			return false;
		}
		if(!ValidateEan(barKod)) {
			status.setText("Neispravan EAN bar kod!");
			status.setForeground(Color.RED);
			return false;
		}
		
		int res = bll.DodajNabavku(barKod, user, poslovniPartner);
		if(res == 1) {
			status.setText("Niste unijeli niti jedan artikal!");
			status.setForeground(Color.RED);
			return false;
		}
		else if(res == 2) {
			status.setText("Vec postoji nabaka sa unesenim bar kodom!");
			status.setForeground(Color.RED);
			return false;
		}
		
		return true;
	}
	
	public boolean ValidateCommon(JLabel status, String ean, String nabavnaCijena, int kolicina){
		if(!ValidateEan(ean)) {
			status.setText("Neispravan EAN bar kod!");
			status.setForeground(Color.RED);
			return false;
		}
		if(nabavnaCijena == null || nabavnaCijena.length() == 0) {
			status.setText("Niste unijeli nabavnu cijenu!");
			status.setForeground(Color.RED);
			return false;
		}
		if(kolicina < 1) {
			status.setText("Kolicina mora biti prirodan broj!");
			status.setForeground(Color.RED);
			return false;
		}
		try {
			Double.parseDouble(nabavnaCijena);
		}
		catch (NumberFormatException e) {
			status.setText("Nabavna cijena nije broj!");
			status.setForeground(Color.RED);
			return false;
		}
		if(Double.parseDouble(nabavnaCijena) <= 0) {
			status.setText("Nabavna cijena ne moze biti negativna!");
			status.setForeground(Color.RED);
			return false;
		}
		return true;
	}
}
