//package com.wespobazaar.wespo.entity.UserOtp;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name="UserOtp")
//public class UserOtp {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long idUserOtp;
//
//    @Column(name="Username")
//    private String username;
//
//    @OneToOne
//    private OtpUser otpUser;
//
//    public UserOtp() {
//    }
//
//    public UserOtp(long idUserOtp, String username, OtpUser otpUser) {
//        this.idUserOtp = idUserOtp;
//        this.username = username;
//        this.otpUser = otpUser;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public long getIdUserOtp() {
//        return idUserOtp;
//    }
//
//    public void setIdUserOtp(long idUserOtp) {
//        this.idUserOtp = idUserOtp;
//    }
//
//    public OtpUser getOtpUser() {
//        return otpUser;
//    }
//
//    public void setOtpUser(OtpUser otpUser) {
//        this.otpUser = otpUser;
//    }
//}
