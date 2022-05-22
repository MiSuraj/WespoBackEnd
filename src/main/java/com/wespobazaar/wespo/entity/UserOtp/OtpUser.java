//package com.wespobazaar.wespo.entity.UserOtp;
//
//import javax.persistence.*;
//import java.sql.Date;
//import java.time.LocalDateTime;
//
//@Entity
//public class OtpUser {
//
//    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
//    private long idOtpUser;
//
//    @Column(name="Otp")
//    private String Otp;
//
//    @OneToOne(mappedBy = "otpUser")
//    private UserOtp userOtp;
//
//    @Column(name="ExpireAt")
//    private String dateTime;
//
//     public OtpUser(){}
//
//    public OtpUser(long idOtpUser, String otp, UserOtp userOtp, String dateTime) {
//        this.idOtpUser = idOtpUser;
//        Otp = otp;
//        this.userOtp = userOtp;
//        this.dateTime = dateTime;
//    }
//
//    public String getDateTime() {
//        return dateTime;
//    }
//
//    public void setDateTime(String dateTime) {
//        this.dateTime = dateTime;
//    }
//
//    public long getIdOtpUser() {
//        return idOtpUser;
//    }
//
//    public void setIdOtpUser(long idOtpUser) {
//        this.idOtpUser = idOtpUser;
//    }
//
//    public String getOtp() {
//        return Otp;
//    }
//
//    public void setOtp(String otp) {
//        Otp = otp;
//    }
//
//    public long getId() {
//        return idOtpUser;
//    }
//
//    public void setId(long idOtpUser) {
//        this.idOtpUser = idOtpUser;
//    }
//
//    public UserOtp getUserOtp() {
//        return userOtp;
//    }
//
//    public void setUserOtp(UserOtp userOtp) {
//        this.userOtp = userOtp;
//    }
//}
