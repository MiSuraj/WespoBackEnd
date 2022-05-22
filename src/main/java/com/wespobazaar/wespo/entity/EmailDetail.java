package com.wespobazaar.wespo.entity;

public class EmailDetail {
    private String toEmail;
    private String toBody;
    private String Subject;

    public EmailDetail() {
    }

    public EmailDetail(String toEmail, String toBody, String subject) {
        this.toEmail = toEmail;
        this.toBody = toBody;
        Subject = subject;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getToBody() {
        return toBody;
    }

    public void setToBody(String toBody) {
        this.toBody = toBody;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }
}
