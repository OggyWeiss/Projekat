package com.example.demo.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class KorisnikDTO {

	@NotBlank(message = "Ime je obavezno")
	@Size(min = 3, max = 50, message = "Ime mora imati između 3 i 50 karaktera")
	private String ime;

	@NotBlank(message = "Prezime je obavezno")
	@Size(min = 3, max = 50, message = "Prezime mora imati između 3 i 50 karaktera")
	private String prezime;

	@NotBlank(message = "Email je obavezan")
	@Size(min = 3, max = 50, message = "Email mora imati između 3 i 50 karaktera")
	private String email;

	@NotBlank(message = "Lozinka je obavezna")
	@Size(min = 3, max = 50, message = "Lozinka mora imati između 3 i 50 karaktera")
	private String lozinka;

	@NotBlank(message = "Uloga je obavezna")
	private String uloga;

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUloga() {
		return uloga;
	}

	public void setUloga(String uloga) {
		this.uloga = uloga;
	}
}
