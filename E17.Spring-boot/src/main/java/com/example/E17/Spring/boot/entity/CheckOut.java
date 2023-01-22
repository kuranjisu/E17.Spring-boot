package com.example.E17.Spring.boot.entity;

import jakarta.persistence.Table;

@jakarta.persistence.Entity
@Table(name = "check_out")
public class CheckOut {
    @jakarta.persistence.GeneratedValue

    @jakarta.persistence.Id
    private Integer checkOutId;
    private Integer userId;
    private Integer productId;

    private float price;
    private String productName;
    private int productQuantity;
    private float productTotal;


    private String userName ;

    public Integer getCheckOutId() {
        return checkOutId;
    }

    public void setCheckOutId(Integer checkOutId) {
        this.checkOutId = checkOutId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public float getProductTotal() {
        return productTotal;
    }

    public void setProductTotal(float productTotal) {
        this.productTotal = productTotal;
    }

    public  float getPrice() {
        return price;
    }

    public void setPrice( float price) {
        this.price = price;
    }


    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        userName = username;
    }
}