package com.wespobazaar.wespo.entity.helperClasses;

import java.util.List;

public class CartDto {
    private List<CartItemsDto> cartItems;
    private double totalCost;

    public CartDto() {
    }

    public List<CartItemsDto> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemsDto> cartItems) {
        this.cartItems = cartItems;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }


}
