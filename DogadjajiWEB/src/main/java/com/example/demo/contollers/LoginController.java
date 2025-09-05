package com.example.demo.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.security.CustomUserDetail;
import com.example.demo.service.KorisnikService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import model.Korisnik;

@Controller
@RequestMapping("/loginController/")
public class LoginController {

    @Autowired
    private KorisnikService korisnikService;

    @GetMapping("prikazLogina")
    public String prikaziLoginFormu() {
        return "loginFolder/loginStranica";
    }

    //metoda ukoliko postoji Spring security
    @GetMapping("preusmeriNakonLogin")
    public String getPocetnaUlogovan(HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Korisnik k = ((CustomUserDetail) authentication.getPrincipal()).getK(); //vraca detalje o korisniku 
        request.getSession().setAttribute("ulogovaniKorisnik", k);

        if (k.getUloga().getNaziv().equals("ADMIN")) {
            return "administrator/administratorHome";
        } else if (k.getUloga().getNaziv().equals("KORISNIK")) {
            return "korisnik/korisnikHome";
        } else {
            return "loginFolder/loginStranica";
        }
    }
    
    @GetMapping("odjava")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); 
        }
        return "loginFolder/loginStranica";
    }
    
// metoda namenjena ukoliko ne postoji Spring security
//    @PostMapping("login") 
//    public String login(@RequestParam String username,
//                        @RequestParam String password,
//                        HttpSession session,
//                        Model model) {
//
//        Korisnik k = korisnikService.login(username, password);
//
//        if (k == null) {
//            model.addAttribute("greska", "Pogrešan email ili lozinka!");
//            return "loginFolder/loginStranica";
//        }
//
//        session.setAttribute("ulogovaniKorisnik", k);
//
//        if ("ADMIN".equals(k.getUloga().getNaziv())) {
//            return "administrator/administratorHome";
//        } else {
//            return "korisnik/korisnikHome";
//        }
//    }
    
    

}
