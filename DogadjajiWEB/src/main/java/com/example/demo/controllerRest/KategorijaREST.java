package com.example.demo.controllerRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.serviceRest.KategorijaServiceREST;

@RestController
@RequestMapping("/kategorijaControllerREST/")
public class KategorijaREST {

	@Autowired
	KategorijaServiceREST ks;
	
	
	//getAll
	
	@GetMapping("getKategorije")
	public ResponseEntity<?> getKategorije(){
		return ResponseEntity.ok(ks.getKategorije());
	}
	//getByNaziv
	@GetMapping("getKategorijeByNaziv")
	public ResponseEntity<?> getKategorijeByNaziv(String naziv){
		if(naziv.trim().isEmpty()) {
			return ResponseEntity.badRequest().body("Naziv ne valja");
		}
		if(ks.getKategorijeByNaziv(naziv) == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Kategorija nije nadjena");
		}
		return ResponseEntity.ok(ks.getKategorijeByNaziv(naziv));
	}
}
