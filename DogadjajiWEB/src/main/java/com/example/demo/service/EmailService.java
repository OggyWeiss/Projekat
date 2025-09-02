package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void posaljiEmail(String to, String subject, String text) {
        SimpleMailMessage poruka = new SimpleMailMessage();
        poruka.setTo(to);
        poruka.setSubject(subject);
        poruka.setText(text);
        poruka.setFrom("ognjenjozef1@gmail.com");
        mailSender.send(poruka);
    }
}

