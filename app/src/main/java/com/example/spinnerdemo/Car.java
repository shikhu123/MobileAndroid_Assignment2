package com.example.spinnerdemo;

import java.lang.reflect.Type;

class Car {
    String name;
    String price;
    int img;
    String Color;
    String Type;

    public Car(String name, String price, int img, String Color, String type) {
        this.name = name;
        this.price = price;
        this.img = img;
        this.Color = Color;
        Type = type;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public int getImg() {
        return img;
    }

    public String getColor(){
        return Color;
    }

    public String getType() {
        return Type;
    }
}
