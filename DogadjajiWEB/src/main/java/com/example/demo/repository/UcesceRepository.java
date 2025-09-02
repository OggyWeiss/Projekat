package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Ucesce;
import model.UcesceId;

public interface UcesceRepository extends JpaRepository<Ucesce, UcesceId> {

	boolean existsByKorisnikIdKorisnikAndDogadjajIdDogadjaj(int idKorisnik, int idDogadjaj);

	void deleteByKorisnikIdKorisnikAndDogadjajIdDogadjaj(int idKorisnik, int idDogadjaj);
	
	List<Ucesce> findByKorisnikIdKorisnik(int idKorisnik);
}
