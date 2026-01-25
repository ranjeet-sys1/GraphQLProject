package com.example.graphQl.DTO;

import lombok.Data;

@Data
public class ProductFilterInput {
    private String productName;
    private Double price;
    private String category;
    private String brand;
    private String origin;

}
