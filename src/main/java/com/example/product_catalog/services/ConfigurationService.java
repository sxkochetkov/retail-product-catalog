package com.example.product_catalog.services;

import com.example.product_catalog.datastore.CatalogDataManager;
import com.example.product_catalog.models.Product;
import com.example.product_catalog.utils.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigurationService {
    @Autowired
    CatalogDataManager catalogDataManager;

    public String prepopulate() {

        List<Product> products = DataUtil.generateProductCatalogData();
        catalogDataManager.addProducts(products);

        return "Number of products added: " + products.size();
    }
}
