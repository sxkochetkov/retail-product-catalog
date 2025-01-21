package com.example.product_catalog;

import com.example.product_catalog.models.Product;
import com.example.product_catalog.models.ProductCategory;
import com.example.product_catalog.utils.DataUtil;
import com.example.product_catalog.utils.SearchUtil;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class RetailProductCatalogApplicationTests {

	@Test
	void testSearchAlgorithmWithSimpleData() {
		Map<String, Integer> dictionary = new HashMap<>();

		Map<String, Product> products = new HashMap<>();
		products.put("pillow", new Product(1, "Pillow", new ProductCategory("Cushion"), "Good pillow for your bedroom", 20.00, "https://www.ikea.com/se/en/images/products/skogsfraeken-pillow-high__0789288_pe763917_s5.jpg?f=s"));
		products.put("pilolw", new Product(2, "Pilolw", new ProductCategory("Cushion"), "Good pillow for your bedroom", 30.00, "https://www.ikea.com/us/en/images/products/roedarv-cushion-multicolor__0600167_pe678583_s5.jpg"));
		products.put("cushion", new Product(3, "Cushion", new ProductCategory("Cushion"), "Good pillow for your bedroom", 19.00, "https://www.ikea.com/se/en/images/products/jordkastanj-cushion-grey__1138424_pe879956_s5.jpg"));
		products.put("cushoin", new Product(4, "Cushion", new ProductCategory("Cushion"), "Good pillow for your bedroom", 19.00, "https://www.ikea.com/se/en/images/products/jordkastanj-cushion-grey__1138424_pe879956_s5.jpg"));

		String searchTerm1 = "pillow";
		Map<String, Product> found = SearchUtil.search(searchTerm1, products);
		Assert.isTrue(found.size() == 2, "should be true");

		String searchTerm2 = "pilow";
		found = SearchUtil.search(searchTerm2, products);
		Assert.isTrue(found.size() == 2, "should be true");

		String searchTerm3 = "ilpow";
		found = SearchUtil.search(searchTerm3, products);
		Assert.isTrue(found.isEmpty(), "should be empty");

		String searchTerm4 = "cushion";
		found = SearchUtil.search(searchTerm4, products);
		Assert.isTrue(found.size() == 2, "should be true");
	}

	@Test
	void testSearchAlgorithmWithMoreData() {
		Map<String, Product> catalog = new HashMap<>();
		List<Product> products = DataUtil.generateProductCatalogData();

		for(Product product : products) {
			catalog.put(product.getName().toLowerCase(), product);
		}

		String searchTerm = "roedarv";

		Map<String, Product> found  = SearchUtil.search(searchTerm, catalog);
		Assert.isTrue(found.size() == 8, "should be true");
	}
}