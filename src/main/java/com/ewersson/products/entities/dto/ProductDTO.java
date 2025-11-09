package com.ewersson.products.entities.dto;

import com.ewersson.products.entities.Product;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class ProductDTO {

    private Long id;
    private String name;
    private BigDecimal price;
    private String image;

    public ProductDTO(List<Product> product){}

    public ProductDTO(Product product) {
        BeanUtils.copyProperties(product, this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO that = (ProductDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}