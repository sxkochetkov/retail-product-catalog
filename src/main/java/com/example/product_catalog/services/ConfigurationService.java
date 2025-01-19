package com.example.product_catalog.services;

import com.example.product_catalog.datastore.CatalogDataManager;
import com.example.product_catalog.models.Product;
import com.example.product_catalog.models.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConfigurationService {
    @Autowired
    CatalogDataManager catalogDataManager;

    public String prepopulate() {
        List<Product> products = new ArrayList<>(List.of(
                new Product(1, "Skogsfraeken Pillow High", new ProductCategory("Bedroom"), "Good pillow for your bedroom", 0.00, "https://www.ikea.com/se/en/images/products/skogsfraeken-pillow-high__0789288_pe763917_s5.jpg?f=s"),
                new Product(2, "Roedarv Cushion Multicolor", new ProductCategory("Bedroom"), "Good pillow for your bedroom", 0.00, "https://www.ikea.com/us/en/images/products/roedarv-cushion-multicolor__0600167_pe678583_s5.jpg"),
                new Product(3, "Roedarv Cushion Multicolor 2", new ProductCategory("Bedroom"), "Good pillow for your bedroom", 0.00, "https://www.ikea.com/us/en/images/products/roedarv-cushion-multicolor__0600167_pe678583_s5.jpg")
        ));
        catalogDataManager.addProducts(products);

        return "Number of products added: " + products.size();
    }
}
