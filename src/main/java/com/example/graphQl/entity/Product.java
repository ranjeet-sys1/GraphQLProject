package com.example.graphQl.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    private String productName;
    private Double price;
    private String category;
    private String brand;
    private String origin;

    public Product(String productName, Double price, String category, String brand, String origin) {
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.brand = brand;
        this.origin = origin;
    }
}
