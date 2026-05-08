package com.salehin.E_commerce.Backend.repository;

import com.salehin.E_commerce.Backend.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ProductRepository extends JpaRepository<Product,Long> {
    //Page<Product> findByNameContainingIgnoreCaseAndIsActiveTrue(String key, Pageable pageable);
    @Query("""
            SELECT DISTINCT p FROM Product p
            LEFT JOIN p.categories c WHERE
            p.isActive=TRUE AND (c IS NULL OR c.isActive=TRUE)
            AND(:name IS NULL OR LOWER(p.name) LIKE LOWER(CONCAT('%',:name,'%')))
            AND(:sku IS NULL OR LOWER(p.sku) LIKE LOWER(CONCAT('%',:sku,'%')))
            AND(:categoryId IS NULL OR c.id=:categoryId)
            AND(:minPrice IS NULL OR p.price >= :minPrice)
            AND(:maxPrice IS NULL OR p.price <= :maxPrice)
            """)
    Page<Product> searchProducts(@Param("name") String name,
                                 @Param("sku")String sku,
                                 @Param("categoryId") Long categoryId,
                                 @Param("minPrice") Double minPrice,
                                 @Param("maxPrice") Double maxPrice,
                                 Pageable pageable);
}

