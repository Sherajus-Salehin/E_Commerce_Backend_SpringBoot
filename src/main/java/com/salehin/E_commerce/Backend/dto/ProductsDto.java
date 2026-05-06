package com.salehin.E_commerce.Backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductsDto {
    Long id;
    String name;
    String sku;
}
