package com.ewersson.products.entities.hateoas.assembler;

import com.ewersson.products.controller.ProductController;
import com.ewersson.products.entities.dto.ProductDTO;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProductModelAssembler
        implements RepresentationModelAssembler<ProductDTO, EntityModel<ProductDTO>> {

    @Override
    public EntityModel<ProductDTO> toModel(ProductDTO product) {
        return EntityModel.of(
                product,
                linkTo(methodOn(ProductController.class).getById(product.id())).withSelfRel(),
                linkTo(methodOn(ProductController.class).getAll()).withRel("all-products"));
    }
}