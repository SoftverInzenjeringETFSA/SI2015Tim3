package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import java.awt.EventQueue;

import javax.swing.JComboBox;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Uposlenik;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.App;
import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Nabavka;

public class RunForms {
	public static void RunMenadzerForm(final Uposlenik _user)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormaZaMenadzera window = new FormaZaMenadzera();
					window.set_user(_user);
					window.frmSistemUpravljanjaSkladistem.setVisible(true);
				} catch (Exception e) {
					App.logger.error("Omaska - Otvaranje forme za menadzera.", e);
					
				}
			}
		});
	}
	
	public static void RunPrijavaForm() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prijava window = new Prijava();
					window.frmPrijava.setVisible(true);
				} catch (Exception e) {
					App.logger.error("Omaska - Otvaranje forme za prijavu.", e);
				}
			}
		});
	}
	
	public static void RunUposlenikForm(final Uposlenik _user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormaZaUposlenika window = new FormaZaUposlenika();
					window.set_user(_user);
					window.frmSistemUpravljanjaSkladitem.setVisible(true);
				} catch (Exception e) {
					App.logger.error("Omaska - Otvaranje forme za uposlenika.", e);
				}
			}
		});
	}
	
	public static void RunWizardForm(final Nabavka _nabavka) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NaljepniceWizard window = new NaljepniceWizard();
					window.forma.setVisible(true);
					window.PostaviNabavku(_nabavka);
				} catch (Exception e) {
					App.logger.error("Omaska - Otvaranje forme za naljepnice.", e);
				}
			}
		});
	}
	
	public static void RunUnosPartneraForm(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodavanjePoslovnogPartnera window = new DodavanjePoslovnogPartnera();
					window.frmDodavanjePoslovnogPartnera.setVisible(true);
				} catch (Exception e) {
					App.logger.error("Omaska.", e);
				}
			}
		});
	}
}
