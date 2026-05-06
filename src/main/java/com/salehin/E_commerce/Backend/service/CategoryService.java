package com.salehin.E_commerce.Backend.service;

import com.salehin.E_commerce.Backend.dto.CategoryDto;
import com.salehin.E_commerce.Backend.dto.CategoryResponseDto;
import com.salehin.E_commerce.Backend.dto.ProductsDto;
import com.salehin.E_commerce.Backend.entity.Category;
import com.salehin.E_commerce.Backend.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;


    public CategoryResponseDto mapToDto(Category category) {
        CategoryResponseDto dto=new CategoryResponseDto();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setCode(category.getCode());
        List<ProductsDto> products= category.getProducts()
                .stream()
                .map(product ->
                            new ProductsDto(product.getId(),
                                    product.getName(),
                                    product.getSku()
                                    )

                ).toList();
        dto.setProducts(products);
        return dto;
    }

    Page<CategoryResponseDto> search(String key, Pageable pageable){
        Page<Category> categories=categoryRepository.findByNameContaining(key,pageable);
        return categories.map(this::mapToDto);
    }
}
