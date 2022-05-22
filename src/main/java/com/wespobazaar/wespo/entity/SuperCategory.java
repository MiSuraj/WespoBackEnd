package com.wespobazaar.wespo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name="Super_Category")
public class SuperCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "category_name")
    private @NotBlank String scatname;

    private @NotBlank String sdescription;


    @Column(name="imageCat_url")
    private @NotBlank String imageUrl;

    @OneToMany(mappedBy = "superCategory",fetch = FetchType.EAGER)
    @JsonIgnore
    Set<Category> category;

    @OneToMany
    Set<Product> products;

    public SuperCategory() {

    }

    public SuperCategory(long id, @NotBlank String scatname, @NotBlank String sdescription, @NotBlank String imageUrl, Set<Category> category, Set<Product> products) {
        this.id = id;
        this.scatname = scatname;
        this.sdescription = sdescription;
        this.imageUrl = imageUrl;
        this.category = category;
        this.products = products;
    }

    public SuperCategory(long id, @NotBlank String scatname, @NotBlank String sdescription, @NotBlank String imageUrl, Set<Category> category) {
        this.id = id;
        this.scatname = scatname;
        this.sdescription = sdescription;
        this.imageUrl = imageUrl;
        this.category = category;
    }

    public SuperCategory(long id, @NotBlank String scatname, @NotBlank String sdescription, @NotBlank String imageUrl) {
        this.id = id;
        this.scatname = scatname;
        this.sdescription = sdescription;
        this.imageUrl = imageUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getScatname() {
        return scatname;
    }

    public void setScatname(String scatname) {
        this.scatname = scatname;
    }

    public String getSdescription() {
        return sdescription;
    }

    public void setSdescription(String sdescription) {
        this.sdescription = sdescription;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Set<Category> getCategory() {
        return category;
    }

    public void setCategory(Set<Category> category) {
        this.category = category;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "SuperCategory{" +
                "id=" + id +
                ", scatname='" + scatname + '\'' +
                ", sdescription='" + sdescription + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", category=" + category +
                ", products=" + products +
                '}';
    }
}
