package com.salehin.E_commerce.Backend.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String code;
    Boolean isActive;

    @ManyToMany(mappedBy = "categories")
    private Set<Product> products=new HashSet<>();
}
