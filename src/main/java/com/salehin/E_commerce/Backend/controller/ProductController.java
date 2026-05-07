package com.salehin.E_commerce.Backend.controller;

import com.salehin.E_commerce.Backend.dto.CategoryResponseDto;
import com.salehin.E_commerce.Backend.dto.CreateCategoryDto;
import com.salehin.E_commerce.Backend.dto.CreateProductDto;
import com.salehin.E_commerce.Backend.dto.ProductResponseDTO;
import com.salehin.E_commerce.Backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/search")
    //(required = false)
    public Page<ProductResponseDTO> search(@RequestParam String key, @RequestParam int page, @RequestParam int size){
        Pageable pageable = PageRequest.of(page, size);
        return productService.search(key,pageable);
    }

    @GetMapping
    public List<ProductResponseDTO> categories(){
        return productService.getAll();
    }


    @PostMapping("/new")
    public ProductResponseDTO create(@RequestBody CreateProductDto dto){
        return productService.create(dto);
    }
}
