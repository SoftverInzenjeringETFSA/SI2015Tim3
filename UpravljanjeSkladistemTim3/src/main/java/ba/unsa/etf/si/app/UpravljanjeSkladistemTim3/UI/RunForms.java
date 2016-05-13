package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import java.awt.EventQueue;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Uposlenik;
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
					e.printStackTrace();
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
					e.printStackTrace();
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
					e.printStackTrace();
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
					e.printStackTrace();
				}
			}
		});
	}
}
