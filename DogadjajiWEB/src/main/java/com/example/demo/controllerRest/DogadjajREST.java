package com.example.demo.controllerRest;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.serviceRest.DogadjajServiceREST;

@RestController
@RequestMapping("/dogadjajControllerREST/")
public class DogadjajREST {

    @Autowired
    DogadjajServiceREST ds;

    // getAll
    @GetMapping("getDogadjaji")
    public ResponseEntity<?> getDogadjaji() {
        return ResponseEntity.ok(ds.getDogadjaji());
    }

    // getByDatum
    @GetMapping("getDogadjajiByDatum")
    public ResponseEntity<?> getDogadjajiByDatum(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date datum) {

        if (datum == null) {
            return ResponseEntity.badRequest().body("Datum je obavezan.");
        }
       
        if ( ds.getDogadjajiByDatum(datum) == null ||  ds.getDogadjajiByDatum(datum).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nema događaja za dati datum.");
        }
        return ResponseEntity.ok( ds.getDogadjajiByDatum(datum));
    }
}

