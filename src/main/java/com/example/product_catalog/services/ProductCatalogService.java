package com.example.product_catalog.services;

import com.example.product_catalog.models.Product;
import com.example.product_catalog.models.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCatalogService {
    public List<Product> getProductCatalogPage(Integer page, Integer pageSize, String sortedBy) {
        return new ArrayList<>(List.of(new Product(1, "Pillow", new ProductCategory("Bedroom"), "Good pillow for your bedroom", 0.00, "https://www.ikea.com/se/en/images/products/skogsfraeken-pillow-high__0789288_pe763917_s5.jpg?f=s")));
    }

    public Product getProduct(Integer id) {
        return new Product(1, "Pillow", new ProductCategory("Bedroom"), "Good pillow for your bedroom", 0.00, "https://www.ikea.com/se/en/images/products/skogsfraeken-pillow-high__0789288_pe763917_s5.jpg?f=s");
    }

    public String addProduct(Product product) {
        return "Product has been added successfully";
    }
}
