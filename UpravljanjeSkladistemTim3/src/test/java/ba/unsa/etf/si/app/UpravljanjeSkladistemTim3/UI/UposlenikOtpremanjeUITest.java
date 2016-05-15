package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import java.util.Date;

import javax.swing.JTable;
import javax.swing.JTextField;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Uposlenik;
import junit.framework.TestCase;

public class UposlenikOtpremanjeUITest extends TestCase {
	UposlenikOtpremanjeUI uposOtpremUI = new UposlenikOtpremanjeUI();
	JTable tabela;
	JTextField prodajnaCijena;
	JTextField prodajnaCijena2;
	
	public UposlenikOtpremanjeUITest(){
		tabela = new JTable();
		prodajnaCijena = new JTextField("3");
		prodajnaCijena = new JTextField("");
	}
	
	//@Before 
	/*public void initialize ()
	{
	}*/
	
	//@Test
	public void dodajArtikalZaOtpremuEanNijeUnesen(){
		String poruka = uposOtpremUI.dodajArtikalZaOtpremu(tabela, prodajnaCijena, "", 2);
		
		assertEquals("Nije unesen bar kod!", poruka);		
	}
	
	//@Test
	public void dodajArtikalZaOtpremuEanNeispravan(){
		String poruka = uposOtpremUI.dodajArtikalZaOtpremu(tabela, prodajnaCijena, "dhdrh45", 3);
		
		assertEquals("Nije ispravan bar kod", poruka);		
	}
	
	//@Test
	public void dodajArtikalZaOtpremuKolicinaNeispravna(){
		String poruka = uposOtpremUI.dodajArtikalZaOtpremu(tabela, prodajnaCijena, "dhdrh45", -3);
		
		assertEquals("Količina nije ispravna", poruka);		
	}
	
	//@Test
	public void dodajArtikalZaOtpremuCijenaNijeUnesena(){
		JTextField prodajnaCijena3 = new JTextField("");
		String poruka = uposOtpremUI.dodajArtikalZaOtpremu(tabela, prodajnaCijena3, "1111111111111", 3);
		
		assertEquals("Prodajna cijena nije broj!", poruka);		
	}
	
	//@Test
	public void dobaviProdajnuCijenuNePostojiArtikal(){
		JTextField prodajnaCijena3 = new JTextField("2");
		String poruka = uposOtpremUI.dobaviProdajnuCijenu(prodajnaCijena3, "1928374657483");
		
		assertEquals("Artikal sa unesenim bar kodom ne postoji!", poruka);		
	}
	
	//@Test
	public void dobaviProdajnuCijenuTest(){
		JTextField prodajnaCijena3 = new JTextField("3");
		String poruka = uposOtpremUI.dobaviProdajnuCijenu(prodajnaCijena3, "1111111111111");
		
		assertEquals("  ", poruka);		
	}
	
	//@Test
	public void zavrsiOtpremanjeTest(){
		JTextField prodajnaCijena3 = new JTextField("3");
		Uposlenik user = new Uposlenik();
		
		String poruka = uposOtpremUI.zavrsiOtpremanje(user, 1);
		
		assertEquals("Niste odabrali nijedan artikal za otpremu!", poruka);		
	}
	

}
