package com.ewersson.products.entities.dto;

import java.math.BigDecimal;

public record CreateProductDTO(
        String name,
        BigDecimal price,
        String image,
        Integer quantity){}
