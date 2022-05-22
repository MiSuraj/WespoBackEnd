package com.wespobazaar.wespo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name="category ")
public class Category {



          @Id
          @GeneratedValue(strategy = GenerationType.IDENTITY)
          private long id;

          @Column(name = "category_name")
           private @NotBlank String categoryName;

           private @NotBlank String description;


           @Column(name="imageCat_url")
           private @NotBlank String imageUrl;

//           @Column(name="scategoryid")
//           private @NotBlank Long scategoryId;



    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Set<Product> products;
//change//
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "supercategory_id", nullable = false)
    SuperCategory superCategory;


//change//
    public Category() {
    }

    public Category(long id, @NotBlank String categoryName, @NotBlank String description) {
        this.id = id;
        this.categoryName = categoryName;
        this.description = description;
    }

    public Category(long id, @NotBlank String categoryName, @NotBlank String description, @NotBlank String imageUrl) {
        this.id = id;
        this.categoryName = categoryName;
        this.description = description;
        this.imageUrl = imageUrl;

    }

    public Category(long id, @NotBlank String categoryName, @NotBlank String description, @NotBlank String imageUrl, SuperCategory superCategory) {
        this.id = id;
        this.categoryName = categoryName;
        this.description = description;
        this.imageUrl = imageUrl;
        this.superCategory = superCategory;
    }
//
//    public Category(long id, @NotBlank String categoryName, @NotBlank String description, @NotBlank String imageUrl, @NotBlank Long scategoryId, Set<Product> products, SuperCategory superCategory) {
//        this.id = id;
//        this.categoryName = categoryName;
//        this.description = description;
//        this.imageUrl = imageUrl;
//        this.scategoryId = scategoryId;
//        this.products = products;
//        this.superCategory = superCategory;
//    }
//
//    public Long getScategoryId() {
//        return scategoryId;
//    }
//
//    public void setScategoryId(Long scategoryId) {
//        this.scategoryId = scategoryId;
//    }

    public SuperCategory getSuperCategory() {
        return superCategory;
    }

    public void setSuperCategory(SuperCategory superCategory) {
        this.superCategory = superCategory;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", products=" + products +
                ", superCategory=" + superCategory +
                '}';
    }
}
