package com.example.demo.serviceRest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.DogadjajDTO;
import com.example.demo.repository.DogadjajRepository;

import model.Dogadjaj;

@Service
public class DogadjajServiceREST {

    @Autowired
    DogadjajRepository dr;

    // getAll
    public List<DogadjajDTO> getDogadjaji() {
        List<DogadjajDTO> dogadjaji = new ArrayList<>();
        for (Dogadjaj d : dr.findAll()) {
            DogadjajDTO dto = new DogadjajDTO();
            BeanUtils.copyProperties(d, dto);
            dogadjaji.add(dto);
        }
        return dogadjaji;
    }

    // getByDatum
    public List<DogadjajDTO> getDogadjajiByDatum(Date datum) {
        if (dr.pretraziPoDatumu(datum).isEmpty())
            return null;

        List<DogadjajDTO> dogadjaji = new ArrayList<>();
        for (Dogadjaj d : dr.pretraziPoDatumu(datum)) {
            DogadjajDTO dto = new DogadjajDTO();
            BeanUtils.copyProperties(d, dto);
            dogadjaji.add(dto);
        }
        return dogadjaji;
    }
}
