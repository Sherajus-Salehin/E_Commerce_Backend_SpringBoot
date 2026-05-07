package com.salehin.E_commerce.Backend.repository;

import com.salehin.E_commerce.Backend.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Set;


//deal with long and integer later
public interface CategoryRepository extends JpaRepository<Category,Long> {
    //Page<Category> findByNameContainingIgnoreCaseAndIsActiveTrue(String name, Pageable pageable);

    @Query("""
            SELECT c FROM Category c
            WHERE
            (:name IS NULL OR LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND
            (:code IS NULL OR LOWER(c.code) LIKE LOWER(CONCAT('%', :code, '%')))
            """)
    Page<Category> searchCategory(@Param("name") String name,
                                  @Param("code") String code,
                                  Pageable pageable);

}
