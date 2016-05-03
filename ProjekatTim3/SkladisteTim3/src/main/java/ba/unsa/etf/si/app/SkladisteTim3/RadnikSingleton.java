package ba.unsa.etf.si.app.SkladisteTim3;

public final class RadnikSingleton {
	private static RadnikSingleton instance = new RadnikSingleton();
	
	private RadnikSingleton() {}
	public static RadnikSingleton getInstance() {
		return instance;
	}
}
