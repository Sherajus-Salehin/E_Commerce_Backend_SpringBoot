package com.salehin.E_commerce.Backend.service;

import com.salehin.E_commerce.Backend.dto.CategoryDto;
import com.salehin.E_commerce.Backend.dto.CategoryResponseDto;
import com.salehin.E_commerce.Backend.dto.CreateProductDto;
import com.salehin.E_commerce.Backend.dto.ProductResponseDTO;
import com.salehin.E_commerce.Backend.entity.Category;
import com.salehin.E_commerce.Backend.entity.Product;
import com.salehin.E_commerce.Backend.repository.CategoryRepository;
import com.salehin.E_commerce.Backend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

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

    public Page<ProductResponseDTO> search(String key, Pageable pageable){
        Page<Product> products=productRepository.findByNameContainingIgnoreCaseAndIsActiveTrue(key,pageable);
        return products.map(this::mapToDTO);
    }

    public List<ProductResponseDTO> getAll() {
        List<Product> products=productRepository.findAll();
        return products.stream().map(this::mapToDTO).toList();
    }

    public ProductResponseDTO create(CreateProductDto dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setSku(dto.getSku());
        product.setMinPrice(dto.getMinPrice());
        product.setMaxPrice(dto.getMaxPrice());
        Set<Category> categories=new HashSet<>(categoryRepository.findAllById(dto.getCategoryIds()));
        product.setCategories(categories);
        return mapToDTO(productRepository.save(product));
    }

    public void isActive(Integer id, Boolean isActive) {
        Product p= productRepository.findById(id).orElseThrow(()-> new RuntimeException("product not found"));
        p.setIsActive(isActive);
        productRepository.save(p);
    }
}
