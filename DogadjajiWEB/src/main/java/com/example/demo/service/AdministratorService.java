package com.example.demo.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.DogadjajRepository;
import com.example.demo.repository.KorisnikRepository;

import model.Dogadjaj;
import model.Korisnik;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class AdministratorService {

	@Autowired
	KorisnikRepository kr;
	
	@Autowired
	DogadjajRepository dr;

	public List<Korisnik> getKorisnici() {
		return kr.findAll();
	}

	public void deleteById(Integer idKorisnika) {
		kr.deleteById(idKorisnika);
	}

	public JasperPrint kreirajIzvestaj(Date datum) throws JRException, IOException{
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dr.pretraziPoDatumu(datum));
		InputStream inputStream = this.getClass().getResourceAsStream("/jasperreports/dogadjajPoDatumu.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("datum", datum);
		params.put("brojDogadjaja", dr.pretraziPoDatumu(datum).size());
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
		inputStream.close();
		return jasperPrint;
	}

	public JasperPrint kreirajIzvestaj(Dogadjaj d) throws IOException, JRException {
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(kr.ucestvujeNa(d));
		InputStream inputStream = this.getClass().getResourceAsStream("/jasperreports/brojPrijavljenih.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("naziv", d.getNaziv());
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
		inputStream.close();
		return jasperPrint;
	}
	
	
}
