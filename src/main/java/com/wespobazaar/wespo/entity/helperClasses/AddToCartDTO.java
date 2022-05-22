package com.wespobazaar.wespo.entity.helperClasses;


import javax.validation.constraints.NotNull;

public class AddToCartDTO {
    private Long id;//We can have id as nullable
    private @NotNull Long productId;//but product id and quantity not nullable
    private  @NotNull  Integer quantity;//

    public AddToCartDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
