package com.example.product_catalog.services;

import com.example.product_catalog.models.Product;
import com.example.product_catalog.models.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCatalogService {
    public List<Product> getProductCatalogPage(Integer page, Integer pageSize, String sortedBy) {
        return new ArrayList<>(List.of(new Product(1, "test_product", new ProductCategory("test"), "test description", 0.00, "img://test")));
    }

    public Product getProduct(Integer id) {
        return new Product(1, "test_product", new ProductCategory("test"), "test description", 0.00, "img://test");
    }

    public String addProduct(Product product) {
        return "Product has been added successfully";
    }
}
