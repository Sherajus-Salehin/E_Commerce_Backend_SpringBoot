package com.salehin.E_commerce.Backend.service;

import com.salehin.E_commerce.Backend.dto.CategoryDto;
import com.salehin.E_commerce.Backend.dto.CategoryResponseDto;
import com.salehin.E_commerce.Backend.dto.ProductResponseDTO;
import com.salehin.E_commerce.Backend.entity.Category;
import com.salehin.E_commerce.Backend.entity.Product;
import com.salehin.E_commerce.Backend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponseDTO mapToDTO(Product product){
        ProductResponseDTO dto=new ProductResponseDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setSku(product.getSku());
        dto.setMinPrice(product.getMinPrice());
        dto.setMaxPrice(product.getMaxPrice());
        List<CategoryDto> categories= product.getCategories()
                .stream()
                .map(category -> new CategoryDto(
                        category.getId(),
                        category.getName(),
                        category.getCode()
                        )
                ).toList();
        dto.setCategories(categories);
    return dto;
    }

    Page<ProductResponseDTO> search(String key, Pageable pageable){
        Page<Product> products=productRepository.findByNameContaining(key,pageable);
        return products.map(this::mapToDTO);
    }
}
