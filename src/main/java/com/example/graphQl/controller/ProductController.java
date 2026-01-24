package com.example.graphQl.controller;

import com.example.graphQl.entity.Product;
import com.example.graphQl.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/graphql")
public class ProductController {
    @Autowired
    private ProductService productService;
    @QueryMapping
    public List<Product> getAll(){
        return productService.getAll();

    }
    @QueryMapping
    public List<Product> findByCategory(@Argument String category){
        return productService.findByCategory(category);
    }
}
