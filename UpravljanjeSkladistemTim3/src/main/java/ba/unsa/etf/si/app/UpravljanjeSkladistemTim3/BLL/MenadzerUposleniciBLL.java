package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.App;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Skladiste;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.StrucnaSprema;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.TipUposlenika;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Uposlenik;

public class MenadzerUposleniciBLL {
	public int dodajUposlenika(String ime, String prezime, String jmbg,
			java.util.Date datumRodjenja, String mjestoRodjenja, String adresa, String telefon, String email,
			int strucnaSprema, int tipUposlenika, String user, String pass, int skladiste){
		try{
			if(postojiUposlenikUBaziJMBG(jmbg))
				return 2;
			if(postojiUposlenikUBaziUser(user))
				return 3;
			Transaction t = App.session.beginTransaction();		
			Uposlenik noviUposlenik = new Uposlenik();		
			System.out.println(skladiste);
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
		
			Skladiste s = App.session.load(Skladiste.class, (long)1);//Treba promijeniti
			System.out.println(s.getNaziv());
			noviUposlenik.set_skladiste(s);

			//Long id = (Long)App.session.save(noviUposlenik);		
			System.out.println("Dodan uposlenik");
		
			App.session.save(noviUposlenik);
			t.commit();
			return 1;
		}
		catch(HibernateException e){
			return 0;
		}

		//Treba za drugi datum datum zaposlenja
		/*Query query = App.session.createQuery("insert into Uposlenik values(" + ime +","+prezime+","+jmbg+","
				+datumRodjenja+","+mjestoRodjenja+","+adresa+","+telefon+","+email+","+strucnaSprema+","+datumRodjenja
				+","+user+","+pass+","+tipUposlenika+","+skladiste);

		int result = query.executeUpdate();

		System.out.println("Rows affected: " + result);
		App.session.getTransaction().commit();*/
	}
	
	private boolean postojiUposlenikUBaziJMBG(String jmbg){
		String query = "from Uposlenik where jmbg= :uposlenikJmbg";
		Query q = App.session.createQuery(query);
		q.setParameter("uposlenikJmbg", jmbg);
		List<?> result = q.list();
		if(!result.isEmpty())
			return true;
		return false;
	}
	
	private boolean postojiUposlenikUBaziUser(String user){
		String query = "from Uposlenik where user= :uposlenikUser";
		Query q = App.session.createQuery(query);
		q.setParameter("uposlenikUser", user);
		List<?> result = q.list();
		if(!result.isEmpty())
			return true;
		return false;
	}
	
	public boolean obrisiUposlenika(String jmbg){
		try{
			Transaction t = App.session.beginTransaction();
			Query q = App.session.createQuery("delete Uposlenik where jmbg= :uposlenikJmbg");
			q.setParameter("uposlenikJmbg", jmbg);
			int result = q.executeUpdate();
			t.commit();
			return true;
		}
		catch(HibernateException e){
			return false;
		}
	}
}
