package com.example.graphQl.specification;

import com.example.graphQl.DTO.ProductFilterInput;
import com.example.graphQl.entity.Product;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;


public class ProductSpecification {

    public static Specification<Product> filter(ProductFilterInput filter) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter != null) {

                if (filter.getProductName() != null) {
                    predicates.add(
                        cb.like(
                            cb.lower(root.get("product_name")),
                            "%" + filter.getProductName().toLowerCase() + "%"
                        )
                    );
                }

                if (filter.getCategory() != null) {
                    predicates.add(
                        cb.like(
                            cb.lower(root.get("category")),
                            "%" + filter.getCategory().toLowerCase() + "%"
                        )
                    );
                }
                if(filter.getPrice()!=null){
                    predicates.add(
                            cb.equal(
                                   (root.get("price")),
                                 filter.getPrice()
                            )
                    );
                }
                if(filter.getOrigin()!=null){
                    predicates.add(
                            cb.like(cb.lower(root.get("origin")),
                            "%"+filter.getOrigin().toLowerCase()+"%"
                            )
                    );
                }
                if(filter.getBrand()!=null){
                    predicates.add(
                            cb.like(cb.lower(root.get("brand")),
                                    "%"+filter.getBrand().toLowerCase()+"%")
                    );
                }
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
