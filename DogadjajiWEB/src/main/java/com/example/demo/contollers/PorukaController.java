package com.example.demo.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.KorisnikService;
import com.example.demo.service.PorukaService;

import jakarta.servlet.http.HttpSession;
import model.Korisnik;
import model.Poruka;

@Controller
@RequestMapping("/porukaController")
public class PorukaController {

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private PorukaService porukaService;

    @GetMapping("/slanjePoruke")
    public String prikaziStranicuSlanjePoruka(Model model, HttpSession session) {
        Korisnik ulogovani = (Korisnik) session.getAttribute("ulogovaniKorisnik");
        List<Korisnik> sviKorisnici = korisnikService.findAll();

        model.addAttribute("korisnici", sviKorisnici);
        model.addAttribute("ulogovani", ulogovani);

        return "korisnik/slanjePoruke"; 
    }

 
    @GetMapping("/listaKorisnika")
    public String listaKorisnika(Model model, HttpSession session) {
        Korisnik ulogovani = (Korisnik) session.getAttribute("ulogovaniKorisnik");
        List<Korisnik> sviKorisnici = korisnikService.findAll();

        model.addAttribute("korisnici", sviKorisnici);
        model.addAttribute("ulogovani", ulogovani);

        return "korisnik/slanjePoruke";
    }

  
    @GetMapping("/chat")
    public String chat(@RequestParam("idPrimaoca") int idPrimaoca, Model model, HttpSession session) {
        Korisnik ulogovani = (Korisnik) session.getAttribute("ulogovaniKorisnik");
        Korisnik primalac = korisnikService.findById(idPrimaoca);

        List<Poruka> poruke = porukaService.findConversation(ulogovani.getIdKorisnik(), idPrimaoca);

        model.addAttribute("ulogovani", ulogovani);
        model.addAttribute("primalac", primalac);
        model.addAttribute("poruke", poruke);

        return "korisnik/chat"; 
    }

    
    @PostMapping("/posalji")
    public String posalji(@RequestParam("idPrimaoca") int idPrimaoca,
                          @RequestParam("tekst") String tekst,
                          HttpSession session) {

        Korisnik posiljalac = (Korisnik) session.getAttribute("ulogovaniKorisnik");
        porukaService.posaljiPoruku(posiljalac.getIdKorisnik(), idPrimaoca, tekst);

       
        return "redirect:/porukaController/chat?idPrimaoca=" + idPrimaoca;
    }
}
