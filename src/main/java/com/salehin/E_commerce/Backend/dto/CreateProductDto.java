package com.salehin.E_commerce.Backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateProductDto {
    String  name;
    String  sku;
    Double  minPrice;
    Double  maxPrice;
    Set<Long> categoryIds;
}
