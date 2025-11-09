package com.ewersson.products.controller;

import com.ewersson.products.entities.Product;
import com.ewersson.products.entities.dto.ProductDTO;
import com.ewersson.products.repositories.ProductRepository;
import com.ewersson.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private Product create(@RequestBody Product body){
        return productService.create(body);
    }

    @GetMapping
    private List<ProductDTO> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    private Optional<ProductDTO> getById(@PathVariable Long id){
        return productService.findById(id);
    }

    @GetMapping("price/{smaller}/{bigger}")
    private List<ProductDTO> findBetweenPrice(@PathVariable BigDecimal smaller,@PathVariable BigDecimal bigger){
        return productService.findBetweenPrice(smaller, bigger);
    }

}