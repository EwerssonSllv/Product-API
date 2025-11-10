package com.ewersson.products;

import com.ewersson.products.entities.Product;
import com.ewersson.products.entities.dto.CreateProductDTO;
import com.ewersson.products.entities.dto.ProductDTO;
import com.ewersson.products.entities.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ProductsApplicationTests {

    @Autowired
    ProductMapper productMapper;

    @Test
    void shouldMapCreateProductDTOToEntity() {
        CreateProductDTO dto = new CreateProductDTO(
                "Doritos",
                BigDecimal.valueOf(14.50),
                "example.jpg",
                10
        );

        Product entity = productMapper.toEntity(dto);

        assertNotNull(entity);
        assertEquals("Doritos", entity.getName());
        assertEquals(BigDecimal.valueOf(14.50), entity.getPrice());
        assertEquals("example.jpg", entity.getImage());
        assertEquals(10, entity.getQuantity());
    }

    @Test
    void shouldMapEntityToDTO() {
        Product entity = new Product(
                1L,
                "Doritos",
                BigDecimal.valueOf(14.50),
                "example.jpg",
                10
        );

        ProductDTO dto = productMapper.toDTO(entity);

        assertNotNull(dto);
        assertEquals(1L, dto.id());
        assertEquals("Doritos", dto.name());
        assertEquals(BigDecimal.valueOf(14.50), dto.price());
        assertEquals("example.jpg", dto.image());
    }

    @Test
    void shouldMapEntityListToDTOList() {
        List<Product> products = List.of(
                new Product(1L, "Doritos", BigDecimal.valueOf(14.50), "example.jpg", 10),
                new Product(2L, "Coca-Cola", BigDecimal.valueOf(5.00), "coke.jpg", 20)
        );

        List<ProductDTO> dtos = productMapper.toDTOList(products);

        assertNotNull(dtos);
        assertEquals(2, dtos.size());

        assertEquals("Doritos", dtos.get(0).name());
        assertEquals("Coca-Cola", dtos.get(1).name());
    }



}
