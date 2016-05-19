package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

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
			JCheckBox checkBox, JDateChooser dateChooser_od, JDateChooser dateChooser_do, JTextField textField_11, 
			JPanel panel_16, JLabel label_4, JLabel label_5) {
		comboBox_1.setSelectedIndex(-1);
		radioButton.setSelected(false);
		radioButton_1.setSelected(false);
		checkBox.setSelected(false);
		dateChooser_od.setVisible(true);
		dateChooser_do.setVisible(true);
		dateChooser_od.setDate(null);
		dateChooser_do.setDate(null);
		textField_11.setText("");
		panel_16.enable();
		panel_16.setForeground(Color.white);
		label_4.enable();
		label_5.enable();
	}
	
	public void ponistiBarKod (JTextField barKod){
		barKod.setText("");
	}
	
	public void PonistiVrijeme(JDateChooser _od, JDateChooser _do){
		_od.setDate(null);
		_do.setDate(null);
	}
	
	public void generisiIzvjestaj(JComboBox comboBox, JRadioButton trend, JRadioButton sumarni, JCheckBox checkBox, 
			JDateChooser dateChooser_od, JDateChooser dateChooser_do, 
			JTextField barKod, JLabel status, 
			JPanel panel_16, JLabel label_4, JLabel label_5) {
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
		if ((checkBox.isSelected()==false) && (dateChooser_od.getDate()==null || dateChooser_do.getDate()==null)){
			status.setText("Niste odabrali vremenski period!");
			status.setForeground(Color.red);
			return;
		}
		if (dateChooser_od.getDate()!=null && dateChooser_do.getDate()!=null){
			if (dateChooser_od.getDate().compareTo(dateChooser_do.getDate())>0){
				status.setText("Niste odabrali valjan vremenski period!");
				status.setForeground(Color.red);
				PonistiVrijeme(dateChooser_od, dateChooser_do);
				return;
			}
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
					ponistiKontrole(comboBox, trend, sumarni, checkBox, dateChooser_od, 
							dateChooser_do, barKod, panel_16, label_4, label_5);
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
					ponistiKontrole(comboBox, trend, sumarni, checkBox, dateChooser_od, 
							dateChooser_do, barKod, panel_16, label_4, label_5);
				}
				catch(Exception e){	
					App.logger.error("Omaska.", e);
				}
			}
		}
	}

}

