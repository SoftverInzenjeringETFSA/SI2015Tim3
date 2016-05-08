package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL;

import org.hibernate.Transaction;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Uposlenik;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.App;

public class PrijavaBLL {
	public static Uposlenik Autorizacija(String user, String pass)
	{
		Transaction t = App.session.beginTransaction();
		String hql = "from Uposlenik where user = :user_par";
		Query querry = App.session.createQuery(hql);
		querry.setParameter("user_par", user);
		//querry.setParameter("pass_par", pass);
		Uposlenik result = (Uposlenik) querry.uniqueResult();
		
		return result;
		}
}

