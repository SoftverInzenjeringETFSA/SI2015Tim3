package ba.unsa.etf.si.app.UpravljanjeSkladistemTim3.DAL;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="UPOSLENIK")
public class Uposlenik implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "uposlenik_id")
	long id;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getJMBG() {
		return JMBG;
	}

	public void setJMBG(String jMBG) {
		JMBG = jMBG;
	}

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getMjestoRodjenja() {
		return mjestoRodjenja;
	}

	public void setMjestoRodjenja(String mjestoRodjenja) {
		this.mjestoRodjenja = mjestoRodjenja;
	}

	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}

	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public StrucnaSprema getStrucnaSprema() {
		return strucnaSprema;
	}

	public void setStrucnaSprema(StrucnaSprema strucnaSprema) {
		this.strucnaSprema = strucnaSprema;
	}

	public Date getDatumZaposlenja() {
		return datumZaposlenja;
	}

	public void setDatumZaposlenja(Date datumZaposlenja) {
		this.datumZaposlenja = datumZaposlenja;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TipUposlenika getTipUposlenika() {
		return tipUposlenika;
	}

	public void setTipUposlenika(TipUposlenika tipUposlenika) {
		this.tipUposlenika = tipUposlenika;
	}


	public Skladiste get_skladiste() {
		return _skladiste;
	}

	public void set_skladiste(Skladiste _skladiste) {
		this._skladiste = _skladiste;
	}
	@Column(name="ime")
	String ime;
	@Column(name="prezime")
	String prezime;
	@Column(name="jmbg")
	String JMBG;
	@Column(name="datum_rodjenja")
	Date datumRodjenja;
	@Column(name="mjesto_rodjenja")
	String mjestoRodjenja;
	@Column(name="adresa_stanovanja")
	String adresaStanovanja;
	@Column(name="broj_telefona")
	String brojTelefona;
	@Column(name="email")
	String email;
	@Column(name="strucna_sprema")
	StrucnaSprema strucnaSprema;
	@Column(name="datum_zaposlenja")
	Date datumZaposlenja;
	@Column(name="user")
	String user;
	@Column(name="password")
	String password;
	@Column(name="tip_uposlenika")
	TipUposlenika tipUposlenika;
	@ManyToOne
	@JoinColumn(name="skladiste_id")
	Skladiste _skladiste;
	
	public Uposlenik() {}
}
