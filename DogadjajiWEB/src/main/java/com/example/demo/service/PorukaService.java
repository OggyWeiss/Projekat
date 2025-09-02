package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.KorisnikRepository;
import com.example.demo.repository.PorukaRepository;

import model.Korisnik;
import model.Poruka;

@Service
public class PorukaService {

    @Autowired
    private PorukaRepository porukaRepository;

    @Autowired
    private KorisnikRepository korisnikRepo;

    
    public List<Poruka> findConversation(int idPosiljalac, int idPrimalac) {
        Korisnik posiljalac = korisnikRepo.findById(idPosiljalac).get();
        Korisnik primalac = korisnikRepo.findById(idPrimalac).get();

        return porukaRepository.findConversation(posiljalac, primalac);

    }

    public Poruka posaljiPoruku(int idPosiljalac, int idPrimalac, String tekst) {
        Korisnik posiljalac = korisnikRepo.findById(idPosiljalac).get();
        Korisnik primalac = korisnikRepo.findById(idPrimalac).get();

        Poruka poruka = new Poruka();
        poruka.setKorisnik1(posiljalac);
        poruka.setKorisnik2(primalac);
        poruka.setTekst(tekst);
        poruka.setDatum(new Date());

        return porukaRepository.save(poruka);
    }
}
