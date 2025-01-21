package com.example.product_catalog.services;

import com.example.product_catalog.datastore.CatalogDataManager;
import com.example.product_catalog.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductCatalogService {
    @Autowired
    CatalogDataManager catalogDataManager;

    public List<Product> getProductCatalogPage(int page, int pageSize) {
        // TODO - this can be improved to retrieve only relevant data based on page, e.g. filtering on database side
        List<Product> fullCatalog = new ArrayList<>(catalogDataManager.getCatalog().values());

        // TODO - was not tested for edge cases
        int startPage = page * pageSize;
        int endPage = startPage + pageSize;

        return fullCatalog.subList(startPage, Math.min(endPage, fullCatalog.size()));
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
