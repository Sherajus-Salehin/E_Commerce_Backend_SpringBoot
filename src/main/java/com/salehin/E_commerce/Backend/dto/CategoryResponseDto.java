package com.salehin.E_commerce.Backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Getter
@Setter
public class CategoryResponseDto {
    Long id;
    String name;
    String code;
    List<ProductsDto> products;
}
