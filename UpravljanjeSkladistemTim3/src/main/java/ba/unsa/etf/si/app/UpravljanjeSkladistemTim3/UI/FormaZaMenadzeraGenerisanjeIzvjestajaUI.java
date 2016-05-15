package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.App;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL.FormaZaMenadzeraGenerisanjeIzvjestajaBLL;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Artikal;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Skladiste;

public class FormaZaMenadzeraGenerisanjeIzvjestajaUI {

	private FormaZaMenadzeraGenerisanjeIzvjestajaBLL bll;
	
	public FormaZaMenadzeraGenerisanjeIzvjestajaUI(){
		bll = new FormaZaMenadzeraGenerisanjeIzvjestajaBLL();
	}
	
	public void ponistiKontrole(JComboBox comboBox_1, JRadioButton radioButton, JRadioButton radioButton_1,
			JCheckBox checkBox, JComboBox comboBox_2, JComboBox comboBox_3, JTextField textField_11) {
		comboBox_1.setSelectedIndex(-1);
		radioButton.setSelected(false);
		radioButton_1.setSelected(false);
		checkBox.setSelected(false);
		comboBox_2.setSelectedIndex(-1);
		comboBox_3.setSelectedIndex(-1);
		textField_11.setText("");
	}
	
	public void ponistiBarKod (JTextField barKod){
		barKod.setText("");
	}
	
	public void generisiIzvjestaj(JComboBox comboBox, JRadioButton trend, JRadioButton sumarni, JCheckBox checkBox, JComboBox comboBox_2, JComboBox comboBox_3, JTextField barKod, JLabel status) {
		// validacija
		if (comboBox.getSelectedItem()==null){
			status.setText("Niste odabrali skladiste!");
			status.setForeground(Color.red);
			return;
		}
		if (trend.isSelected()==false && sumarni.isSelected()==false){
			status.setText("Niste odabrali tip izvjestaja!");
			status.setForeground(Color.red);
			return;
		}
		if ((checkBox.isSelected()==false) && (comboBox_2.getSelectedItem()==null || comboBox_3.getSelectedItem()==null)){
			status.setText("Niste odabrali vremenski period!");
			status.setForeground(Color.red);
			return;
		}
		Skladiste s = bll.dajSkladiste(comboBox.getSelectedItem().toString());
		if (s == null){
				status.setText("Niste odabrali skladiste!");
				status.setForeground(Color.red);
				return;
		}
		else {
			if (trend.isSelected()){
				Artikal a = bll.dajArtikal(barKod.getText());
				if (a == null){
					status.setText("Artikal sa tim bar-kodom ne postoji!");
					status.setForeground(Color.red);
					ponistiBarKod(barKod);
					return;
				}
				try {
					bll.generisiIzvjestajTrend(s, a, status);
					ponistiKontrole(comboBox, trend, sumarni, checkBox, comboBox_2, comboBox_3, barKod);
				}
				catch (Exception e){
					App.logger.error("Omaska.", e);
				}	
			}
			if (sumarni.isSelected()){
				List<Artikal> artikli = new ArrayList<Artikal>();
				artikli = bll.dajArtikle(s.getNaziv());
				try {
					bll.generisiIzvjestajSumarni(s,  artikli, status);
					ponistiKontrole(comboBox, trend, sumarni, checkBox, comboBox_2, comboBox_3, barKod);
				}
				catch(Exception e){	
					App.logger.error("Omaska.", e);
				}
			}
		}
	}

}

