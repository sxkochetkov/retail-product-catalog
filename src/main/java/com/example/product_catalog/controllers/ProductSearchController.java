package com.example.product_catalog.controllers;

import com.example.product_catalog.models.Product;
import com.example.product_catalog.services.ProductSearchService;
import com.example.product_catalog.utils.ProductCatalogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class ProductSearchController {
    private final Logger logger = LoggerFactory.getLogger(ProductSearchController.class);
    @Autowired
    private ProductSearchService productSearchService;

    @GetMapping("")
    public List<Product> searchProducts(@RequestParam(value = "term", required = false) String term) {
        logger.info("ProductSearchController:searchProducts:enter");

        if(ProductCatalogUtil.isNullOrEmpty(term))
            term = "*";

        logger.info("ProductSearchController:searchProducts:term:{}", term);
        List<Product> searchResults =  productSearchService.searchProductCatalogPage(term.toLowerCase());
        logger.info("ProductSearchController:searchProducts:found:{}", searchResults.size());

        return searchResults;
    }
}
