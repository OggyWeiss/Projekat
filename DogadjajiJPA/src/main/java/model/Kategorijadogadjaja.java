package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the kategorijadogadjaja database table.
 * 
 */
@Entity
@NamedQuery(name="Kategorijadogadjaja.findAll", query="SELECT k FROM Kategorijadogadjaja k")
public class Kategorijadogadjaja implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKategorija;

	private String naziv;

	//bi-directional many-to-one association to Dogadjaj
	@OneToMany(mappedBy="kategorijadogadjaja")
	private List<Dogadjaj> dogadjajs;

	public Kategorijadogadjaja() {
	}

	public int getIdKategorija() {
		return this.idKategorija;
	}

	public void setIdKategorija(int idKategorija) {
		this.idKategorija = idKategorija;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Dogadjaj> getDogadjajs() {
		return this.dogadjajs;
	}

	public void setDogadjajs(List<Dogadjaj> dogadjajs) {
		this.dogadjajs = dogadjajs;
	}

	public Dogadjaj addDogadjaj(Dogadjaj dogadjaj) {
		getDogadjajs().add(dogadjaj);
		dogadjaj.setKategorijadogadjaja(this);

		return dogadjaj;
	}

	public Dogadjaj removeDogadjaj(Dogadjaj dogadjaj) {
		getDogadjajs().remove(dogadjaj);
		dogadjaj.setKategorijadogadjaja(null);

		return dogadjaj;
	}

}