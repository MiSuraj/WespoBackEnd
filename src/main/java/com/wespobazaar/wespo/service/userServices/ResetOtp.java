package com.wespobazaar.wespo.service.userServices;

import org.springframework.stereotype.Service;

import javax.persistence.Access;

@Service
public class ResetOtp {


    public String generateOtp(){
        int numbers[]={4,2,5,1,3,0,7,8,9,6};
        String Otp="";
        for(int i=0;i<4;i++){
            Otp=Otp+(int)(Math.random()*10);
        }
        return Otp;

    }

}
