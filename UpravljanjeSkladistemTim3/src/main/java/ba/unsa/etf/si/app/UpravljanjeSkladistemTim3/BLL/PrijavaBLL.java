package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL;

import org.hibernate.Transaction;

import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.hibernate.Query;
import org.hibernate.Session;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Uposlenik;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.App;

public class PrijavaBLL {
	public PrijavaBLL() {}
	public Uposlenik Autorizacija(String user, String pass)
	{
		Transaction t = App.session.beginTransaction();
		String hql = "from Uposlenik where user = :user_par";
		Query querry = App.session.createQuery(hql);
		querry.setParameter("user_par", user);
		
		Uposlenik _user = (Uposlenik) querry.uniqueResult();
		return _user;
	}
	public String HashStringa(String passwordToHash) {
        String hashPass = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(passwordToHash.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            hashPass = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
        
        return hashPass;
	}
}

