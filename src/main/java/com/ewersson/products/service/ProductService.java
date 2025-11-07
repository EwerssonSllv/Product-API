package com.ewersson.products.service;

import com.ewersson.products.entities.Product;
import com.ewersson.products.entities.dto.ProductDTO;
import com.ewersson.products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product create(Product product){
        return productRepository.save(product);
    }

    public List<ProductDTO> getAll(){
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductDTO::new).toList();
    }

    public Optional<ProductDTO> findById(Long id){
        Optional<Product> product = productRepository.findById(id);
        return Optional.of(new ProductDTO(product.orElse(null)));
    }

}