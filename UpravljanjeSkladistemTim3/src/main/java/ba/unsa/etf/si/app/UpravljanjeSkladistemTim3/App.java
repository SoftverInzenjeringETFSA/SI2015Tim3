package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3;

//import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL.*;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.*;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI.Prijava;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI.RunForms;

import org.apache.log4j.Logger;

import java.awt.EventQueue;

import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.swing.JOptionPane;

public class App 
{
	public final static Session session = HibernateUtil.getSessionFactory().openSession();
	public final static Logger logger = Logger.getLogger(App.class);
    public static void main( String[] args )
    {
    	RunForms.RunPrijavaForm();
    }
}
