package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.App;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.*;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI.*;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.Query;


public class TrenutnoStanjeSkladistaBLL {

	public List<Artikal> dajTrenutnoStanje(String skladiste) {
		String hq1 = "from Skladiste where naziv = :naziv_pp";
		Query query = App.session.createQuery(hq1);
		query.setParameter("naziv_pp", skladiste);
		List<Artikal> artikliNaStanju = new ArrayList<Artikal>();
		try {
			Skladiste ss = (Skladiste) query.uniqueResult();
			
			for (SkladisteArtikal sa: ss.get_skladisteArtikli()){
				artikliNaStanju.add(sa.get_artikal());
			}
		}
		catch(NullPointerException e){
		}
		return artikliNaStanju;
	}
	
	public List<Skladiste> dajSkladista(){
		String hq1 = "from Skladiste";
		Query query = App.session.createQuery(hq1);
		List<Skladiste> skladista = new ArrayList<Skladiste>();
		try {
			skladista = (List<Skladiste>) query.list();
		}
		catch(NullPointerException e){
			
		}
		return skladista;
	}
	
}
