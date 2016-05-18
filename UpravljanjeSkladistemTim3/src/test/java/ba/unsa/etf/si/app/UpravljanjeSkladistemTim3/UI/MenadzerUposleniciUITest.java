package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.StrucnaSprema;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.TipUposlenika;
import junit.framework.TestCase;



public class MenadzerUposleniciUITest extends TestCase{
	private MenadzerUposleniciUI menUposUI = new MenadzerUposleniciUI();
	
	//@Test
	public void dodajUposlenikaImeNijeUneseno(){
		Date datumRodjenja = new Date();
		
		String poruka = menUposUI.dodajUposlenika("", "Nekic", "1111111111111", datumRodjenja,
				"Sarajevo", "Adresa", "061111111", "nc@gmail.com", 0,
				0, "ncongo", "pass", 0);
		
		assertEquals("Nije uneseno ime!", poruka);		
	}
	
	//@Test
	public void dodajUposlenikaImeNeispravno(){
		Date datumRodjenja = new Date();
			
		String poruka = menUposUI.dodajUposlenika("dgdrg", "Nekic", "1111111111111", datumRodjenja,
				"Sarajevo", "Adresa", "061111111", "nc@gmail.com", 0,
				0, "ncongo", "pass", 0);
			
		assertEquals("Nije ispravno ime!", poruka);		
	}
	
	//@Test
	public void dodajUposlenikaPrezimeNijeUneseno(){
		Date datumRodjenja = new Date();
				
		String poruka = menUposUI.dodajUposlenika("Neko", "", "1111111111111", datumRodjenja,
				"Sarajevo", "Adresa", "061111111", "nc@gmail.com", 0,
				0, "ncongo", "pass", 0);
				
		assertEquals("Nije uneseno prezime!", poruka);		
	}
	
	//@Test
	public void dodajUposlenikaPrezimeNeispravno(){
		Date datumRodjenja = new Date();
					
		String poruka = menUposUI.dodajUposlenika("Neko", "rgdrhd", "1111111111111", datumRodjenja,
				"Sarajevo", "Adresa", "061111111", "nc@gmail.com", 0,
				0, "ncongo", "pass", 0);
					
		assertEquals("Nije ispravno prezime!", poruka);		
	}
	
	//@Test
	public void dodajUposlenikaJmbgNijeUnesen(){
		Date datumRodjenja = new Date();
					
		String poruka = menUposUI.dodajUposlenika("Neko", "Nekic", "", datumRodjenja,
				"Sarajevo", "Adresa", "061111111", "nc@gmail.com", 0,
				0, "ncongo", "pass", 0);
					
		assertEquals("Nije unesen JMBG!", poruka);		
	}
	
	//@Test
	public void dodajUposlenikaJmbgNeispravan(){
		Date datumRodjenja = new Date();
					
		String poruka = menUposUI.dodajUposlenika("Neko", "Nekic", "2423452", datumRodjenja,
				"Sarajevo", "Adresa", "061111111", "nc@gmail.com", 0,
				0, "ncongo", "pass", 0);
					
		assertEquals("JMBG mora imati 13 cifara!", poruka);		
	}
	
	//@Test
	public void dodajUposlenikaJmbgNeispravan2(){
		Date datumRodjenja = new Date();
						
		String poruka = menUposUI.dodajUposlenika("Neko", "Nekic", "232dgdhg54345", datumRodjenja,
				"Sarajevo", "Adresa", "061111111", "nc@gmail.com", 0,
				0, "ncongo", "pass", 0);
						
		assertEquals("JMBG mora imati 13 cifara!", poruka);		
	}
	
	//@Test
	public void dodajUposlenikaDatumRodjenjaNeispravan(){
		Date datumRodjenja = new Date();
		datumRodjenja.setDate(29);
		datumRodjenja.setMonth(5);
		datumRodjenja.setYear(2010);
						
		String poruka = menUposUI.dodajUposlenika("Neko", "Nekic", "1111111111111", datumRodjenja,
				"Sarajevo", "Adresa", "061111111", "nc@gmail.com", 0,
				0, "ncongo", "pass", 0);
						
		assertEquals("Datum rođenja nije ispravan!", poruka);		
	}
	
	//@Test
	public void dodajUposlenikaMjestoRodjenjaNijeUneseno(){
		Date datumRodjenja = new Date();
		datumRodjenja.setDate(29);
		datumRodjenja.setMonth(5);
		datumRodjenja.setYear(1993);
						
		String poruka = menUposUI.dodajUposlenika("Neko", "Nekic", "1111111111111", datumRodjenja,
				"", "Adresa", "061111111", "nc@gmail.com", 0,
				0, "ncongo", "pass", 0);
						
		assertEquals("Nije uneseno mjesto rođenja!", poruka);		
	}
	
	//@Test
	public void dodajUposlenikaMjestoRodjenjaNeispravno(){
		Date datumRodjenja = new Date();
		datumRodjenja.setDate(29);
		datumRodjenja.setMonth(5);
		datumRodjenja.setYear(1993);
						
		String poruka = menUposUI.dodajUposlenika("Neko", "Nekic", "1111111111111", datumRodjenja,
				"sarajevo", "Adresa", "061111111", "nc@gmail.com", 0,
				0, "ncongo", "pass", 0);
						
		assertEquals("Nije ispravno mjesto rođenja!", poruka);		
	}
	
	//@Test
	public void dodajUposlenikaAdresaNijeUnesena(){
		Date datumRodjenja = new Date();
		datumRodjenja.setDate(29);
		datumRodjenja.setMonth(5);
		datumRodjenja.setYear(1993);
						
		String poruka = menUposUI.dodajUposlenika("Neko", "Nekic", "1111111111111", datumRodjenja,
				"Sarajevo", "", "061111111", "nc@gmail.com", 0,
				0, "ncongo", "pass", 0);
						
		assertEquals("Nije unesena adresa!", poruka);		
	}
	
	//@Test
	public void dodajUposlenikaAdresaNeispravna(){
		java.util.Date datRodj = new Date();
		datRodj.setDate(29);
		datRodj.setMonth(5);
		datRodj.setYear(1993);
		
		//Calendar datumRodjenja = Calendar.getInstance();
		//datumRodjenja.setTime(datRodj);
						
		String poruka = menUposUI.dodajUposlenika("Neko", "Nekic", "1111111111111", datRodj,
				"Sarajevo", "sgdgr", "061111111", "nc@gmail.com", 0,
				0, "ncongo", "pass", 0);
						
		assertEquals("Nije ispravna adresa", poruka);		
	}
	
	//@Test
	public void dodajUposlenikaTelefonNijeUnesen(){
		Date datumRodjenja = new Date();
		datumRodjenja.setDate(29);
		datumRodjenja.setMonth(5);
		datumRodjenja.setYear(1993);
						
		String poruka = menUposUI.dodajUposlenika("Neko", "Nekic", "1111111111111", datumRodjenja,
				"Sarajevo", "Adresa", "", "nc@gmail.com", 0,
				0, "ncongo", "pass", 0);
						
		assertEquals("Nije unesen telefon!", poruka);		
	}
	
	//@Test
	public void dodajUposlenikaTelefonNeispravan(){
		Date datumRodjenja = new Date();
		datumRodjenja.setDate(29);
		datumRodjenja.setMonth(5);
		datumRodjenja.setYear(1993);
						
		String poruka = menUposUI.dodajUposlenika("Neko", "Nekic", "1111111111111", datumRodjenja,
				"Sarajevo", "Adresa", "876453432", "nc@gmail.com", 0,
				0, "ncongo", "pass", 0);
						
		assertEquals("Nije ispravan telefon!", poruka);		
	}
	
	//@Test
	public void dodajUposlenikaEmailNijeUnesen(){
		Date datumRodjenja = new Date();
		datumRodjenja.setDate(29);
		datumRodjenja.setMonth(5);
		datumRodjenja.setYear(1993);
						
		String poruka = menUposUI.dodajUposlenika("Neko", "Nekic", "1111111111111", datumRodjenja,
				"Sarajevo", "Adresa", "061123123", "", 0,
				0, "ncongo", "pass", 0);
						
		assertEquals("Nije unesen email", poruka);		
	}
	
	//@Test
	public void dodajUposlenikaEmailNeispravan(){
		Date datumRodjenja = new Date();
		datumRodjenja.setDate(29);
		datumRodjenja.setMonth(5);
		datumRodjenja.setYear(1993);
						
		String poruka = menUposUI.dodajUposlenika("Neko", "Nekic", "1111111111111", datumRodjenja,
				"Sarajevo", "Adresa", "061123123", "dhdrhdr", 0,
				0, "ncongo", "pass", 0);
						
		assertEquals("Nije ispravan email!", poruka);		
	}
	
	//@Test
	public void dodajUposlenikaUserNijeUnesen(){
		Date datumRodjenja = new Date();
		datumRodjenja.setDate(29);
		datumRodjenja.setMonth(5);
		datumRodjenja.setYear(1993);
						
		String poruka = menUposUI.dodajUposlenika("Neko", "Nekic", "1111111111111", datumRodjenja,
				"Sarajevo", "Adresa", "061123123", "nc@gmail.com", 0,
				0, "", "pass", 0);
						
		assertEquals("Nije uneseno korisničko ime!", poruka);		
	}
	
	//@Test
	public void dodajUposlenikaSifraNijeUnesena(){
		Date datumRodjenja = new Date();
		datumRodjenja.setDate(29);
		datumRodjenja.setMonth(5);
		datumRodjenja.setYear(1993);
						
		String poruka = menUposUI.dodajUposlenika("Neko", "Nekic", "1111111111111", datumRodjenja,
				"Sarajevo", "Adresa", "061123123", "nc@gmail.com", 0,
				0, "ncongo", "", 0);
						
		assertEquals("Nije unesena korisnička šifra", poruka);		
	}
	
	//@Test
	public void dodajUposlenikaPostojiUserJmbg(){
		Date datumRodjenja = new Date();
		datumRodjenja.setDate(29);
		datumRodjenja.setMonth(5);
		datumRodjenja.setYear(1993);
						
		String poruka = menUposUI.dodajUposlenika("Neko", "Nekic", "1111111111111", datumRodjenja,
				"Sarajevo", "Adresa", "061123123", "nc@gmail.com", 0,
				0, "ncongo", "pass", 0);
		String poruka2 = menUposUI.dodajUposlenika("Nr", "Nr", "1111111111111", datumRodjenja,
				"Mostar", "Adresa2", "061234234", "nr@gmail.com", 0,
				0, "n", "p", 0);
						
		assertEquals("Uposlenik sa tim matičnim brojem već postoji!", poruka2);		
	}
	
	//@Test
	public void dodajUposlenikaPostojiUser(){
		Date datumRodjenja = new Date();
		
		String poruka = menUposUI.dodajUposlenika("Neko", "Nekic", "1111111111111", datumRodjenja,
				"Sarajevo", "Adresa", "061111111", "nc@gmail.com", 0,
				0, "ncongo", "pass", 0);
		String poruka2 = menUposUI.dodajUposlenika("Nr", "Nr", "2222222222222", datumRodjenja,
				"Mostar", "Adresa2", "061234234", "nr@gmail.com", 0,
				0, "ncongo", "p", 0);
		
		assertEquals("Uposlenik sa tim korisničkim imenom već postoji!", poruka2);		
	}
	
	//@Test
	public void dodajUposlenikaTest(){
		Date datumRodjenja = new Date();
		datumRodjenja.setDate(29);
		datumRodjenja.setMonth(5);
		datumRodjenja.setYear(1993);
		
		String poruka = menUposUI.dodajUposlenika("Neko", "Nekic", "1111111111111", datumRodjenja,
				"Sarajevo", "Adresa", "061111111", "nc@gmail.com", 0,
				0, "p", "p", 0);
		
		assertEquals("  ", poruka);		
	}
	
	//@Test
	public void obrisiUposlenikaTestNijeOdabran(){
		java.util.Date datumRodjenja = new Date();
		datumRodjenja.setDate(29);
		datumRodjenja.setMonth(5);
		datumRodjenja.setYear(1993);
		
		String poruka = menUposUI.dodajUposlenika("Neko", "Nekic", "1111111111111", datumRodjenja,
				"Sarajevo", "Adresa", "061111111", "nc@gmail.com", 0,
				0, "ncongo", "pass", 0);
		String poruka2 = menUposUI.dodajUposlenika("Nr", "Nr", "2222222222222", datumRodjenja,
				"Mostar", "Adresa2", "061234234", "nr@gmail.com", 0,
				0, "ncongo", "p", 0);
		
		String poruka3 = menUposUI.obrisiUposlenika(-1, "2222222222222");
		
		assertEquals("Nije odabran nijedan uposlenik!", poruka3);		
	}
	
	//@Test
	public void obrisiUposlenikaTest(){
		java.util.Date datumRodjenja = new Date();
		datumRodjenja.setDate(29);
		datumRodjenja.setMonth(5);
		datumRodjenja.setYear(1993);
		
		String poruka = menUposUI.dodajUposlenika("Neko", "Nekic", "1111111111111", datumRodjenja,
				"Sarajevo", "Adresa", "061111111", "nc@gmail.com", 0,
				0, "ncongo", "pass", 0);
		String poruka2 = menUposUI.dodajUposlenika("Nr", "Nr", "2222222222222", datumRodjenja,
				"Mostar", "Adresa2", "061234234", "nr@gmail.com", 0,
				0, "ncongo", "p", 0);
		
		String poruka3 = menUposUI.obrisiUposlenika(1, "2222222222222");
		
		assertEquals("  ", poruka3);		
	}
	
	
	

}
