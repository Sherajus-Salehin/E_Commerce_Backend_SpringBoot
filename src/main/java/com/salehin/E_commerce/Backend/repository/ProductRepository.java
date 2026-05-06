package com.salehin.E_commerce.Backend.repository;

import com.salehin.E_commerce.Backend.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Page<Product> findByNameContaining(String key, Pageable pageable);
}
