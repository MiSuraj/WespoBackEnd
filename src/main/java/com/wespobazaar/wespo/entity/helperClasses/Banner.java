package com.wespobazaar.wespo.entity.helperClasses;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Banner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String  url1;
    private String  url2;
    private String url3;

    public Banner() {
    }

    public Banner(String url1, String url2, String url3) {
        this.url1 = url1;
        this.url2 = url2;
        this.url3 = url3;
    }

    public Banner(int id, String url1, String url2, String url3) {
        this.id = id;
        this.url1 = url1;
        this.url2 = url2;
        this.url3 = url3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl1() {
        return url1;
    }

    public void setUrl1(String url1) {
        this.url1 = url1;
    }

    public String getUrl2() {
        return url2;
    }

    public void setUrl2(String url2) {
        this.url2 = url2;
    }

    public String getUrl3() {
        return url3;
    }

    public void setUrl3(String url3) {
        this.url3 = url3;
    }
}
