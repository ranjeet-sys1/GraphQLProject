package com.example.graphQl.repository;

import com.example.graphQl.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findByCategory(String category);
}
