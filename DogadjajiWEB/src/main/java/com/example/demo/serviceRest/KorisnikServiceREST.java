package com.example.demo.serviceRest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.KorisnikDTO;
import com.example.demo.repository.KorisnikRepository;

import model.Korisnik;

@Service
public class KorisnikServiceREST {

    @Autowired
    KorisnikRepository kr;

    // getAll
    public List<KorisnikDTO> getKorisnici() {
        List<KorisnikDTO> korisnici = new ArrayList<>();
        for (Korisnik k : kr.findAll()) {
            KorisnikDTO dto = new KorisnikDTO();
            BeanUtils.copyProperties(k, dto);
            korisnici.add(dto);
        }
        return korisnici;
    }

    // getByIme
    public List<KorisnikDTO> getKorisniciByIme(String ime) {
        if (kr.findByIme(ime).isEmpty())
            return null;

        List<KorisnikDTO> korisnici = new ArrayList<>();
        for (Korisnik k : kr.findByIme(ime)) {
            KorisnikDTO dto = new KorisnikDTO();
            BeanUtils.copyProperties(k, dto);
            korisnici.add(dto);
        }
        return korisnici;
    }
}
