package model;

import jakarta.persistence.*;

@Entity
@Table(name = "ucesce")
public class Ucesce {

	@EmbeddedId
	private UcesceId id;

	@ManyToOne
	@MapsId("idKorisnik")
	@JoinColumn(name = "idKorisnik")
	private Korisnik korisnik;

	@ManyToOne
	@MapsId("idDogadjaj")
	@JoinColumn(name = "idDogadjaj")
	private Dogadjaj dogadjaj;

	// konstruktori
	public Ucesce() {
	}

	public Ucesce(Korisnik korisnik, Dogadjaj dogadjaj) {
		this.korisnik = korisnik;
		this.dogadjaj = dogadjaj;
	}

	// getteri i setteri
	public UcesceId getId() {
		return id;
	}

	public void setId(UcesceId id) {
		this.id = id;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Dogadjaj getDogadjaj() {
		return dogadjaj;
	}

	public void setDogadjaj(Dogadjaj dogadjaj) {
		this.dogadjaj = dogadjaj;
	}
}
