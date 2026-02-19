package com.example.graphQl.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    private String name; // ROLE_ADMIN

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> permissions; // READ_STUDENT, DELETE_STUDENT
}

