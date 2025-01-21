package com.example.product_catalog.models;

import java.util.List;

public class PaginationResultsTuple3<T> {
    public List<T> items;
    public int totalPages;
    public int totalItems;

    public PaginationResultsTuple3(List<T> items, int totalPages, int totalItems) {
        this.items = items;
        this.totalPages = totalPages;
        this.totalItems = totalItems;
    }
}
