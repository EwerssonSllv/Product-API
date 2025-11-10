package com.ewersson.products.controller;

import com.ewersson.products.entities.dto.CreateProductDTO;
import com.ewersson.products.entities.dto.ProductDTO;
import com.ewersson.products.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDTO> create(
            @RequestBody @Valid CreateProductDTO body) {
        ProductDTO created = productService.create(body);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(created);
    }

    @GetMapping
    private ResponseEntity<List<ProductDTO>> getAll(){
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProductDTO>> getById(@PathVariable Long id){
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping("price/{smaller}/{bigger}")
    private ResponseEntity<List<ProductDTO>> findBetweenPrice(
            @PathVariable @NotNull BigDecimal smaller,
            @PathVariable @NotNull BigDecimal bigger) {

        return ResponseEntity.ok(productService.findBetweenPrice(smaller, bigger));
    }

}