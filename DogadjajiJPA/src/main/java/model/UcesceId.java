package model;

import java.io.Serializable;
import jakarta.persistence.Embeddable;

@Embeddable
public class UcesceId implements Serializable {

	private int idKorisnik;
	private int idDogadjaj;

	public UcesceId() {
	}

	public UcesceId(int idKorisnik, int idDogadjaj) {
		this.idKorisnik = idKorisnik;
		this.idDogadjaj = idDogadjaj;
	}

	// getter i setter
	public int getIdKorisnik() {
		return idKorisnik;
	}

	public void setIdKorisnik(int idKorisnik) {
		this.idKorisnik = idKorisnik;
	}

	public int getIdDogadjaj() {
		return idDogadjaj;
	}

	public void setIdDogadjaj(int idDogadjaj) {
		this.idDogadjaj = idDogadjaj;
	}

	@Override
	public int hashCode() {
		return idKorisnik + idDogadjaj;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		UcesceId that = (UcesceId) obj;
		return this.idKorisnik == that.idKorisnik && this.idDogadjaj == that.idDogadjaj;
	}
}
