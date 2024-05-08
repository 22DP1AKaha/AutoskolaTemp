package com.example.Autoskola.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SupportService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String toEmail, String name){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("runcisautoskola@gmail.com");
        message.setTo(toEmail);

        message.setText("Sveiki!\n\nPaldies par jūsu ziņu. Mēs esam to saņēmuši un drīz atbildēsim.");
        message.setSubject(name + ": " + "Ziņojums");

        mailSender.send(message);
    }

    public void ReciveEmail(String body, String fromEmail, String name){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("runcisautoskola@gmail.com");
        message.setTo("runcisautoskola@gmail.com");
        message.setText(body + "\n" + "Ziņu sūtīja:" + "\n" + fromEmail);
        message.setSubject(name + ": " + "Ziņojums");

        mailSender.send(message);
    }
}
