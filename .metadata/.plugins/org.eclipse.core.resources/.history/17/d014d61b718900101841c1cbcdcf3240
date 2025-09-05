package com.example.demo.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.KorisnikService;

import jakarta.servlet.http.HttpSession;
import model.Korisnik;

@Controller
@RequestMapping("/loginController/")
public class LoginController {

    @Autowired
    private KorisnikService korisnikService;

    @GetMapping("loginStranica")
    public String prikaziLoginFormu() {
        return "loginFolder/loginStranica";
    }

    @PostMapping("login")
    public String login(@RequestParam String email,
                        @RequestParam String lozinka,
                        HttpSession session,
                        Model model) {

        Korisnik k = korisnikService.login(email, lozinka);

        if (k == null) {
            model.addAttribute("greska", "Pogrešan email ili lozinka!");
            return "loginFolder/loginStranica";
        }

        session.setAttribute("ulogovaniKorisnik", k);

        if ("ADMIN".equals(k.getUloga().getNaziv())) {
            return "administrator/administratorHome";
        } else {
            return "korisnik/korisnikHome";
        }
    }

}
