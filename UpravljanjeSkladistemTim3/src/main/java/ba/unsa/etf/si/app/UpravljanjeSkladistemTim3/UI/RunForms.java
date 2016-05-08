package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.UI;

import java.awt.EventQueue;

import ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL.Uposlenik;

public class RunForms {
	public static void RunMenadzerForm(Uposlenik _user)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormaZaMenadzera window = new FormaZaMenadzera();
					//window._user = _user;
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
	
	public static void RunUposlenikForm(Uposlenik _user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormaZaUposlenika window = new FormaZaUposlenika();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
