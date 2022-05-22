package com.wespobazaar.wespo.entity.UserOtp;

import javax.persistence.*;

@Entity
public class UsernameOtp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="Username")
    private String username;

    @Column(name="Otp")
    private String otp;

    @Column(name="CreatedAt")
    private String createdAt;

    public UsernameOtp(long id, String username, String otp, String createdAt) {
        this.id = id;
        this.username = username;
        this.otp = otp;
        this.createdAt = createdAt;
    }

    public UsernameOtp(String username, String otp, String createdAt) {
        this.username = username;
        this.otp = otp;
        this.createdAt = createdAt;
    }

    public UsernameOtp() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
