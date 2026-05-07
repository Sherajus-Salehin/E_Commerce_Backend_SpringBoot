package com.salehin.E_commerce.Backend.controller;

import com.salehin.E_commerce.Backend.dto.CategoryResponseDto;
import com.salehin.E_commerce.Backend.dto.CreateCategoryDto;
import com.salehin.E_commerce.Backend.service.CategoryService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/search")
    //(required = false)
    public Page<CategoryResponseDto> search(@RequestParam String key, @RequestParam int page, @RequestParam int size){
        Pageable pageable = PageRequest.of(page, size);
        return categoryService.search(key,pageable);
    }

    @GetMapping
    public List<CategoryResponseDto> categories(){
        return categoryService.getAll();
    }


    @PostMapping("/new")
    public CategoryResponseDto create(@RequestBody CreateCategoryDto dto){
        return categoryService.create(dto);
    }
}
