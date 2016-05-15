package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL.UposlenikOtpremanjeBLL;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL.UposlenikUnosRobeBLL;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Artikal;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Uposlenik;

public class UposlenikOtpremanjeUI {
	
	public UposlenikOtpremanjeUI() {
		uposOtpremBLL = new UposlenikOtpremanjeBLL();
	}
	private UposlenikOtpremanjeBLL uposOtpremBLL;
	
	public String dodajArtikalZaOtpremu(JTable tabela, JTextField prodajnaCijena, String barKod, int kolicinaZaOtprem){
		
		String prodCijena = prodajnaCijena.getText();

		//Provjera polja
		if(barKod.equals(""))
			return "Nije unesen bar kod!";
		else if(!barKod.matches("^[a-zA-Z0-9]*$"))
			return "Nije ispravan bar kod";
		else if(kolicinaZaOtprem <= 0)
			return "Količina nije ispravna";
		else if(prodajnaCijena.equals(""))
			return "Nije unesena prodajna cijena!";
		else{
			
			try {
				Double.parseDouble(prodCijena);
			}
			catch (NumberFormatException e) {
				return "Prodajna cijena nije broj!";
			}
			
			if(Double.parseDouble(prodCijena) <= 0)
				return "Prodajna cijena ne može biti negativna!";

			Artikal a = uposOtpremBLL.dobaviArtikalZaOtprem(barKod, kolicinaZaOtprem, Double.parseDouble(prodCijena));
			double staraKol = uposOtpremBLL.dobaviStaruKolicinuArtikla(a.getId());
			//System.out.println("Greska  "+staraKol + "  " + kolicinaZaOtprem);
			if(kolicinaZaOtprem > staraKol){
				return "Količina nije ispravna!";
			}
			else{
				DefaultTableModel model = (DefaultTableModel) tabela.getModel();
				model.addRow(new Object[] {a.getBarKod(), a.getNaziv(), a.getJedinicnaKolicina(),
						kolicinaZaOtprem, a.getMjernaJedinica(), prodCijena});
			}
					
		}
		
		return "";
	}
		
		public String dobaviProdajnuCijenu(JTextField prodajnaCijena, String barKod){
			Double cijena = uposOtpremBLL.dobaviProdajnuCijenu(barKod);
			if(cijena==0)
				return "Artikal sa unesenim bar kodom ne postoji!";
			String prodCijena = Double.toString(uposOtpremBLL.dobaviProdajnuCijenu(barKod));
			
			prodajnaCijena.setText(prodCijena);
			return "  ";
		}
		
		public String zavrsiOtpremanje(Uposlenik user){
			int res = uposOtpremBLL.zavrsiOtpremanje(user);
			if(res == 0)
				return "Niste odabrali nijedan artikal za otpremu!";
			else if(res == 2)
				return "Otpremanje nije uspješno!";
			else{
				JOptionPane.showMessageDialog(null, "Uspješno ste završili otpremanje.");
				return "  ";
			}
		}
}
