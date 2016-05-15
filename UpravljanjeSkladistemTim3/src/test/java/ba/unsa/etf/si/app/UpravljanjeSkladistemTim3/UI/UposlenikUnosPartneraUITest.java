package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import junit.framework.TestCase;

public class UposlenikUnosPartneraUITest extends TestCase {

public void testUnosPartneraNazivPrazanString() {
		
		String naziv = "";
		String adresa = "Muje Mujica";
		String jib = "12345678910111213";
		UposlenikUnosPartneraUI uposUnosPartneraUI = new UposlenikUnosPartneraUI();

		String result = uposUnosPartneraUI.unosPartnera(naziv,adresa,jib);
		assertEquals("Nije unesen naziv!", result);
	}
	
	
	public void testUnosPartneraAdresaPrazanString() {
	UposlenikUnosPartneraUI uposUnosPartneraUI = new UposlenikUnosPartneraUI();
	
	String naziv = "Macaroni";
	String adresa = "";
	String jib = "12345678910111213";
	
	String result = uposUnosPartneraUI.unosPartnera(naziv,adresa,jib);
	assertEquals("Nije unesena adresa!", result);
	}
	
	public void testUnosPartneraJibPrazanString() {
		UposlenikUnosPartneraUI uposUnosPartneraUI = new UposlenikUnosPartneraUI();
		
		String naziv = "Macaroni";
		String adresa = "Bulevar mese selimovica";
		String jib = "";
		
		String result = uposUnosPartneraUI.unosPartnera(naziv,adresa,jib);
		assertEquals("Nije unesen jib!", result);
		}
	public void testUnosPartneraNeispravanNaziv() {
		UposlenikUnosPartneraUI uposUnosPartneraUI = new UposlenikUnosPartneraUI();
		
		String naziv = "macaroni";
		String adresa = "Bulevar Mese selimovica 12";
		String jib = "1234567891234";
		
		String result = uposUnosPartneraUI.unosPartnera(naziv,adresa,jib);
		assertEquals("Naziv nije ispravan!", result);
		}
	public void testUnosPartneraNeispravanJib() {
		UposlenikUnosPartneraUI uposUnosPartneraUI = new UposlenikUnosPartneraUI();
		
		String naziv = "Macaroni";
		String adresa = "Bulevar mese selimovica";
		String jib = "123";
		
		String result = uposUnosPartneraUI.unosPartnera(naziv,adresa,jib);
		assertEquals("JIB mora imati 13 cifara", result);
		}
	
	public void testUnosPartneraNeispravnaAdresa() {
		UposlenikUnosPartneraUI uposUnosPartneraUI = new UposlenikUnosPartneraUI();
		
		String naziv = "Macaroni";
		String adresa = "bulevar mese";
		String jib = "1234560891234";
		
		String result = uposUnosPartneraUI.unosPartnera(naziv,adresa,jib);
		assertEquals("Adresa nije ispravna!", result);
		}

}
