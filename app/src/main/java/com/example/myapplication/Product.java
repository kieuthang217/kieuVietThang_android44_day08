package com.example.myapplication;

public class Product {
    public int img;
    public  String name;
    public float rating;
    public  int price;

    public Product() {
    }

    public Product(int img, String name, float rating, int price) {
        this.img = img;
        this.name = name;
        this.rating = rating;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}



