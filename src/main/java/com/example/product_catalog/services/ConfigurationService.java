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
                new Product(1, "Skogsfraeken Pillow High", new ProductCategory("Cushion"), "Good pillow for your bedroom", 20.00, "https://www.ikea.com/se/en/images/products/skogsfraeken-pillow-high__0789288_pe763917_s5.jpg?f=s"),
                new Product(2, "Roedarv Cushion Multicolor", new ProductCategory("Cushion"), "Good pillow for your bedroom", 30.00, "https://www.ikea.com/us/en/images/products/roedarv-cushion-multicolor__0600167_pe678583_s5.jpg"),
                new Product(3, "JORDKASTANJ", new ProductCategory("Cushion"), "Good pillow for your bedroom", 19.00, "https://www.ikea.com/se/en/images/products/jordkastanj-cushion-grey__1138424_pe879956_s5.jpg")
        ));
        catalogDataManager.addProducts(products);

        return "Number of products added: " + products.size();
    }
}
