package com.example.product_catalog.services;

import com.example.product_catalog.datastore.CatalogDataManager;
import com.example.product_catalog.models.Product;
import com.example.product_catalog.models.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductCatalogService {
    @Autowired
    CatalogDataManager catalogDataManager;

    public List<Product> getProductCatalogPage(Integer page, Integer pageSize, String sortedBy) {
        return new ArrayList<>(catalogDataManager.getCatalog().values());
    }

    public Optional<Product> getProductById(Long id) {
        return catalogDataManager.getProductById(id);
    }

    public Optional<Product> getProductByName(String name) {
        return catalogDataManager.getProductByName(name);
    }

    public String addProduct(Product product) {
        catalogDataManager.addProduct(product);
        return "Product has been added successfully";
    }
}
