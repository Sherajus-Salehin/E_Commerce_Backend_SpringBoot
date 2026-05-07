package com.salehin.E_commerce.Backend.repository;

import com.salehin.E_commerce.Backend.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Set;


//deal with long and integer later
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Page<Category> findByNameContaining(String name, Pageable pageable);

    Category findById(Long id);

    Collection<? extends Category> findAllById(Set<Long> categoryIds);
}
