package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;

/**
 * The persistent class for the korisnik database table.
 * 
 */
@Entity
@NamedQuery(name = "Korisnik.findAll", query = "SELECT k FROM Korisnik k")
public class Korisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idKorisnik;

	private String email;

	private String ime;

	private String lozinka;

	private String prezime;

	// bi-directional many-to-one association to Dogadjaj
	@OneToMany(mappedBy = "korisnik")
	private List<Dogadjaj> dogadjajs1;

	// bi-directional many-to-one association to Komentar
	@OneToMany(mappedBy = "korisnik")
	private List<Komentar> komentars;

	// bi-directional many-to-one association to Uloga
	@ManyToOne
	@JoinColumn(name = "idUloga")
	private Uloga uloga;

	// bi-directional many-to-one association to Poruka
	@OneToMany(mappedBy = "korisnik1")
	private List<Poruka> porukas1;

	// bi-directional many-to-one association to Poruka
	@OneToMany(mappedBy = "korisnik2")
	private List<Poruka> porukas2;

	// bi-directional many-to-many association to Ucesce
	@OneToMany(mappedBy = "korisnik", cascade = CascadeType.ALL)
	private List<Ucesce> ucesca;

	public Korisnik() {
	}

	public List<Ucesce> getUcesca() {
		return ucesca;
	}

	public void setUcesca(List<Ucesce> ucesca) {
		this.ucesca = ucesca;
	}

	public int getIdKorisnik() {
		return this.idKorisnik;
	}

	public void setIdKorisnik(int idKorisnik) {
		this.idKorisnik = idKorisnik;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getLozinka() {
		return this.lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public List<Dogadjaj> getDogadjajs1() {
		return this.dogadjajs1;
	}

	public void setDogadjajs1(List<Dogadjaj> dogadjajs1) {
		this.dogadjajs1 = dogadjajs1;
	}

	public Dogadjaj addDogadjajs1(Dogadjaj dogadjajs1) {
		getDogadjajs1().add(dogadjajs1);
		dogadjajs1.setKorisnik(this);

		return dogadjajs1;
	}

	public Dogadjaj removeDogadjajs1(Dogadjaj dogadjajs1) {
		getDogadjajs1().remove(dogadjajs1);
		dogadjajs1.setKorisnik(null);

		return dogadjajs1;
	}

	public List<Komentar> getKomentars() {
		return this.komentars;
	}

	public void setKomentars(List<Komentar> komentars) {
		this.komentars = komentars;
	}

	public Komentar addKomentar(Komentar komentar) {
		getKomentars().add(komentar);
		komentar.setKorisnik(this);

		return komentar;
	}

	public Komentar removeKomentar(Komentar komentar) {
		getKomentars().remove(komentar);
		komentar.setKorisnik(null);

		return komentar;
	}

	public Uloga getUloga() {
		return this.uloga;
	}

	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}

	public List<Poruka> getPorukas1() {
		return this.porukas1;
	}

	public void setPorukas1(List<Poruka> porukas1) {
		this.porukas1 = porukas1;
	}

	public Poruka addPorukas1(Poruka porukas1) {
		getPorukas1().add(porukas1);
		porukas1.setKorisnik1(this);

		return porukas1;
	}

	public Poruka removePorukas1(Poruka porukas1) {
		getPorukas1().remove(porukas1);
		porukas1.setKorisnik1(null);

		return porukas1;
	}

	public List<Poruka> getPorukas2() {
		return this.porukas2;
	}

	public void setPorukas2(List<Poruka> porukas2) {
		this.porukas2 = porukas2;
	}

	public Poruka addPorukas2(Poruka porukas2) {
		getPorukas2().add(porukas2);
		porukas2.setKorisnik2(this);

		return porukas2;
	}

	public Poruka removePorukas2(Poruka porukas2) {
		getPorukas2().remove(porukas2);
		porukas2.setKorisnik2(null);

		return porukas2;
	}

}