package com.example.phones_app.models;


import java.io.Serializable;

public class Microsoft extends Smartphone implements Serializable {
    public Microsoft(String model, double price, double rating, int memoryCapacity, String[] images) {
        super(model, "Windows", price, rating, memoryCapacity, images);
    }
}
