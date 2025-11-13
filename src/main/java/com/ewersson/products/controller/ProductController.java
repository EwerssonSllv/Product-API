package com.ewersson.products.controller;

import com.ewersson.products.entities.hateoas.assembler.ProductModelAssembler;
import com.ewersson.products.entities.dto.CreateProductDTO;
import com.ewersson.products.entities.dto.ProductDTO;
import com.ewersson.products.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductModelAssembler assembler;

    @PostMapping
    public ResponseEntity<EntityModel<ProductDTO>> create(
            @RequestBody @Valid CreateProductDTO body) {
        ProductDTO created = productService.create(body);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(assembler.toModel(created));
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<ProductDTO>>> getAll(){
        List<ProductDTO> products = productService.getAll();

        List<EntityModel<ProductDTO>> models = products.stream()
                .map(assembler::toModel)
                .toList();

        return ResponseEntity.ok(
                CollectionModel.of(
                        models,
                        linkTo(methodOn(ProductController.class).getAll()).withSelfRel()
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<ProductDTO>> getById(@PathVariable Long id){
        ProductDTO product = productService.getById(id);

        return ResponseEntity.ok(assembler.toModel(product));

    }

    @GetMapping("/price/{smaller}/{bigger}")
    public ResponseEntity<CollectionModel<EntityModel<ProductDTO>>> findBetweenPrice(
            @PathVariable @NotNull BigDecimal smaller,
            @PathVariable @NotNull BigDecimal bigger) {

        List<ProductDTO> product = productService.findBetweenPrice(smaller, bigger);

        List<EntityModel<ProductDTO>> models = product.stream()
                .map(assembler::toModel)
                .toList();

        return ResponseEntity.ok(
                CollectionModel.of(
                        models,
                        linkTo(methodOn(ProductController.class)
                                .findBetweenPrice(smaller, bigger)).withSelfRel())
        );
    }

}