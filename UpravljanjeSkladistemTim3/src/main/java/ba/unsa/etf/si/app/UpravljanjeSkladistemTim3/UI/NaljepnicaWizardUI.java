package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.krysalis.barcode4j.ChecksumMode;
import org.krysalis.barcode4j.impl.upcean.EAN13Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.BLL.NaljepnicaWizardBLL;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Nabavka;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.StavkaDokumenta;

public class NaljepnicaWizardUI {
	public NaljepnicaWizardUI() {}
	private NaljepnicaWizardBLL bll;
	
	public String SetData(JTable table, Nabavka nabavka) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for(StavkaDokumenta sd:nabavka.get_stavke()) {
			model.addRow(new Object[] {sd.get_artikal().getBarKod(), 1});
		}
		return nabavka.getBarKod();
	}
	
	public String DobaviNabavku(JTable table, String barKod) {
		// validirati ean bar kod
		if(barKod == null || barKod.length() == 0) {
			JOptionPane.showMessageDialog(null, "Niste unijeli bar kod nabavke", "Omaška", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		
		bll = new NaljepnicaWizardBLL();
		Nabavka n = bll.DajNabavku(barKod);
		if(n == null) {
			JOptionPane.showMessageDialog(null, "Nabavka sa unesenim bar kodom ne postoji u bazi!", "Omaška", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		return SetData(table, n);
	}

	private BufferedImage[] KreirajSlikeNaljepnica(JTable table, String barKod) {
		int brojSlika = table.getRowCount() + 1;
		BufferedImage[] slike = new BufferedImage[brojSlika];
		
		EAN13Bean bean = new EAN13Bean();
		int dpi = 300;
		bean.setModuleWidth(UnitConv.in2mm(2.0f / dpi));
		bean.setFontSize(2);
		bean.setChecksumMode(ChecksumMode.CP_IGNORE);
		bean.doQuietZone(true);
		bean.setBarHeight(5);
		
		BitmapCanvasProvider provider = new BitmapCanvasProvider(dpi, BufferedImage.TYPE_BYTE_GRAY, true, 0);
		
		for(int i = 0; i < brojSlika; i++) {
		if(i == 0)
		bean.generateBarcode(provider, barKod);
		else
			bean.generateBarcode(provider, (String)table.getValueAt(i - 1, 0));
		try {
			provider.finish();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		slike[i] = provider.getBufferedImage();
		}
		return slike;
	}
	
	private void KreirajPDFDokument(BufferedImage[] slike, int[] brojNaljepnica) {
		
		try 
		{
			Document document = new Document(PageSize.A4, 10, 10, 10, 10);
			PdfWriter.getInstance(document, new FileOutputStream("naljepnice.pdf"));
			document.open();
			
			
			
			for(int i = 1; i < slike.length; i++) {
				for(int j = 0; j < brojNaljepnica[i]; j++) {
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					
					ImageIO.write(slike[0], "png", baos);
					Image img = Image.getInstance(baos.toByteArray());
					
					img.setAlignment(0);
					document.add(new Chunk(img, 0, 20, true));
					
					ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
					ImageIO.write(slike[i], "png", baos2);
					Image img2 = Image.getInstance(baos2.toByteArray());
					
					img2.setAlignment(0);
					document.add(new Chunk(img2, 0, 20, true));
				}
			}
			
			document.close();
			
			File fajl = new File("naljepnice.pdf");
			Desktop.getDesktop().open(fajl);
		}
		catch(Exception e) 
		{
			
		}
		
	}
	
	private int[] BrojNaljepnica(JTable table) {
		int broj = table.getRowCount() + 1;
		int[] brojNaljepnica = new int[broj];
		brojNaljepnica[0] = 1;
		for(int i = 1; i < broj; i++) {
			brojNaljepnica[i] = (Integer)table.getValueAt(i - 1, 1);
		}
		return brojNaljepnica;
	}
	public void KreirajNaljepnice(JTable table, String barKod) {
		if(barKod == null) return;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for(int count = 0; count < model.getRowCount(); count++) {
			try {
				int number = Integer.parseInt(model.getValueAt(count, 1).toString());
				if(number < 0) {
					JOptionPane.showMessageDialog(null, "Broj naljepnica ne moze biti negativan!", "Omaška", JOptionPane.ERROR_MESSAGE);
					return;
				}
			} 
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Uneseni broj naljepnica ne predstavlja broj!", "Omaška", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		
		BufferedImage[] slike = KreirajSlikeNaljepnica(table, barKod);
		int[] brojNaljepnica = BrojNaljepnica(table);
		KreirajPDFDokument(slike, brojNaljepnica);
	}
}
