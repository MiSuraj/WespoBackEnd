package com.wespobazaar.wespo.entity.helperClasses;


public class WishlistProd {
    private String username;
    private  long prodId;

    public WishlistProd() {
    }

    public WishlistProd(String username, long prodId) {
        this.username = username;
        this.prodId = prodId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getProdId() {
        return prodId;
    }

    public void setProdId(long prodId) {
        this.prodId = prodId;
    }
}
