package com.wespobazaar.wespo.dto;

import com.wespobazaar.wespo.entity.Category;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class CategoryDto {
    private long id;


    private @NotBlank String categoryName;

    private @NotBlank String description;


    private @NotBlank String imageUrl;


    private @NotBlank Long scategoryId;

    public CategoryDto(Category category) {
        this.setId(category.getId());
        this.setCategoryName(category.getCategoryName());
        this.setDescription(category.getDescription());
        this.setImageUrl(  category.getImageUrl());
        this.setScategoryId( category.getSuperCategory().getId());
    }

    public CategoryDto() {
    }

    public CategoryDto(long id, @NotBlank String categoryName, @NotBlank String description, @NotBlank String imageUrl, @NotBlank Long scategoryId) {
        this.id = id;
        this.categoryName = categoryName;
        this.description = description;
        this.imageUrl = imageUrl;
        this.scategoryId = scategoryId;
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

    public Long getScategoryId() {
        return scategoryId;
    }

    public void setScategoryId(Long scategoryId) {
        this.scategoryId = scategoryId;
    }
}
