package com.example.product_catalog.controllers;

import com.example.product_catalog.models.Product;
import com.example.product_catalog.services.ProductCatalogService;
import com.example.product_catalog.utils.ProductCatalogUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductCatalogController {
    private final Logger logger = LoggerFactory.getLogger(ProductCatalogController.class);
    @Autowired
    private ProductCatalogService productCatalogService;

    // sample of request: `/products?page=2&pageSize=18`
    @GetMapping("")
    public List<Product> getAllProducts(@RequestParam(value = "page", required = false) Integer page,
                                 @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        logger.info("ProductCatalogController:getAllProducts:enter");
        if (page == null)
            page = 0;

        if (pageSize == null)
            pageSize = 0; // which means bring everything

        return productCatalogService.getProductCatalogPage(page, pageSize);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        logger.info("ProductCatalogController:getProductById:enter");
        return productCatalogService
                .getProductById(id)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public String addNewProduct(@RequestBody Product product) {
        logger.info("ProductCatalogController:addNewProduct:enter");
        logger.info("{}:{}:{}:{}:{}", product.getName(), product.getDescription(), product.getCategory(), product.getImageUrl(), product.getPrice());
        return productCatalogService.addProduct(product);
    }
}
