package com.wespobazaar.wespo.dto.orderDto;



import java.util.List;

public class OrderSummaryDto {

    private long Id;
    private String address;
    private String username;
    private double totalPrice;
    private List<ProductItemsDto> productsItemsDto;

    //constructor and getter setter


    public OrderSummaryDto() {
    }

    public OrderSummaryDto(long id, String address, String username, double totalPrice, List<ProductItemsDto> productsItemsDto) {
        Id = id;
        this.address = address;
        this.username = username;
        this.totalPrice = totalPrice;
        this.productsItemsDto = productsItemsDto;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<ProductItemsDto> getProductsItemsDto() {
        return productsItemsDto;
    }

    public void setProductsItemsDto(List<ProductItemsDto> productsItemsDto) {
        this.productsItemsDto = productsItemsDto;
    }

    @Override
    public String toString() {
        return "OrderSummaryDto{" +
                "Id=" + Id +
                ", address='" + address + '\'' +
                ", username='" + username + '\'' +
                ", totalPrice=" + totalPrice +
                ", productsItemsDto=" + productsItemsDto +
                '}';
    }
}



