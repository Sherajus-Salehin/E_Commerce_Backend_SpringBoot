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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String sku;
    Double minPrice;
    Double maxPrice;
    Boolean isActive;
    @ManyToMany
    @JoinTable(
            name="category_list",
            joinColumns = @JoinColumn(name="product_id"),
            inverseJoinColumns = @JoinColumn(name="category_id")
    )
    private Set<Category> categories= new HashSet<>();
}
