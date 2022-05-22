package com.wespobazaar.wespo.entity.helperClasses;

import com.wespobazaar.wespo.entity.Cart;
import com.wespobazaar.wespo.entity.Product;

public class CartItemsDto {
    private Long id;
    private Long quantity;
    private Product product;//IT may be ProductDTO




    public CartItemsDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "CartItemsDto{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", product=" + product +
                '}';
    }

    public CartItemsDto(Cart cart){
        this.id=cart.getId();
        this.quantity=cart.getQuantity();
        this.setProduct(cart.getProduct());
    }

}
