package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3;

/**
 * Hello world!
 *
 */
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL.*;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        dodajPoslovnogPartnera(session);
        session.close();
    }

	private static void dodajPoslovnogPartnera(Session session) {
		Transaction t = session.beginTransaction();
		PoslovniPartner pp = new PoslovniPartner();
		
		pp.setAdresa("kdkadk");
		pp.setJIB("55335");
		pp.setNaziv("firma");
		
		Long id = (Long) session.save(pp);
		System.out.println("Dodan pp sa IDom" + id);
		t.commit();
	}
}
