package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.KategorijaRepository;

import model.Kategorijadogadjaja;

@Service
public class KategorijaService {

	@Autowired
	KategorijaRepository kr;

	public Kategorijadogadjaja findById(Integer kategorijaId) {
		return kr.findById(kategorijaId).get();
	}

	public List<Kategorijadogadjaja> findAll() {
		// TODO Auto-generated method stub
		return kr.findAll();
	}

	public void sacuvaj(Kategorijadogadjaja kd) {
		kr.save(kd);
	}

	public int getNumDogadjaja() {
		return kr.findAll().size();
	}
	
	
}
