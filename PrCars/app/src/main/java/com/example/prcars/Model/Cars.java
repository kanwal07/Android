package com.example.prcars.Model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Cars implements Serializable {
    private String brand;
    private String id;
    private String model;
    private Double price;
    private Integer year;

    public Cars() {

    }

    @NonNull
    @Override
    public String toString() {
        return model;
    }

    public Cars(String brand, String id, String model, Double price, Integer year) {
        this.brand = brand;
        this.id = id;
        this.model = model;
        this.price = price;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
