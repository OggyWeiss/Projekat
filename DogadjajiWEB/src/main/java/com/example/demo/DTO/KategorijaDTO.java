package com.example.demo.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class KategorijaDTO {

	@NotBlank(message = "Naziv kategorije je obavezan")
	@Size(min = 2, max = 50, message = "Naziv mora imati između 2 i 50 karaktera")
	private String naziv;

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
}
