package com.example.graphQl.service;

import com.example.graphQl.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    List<Product> findByCategory(String category);
    Product saveProduct(Product product);
    Product findByProductId(int id);
}
