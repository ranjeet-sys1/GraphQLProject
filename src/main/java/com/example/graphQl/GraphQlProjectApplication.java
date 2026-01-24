package com.example.graphQl;

import com.example.graphQl.entity.Product;
import com.example.graphQl.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class GraphQlProjectApplication {
	@Autowired
	private ProductRepository repository;
	/*@PostConstruct
	public void saveProduct(){
		repository.saveAll(List.of(new Product("TV",55000.00,"ELECTRONICS","LG","CHINA"),
				new Product("Sofa",50000.00,"furniture","Nilkamal","India"),
				new Product("Bike",115000.00,"AUTOMOBILES","HONDA","INDIA"),
				new Product("AC",35000.00,"ELECTRONICS","CARRIER","CHINA"),
				new Product("INDUCTION",5000.00,"HOME APPLIANCES","PIEGON","INDIA")));

	}*/

	public static void main(String[] args) {
		SpringApplication.run(GraphQlProjectApplication.class, args);
	}

}
