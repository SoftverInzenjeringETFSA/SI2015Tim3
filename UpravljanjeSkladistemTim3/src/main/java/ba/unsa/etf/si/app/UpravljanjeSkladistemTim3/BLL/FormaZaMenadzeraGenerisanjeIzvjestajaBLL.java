package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL;

import org.hibernate.Query;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.App;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Artikal;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Dokument;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Nabavka;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Skladiste;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.SkladisteArtikal;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class FormaZaMenadzeraGenerisanjeIzvjestajaBLL {

	public Skladiste dajSkladiste (String skladiste){
		Skladiste s = new Skladiste();
		
		String hq1 = "from Skladiste where naziv = :naziv_pp";
		Query query = App.session.createQuery(hq1);
		query.setParameter("naziv_pp", skladiste);
		try {
			s = (Skladiste) query.uniqueResult();
		}
		catch(NullPointerException e){
		}
		
		return s;
	}
	
	public Artikal dajArtikal (String barKod){
		Artikal a = new Artikal();
		
		String hq1 = "from Artikal where barKod = :barKod";
		Query query = App.session.createQuery(hq1);
		query.setParameter("barKod", barKod);
		try {
			a = (Artikal) query.uniqueResult();
		}
		catch(NullPointerException e){
		}
		
		return a;
	}
	
	public List<Artikal> dajArtikle (String skladiste){
		TrenutnoStanjeSkladistaBLL tss = new TrenutnoStanjeSkladistaBLL();
		List<Artikal> artikli = new ArrayList<Artikal>();
		artikli = tss.dajTrenutnoStanje(skladiste);
		
		return artikli;
	}
	
	public void podaciUlaza(Artikal a){
		String hq1 = "from Nabavka where barKod = :barKod";
		Query query = App.session.createQuery(hq1);
		query.setParameter("barkKod", a.getBarKod());
		
		try {
			
		}
		catch(Exception e){
			
		}
	}
	
	public Nabavka dajUlazniDokument(Artikal a, Date _od, Date _do){
		Nabavka ulaz = new Nabavka();
		
		
		
		return ulaz;
	}
	
	public void generisiIzvjestajTrend (Skladiste s, Artikal a, JLabel status) throws Exception {
		
		Document document = new Document();
	    PdfWriter.getInstance(document, new FileOutputStream("IzvjestajTrendovaProizvoda.pdf"));
	    
		//tabela
		PdfPTable tabela = new PdfPTable(new float[] {3, 3, 3, 3});
		tabela.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		tabela.addCell("Datum ulaza");
		tabela.addCell("Ulazna cijena");
	    tabela.addCell("Kolicina");
	    tabela.addCell("Izlazna cijena");
		tabela.setHeaderRows(1);
		// oboji prvi red
	    PdfPCell[] cells = tabela.getRow(0).getCells(); 
	    for (int j=0;j<cells.length;j++){
	    	cells[j].setBackgroundColor(BaseColor.GRAY);
	    }
	    tabela.addCell(""); // datum ulaza?
	    String ulaznaCijena = String.valueOf(a.getProdajnaCijena());
	    tabela.addCell(ulaznaCijena); // ulazna cijena
	    String kolicina = String.valueOf(a.getKolicina());
	    tabela.addCell(kolicina);
	    String izlaznaCijena = String.valueOf(a.getProdajnaCijena()*a.getKolicina());
	    tabela.addCell(izlaznaCijena); 
		    
		    
	    document.open();
	    document.add(new Paragraph("Skladiste: " + s.getNaziv()));
	    document.add(new Paragraph("Naziv artikla: " + a.getNaziv()));
	    // trenutno vrijeme
	    Date date = new Date();
	    DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		    
		document.add(new Paragraph("Datum generisanja: " + df.format(date)));
		document.add(new Paragraph(""));
		document.add(tabela);
		File myFile = new File("IzvjestajTrendovaProizvoda.pdf");
	    Desktop.getDesktop().open(myFile);
		document.close();
		  
		status.setText("Izvjestaj je kreiran.");
		status.setForeground(Color.green);
		
		//JOptionPane.showMessageDialog(null, "Izvjestaj je kreiran!", "", JOptinPane.INFORMATION_MESSAGE);
		status.setText("Izvjestaj je kreiran!");
		status.setForeground(Color.green);
	}

	public void generisiIzvjestajSumarni (Skladiste s, List<Artikal> artikli, JLabel status) throws Exception {
		Document document = new Document();
	    PdfWriter.getInstance(document, new FileOutputStream("SumarniIzvjestaj.pdf"));
	    
	    //tabela
	    PdfPTable tabela = new PdfPTable(new float[] {3, 3, 3});
	    tabela.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
	    tabela.addCell("Naziv");
	    tabela.addCell("Kolicina na stanju");
	    tabela.addCell("Trenutna (ponderirana) cijena");
	    tabela.setHeaderRows(1);
	    // oboji prvi red
	    PdfPCell[] cells = tabela.getRow(0).getCells(); 
		  for (int j=0;j<cells.length;j++){
		     cells[j].setBackgroundColor(BaseColor.GRAY);
		  }
		
	    // punimo tabelu
		for (Artikal a: artikli){
			tabela.addCell(a.getNaziv());
			String kolicinaNaStanju = String.valueOf(a.getKolicina());
			tabela.addCell(kolicinaNaStanju);
			String trenutnaCijena = String.valueOf(a.getProdajnaCijena());
			tabela.addCell(trenutnaCijena);
		}
	    
	    document.open();
	    document.add(new Paragraph("Skladiste: " + s.getNaziv()));
	    // trenutno vrijeme
	    Date date = new Date();
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	    
	    document.add(new Paragraph("Datum generisanja: " + df.format(date)));
	    document.add(new Paragraph(""));
	    document.add(tabela);
	    File myFile = new File("SumarniIzvjestaj.pdf");
	    Desktop.getDesktop().open(myFile);
	    document.close();
	  
	    status.setText("Izvjestaj je kreiran.");
	    status.setForeground(Color.green);
	    //JOptionPane.showMessageDialog(null, "Izvjestaj je kreiran!", "", JOptionPane.INFORMATION_MESSAGE);
	}
}
