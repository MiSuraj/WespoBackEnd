package com.wespobazaar.wespo.dto;

import com.wespobazaar.wespo.entity.Product;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class ProductDto {


   //for create it can be optional
    //for update we need Id
     private Long Id;

    private @NotNull String name;
    private @NotNull double price;
    private @NotNull String description;
    private @NotNull String imageUrl1;
    private @NotNull String imageUrl2;
    private @NotNull String imageUrl3;
    private @NotNull String prodUrl;
    private @NotNull int rating;

    private @NotNull Long categoryId;
    private @NotNull Long scategoryId;



    public ProductDto(Product product){
        this.setId(product.getId());
        this.setName(product.getName());
        this.setPrice(product.getPrice());
        this.setDescription(product.getDescription());
        this.setImageUrl1(product.getImageUrl1());
        this.setImageUrl2(product.getImageUrl2());
        this.setImageUrl3(product.getImageUrl3());
        this.setProdUrl(product.getProdUrl());
        this.setRating(product.getRating());
        this.setCategoryId(product.getCategory().getId());
        this.setScategoryId(product.getSuperCategory().getId());



    }


    public ProductDto(@NotNull String name, @NotNull double price, @NotNull String description, @NotNull String imageUrl1, @NotNull String imageUrl2, @NotNull String imageUrl3, @NotNull String prodUrl, @NotNull int rating, @NotNull Long categoryId) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageUrl1 = imageUrl1;
        this.imageUrl2 = imageUrl2;
        this.imageUrl3 = imageUrl3;
        this.prodUrl = prodUrl;
        this.rating = rating;
        this.categoryId = categoryId;


    }

    public ProductDto(Long id, @NotNull String name, @NotNull double price, @NotNull String description, @NotNull String imageUrl1, @NotNull String imageUrl2, @NotNull String imageUrl3, @NotNull String prodUrl, @NotNull int rating, @NotNull Long categoryId, @NotNull Long scategoryId) {
        Id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageUrl1 = imageUrl1;
        this.imageUrl2 = imageUrl2;
        this.imageUrl3 = imageUrl3;
        this.prodUrl = prodUrl;
        this.rating = rating;
        this.categoryId = categoryId;
        this.scategoryId = scategoryId;
    }

    public ProductDto() {
    }

    public Long getScategoryId() {
        return scategoryId;
    }

    public void setScategoryId(Long scategoryId) {
        this.scategoryId = scategoryId;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl1() {
        return imageUrl1;
    }

    public void setImageUrl1(String imageUrl1) {
        this.imageUrl1 = imageUrl1;
    }

    public String getImageUrl2() {
        return imageUrl2;
    }

    public void setImageUrl2(String imageUrl2) {
        this.imageUrl2 = imageUrl2;
    }

    public String getImageUrl3() {
        return imageUrl3;
    }

    public void setImageUrl3(String imageUrl3) {
        this.imageUrl3 = imageUrl3;
    }

    public String getProdUrl() {
        return prodUrl;
    }

    public void setProdUrl(String prodUrl) {
        this.prodUrl = prodUrl;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
