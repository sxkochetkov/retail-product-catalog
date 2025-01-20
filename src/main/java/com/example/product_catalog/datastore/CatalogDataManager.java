package com.example.product_catalog.datastore;

import com.example.product_catalog.models.Product;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Component
public class CatalogDataManager {
    private final HashMap<String, Product> catalog = new HashMap<>();
    private long maxId; // not thread safe but for this assignment no multithreading is assumed

    public void addProduct(Product product) {
        maxId++;
        product.setId(maxId);
        catalog.put(product.getName(), product);

    }

    public void addProducts(List<Product> productList) {
        for(Product product : productList) {
            addProduct(product);
        }
    }
    
    public HashMap<String, Product> getCatalog() {
        return catalog;
    }

    public Optional<Product> getProductById(Long id) {
        return catalog
                .values().stream()
                .filter(product -> product.getId() == id)
                .findFirst();
    }

    public Optional<Product> getProductByName(String name) {
        return Optional.ofNullable(catalog.get(name));
    }
}
