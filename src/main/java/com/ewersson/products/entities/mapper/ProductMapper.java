package com.ewersson.products.entities.mapper;

import com.ewersson.products.entities.Product;
import com.ewersson.products.entities.dto.CreateProductDTO;
import com.ewersson.products.entities.dto.ProductDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toEntity(CreateProductDTO dto);
    ProductDTO toDTO(Product entity);
    List<ProductDTO> toDTOList(List<Product> entity);
}
