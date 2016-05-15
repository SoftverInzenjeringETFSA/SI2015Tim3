package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL;

import java.util.Date;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI.MenadzerUposleniciUI;
import junit.framework.TestCase;

public class MenadzerUposleniciBLLTest extends TestCase{
	private MenadzerUposleniciBLL menUposBLL = new MenadzerUposleniciBLL();
	
	//@Test
	public void dodajUposlenikaPostojiUser(){
		Date datumRodjenja = new Date();
		datumRodjenja.setDate(29);
		datumRodjenja.setMonth(5);
		datumRodjenja.setYear(2010);
		
		int rez = menUposBLL.dodajUposlenika("Neko", "Nekic", "8888888888877", datumRodjenja,
				"Sarajevo", "Adresa", "061111111", "nc@gmail.com", 0,
				0, "der", "pass", 0);
		
		int rez2 = menUposBLL.dodajUposlenika("Neko", "Nekic", "8888888888877", datumRodjenja,
				"Sarajevo", "Adresa", "061111111", "nc@gmail.com", 0,
				0, "dhrdh", "r", 0);
		
		assertEquals(2, rez2);		
	}
	
	//@Test
	public void dodajUposlenikaPostojiUser2(){
		Date datumRodjenja = new Date();
		datumRodjenja.setDate(29);
		datumRodjenja.setMonth(5);
		datumRodjenja.setYear(2010);
		
		int rez = menUposBLL.dodajUposlenika("Neko", "Nekic", "1111111716112", datumRodjenja,
				"Sarajevo", "Adresa", "061111111", "nc@gmail.com", 0,
				0, "tzt", "pass", 0);
		
		int rez2 = menUposBLL.dodajUposlenika("Neko", "Nekic", "1211311161111", datumRodjenja,
				"Sarajevo", "Adresa", "061111111", "nc@gmail.com", 0,
				0, "tzt", "r", 0);
		
		assertEquals(3, rez2);		
	}
	
	//@Test
	public void dodajUposlenikaTest(){
		Date datumRodjenja = new Date();
		datumRodjenja.setDate(29);
		datumRodjenja.setMonth(5);
		datumRodjenja.setYear(2010);
		
		int rez = menUposBLL.dodajUposlenika("Neko", "Nekic", "6767676767676", datumRodjenja,
				"Sarajevo", "Adresa", "061111111", "nc@gmail.com", 0,
				0, "polpo", "pass", 0);

		assertEquals(1, rez);		
	}
	
	
}
