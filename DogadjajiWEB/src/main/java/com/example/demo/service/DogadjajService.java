package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.DogadjajRepository;
import com.example.demo.repository.KomentarRepository;
import com.example.demo.repository.KorisnikRepository;
import com.example.demo.repository.UcesceRepository;

import jakarta.transaction.Transactional;
import model.Dogadjaj;
import model.Komentar;
import model.Korisnik;
import model.Ucesce;
import model.UcesceId;

@Service
public class DogadjajService {

	@Autowired
	DogadjajRepository dr;

	@Autowired
	KorisnikRepository korisnikRepository;

	@Autowired
	UcesceRepository ucesceRepository;
	
	@Autowired
	KomentarRepository kr;
	

	public List<Dogadjaj> getDogadjaji() {
		return dr.findAll();
	}

	public List<Dogadjaj> findByNaziv(String naziv) {
		// TODO Auto-generated method stub
		return dr.pretraziPoNazivu(naziv);
	}

	public List<Dogadjaj> findByNazivAndDatum(String naziv, Date datum) {
		return dr.pretraziPoNazivuIDatumu(naziv, datum);
	}

	public List<Dogadjaj> findByDatum(Date datum) {
		// TODO Auto-generated method stub
		return dr.pretraziPoDatumu(datum);
	}

	public void sacuvaj(Dogadjaj dogadjaj) {
		dr.save(dogadjaj);
	}

	public void deleteById(Integer id) {
		dr.deleteById(id);
	}

	public Dogadjaj findById(Integer id) {
		return dr.findById(id).get();
	}

	public void prijaviKorisnikaNaDogadjaj(int idKorisnik, int idDogadjaj) {
		if (ucesceRepository.existsByKorisnikIdKorisnikAndDogadjajIdDogadjaj(idKorisnik, idDogadjaj)) {
			throw new RuntimeException("Korisnik je već prijavljen na ovaj događaj.");
		}

		Korisnik k = korisnikRepository.findById(idKorisnik).orElseThrow();
		Dogadjaj d = dr.findById(idDogadjaj).orElseThrow();

		Ucesce ucesce = new Ucesce();
		UcesceId id = new UcesceId();
		id.setIdKorisnik(k.getIdKorisnik());
		id.setIdDogadjaj(d.getIdDogadjaj());
		ucesce.setId(id);
		ucesce.setKorisnik(k);
		ucesce.setDogadjaj(d);

		ucesceRepository.save(ucesce);
	}

	public List<Dogadjaj> findDogadjajiByKorisnik(int idKorisnik) {
		List<Ucesce> ucesca = ucesceRepository.findByKorisnikIdKorisnik(idKorisnik);
        List<Dogadjaj> dogadjaji = new ArrayList<>();
        for (Ucesce u : ucesca) {
            dogadjaji.add(u.getDogadjaj());
        }
        return dogadjaji;
	}
	
	@Transactional
	public void odjaviKorisnikaSaDogadjaja(int idKorisnik, List<Integer> idDogadjaja) {
        if (idDogadjaja != null) {
            for (Integer idDog : idDogadjaja) {
                ucesceRepository.deleteByKorisnikIdKorisnikAndDogadjajIdDogadjaj(idKorisnik, idDog);
            }
        }
    }

	public List<Komentar> getKomentari() {
		return kr.findAll();
	}

	public void dodajKomentar(int idDogadjaj, int idKorisnik, String tekst) {
		Dogadjaj dogadjaj = dr.findById(idDogadjaj).get();
        Korisnik korisnik = korisnikRepository.findById(idKorisnik).get();

 

        Komentar komentar = new Komentar();
        komentar.setDogadjaj(dogadjaj);
        komentar.setKorisnik(korisnik);
        komentar.setTekst(tekst);
        komentar.setDatum(new Date());

        
        kr.save(komentar);
    }
	
}
