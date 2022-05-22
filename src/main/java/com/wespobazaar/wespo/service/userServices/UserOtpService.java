package com.wespobazaar.wespo.service.userServices;


import com.wespobazaar.wespo.Repository.userOtpRepo.UsernameOtpRepo;

import com.wespobazaar.wespo.entity.UserOtp.UsernameOtp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserOtpService {


    @Autowired
    private UsernameOtpRepo usernameOtpRepo;



    public void setUsernameOtp(UsernameOtp usernameOtp){
        System.out.println("Set Username Otp");
        usernameOtpRepo.save(usernameOtp);


    }

//    public void setUserOtp(UserOtp userOtp, OtpUser otpUser){
//        System.out.println("Set User Otp");
//        otpUserRepo.save(otpUser);
//
//        userOtpRepo.save(userOtp);
//
//    }

    public boolean isPresent(String username){
        boolean b=false;
        if(usernameOtpRepo.findUsername(username)!=null){
            return true;
        }
        return false;
    }
    public void deleteUsernameOtp(UsernameOtp usernameOtp){
        usernameOtpRepo.delete(usernameOtp);

    }
    public boolean validate(String Otp,String username){
        boolean flag=false;
        System.out.println("validate Method");
        UsernameOtp usernameOtp=usernameOtpRepo.findUsername(username);
        System.out.println("Username Get OTP "+usernameOtp.getOtp());
        System.out.println("MY OTP "+Otp);;
        if(usernameOtp.getOtp().equals(Otp)) {
            System.out.println("validate Otp Service ");
            return true;
        }
        return  flag;
    }
}
