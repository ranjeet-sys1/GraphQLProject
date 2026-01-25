package com.example.graphQl.DTO;

import com.example.graphQl.entity.Product;
import lombok.Data;

import java.util.List;
@Data
public class ProductPagination {
    private List<Product> content;
    private long totalElements;
    private int totalPages;
    private int currentPage;
}
