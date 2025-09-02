package com.example.demo.DTO;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Date;

public class DogadjajDTO {

	@NotBlank(message = "Naziv je obavezan")
	@Size(min = 3, max = 50, message = "Naziv mora imati između 3 i 50 karaktera")
	private String naziv;

	@NotBlank(message = "Opis je obavezan")
	@Size(min = 10, max = 500, message = "Opis mora imati između 10 i 500 karaktera")
	private String opis;

	@NotNull(message = "Datum je obavezan")
	@FutureOrPresent(message = "Datum ne može biti u prošlosti")
	private Date datum;

	private Integer kategorijaId;

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Integer getKategorijaId() {
		return kategorijaId;
	}

	public void setKategorijaId(Integer kategorijaId) {
		this.kategorijaId = kategorijaId;
	}
}
