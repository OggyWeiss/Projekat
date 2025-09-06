package com.example.demo.contollers;

import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.AdministratorService;
import com.example.demo.service.DogadjajService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Dogadjaj;
import model.Korisnik;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
@RequestMapping("/administratorController/")
public class AdministratorController {

	
	@Autowired
	AdministratorService as;
	
	@Autowired
	DogadjajService ds;
	
	@GetMapping("pregledKorisnika")
	public String otvoriKorisnika(Model m) {
		List<Korisnik> korisnici = as.getKorisnici();
		m.addAttribute("korisnici", korisnici);
		return "administrator/pregledKorisnika";
	}
	
	@GetMapping("brojPrijava")
	public String brojPrijava(Model m) {
		m.addAttribute("dogadjaji", ds.getDogadjaji());
		return "administrator/brojPrijava";
	}
	
	@GetMapping("pregledDogadjaja")
	public String otvoriDogadjaj(Model m) {
		List<Dogadjaj> dogadjaji = ds.getDogadjaji();
		m.addAttribute("dogadjaji", dogadjaji);
		return "administrator/pregledDogadjaja";
	}
	
	@GetMapping("brojDogadjaja")
	public String brojDogadjaja(Model m) {
		return "administrator/brojDogadjaja";
	}
	
	@PostMapping("obrisiKorisnika")
	public String obrisiKorisnika(@RequestParam("id") Integer idKorisnika) {
		
		as.deleteById(idKorisnika);
		
		return "administrator/administratorHome";
	}
	
	@PostMapping("obrisiDogadjaj")
    public String obrisiDogadjaj(@RequestParam("idDogadjaja") Integer idDogadjaja) {
        ds.deleteById(idDogadjaja);
        return "administrator/administratorHome"; 
    }
	
	@GetMapping("stampajBrojPrijavljenih")
	public void stampajBrojPrijavljenih(@RequestParam("idDogadjaj") Integer idDogadjaj, HttpServletResponse response, HttpSession session) {
		try {
			Dogadjaj d = ds.findById(idDogadjaj);
			
			JasperPrint jasperReport = as.kreirajIzvestaj(d);
			response.setContentType("text/html");
			response.setContentType("application/x-download");
			response.addHeader("Content-disposition", "attachment; filename=brojPrijava.pdf");
			OutputStream out = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperReport, out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("stampajBrojDogadjaja")
	public void stampajBrojDogadjaja(@RequestParam("datum")Date datum, HttpServletResponse response) {
		try {
			JasperPrint jasperReport = as.kreirajIzvestaj(datum);
			response.setContentType("text/html");
			response.setContentType("application/x-download");
			response.addHeader("Content-disposition", "attachment; filename=brojDogadjaja.pdf");
			OutputStream out = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperReport, out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
