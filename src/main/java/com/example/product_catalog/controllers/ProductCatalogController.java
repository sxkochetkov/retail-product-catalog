package com.example.product_catalog.controllers;

import com.example.product_catalog.models.Product;
import com.example.product_catalog.services.ProductCatalogService;
import com.example.product_catalog.utils.ProductCatalogUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductCatalogController {
    @Autowired
    private ProductCatalogService productCatalogService;

    // sample of request: `/products?page=2&pageSize=18`
    @GetMapping("")
    List<Product> getAllProducts(@RequestParam(value = "page", required = false) Integer page,
                      @RequestParam(value = "pageSize", required = false) Integer pageSize,
                      @RequestParam(value = "sortedBy", required = false) String sortedBy) {
        if(page == null)
            page = 0;

        if(pageSize == null)
            pageSize = 0; // which means bring everything

        if(ProductCatalogUtil.isNullOrEmpty(sortedBy))
            sortedBy = "name"; // keeping simple here, but normally we need to use or enum/schema column or Sort/Order from org.springframework.data.domain package

        return productCatalogService.getProductCatalogPage(page, pageSize, sortedBy);
    }

    @GetMapping("/{id}")
    Product getProductById(@PathVariable Integer id) {
        return productCatalogService.getProduct(id);
    }

    @PostMapping()
    String addNewProduct() {
        return productCatalogService.addProduct(new Product());
    }
}
