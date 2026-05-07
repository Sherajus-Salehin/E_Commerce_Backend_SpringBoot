package com.salehin.E_commerce.Backend.dto;

import com.salehin.E_commerce.Backend.entity.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Getter
@Setter
public class ProductResponseDTO {
    Long id;
    String name;
    String sku;
    Double price;
    List<CategoryDto> categories;
}
