package com.example.product_catalog.services;

import com.example.product_catalog.datastore.CatalogDataManager;
import com.example.product_catalog.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSearchService {
    @Autowired
    CatalogDataManager catalogDataManager;

    public List<Product> searchProductCatalogPage(String term) {
        return catalogDataManager.getSearchResults(term);
    }
}
