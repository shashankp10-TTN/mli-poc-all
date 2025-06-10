package com.poc.emailservice.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

//    @Async
    public void sendEmail(String email, String name) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(email);
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("Employee Registration!");
        simpleMailMessage.setText("Hi, " +  name + "! Your account has been created successfully!");

        mailSender.send(simpleMailMessage);
        System.out.println("Email sent successfully!");
    }
}
