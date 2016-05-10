package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL;

import org.hibernate.Query;
import org.hibernate.Transaction;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.App;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Skladiste;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.StrucnaSprema;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.TipUposlenika;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Uposlenik;

public class MenadzerUposleniciBLL {
	public static void DodajUposlenika(String ime, String prezime, String jmbg,
			java.util.Date datumRodjenja, String mjestoRodjenja, String adresa, String telefon, String email,
			int strucnaSprema, int tipUposlenika, String user, String pass, int skladiste){
		Transaction t = App.session.beginTransaction();		
		Uposlenik noviUposlenik = new Uposlenik();		
		
		noviUposlenik.setIme(ime);
		noviUposlenik.setPrezime(prezime);
		noviUposlenik.setJMBG(jmbg);
		noviUposlenik.setDatumRodjenja(datumRodjenja);
		noviUposlenik.setMjestoRodjenja(mjestoRodjenja);
		noviUposlenik.setAdresaStanovanja(adresa);
		noviUposlenik.setBrojTelefona(telefon);
		noviUposlenik.setEmail(email);
		noviUposlenik.setStrucnaSprema(StrucnaSprema.V_VKV);//Treba ispraviti da prima parametar
		noviUposlenik.setDatumZaposlenja(datumRodjenja);//Treba datum zaposlenja
		noviUposlenik.setUser(user);
		noviUposlenik.setPassword(pass);
		noviUposlenik.setTipUposlenika(TipUposlenika.Menadzer);//Treba ispraviti da prima parametar
		
		Skladiste s = App.session.load(Skladiste.class, (long)skladiste);
		noviUposlenik.setId(s.getId());
		
		//Long id = (Long)App.session.save(noviUposlenik);		
		System.out.println("Dodan uposlenik");
		App.session.save(noviUposlenik);
		t.commit();
		
		
		//Treba za drugi datum datum zaposlenja
		/*Query query = App.session.createQuery("insert into Uposlenik values(" + ime +","+prezime+","+jmbg+","
				+datumRodjenja+","+mjestoRodjenja+","+adresa+","+telefon+","+email+","+strucnaSprema+","+datumRodjenja
				+","+user+","+pass+","+tipUposlenika+","+skladiste);

		int result = query.executeUpdate();

		System.out.println("Rows affected: " + result);
		App.session.getTransaction().commit();*/

	}
}
