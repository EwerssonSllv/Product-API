package com.ewersson.products.entities.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.util.Objects;

public class CreateProductDTO {

    @NotBlank
    private String name;

    @NotNull
    @Positive
    private BigDecimal price;
    private String image;

    @PositiveOrZero
    @NotNull
    private Integer quantity;

    public CreateProductDTO(){}

    public CreateProductDTO(String name, String image, Integer quantity, BigDecimal price) {
        this.name = name;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
        CreateProductDTO that = (CreateProductDTO) o;
        return Objects.equals(name, that.name) && Objects.equals(price, that.price) && Objects.equals(image, that.image) && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, image, quantity);
    }
}
