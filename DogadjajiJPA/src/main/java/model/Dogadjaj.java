package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the dogadjaj database table.
 * 
 */
@Entity
@NamedQuery(name="Dogadjaj.findAll", query="SELECT d FROM Dogadjaj d")
public class Dogadjaj implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDogadjaj;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datum;

	private String naziv;

	@Lob
	private String opis;

	//bi-directional many-to-one association to Kategorijadogadjaja
	@ManyToOne
	@JoinColumn(name="kategorija_id")
	private Kategorijadogadjaja kategorijadogadjaja;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="kreator_id")
	private Korisnik korisnik;

	//bi-directional many-to-one association to Komentar
	@OneToMany(mappedBy="dogadjaj")
	private List<Komentar> komentars;

	//bi-directional many-to-many association to Korisnik
	// bi-directional one-to-many association to Ucesce
	@OneToMany(mappedBy="dogadjaj", cascade=CascadeType.ALL)
	private List<Ucesce> ucesca;

	// getter i setter
	public List<Ucesce> getUcesca() {
	    return ucesca;
	}

	public void setUcesca(List<Ucesce> ucesca) {
	    this.ucesca = ucesca;
	}

	public Dogadjaj() {
	}

	public int getIdDogadjaj() {
		return this.idDogadjaj;
	}

	public void setIdDogadjaj(int idDogadjaj) {
		this.idDogadjaj = idDogadjaj;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Kategorijadogadjaja getKategorijadogadjaja() {
		return this.kategorijadogadjaja;
	}

	public void setKategorijadogadjaja(Kategorijadogadjaja kategorijadogadjaja) {
		this.kategorijadogadjaja = kategorijadogadjaja;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public List<Komentar> getKomentars() {
		return this.komentars;
	}

	public void setKomentars(List<Komentar> komentars) {
		this.komentars = komentars;
	}

	public Komentar addKomentar(Komentar komentar) {
		getKomentars().add(komentar);
		komentar.setDogadjaj(this);

		return komentar;
	}

	public Komentar removeKomentar(Komentar komentar) {
		getKomentars().remove(komentar);
		komentar.setDogadjaj(null);

		return komentar;
	}

}