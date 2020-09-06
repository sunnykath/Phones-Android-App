package com.example.phones_app.models;

import java.io.Serializable;

abstract public class Smartphone implements Serializable {
    protected String model, OS;//, colours;//add more stuff here if needed
    protected double price, rating;//add more stuff here if needed
    protected int  memoryCapacity;
    protected String[] images;

    public Smartphone(String model, String OS, double price,
                      double rating, int memoryCapacity, String[]images){
        this.model = model;
        this.OS = OS;
        this.price = price;
        this.rating = rating;
        this.memoryCapacity = memoryCapacity;
        this.images = images;
    }

    public String getModel(){return model; }
    public String getOS(){return OS; }
    public double getPrice(){return price; }
    public double getRating(){return rating; }
    public int getMemoryCapacity(){return memoryCapacity; }
    public String[] getImages(){return images; }
}


