package com.example.phones_app.models;


import java.io.Serializable;

public class Apple extends Smartphone implements Serializable {
    public Apple(String model, double price, double rating, int memoryCapacity, String[] images) {
        super(model, "iOS", price, rating, memoryCapacity, images);
    }
}
