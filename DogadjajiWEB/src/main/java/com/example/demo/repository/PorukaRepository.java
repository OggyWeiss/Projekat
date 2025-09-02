package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Korisnik;
import model.Poruka;

public interface PorukaRepository extends JpaRepository<Poruka, Integer> {

	@Query("SELECT p FROM Poruka p WHERE (p.korisnik1 = :posiljalac AND p.korisnik2 = :primalac) OR (p.korisnik1 = :primalac AND p.korisnik2 = :posiljalac) ORDER BY p.datum ASC")
	List<Poruka> findConversation(@Param("posiljalac") Korisnik posiljalac, @Param("primalac") Korisnik primalac);

}
