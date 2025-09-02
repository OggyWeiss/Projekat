package com.example.demo.contollers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Dogadjaj;
import model.Kategorijadogadjaja;
import model.Korisnik;

import com.example.demo.DTO.DogadjajDTO;
import com.example.demo.DTO.KategorijaDTO;
import com.example.demo.service.DogadjajService;
import com.example.demo.service.EmailService;
import com.example.demo.service.KategorijaService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/dogadjajController/")
public class DogadjajController {

	@Autowired
	DogadjajService ds;

	@Autowired
	KategorijaService ks;
	
	@Autowired
	EmailService emailService;

	@GetMapping("redirectToPregled")
	public String redirectPregled() {
		return "dogadjaji/pregledDogadjaja";
	}

	@ModelAttribute("dogadjaji")
	public List<Dogadjaj> getDogadjaji() {
		return ds.getDogadjaji();
	}

	@GetMapping("korisnikHome")
	public String redirectToHome() {
		return "korisnik/korisnikHome";
	}

	@GetMapping("redirectToPretraga")
	public String redirectPretraga() {
		return "dogadjaji/pretragaDogadjaja";
	}
	
	@Scheduled(fixedRate = 30000) 
    public void simpleScheduler() {
        System.out.println("Scheduler: Trenutni broj dogadjaja je: " + ks.getNumDogadjaja());
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

	@GetMapping("dodajDogadjaj")
	public String prikaziFormu(Model model) {
		model.addAttribute("kategorije", ks.findAll());
		model.addAttribute("dogadjajDTO", new DogadjajDTO());
		return "korisnik/dodajDogadjaj";
	}

	@GetMapping("dodajKomentar")
	public String prikaziKomentar(Model model) {
		model.addAttribute("dogadjaji", ds.getDogadjaji());
		return "korisnik/dodajKomentar";
	}

	@GetMapping("prijavaNaDogadjaj")
	public String prikaziPrijavu(Model model) {
		model.addAttribute("dogadjaji", ds.getDogadjaji());
		return "dogadjaji/prijavaNaDogadjaj";
	}

	@GetMapping("sacuvajKomentar")
	public String sacuvajKomentar(@RequestParam("idDogadjaj") int idDogadjaj, Model model) {
		Dogadjaj dogadjaj = ds.findById(idDogadjaj);
		model.addAttribute("dogadjaj", dogadjaj);
		return "korisnik/sacuvajKomentar";
	}
	
	@PostMapping("sacuvajKomentar")
    public String sacuvajKomentar(@RequestParam("idDogadjaj") int idDogadjaj,
                                   @RequestParam("tekst") String tekst,
                                   HttpSession session) {
        Korisnik ulogovani = (Korisnik) session.getAttribute("ulogovaniKorisnik");
        ds.dodajKomentar(idDogadjaj, ulogovani.getIdKorisnik(), tekst);
        return "korisnik/dodajKomentar";
    }

	@GetMapping("odjavaSaDogadjaja")
	public String prikaziOdjavu(Model model, HttpSession session) {
		Korisnik k = (Korisnik) session.getAttribute("ulogovaniKorisnik");
		if (k == null) {
			return "loginFolder/loginStranica";
		}
		model.addAttribute("dogadjaji", ds.findDogadjajiByKorisnik(k.getIdKorisnik()));
		return "dogadjaji/odjavaSaDogadjaja";
	}

	@GetMapping("ucestvuje")
	public String prikaziUcestvovanja(Model model, HttpSession session) {
		Korisnik k = (Korisnik) session.getAttribute("ulogovaniKorisnik");
		if (k == null) {
			return "loginFolder/loginStranica";
		}
		List<Dogadjaj> dogadjaji = ds.findDogadjajiByKorisnik(k.getIdKorisnik());
		model.addAttribute("dogadjaji", dogadjaji);
		return "dogadjaji/ucestvujeNa";
	}

	@PostMapping("odjaviSe")
	public String odjaviSe(@RequestParam(value = "odabraniDogadjaji", required = false) List<Integer> odabraniDogadjaji,
			HttpSession session, Model model) {

		Korisnik k = (Korisnik) session.getAttribute("ulogovaniKorisnik");
		if (k == null) {
			return "loginFolder/loginStranica";
		}

		ds.odjaviKorisnikaSaDogadjaja(k.getIdKorisnik(), odabraniDogadjaji);

		model.addAttribute("dogadjaji", ds.findDogadjajiByKorisnik(k.getIdKorisnik()));

		return "dogadjaji/odjavaSaDogadjaja";
	}

	@PostMapping("prijavaNaDogadjaj")
	public String prijaviSe(@RequestParam("idDogadjaj") int idDogadjaj, HttpSession session) {
		Korisnik korisnik = (Korisnik) session.getAttribute("ulogovaniKorisnik");

		if (korisnik == null) {
			return "/Dogadjaji/loginController/loginStranica";
		}

		ds.prijaviKorisnikaNaDogadjaj(korisnik.getIdKorisnik(), idDogadjaj);
		
//		Dogadjaj dogadjaj = ds.findById(idDogadjaj);
//	    String subject = "Prijava na događaj: " + dogadjaj.getNaziv();
//	    String text = "Pozdrav " + korisnik.getIme() + ",\n\nUspešno ste prijavljeni na događaj: " //da bi funkcionisalo slanje mejla potreban mi je app password
//	                  + dogadjaj.getNaziv() + " koji se održava " + dogadjaj.getDatum() + ".";
//	    emailService.posaljiEmail("ognjenjozef1@gmail.com", subject, text); //stavio sam moj mejl radi testiranja da li radi metoda

		return "korisnik/korisnikHome";
	}

	@GetMapping("obrisiDogadjaj")
	public String obrisiStranica(Model m) {
		List<Dogadjaj> dogadjaji = ds.getDogadjaji();
		m.addAttribute("dogadjaji", dogadjaji);
		return "korisnik/obrisiDogadjaj";
	}

	@GetMapping("izmeniDogadjaj")
	public String izmeniStranica(Model m) {
		List<Dogadjaj> dogadjaji = ds.getDogadjaji();
		m.addAttribute("dogadjaji", dogadjaji);
		return "korisnik/izmeniDogadjaj";
	}

	@GetMapping("izmeniStranica")
	public String prikaziFormuZaIzmenu(@RequestParam("id") Integer id, Model model) {
		Dogadjaj dogadjaj = ds.findById(id);
		model.addAttribute("dogadjaj", dogadjaj);
		return "korisnik/izmeniStranica";
	}

	@GetMapping("dodajKategoriju")
	public String dodajKategoriju(Model model) {
		model.addAttribute("kategorijaDTO", new KategorijaDTO());
		return "korisnik/dodajKategoriju";
	}

	@PostMapping("/sacuvaj")
	public String sacuvajDogadjaj(@Valid @ModelAttribute("dogadjajDTO") DogadjajDTO dogadjajDTO,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errorsPoruke", bindingResult.getAllErrors());
			model.addAttribute("kategorije", ks.findAll());
			return "korisnik/dodajDogadjaj";
		}

		Dogadjaj dogadjaj = new Dogadjaj();
		dogadjaj.setNaziv(dogadjajDTO.getNaziv());
		dogadjaj.setOpis(dogadjajDTO.getOpis());
		dogadjaj.setDatum(dogadjajDTO.getDatum());

		if (dogadjajDTO.getKategorijaId() != null) {
			Kategorijadogadjaja kategorija = ks.findById(dogadjajDTO.getKategorijaId());
			dogadjaj.setKategorijadogadjaja(kategorija);
		}

		ds.sacuvaj(dogadjaj);
		return "korisnik/korisnikHome";
	}

	@PostMapping("obrisi")
	public String obrisiDogadjaje(@RequestParam("id") List<Integer> ids) {
		if (ids != null && !ids.isEmpty()) {
			for (Integer id : ids) {
				ds.deleteById(id);
			}
		}
		return "korisnik/korisnikHome";
	}

	@PostMapping("izmeniSacuvaj")
	public String izmeniSacuvaj(@RequestParam("idDogadjaj") Integer id, @RequestParam("naziv") String naziv,
			@RequestParam("opis") String opis,
			@RequestParam("datum") @DateTimeFormat(pattern = "yyyy-MM-dd") Date datum) {
		Dogadjaj d = ds.findById(id);
		d.setNaziv(naziv);
		d.setOpis(opis);
		d.setDatum(datum);
		ds.sacuvaj(d);
		return "korisnik/korisnikHome";
	}

	@PostMapping("sacuvajKategoriju")
	public String dodajKategoriju(@Valid @ModelAttribute("kategorijaDTO") KategorijaDTO kategorijaDTO,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "korisnik/dodajKategoriju";
		}

		Kategorijadogadjaja kd = new Kategorijadogadjaja();
		kd.setNaziv(kategorijaDTO.getNaziv());
		ks.sacuvaj(kd);

		return "korisnik/korisnikHome";

	}
}
