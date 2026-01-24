package com.example.graphQl.service.impl;

import com.example.graphQl.entity.Product;
import com.example.graphQl.repository.ProductRepository;
import com.example.graphQl.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;
    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Product> findByCategory(String category) {
        return repository.findByCategory(category);
    }
}
