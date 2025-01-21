package com.example.product_catalog.utils;

import com.example.product_catalog.models.Product;
import com.example.product_catalog.models.ProductCategory;

import java.util.ArrayList;
import java.util.List;

public class DataUtil {

    public static List<Product> generateProductCatalogData() {

        return new ArrayList<>(List.of(
                new Product(1, "Skogsfraeken", new ProductCategory("Cushion"), "Skogsfraeken Pillow High", 20.00, "https://www.ikea.com/se/en/images/products/skogsfraeken-pillow-high__0789288_pe763917_s5.jpg?f=s"),
                new Product(2, "Roedarv", new ProductCategory("Cushion"), "Roedarv Cushion Multicolor", 30.00, "https://www.ikea.com/us/en/images/products/roedarv-cushion-multicolor__0600167_pe678583_s5.jpg"),
                new Product(3, "JORDKASTANJ", new ProductCategory("Cushion"), "JORDKASTANJ", 19.00, "https://www.ikea.com/se/en/images/products/jordkastanj-cushion-grey__1138424_pe879956_s5.jpg"),
                new Product(4, "JORDKASTAJN", new ProductCategory("Cushion"), "JORDKASTANJ with mistake", 19.00, "https://www.ikea.com/se/en/images/products/jordkastanj-cushion-grey__1138424_pe879956_s5.jpg"),
                new Product(5, "Roedar", new ProductCategory("Cushion"), "Roedarv with mistake", 30.00, "https://www.ikea.com/us/en/images/products/roedarv-cushion-multicolor__0600167_pe678583_s5.jpg"),
                new Product(6, "Roedrv", new ProductCategory("Cushion"), "Roedarv with mistake", 30.00, "https://www.ikea.com/us/en/images/products/roedarv-cushion-multicolor__0600167_pe678583_s5.jpg"),
                new Product(7, "Redarv", new ProductCategory("Cushion"), "Roedarv with mistake", 30.00, "https://www.ikea.com/us/en/images/products/roedarv-cushion-multicolor__0600167_pe678583_s5.jpg"),
                new Product(8, "Roedarva", new ProductCategory("Cushion"), "Roedarv with mistake", 30.00, "https://www.ikea.com/us/en/images/products/roedarv-cushion-multicolor__0600167_pe678583_s5.jpg"),
                new Product(9, "Roedarav", new ProductCategory("Cushion"), "Roedarv with mistake", 30.00, "https://www.ikea.com/us/en/images/products/roedarv-cushion-multicolor__0600167_pe678583_s5.jpg"),
                new Product(10, "Redarv", new ProductCategory("Cushion"), "Roedarv with mistake", 30.00, "https://www.ikea.com/us/en/images/products/roedarv-cushion-multicolor__0600167_pe678583_s5.jpg"),
                new Product(11, "Rodarv", new ProductCategory("Cushion"), "Roedarv with mistake", 30.00, "https://www.ikea.com/us/en/images/products/roedarv-cushion-multicolor__0600167_pe678583_s5.jpg"),
                new Product(12, "oedarv", new ProductCategory("Cushion"), "Roedarv with mistake", 30.00, "https://www.ikea.com/us/en/images/products/roedarv-cushion-multicolor__0600167_pe678583_s5.jpg")
        ));
    }
}
