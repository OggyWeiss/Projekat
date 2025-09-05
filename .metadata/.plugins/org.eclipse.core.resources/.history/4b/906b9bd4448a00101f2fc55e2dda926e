package com.example.demo.contollers;

import com.example.demo.DTO.KorisnikDTO;
import com.example.demo.service.KorisnikService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registracijaController")
public class RegistracijaController {

    @Autowired
    private KorisnikService korisnikService;

    @GetMapping("/registracija")
    public String prikaziFormu(Model model) {
        model.addAttribute("korisnikDTO", new KorisnikDTO());
        return "loginFolder/registracijaStranica";
    }

    @PostMapping("/registracija")
    public String registracija(
            @Valid @ModelAttribute("korisnikDTO") KorisnikDTO dto,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "loginFolder/registracijaStranica";
        }

        korisnikService.registrujKorisnika(dto);

        return "loginFolder/loginStranica";
    }

}
