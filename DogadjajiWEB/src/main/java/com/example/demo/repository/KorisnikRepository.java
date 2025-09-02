package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import model.Dogadjaj;
import model.Korisnik;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Integer> {
	@Query("select k from Korisnik k where k.ime = :ime")
	List<Korisnik> findByIme(@Param("ime") String ime);

	Korisnik findByEmail(String email);

	
	
	@Query("SELECT k FROM Korisnik k " +
		       "JOIN Ucesce u ON k.idKorisnik = u.korisnik.idKorisnik " +
		       "WHERE u.dogadjaj = :dogadjaj")
	    List<Korisnik> ucestvujeNa(@Param("dogadjaj") Dogadjaj dogadjaj);

}
