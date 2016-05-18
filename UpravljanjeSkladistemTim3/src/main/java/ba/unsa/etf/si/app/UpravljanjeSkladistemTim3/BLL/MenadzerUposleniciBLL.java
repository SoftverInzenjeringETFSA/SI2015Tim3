package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL;

import java.util.Date;
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
			PrijavaBLL pbll = new PrijavaBLL();
			System.out.println(skladiste);
			noviUposlenik.setIme(ime);
			noviUposlenik.setPrezime(prezime);
			noviUposlenik.setJMBG(jmbg);
			noviUposlenik.setDatumRodjenja(datumRodjenja);
			noviUposlenik.setMjestoRodjenja(mjestoRodjenja);
			noviUposlenik.setAdresaStanovanja(adresa);
			noviUposlenik.setBrojTelefona(telefon);
			noviUposlenik.setEmail(email);
			noviUposlenik.setStrucnaSprema(StrucnaSprema.values()[strucnaSprema]);
			noviUposlenik.setDatumZaposlenja(new Date());
			noviUposlenik.setUser(user);
			noviUposlenik.setPassword(pbll.HashStringa(pass));
			noviUposlenik.setTipUposlenika(TipUposlenika.values()[tipUposlenika]);
		
			Skladiste s = App.session.load(Skladiste.class, (long)(skladiste+1));
			System.out.println(s.getNaziv());
			noviUposlenik.set_skladiste(s);

			//Long id = (Long)App.session.save(noviUposlenik);		
			System.out.println("Dodan uposlenik");
		
			App.session.save(noviUposlenik);
			t.commit();
			return 1;
		}
		catch(HibernateException e){
			App.logger.error("Omaska", e);
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
			App.logger.error("Omaska", e);
			return false;
		}
	}
	
	//Metoda za dodavanje uposlenika u tabelu
	public List<Object[]> dodavanjeUposlenikaUTabelu(){
		String query = "select ime, prezime, JMBG from Uposlenik";
		Query q = App.session.createQuery(query);
		List<Object[]> listaUposlenika = q.list();
		System.out.println(listaUposlenika.isEmpty());
		return listaUposlenika;
	}
	
	//Metoda za dodavanje skladista u listu skladista(combobox)
	public List<String> dodavanjeSkladistaUComboBox() {
		// TODO Auto-generated method stub
		String query = "select naziv from Skladiste";
		Query q = App.session.createQuery(query);
		List<String> naziviSkladista = q.list();
		return naziviSkladista;
	}
}

