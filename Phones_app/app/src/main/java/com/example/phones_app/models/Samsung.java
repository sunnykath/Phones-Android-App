package com.example.phones_app.models;

import java.io.Serializable;

public class Samsung extends Smartphone implements Serializable {
    public Samsung(String model, double price, double rating, int memoryCapacity, String[] images) {
        super(model, "Android", price, rating, memoryCapacity, images);
    }
}
