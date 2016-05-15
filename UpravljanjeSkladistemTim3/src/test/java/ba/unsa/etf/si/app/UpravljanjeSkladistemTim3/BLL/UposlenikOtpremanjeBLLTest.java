package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL;

import javax.swing.JTextField;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Artikal;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Uposlenik;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI.UposlenikOtpremanjeUI;
import junit.framework.TestCase;

public class UposlenikOtpremanjeBLLTest extends TestCase{
	UposlenikOtpremanjeBLL uposOtpremBLL = new UposlenikOtpremanjeBLL();
	
	//@Test
	public void dodajArtikalZaOtpremuTest(){
		Artikal a = uposOtpremBLL.dobaviArtikalZaOtprem("1111111111111", 2, 2);
		
		assertNotNull(a);		
	}
	
	//@Test
		public void dobaviStaruKolicinuArtiklaTest(){
			Long id = new Long(1)  ;
			int a = uposOtpremBLL.dobaviStaruKolicinuArtikla(id);
			
			assertNotSame(0, a);		
		}
		
		//@Test
		public void dobaviProdajnuCijenuTest(){
			double a = uposOtpremBLL.dobaviProdajnuCijenu("1111111111111");
			
			assertNotNull(a);		
		}	
		
		//@Test
		public void zavrsiOtpremanjeTest(){
			JTextField prodajnaCijena3 = new JTextField("3");
			Uposlenik user = new Uposlenik();
			
			int a = uposOtpremBLL.zavrsiOtpremanje(user, 1);
			
			assertEquals("Niste odabrali nijedan artikal za otpremu!", a);		
		}
		

	
	

}
