package com.example.product_catalog.controllers;

import com.example.product_catalog.models.Product;
import com.example.product_catalog.services.ProductSearchService;
import com.example.product_catalog.utils.ProductCatalogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class ProductSearchController {
    @Autowired
    private ProductSearchService productSearchService;

    @GetMapping("")
    List<Product> searchProducts(@RequestParam(value = "term", required = false) String term,
                                    @RequestParam(value = "page", required = false) Integer page,
                                    @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                    @RequestParam(value = "sortedBy", required = false) String sortedBy) {
        if(ProductCatalogUtil.isNullOrEmpty(sortedBy))
            term = "*";

        if(page == null)
            page = 0;

        if(pageSize == null)
            pageSize = 0; // which means bring everything

        if(ProductCatalogUtil.isNullOrEmpty(sortedBy))
            sortedBy = "name"; // keeping simple here, but normally we need to use or enum/schema column or Sort/Order from org.springframework.data.domain package

        return productSearchService.searchProductCatalogPage(term, page, pageSize, sortedBy);
    }
}
