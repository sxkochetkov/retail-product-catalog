package com.example.product_catalog.models;

// if we need persistence/JPA, should be @Entity
public class Product {
    private int id; // For uniqueness of a product using int for simplicity but in really we need something like UUID or @ID for JPA
    private String name;
    private ProductCategory category;
    private String description;
    private double price;
    private String imageUrl;

    public Product() {}

    public Product(int id, String name, ProductCategory category, String description, double price, String imageUrl) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
