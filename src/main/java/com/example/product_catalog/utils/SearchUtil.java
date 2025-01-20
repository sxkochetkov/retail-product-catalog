package com.example.product_catalog.utils;

import com.example.product_catalog.models.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SearchUtil {
    public static Stream<String> getMutationsStream(String term) {
        String abc = "abcdefghijklmnopqrstuvwxyz";

        Stream<String> deletes = IntStream.range(0, term.length())
                .mapToObj((i) -> term.substring(0, i) + term.substring(i + 1));

        Stream<String> replaces = IntStream.range(0, term.length()).boxed().flatMap((i) -> abc.chars()
                .mapToObj((c) -> term.substring(0, i) + (char) c + term.substring(i + 1)));

        Stream<String> inserts = IntStream.range(0, term.length() + 1).boxed().flatMap((i) -> abc.chars()
                .mapToObj((c) -> term.substring(0, i) + (char) c + term.substring(i)));

        Stream<String> transposes = IntStream.range(0, term.length() - 1)
                .mapToObj((i) -> term.substring(0, i) + term.charAt(i + 1) + term.charAt(i) + term.substring(i + 2));

        return Stream.of(deletes, replaces, inserts, transposes).flatMap((x) -> x);
    }

    public static Map<String, Product> search(String term, Map<String, Product> products) {
        Map<String, Product> searchResults = new HashMap<>();
        getMutationsStream(term).forEach(str -> {
            if(products.containsKey(str.toLowerCase()))
                searchResults.put(str, products.get(str));
        });

        return searchResults;
    }
}
