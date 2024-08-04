package com.eofsentinel.simpleSpringBootWebApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    private int prodId;
    private String prodName;
    private double price;

    public Product() { }

    public Product(int prodId, String prodName, double price) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.price = price;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
