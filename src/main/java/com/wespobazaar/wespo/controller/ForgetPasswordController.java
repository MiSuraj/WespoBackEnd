package com.wespobazaar.wespo.controller;


import com.wespobazaar.wespo.entity.ResetDetail;

import com.wespobazaar.wespo.entity.UserOtp.EmailOtp;
import com.wespobazaar.wespo.entity.UserOtp.UsernameOtp;
import com.wespobazaar.wespo.entity.user.User;
import com.wespobazaar.wespo.service.userServices.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@RestController
@RequestMapping("/forget")
public class ForgetPasswordController {

    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Autowired
    UserService userService;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    ResetOtp resetOtp;
    @Autowired
    UserOtpService userOtpService;
    @Autowired
    EmailService emailService;


    @PostMapping("/reset")
    public String  reset(@RequestBody ResetDetail resetDetail){

        UserDetails user=userDetailsService.loadUserByUsername(resetDetail.getUsername());
        User user1=userService.getUserEmail(user.getUsername());
        user1.setPassword(bCryptPasswordEncoder.encode(resetDetail.getPassword()));
        System.out.println("Password changed successfully with "+resetDetail.getPassword());
        userService.saveUser(user1);
        return "Password changed successfully";
    }
    @PostMapping("/resetpassword")
    public boolean resetMe(@RequestBody ResetDetail resetDetail) throws InterruptedException {
        boolean status=false;
        String Otp="";
        UserDetails user=userDetailsService.loadUserByUsername(resetDetail.getUsername());
        if(user!=null){
            //send email with generated otp
            //generate OTP
             Otp=resetOtp.generateOtp();
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formatDateTime = now.format(format);
            System.out.println("After Formatting: " + formatDateTime);
            //Add this Otp with the corresponding user into the database
            //creating OTP OBJECT
        if(!userOtpService.isPresent(resetDetail.getUsername())) {
            UsernameOtp usernameOtp = new UsernameOtp(resetDetail.getUsername(), Otp, formatDateTime);
            //setting value into database
            userOtpService.setUsernameOtp(usernameOtp);
            //Sending Otp to Email
            //emailService.OtpSend(resetDetail.getUsername(),Otp);
            Thread.sleep(1000*60*2);
            userOtpService.deleteUsernameOtp(usernameOtp);
            status=true;

        }


        }



        return status;
    }

    public void delay(int mili,UsernameOtp usernameOtp) throws InterruptedException {
        Thread.sleep(mili);
        System.out.println("Thread WakeUp");

        userOtpService.deleteUsernameOtp(usernameOtp);

    }


    @PostMapping("/validateOtp")
    public boolean validateOtp(@RequestBody EmailOtp emailOtp){

//        String str = "1986-04-08 12:30";
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
        boolean flag=false;
        if(userOtpService.isPresent(emailOtp.username)){
            System.out.println("Validate OTP Method");
            //reset password
            return userOtpService.validate(emailOtp.Otp, emailOtp.username);
        }
        return flag;

    }

}
