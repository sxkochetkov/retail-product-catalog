package com.example.product_catalog.datastore;

import com.example.product_catalog.models.Product;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class CatalogDataManager {
    private final HashMap<String, Product> catalog = new HashMap<>();

    public void addProduct(Product product) {
        catalog.put(product.getName(), product);
    }

    public void addProducts(List<Product> productList) {
        for(Product product : productList) {
            catalog.put(product.getName(), product);
        }
    }


    public HashMap<String, Product> getCatalog() {
        return catalog;
    }
}
