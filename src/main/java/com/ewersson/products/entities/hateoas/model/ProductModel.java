package com.ewersson.products.entities.hateoas.model;

import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;

public class ProductModel extends RepresentationModel<ProductModel> {
    private Long id;
    private String name;
    private BigDecimal price;
    private String image;
    private Integer quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
