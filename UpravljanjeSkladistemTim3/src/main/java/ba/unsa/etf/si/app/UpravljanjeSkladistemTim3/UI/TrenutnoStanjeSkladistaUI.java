package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.text.DecimalFormat;
import java.util.ArrayList;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.*;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL.*;


public class TrenutnoStanjeSkladistaUI {

	private TrenutnoStanjeSkladistaBLL bll;
	
	public TrenutnoStanjeSkladistaUI(){
		bll = new TrenutnoStanjeSkladistaBLL();
	}
	
	public String dajJedinicnuKolicinu (int jedinica){
		String jedKolicina = null;
		if (jedinica == 0){
			jedKolicina = "kg";
		}
		if (jedinica == 1){
			jedKolicina = "l";
		}
		if (jedinica == 2){
			jedKolicina = "g";
		}
		if (jedinica == 3){
			jedKolicina = "ml";
		}
		if (jedinica == 4){
			jedKolicina = "kom";
		}
		
		return jedKolicina;
	}
	
	public void trenutnoStanjeSkladistaMenadzer(String skladiste, JTable tabela, JLabel status){
		// Provjera da li je odabrano skladiste - suvisno???
		if (skladiste == "") {
			status.setText("Niste odabrali skladište");
			return;
		}
	
		List<Artikal> artikli = bll.dajTrenutnoStanje(skladiste);
	
		DefaultTableModel model = (DefaultTableModel) tabela.getModel();
		// obrisemo sto je prije bilo
		model.setRowCount(0);
		for (Artikal a: artikli){
			// promjena kolicina
			//	model.addRow(new Object[] { a.getBarKod(), a.getNaziv(), a.getJedinicnaKolicina(), a.getKolicina(), a.getProdajnaCijena()});
		}
	}

	public void napuniComboBoxSkladistima(JComboBox comboBox) {
		List<Skladiste> skladista = new ArrayList<Skladiste>();
		skladista = bll.dajSkladista();
		for (Skladiste s: skladista){
			comboBox.addItem(s.getNaziv());
		}
		comboBox.setSelectedIndex(-1);
	}

	public void trenutnoStanjeSkladista(String skladiste, JTable tabela, JLabel status) {
		// Provjera da li je odabrano skladiste - suvisno???
		if (skladiste == "") {
			status.setText("Niste odabrali skladište");
			return;
		}
		
		List<Artikal> artikli = bll.dajTrenutnoStanje(skladiste);
			
		DefaultTableModel model = (DefaultTableModel) tabela.getModel();
		// obrisemo sto je prije bilo
		model.setRowCount(0);
		for (Artikal a: artikli){
			// promjena kolicina
			//double cijena = a.getProdajnaCijena()*a.getKolicina();
			DecimalFormat c = new DecimalFormat("#.##");
			//model.addRow(new Object[] { a.getBarKod(), a.getNaziv(), a.getJedinicnaKolicina(), a.getKolicina(), a.getProdajnaCijena(), c.format(cijena)});
		}
	}
	
}
