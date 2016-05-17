package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.App;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Dokument;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.StavkaDokumenta;

import org.hibernate.Transaction;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;

public class MenadzerDokumentBLL {

	public List<Dokument> PopuniListuDokumenata() {
		Transaction t = App.session.beginTransaction();

		String hql = "from Dokument";
		Query query = App.session.createQuery(hql);
		List<Dokument> lista = query.list();

		t.commit();

		return lista;
	}

	public List<Dokument> PopuniListuDokumenata(List<String> vrste, Date OD, Date DO) {
		List<Dokument> lista = PopuniListuDokumenata();
		List<Dokument> listaZaBrisanje = new ArrayList<Dokument>();
		for (Dokument d : lista) {
			int uslov1 = d.getDatum().compareTo(OD);
			int uslov2 = d.getDatum().compareTo(DO);
			if (!((uslov1 == 0 || uslov1 == 1) && (uslov2 == 0 || uslov2 == -1))) {
				listaZaBrisanje.add(d);
			}
			if (!vrste.contains(d.dajTip())) {
				listaZaBrisanje.add(d);
			}
		}
		lista.removeAll(listaZaBrisanje);

		return lista;
	}

	public void PrikaziPDF(Dokument d) {
		Document document = new Document();

		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(d + ".pdf"));
			document.open();

			Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
			Paragraph naslov = new Paragraph(d.toString(), boldFont);
			naslov.setAlignment(Element.ALIGN_MIDDLE);
			document.add(naslov);
			document.add(new Paragraph("\n"));
			document.add(new Paragraph("Datum:     " + d.getDatum().toString().substring(0, 10)));
			document.add(
					new Paragraph("Autor:       " + d.get_kreirao().getIme() + " " + d.get_kreirao().getPrezime()));
			document.add(new Paragraph("Skladiste: " + d.get_skladiste().getNaziv()));
			document.add(new Paragraph("\n"));
			document.add(new Paragraph("Artikli: "));

			PdfPTable table = new PdfPTable(4);
			table.setWidthPercentage(100);
			table.setSpacingBefore(10f);
			table.setSpacingAfter(10f);

			float[] columnWidths = { 1f, 1f, 1f, 1f };
			table.setWidths(columnWidths);

			PdfPCell cell1 = new PdfPCell(new Paragraph("Naziv"));
			cell1.setBorderColor(BaseColor.BLACK);
			cell1.setPaddingLeft(10);
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

			PdfPCell cell2 = new PdfPCell(new Paragraph("Kolicina"));
			cell2.setBorderColor(BaseColor.BLACK);
			cell2.setPaddingLeft(10);
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

			PdfPCell cell3 = new PdfPCell(new Paragraph("Cijena"));
			cell3.setBorderColor(BaseColor.BLACK);
			cell3.setPaddingLeft(10);
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

			PdfPCell cell4 = new PdfPCell(new Paragraph("Iznos"));
			cell3.setBorderColor(BaseColor.BLACK);
			cell3.setPaddingLeft(10);
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

			table.addCell(cell1);
			table.addCell(cell2);
			table.addCell(cell3);
			table.addCell(cell4);
			boolean brojac = false;
			double suma = 0;
			for (StavkaDokumenta sd : d.get_stavke()) {

				double proizvod = sd.getKolicina() * sd.getCijena();
				suma = suma + proizvod;
				cell1 = new PdfPCell(new Paragraph(sd.get_artikal().getNaziv()));
				cell2 = new PdfPCell(new Paragraph(Integer.toString(sd.getKolicina())));
				cell3 = new PdfPCell(new Paragraph(Double.toString(sd.getCijena())));
				cell4 = new PdfPCell(new Paragraph(Double.toString(proizvod)));

				if (brojac) {
					cell1.setBackgroundColor(BaseColor.GRAY);
					cell2.setBackgroundColor(BaseColor.GRAY);
					cell3.setBackgroundColor(BaseColor.GRAY);
					cell4.setBackgroundColor(BaseColor.GRAY);
					brojac = !brojac;
				} else {
					cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
					cell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
					cell3.setBackgroundColor(BaseColor.LIGHT_GRAY);
					cell4.setBackgroundColor(BaseColor.LIGHT_GRAY);
					brojac = !brojac;
				}

				table.addCell(cell1);
				table.addCell(cell2);
				table.addCell(cell3);
				table.addCell(cell4);
			}

			document.add(table);
			document.add(new Paragraph("Ukupan iznos:     " + suma));
			document.close();
			writer.close();
		} catch (Exception e) {
			App.logger.error("Omaska", e);
			JOptionPane.showMessageDialog(null, e.getMessage(), "Info", JOptionPane.INFORMATION_MESSAGE);
		}

		// Otvaranje fajla
		if (Desktop.isDesktopSupported()) {
			try {
				String workingDir = System.getProperty("user.dir");
				try {
					File myFile = new File(workingDir + "\\" + d + ".pdf");
					Desktop.getDesktop().open(myFile);
				} catch (IllegalArgumentException ex) {
					File myFile = new File(workingDir + "//" + d + ".pdf");
					Desktop.getDesktop().open(myFile);
				}
			} catch (FileNotFoundException e) {
				App.logger.error("Omaska", e);
				JOptionPane.showMessageDialog(null, "Ne postoji trazeni fajl!", "Info",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException ex) {
				App.logger.error("Omaska", ex);
				JOptionPane.showMessageDialog(null, "Ne postoji aplikacija koja podrzava čitanje PDF fajlova!", "Info",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
