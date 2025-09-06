package com.example.demo.contollers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.DogadjajService;

import model.Dogadjaj;

@Controller
@RequestMapping("/nelogovanController/")
public class NelogovanDogadjajController {
	
	@Autowired
	DogadjajService ds;
	
	@GetMapping("redirectToPretraga")
	public String redirectPretraga() {
		return "dogadjaji/pretragaDogadjaja";
	}
	
	@ModelAttribute("dogadjaji")
	public List<Dogadjaj> getDogadjaji() {
		return ds.getDogadjaji();
	}
	
	@GetMapping("redirectToPregled")
	public String redirectPregled() {
		return "dogadjaji/pregledDogadjaja";
	}
	
	@GetMapping("pretraga")
	public String pretragaDogadjaja(@RequestParam(name = "naziv", required = false) String naziv,
			@RequestParam(name = "datum", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date datum,
			Model model) {

		List<Dogadjaj> rezultati;

		if (naziv != null && !naziv.trim().isEmpty() && datum == null) {
			// Samo naziv
			rezultati = ds.findByNaziv(naziv);
		} else if (naziv != null && !naziv.trim().isEmpty() && datum != null) {
			// Naziv i datum
			rezultati = ds.findByNazivAndDatum(naziv, datum);
		} else if ((naziv == null || naziv.trim().isEmpty()) && datum != null) {
			// Samo datum
			rezultati = ds.findByDatum(datum);
		} else {
			// Ništa nije uneto
			rezultati = ds.getDogadjaji();
		}

		model.addAttribute("rezultati", rezultati);
		return "dogadjaji/pretragaDogadjaja";
	}
}
