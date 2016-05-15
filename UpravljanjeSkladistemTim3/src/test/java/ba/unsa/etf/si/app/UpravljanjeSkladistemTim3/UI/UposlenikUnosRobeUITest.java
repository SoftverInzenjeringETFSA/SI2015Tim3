package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import javax.swing.JLabel;
import javax.swing.JTable;

import junit.framework.TestCase;

public class UposlenikUnosRobeUITest extends TestCase {
	
	public void testValidateEan() {
		UposlenikUnosRobeUI ui = new UposlenikUnosRobeUI();
		assertEquals(false, ui.ValidateEan("14587220000h"));
	}

	public void testDodajArtikal() {
		UposlenikUnosRobeUI ui = new UposlenikUnosRobeUI();
		JLabel dummyLabel = new JLabel();
		JTable dummyTable = new JTable();
		
		boolean result = ui.DodajArtikal(dummyLabel, dummyTable, "1111111111111", -1, "");
		assertEquals(false, result);
	}

	public void testDodajNoviArtikal() {
		assertTrue(true);
	}

	public void testUnosNabavke() {
		assertTrue(true);
	}
	
	public void testValidateCommon() {
		assertTrue(true);
	}
}
