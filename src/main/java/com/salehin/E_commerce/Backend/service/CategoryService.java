package com.salehin.E_commerce.Backend.service;

import com.salehin.E_commerce.Backend.dto.CategoryDto;
import com.salehin.E_commerce.Backend.dto.CategoryResponseDto;
import com.salehin.E_commerce.Backend.dto.CreateCategoryDto;
import com.salehin.E_commerce.Backend.dto.ProductsDto;
import com.salehin.E_commerce.Backend.entity.Category;
import com.salehin.E_commerce.Backend.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public String addCategory(Category category) {
        categoryRepository.save(category);
        return "Added successfully";
    }
    public String updateCategory(Category category) {
        Category u=getCategory(category.getId());

        categoryRepository.save(category);
        return "Updated successfully";
    }
    public Category getCategory(Long id) {
        return categoryRepository.findById(id);
    }


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

    public Page<CategoryResponseDto> search(String key, Pageable pageable){
        Page<Category> categories=categoryRepository.findByNameContaining(key,pageable);
        return categories.map(this::mapToDto);
    }

    public CategoryResponseDto create(CreateCategoryDto dto) {
        Category category=new Category();
        category.setName(dto.getName());
        category.setCode(dto.getCode());
        category.setIsActive(true);
        return mapToDto(categoryRepository.save(category));
    }

    //for personal testing, no pageable
    public List<CategoryResponseDto> getAll() {
        List<Category> allCategories= categoryRepository.findAll();
        return allCategories.stream().map(this::mapToDto).toList();
    }
}
