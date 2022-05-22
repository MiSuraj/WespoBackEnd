package com.wespobazaar.wespo.service.userServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

public String sendmail(String toEmail,String password){

    sendSimpleEmail(toEmail,"Your Password for the account"+toEmail +"Your Password: "+password ,"WespoBazaar");

    return "Email Send";

}
    public void sendSimpleEmail(String toEmail,
                                String body,
                                String subject) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("spring.email.from@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);
        System.out.println("Mail Send...");
    }
    public String OtpSend(String toEmail,String Otp){
    sendSimpleEmail(toEmail,"Hi, Your Email One Time Password (OTP) to reset password is: "+Otp+". OTP is valid for only 10 minutes. Please don't share Otp With any Other. ","Your Email OTP to Reset password for WespoBazaar");
    return "Otp Sent to your mail ID";
    }


}
