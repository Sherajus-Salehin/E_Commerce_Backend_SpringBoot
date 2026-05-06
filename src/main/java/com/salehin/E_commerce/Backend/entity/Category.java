package com.salehin.E_commerce.Backend.entity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@RequiredArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long categoryId;
    String name;
    String code;
    Boolean isActive;

    @ManyToMany(mappedBy = "categories")
    private Set<Product> products=new HashSet<Product>();
}
