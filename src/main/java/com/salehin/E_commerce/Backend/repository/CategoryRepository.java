package com.salehin.E_commerce.Backend.repository;

import com.salehin.E_commerce.Backend.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;

import java.awt.print.Pageable;

public interface CategoryRepository extends CrudRepository<Category,Integer> {
    Page<Category> findByNameContaining(String name, Pageable pageable);
}
