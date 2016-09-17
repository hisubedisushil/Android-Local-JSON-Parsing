package com.example.sushil.jsonparsing;

import java.io.Serializable;

/**
 * Created by Sushil on 9/17/2016.
 */
public class Brands implements Serializable {
    String position,brand,name,description;

    public Brands(String position, String brand, String name, String description) {
        this.position = position;
        this.brand = brand;
        this.name = name;
        this.description = description;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
