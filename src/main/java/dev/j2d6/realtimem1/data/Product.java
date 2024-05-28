package dev.j2d6.realtimem1.data;

import java.security.PrivateKey;

public class Product {
    private String name;
    private String type;
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Product(int price, String name, String type) {
        this.price = price;
        this.name = name;
        this.type = type;
    }

    public Product() {
        this.price = 0;
        this.name = "";
        this.type = "";
    }
}
