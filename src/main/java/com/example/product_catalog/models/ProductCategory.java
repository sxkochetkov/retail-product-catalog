package com.example.product_catalog.models;

public class ProductCategory {
    private String productCategory; // This could be enum or entry from database. For simplicity using String

    public ProductCategory() {}

    public ProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductCategory() {
        return productCategory;
    }
}
