package com.example.graphQl.controller;

import com.example.graphQl.DTO.ProductFilterInput;
import com.example.graphQl.DTO.ProductPagination;
import com.example.graphQl.entity.Product;
import com.example.graphQl.repository.ProductRepository;
import com.example.graphQl.service.ProductService;
import com.example.graphQl.specification.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
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
    @Autowired
    private ProductRepository repository;
    @QueryMapping
    public List<Product> getAll(){
        return productService.getAll();

    }
    @QueryMapping
    public List<Product> findByCategory(@Argument String category){
        return productService.findByCategory(category);
    }
    @MutationMapping
    public Product createNewProduct(@Argument String productName,
                                    @Argument Double price,
                                    @Argument String category,
                                    @Argument String brand,
                                    @Argument String origin){
        Product product=new Product();
        if(productName!=null)
            product.setProductName(productName);
        if(price!=null){
            product.setPrice(price);
        }
        if(category!=null)
            product.setCategory(category);
        if(brand!=null)
            product.setBrand(brand);
        if(origin!=null)
            product.setOrigin(origin);
        return productService.saveProduct(product);
    }
    @MutationMapping
    public Product updateProduct(@Argument int id,@Argument String brand){
        Product isExistProduct = productService.findByProductId(id);
        if(isExistProduct!=null){
            isExistProduct.setBrand(brand);
        }
        return productService.saveProduct(isExistProduct);

    }


    @QueryMapping
    public ProductPagination getProducts(
            @Argument int page,
            @Argument int size,
            @Argument ProductFilterInput filter) {

        Pageable pageable = PageRequest.of(page, size);

        Page<Product> userPage =
                repository.findAll(
                        ProductSpecification.filter(filter),
                        pageable
                );

        ProductPagination response = new ProductPagination();
        response.setContent(userPage.getContent());
        response.setTotalElements(userPage.getTotalElements());
        response.setTotalPages(userPage.getTotalPages());
        response.setCurrentPage(userPage.getNumber());

        return response;
    }


}
