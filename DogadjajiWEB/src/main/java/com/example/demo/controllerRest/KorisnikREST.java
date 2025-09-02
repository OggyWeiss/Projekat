package com.example.demo.controllerRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.serviceRest.KorisnikServiceREST;

@RestController
@RequestMapping("/korisnikControllerREST/")
public class KorisnikREST {

    @Autowired
    KorisnikServiceREST ks;

    // getAll
    @GetMapping("getKorisnici")
    public ResponseEntity<?> getKorisnici() {
        return ResponseEntity.ok(ks.getKorisnici());
    }

    // getByIme
    @GetMapping("getKorisniciByIme")
    public ResponseEntity<?> getKorisniciByIme(@RequestParam String ime) {
        if (ime.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Ime ne sme biti prazno.");
        }

        var lista = ks.getKorisniciByIme(ime);
        if (lista == null || lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Korisnik sa tim imenom nije pronađen.");
        }
        return ResponseEntity.ok(lista);
    }
}
