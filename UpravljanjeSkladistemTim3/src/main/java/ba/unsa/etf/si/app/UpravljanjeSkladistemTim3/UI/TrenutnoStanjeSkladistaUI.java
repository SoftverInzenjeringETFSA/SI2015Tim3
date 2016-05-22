package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.text.DecimalFormat;
import java.util.ArrayList;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.*;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.App;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL.*;


public class TrenutnoStanjeSkladistaUI {

	private TrenutnoStanjeSkladistaBLL bll;
	
	public TrenutnoStanjeSkladistaUI(){
		bll = new TrenutnoStanjeSkladistaBLL();
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
		List<Artikal> artikli = bll.dajTrenutnoStanje(skladiste);
		Skladiste s = new Skladiste();
		s = bll.dajSkladiste(skladiste);
			
		DefaultTableModel model = (DefaultTableModel) tabela.getModel();
		// obrisemo sto je prije bilo
		model.setRowCount(0);
		for (Artikal a: artikli){
			DecimalFormat f = new DecimalFormat("#0.00");
			// "Bar-kod", "Naziv", "Koli\u010Dina", "Mjerna jedinica", "Prodajna cijena", "Ponderirana cijena"
			try {
				model.addRow(new Object[] { a.getBarKod(), a.getNaziv(), bll.DajKolicinu(a.getId(), s.getId()), a.getMjernaJedinica().toString(), f.format(a.getProdajnaCijena()), f.format(bll.DajPonderiranu(a.getId(),  s.getId())) });
			}
			catch(Exception ex){
				App.logger.error("Omaska", ex);
			}
		}
	}
	
	public void trenutnoStanjeSkladistaMenadzer(JComboBox comboBox, JTable tabela, JLabel status){
		trenutnoStanjeSkladista(comboBox.getSelectedItem().toString(), tabela, status);
	}
	
}
