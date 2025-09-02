package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import model.Dogadjaj;

@Repository
public interface DogadjajRepository extends JpaRepository<Dogadjaj, Integer> {

	@Query("SELECT d FROM Dogadjaj d WHERE LOWER(d.naziv) = LOWER(:naziv)")
	List<Dogadjaj> pretraziPoNazivu(@Param("naziv") String naziv);

	@Query("SELECT d FROM Dogadjaj d WHERE LOWER(d.naziv) = LOWER(:naziv) AND d.datum = :datum")
	List<Dogadjaj> pretraziPoNazivuIDatumu(@Param("naziv") String naziv, @Param("datum") Date datum);
	
	@Query("SELECT d FROM Dogadjaj d WHERE d.datum = :datum")
	List<Dogadjaj> pretraziPoDatumu(@Param("datum") Date datum);


}
