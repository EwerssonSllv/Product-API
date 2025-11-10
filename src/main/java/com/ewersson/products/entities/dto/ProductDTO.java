package com.ewersson.products.entities.dto;

import java.math.BigDecimal;

public record ProductDTO(
        Long id,
        String name,
        BigDecimal price,
        String image,
        Integer quantity
        ) {}