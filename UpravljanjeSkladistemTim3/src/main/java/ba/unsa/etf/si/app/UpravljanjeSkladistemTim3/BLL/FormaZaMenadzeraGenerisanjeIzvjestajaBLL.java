package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.App;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Artikal;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Dokument;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Nabavka;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Skladiste;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.SkladisteArtikal;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.StavkaDokumenta;

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
			App.logger.error("Omaska - skladiste ne postoji u bazi.", e);
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
			App.logger.error("Omaska - artikal ne postoji u bazi.", e);
		}
		
		return a;
	}
	
	public List<Artikal> dajArtikle (String skladiste){
		TrenutnoStanjeSkladistaBLL tss = new TrenutnoStanjeSkladistaBLL();
		List<Artikal> artikli = new ArrayList<Artikal>();
		artikli = tss.dajTrenutnoStanje(skladiste);
		
		return artikli;
	}
	
	public List<StavkaDokumenta> DajStavkeDokumenata(){
		List<StavkaDokumenta> listaStavkiDok = new ArrayList<StavkaDokumenta>();
		
		String hq1 = "from StavkaDokumenta";
		Query query = App.session.createQuery(hq1);
		List<Skladiste> skladista = new ArrayList<Skladiste>();
		try {
			listaStavkiDok = (List<StavkaDokumenta>) query.list();
		}
		catch(NullPointerException e){
			App.logger.error("Omaska", e);
		}
		
		return listaStavkiDok;
	}
	
	public List<StavkaDokumenta> DajStavkeDokArtikla(Artikal a){
		List<StavkaDokumenta> stavkeDokArtikla = new ArrayList<StavkaDokumenta>();
		List<StavkaDokumenta> listaStavkiDok = new ArrayList<StavkaDokumenta>();
		listaStavkiDok = DajStavkeDokumenata();
		
		for (StavkaDokumenta sd: listaStavkiDok){
			if (sd.get_artikal().getId()==a.getId()){
				stavkeDokArtikla.add(sd);
			}
		}
		
		return stavkeDokArtikla;
	}
	
	public List<StavkaDokumenta> DajStavkeDokArtiklaIzSkladista (Artikal a, Skladiste s){
		List<StavkaDokumenta> stavkeDokArtiklaSkladiste = new ArrayList<StavkaDokumenta>();
		List<StavkaDokumenta> listaStavkiDok = new ArrayList<StavkaDokumenta>();
		listaStavkiDok = DajStavkeDokArtikla(a);
		
		for (StavkaDokumenta sd: listaStavkiDok){
			for (Dokument d: s.get_dokumenti()){
				if (d.getId()==sd.getId()){
					stavkeDokArtiklaSkladiste.add(sd);
				}
			}
		}
		return stavkeDokArtiklaSkladiste;
	}
	
	
	public double DajPonderiranu(long artikal_id, long skladiste_id) {
		String sql = "SELECT ponderirana_cijena FROM skladiste_artikal WHERE artikal_id =:ar_id && skladiste_id = :sk_id";
		SQLQuery query = App.session.createSQLQuery(sql);
		query.setParameter("ar_id",	artikal_id);
		query.setParameter("sk_id", skladiste_id);
		
		double cijena = (Double) query.uniqueResult();
		return cijena;
	}
	
	public int DajKolicinu(long artikal_id, long skladiste_id) {
		String sql = "SELECT kolicina FROM skladiste_artikal WHERE artikal_id =:ar_id && skladiste_id = :sk_id";
		SQLQuery query = App.session.createSQLQuery(sql);
		query.setParameter("ar_id", artikal_id);
		query.setParameter("sk_id", skladiste_id);
		int kolicina = (Integer) query.uniqueResult();
		
		return kolicina;
	}
	
	public void generisiIzvjestajTrend (Skladiste s, Artikal a, JLabel status) throws Exception {
		Document document = new Document();
	    PdfWriter.getInstance(document, new FileOutputStream("IzvjestajTrendova.pdf"));
	    
	    //tabela
	    PdfPTable naslov1 = new PdfPTable(new float[] {3, 3});
	    naslov1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
	    naslov1.addCell("Cijena");
	    naslov1.addCell("Kolicina");
	    naslov1.setHeaderRows(1);
	    // oboji prvi red
	    PdfPCell[] cells = naslov1.getRow(0).getCells(); 
		  for (int j=0;j<cells.length;j++){
		     cells[j].setBackgroundColor(BaseColor.GRAY);
		  }
		
	    // punimo tabelu
		List<StavkaDokumenta> stavke = new ArrayList<StavkaDokumenta>();
		stavke = DajStavkeDokArtiklaIzSkladista(a, s);
		for (StavkaDokumenta sd: stavke){
			try{
				if (stavke.size()==0){
					naslov1.addCell("Za odabrani artikal nema podataka za generisanje izvjestaja");
				}
				else {
					naslov1.addCell(String.valueOf(sd.getCijena()));
					naslov1.addCell(String.valueOf(sd.getKolicina()));
				}
			}
			catch(Exception ex){
				App.logger.error("Greska kod dobijanja stavki dok", ex);
			}
		}
		
	    
	    document.open();
	    document.add(new Paragraph("Skladiste: " + s.getNaziv()));
	    document.add(new Paragraph("Naziv artikla: " + a.getNaziv()));
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	    document.add(new Paragraph("Datum generisanja: " + df.format(new Date())));
	    document.add(naslov1);
	    File myFile = new File("IzvjestajTrendova.pdf");
	    Desktop.getDesktop().open(myFile);
	    document.close();
	  
	    status.setText("Izvjestaj je kreiran.");
	    status.setForeground(Color.green);
	}

	public void generisiIzvjestajSumarni (Skladiste s, List<Artikal> artikli, JLabel status) throws Exception {
		Document document = new Document();
	    PdfWriter.getInstance(document, new FileOutputStream("SumarniIzvjestaj.pdf"));
	    
	    //tabela
	    PdfPTable tabela = new PdfPTable(new float[] {3, 3, 3, 3});
	    tabela.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
	    tabela.addCell("Naziv");
	    tabela.addCell("Kolicina na stanju");
	    tabela.addCell("Jedinica mjere");
	    tabela.addCell("Trenutna (ponderirana) cijena");
	    tabela.setHeaderRows(1);
	    // oboji prvi red
	    PdfPCell[] cells = tabela.getRow(0).getCells(); 
		  for (int j=0;j<cells.length;j++){
		     cells[j].setBackgroundColor(BaseColor.GRAY);
		  }
		
	    // punimo tabelu
		for (Artikal a: artikli){
			try {
				String kolicina = String.valueOf(DajKolicinu(a.getId(), s.getId()));
				String ponder = String.valueOf(DajPonderiranu(a.getId(), s.getId()));
				tabela.addCell(a.getNaziv());
				tabela.addCell(kolicina);
				tabela.addCell(a.getMjernaJedinica().toString());
				tabela.addCell(ponder);
			}
			catch(Exception e){
				App.logger.error("Omaska.", e);
			}
		}
	    
	    document.open();
	    document.add(new Paragraph("Skladiste: " + s.getNaziv()));
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	    document.add(new Paragraph("Datum generisanja: " + df.format(new Date())));
	    document.add(tabela);
	    File myFile = new File("SumarniIzvjestaj.pdf");
	    Desktop.getDesktop().open(myFile);
	    document.close();
	  
	    status.setText("Izvjestaj je kreiran.");
	    status.setForeground(Color.green);
	}
}
