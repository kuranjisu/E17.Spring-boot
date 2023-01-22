package com.example.E17.Spring.boot.entity;

import jakarta.persistence.Table;
@jakarta.persistence.Entity
@Table(name = "product_table")
public class Product {
    @jakarta.persistence.GeneratedValue

    @jakarta.persistence.Id
    private Integer productId;
    private String productName;
    private float price;

    private int quantity;

    private String imageUrl;

    private String userName ;
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return Long.parseLong(String.valueOf(productId));
    }


    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        userName = username;
    }

}

