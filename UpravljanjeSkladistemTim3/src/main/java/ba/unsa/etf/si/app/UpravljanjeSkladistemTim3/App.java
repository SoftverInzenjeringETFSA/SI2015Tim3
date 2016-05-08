package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3;

//import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL.*;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.*;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI.Prijava;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI.RunForms;

import java.awt.EventQueue;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class App 
{
	public static Session session = null;
    public static void main( String[] args )
    {
    	session = HibernateUtil.getSessionFactory().openSession();
    	//RunForms.RunPrijavaForm();
    	RunForms.RunUposlenikForm();
    	//session.close();
    	//RunForms.RunMenadzerForm();
    }
}
