package HRMS.hrms.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class sendOtp {
    private  static final Long Expiration_otp=5*100*1000L;



    private final JavaMailSender mailSender;
    public sendOtp(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void GenerateOtpAndSend(String email,Long number){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("OTP HRMS");
        message.setText("Your OTP is: "+number);
        mailSender.send(message);

    }


}
