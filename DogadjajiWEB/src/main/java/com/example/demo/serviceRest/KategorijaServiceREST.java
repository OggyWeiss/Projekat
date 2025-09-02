package com.example.demo.serviceRest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.KategorijaDTO;
import com.example.demo.repository.KategorijaRepository;

import model.Kategorijadogadjaja;

@Service
public class KategorijaServiceREST {

	@Autowired
	KategorijaRepository kr;
	
	public List<KategorijaDTO> getKategorije() {
		List<KategorijaDTO> kategorije = new ArrayList<KategorijaDTO>();
		for (Kategorijadogadjaja k: kr.findAll()) {
			KategorijaDTO dto = new KategorijaDTO();
			BeanUtils.copyProperties(k, dto);
			kategorije.add(dto);
		}
		return kategorije;
	}

	public List<KategorijaDTO> getKategorijeByNaziv(String naziv) {
		if(kr.findByNaziv(naziv).isEmpty())
			return null;
		List<KategorijaDTO> kategorije = new ArrayList<KategorijaDTO>();
		System.out.println(kr.findByNaziv(naziv).size());
		for (Kategorijadogadjaja k: kr.findByNaziv(naziv)) {
			KategorijaDTO dto = new KategorijaDTO();
			BeanUtils.copyProperties(k, dto);
			kategorije.add(dto);
		}
		return kategorije;
	}
	
}
