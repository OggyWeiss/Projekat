package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import model.Kategorijadogadjaja;

@Repository
public interface KategorijaRepository extends JpaRepository<Kategorijadogadjaja, Integer> {

	@Query("select k from Kategorijadogadjaja k where k.naziv = :naziv")
	public List<Kategorijadogadjaja> findByNaziv(@Param("naziv") String naziv);

}
