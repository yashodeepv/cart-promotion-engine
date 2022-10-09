package com.yasho.domain;

public class Product {

    private String productName;
    private int cost;

    public Product(String a, int i) {
        this.productName = a;
        this.cost = i;
    }



    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
