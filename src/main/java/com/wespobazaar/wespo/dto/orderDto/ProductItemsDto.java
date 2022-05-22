package com.wespobazaar.wespo.dto.orderDto;

import javax.validation.constraints.NotNull;

public class ProductItemsDto {

    private Long id;


    private @NotNull String name;
    private @NotNull double price;
    private @NotNull String description;
    private  String imageUrl1;
    private  String imageUrl2;
    private  String imageUrl3;
    private  String prodUrl;
    private  int rating;

    //constructor and getter setter


    public ProductItemsDto() {
    }

    public ProductItemsDto(Long id,  @NotNull String name, @NotNull double price, @NotNull String description, @NotNull String imageUrl1, @NotNull String imageUrl2, @NotNull String imageUrl3, @NotNull String prodUrl, @NotNull int rating) {
        this.id = id;

        this.name = name;
        this.price = price;
        this.description = description;
        this.imageUrl1 = imageUrl1;
        this.imageUrl2 = imageUrl2;
        this.imageUrl3 = imageUrl3;
        this.prodUrl = prodUrl;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "ProductItemsDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", imageUrl1='" + imageUrl1 + '\'' +
                ", imageUrl2='" + imageUrl2 + '\'' +
                ", imageUrl3='" + imageUrl3 + '\'' +
                ", prodUrl='" + prodUrl + '\'' +
                ", rating=" + rating +
                '}';
    }
}
