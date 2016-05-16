package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import javax.swing.JOptionPane;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL.UposlenikUnosPartneraBLL;

public class UposlenikUnosPartneraUI {
	public String unosPartnera(String naziv, String adresa, String jib){
		if(naziv.equals(""))
			return "Nije unesen naziv!";
		else if(adresa.equals(""))
			return "Nije unesena adresa!";
		else if(jib.equals(""))
			return "Nije unesen jib!";
		else if(!naziv.matches("^[A-Z][0-9a-zA-Z.\\- ]*$"))
			return "Naziv nije ispravan! Mora počinjati velikim slovom.";
		else if(!adresa.matches("^[A-Z][0-9a-zA-Z ]*$"))
			return "Adresa nije ispravna! Mora počinjati velikim slovom.";
		else if (!jib.matches("^[1-9][0-9]{12}") )
			return "JIB mora imati 13 cifara";
		else{
			UposlenikUnosPartneraBLL uposUnosPartneraBLL = new UposlenikUnosPartneraBLL();
			int uspjesno = uposUnosPartneraBLL.unosPoslovnogPartnera(naziv, adresa, jib);
			if(uspjesno == 1){
				JOptionPane.showMessageDialog(null, "Uspjesno ste unijeli poslovnog partnera.");
				return "  ";//Oznaka da je poslovni partner uspjesno unesen
			}
			else if(uspjesno == 2)//Oznaka da postoji poslovni partner s tim imenom u bazi
				return "Poslovni partner sa tim imenom vec postoji!";
			else if(uspjesno == 3) //Oznaka da postoji poslovni partner sa tim JIB brojem u bazi
				return "Poslovni partner sa tim JIB brojem već postoji!";
			return "Poslovni partner nije uspjesno unesen!";		
		}
	}
	
}
