package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3;


import java.io.FileInputStream;
import java.util.Properties;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			java.util.Properties properties = new Properties();
			properties.load(new FileInputStream("db.properties"));
			// Create the SessionFactory from hibernate.cfg.xml
			return new Configuration().addProperties(properties).configure().buildSessionFactory();
		} catch (Exception ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {

		return sessionFactory;

	}

}


