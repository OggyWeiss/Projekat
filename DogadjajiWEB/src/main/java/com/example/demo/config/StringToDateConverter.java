package com.example.demo.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class StringToDateConverter implements Converter<String, Date> {

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date convert(String source) {
        if (source == null || source.trim().isEmpty()) {
            return null;
        }
        try {
            sdf.setLenient(false);
            return sdf.parse(source);
        } catch (Exception e) {
        	throw new InvalidDateFormatException("Datum mora biti u formatu yyyy-MM-dd: " + source, e);
        }
    }
}
