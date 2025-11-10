package com.ewersson.products.service;

import com.ewersson.products.entities.Product;
import com.ewersson.products.entities.dto.CreateProductDTO;
import com.ewersson.products.entities.dto.ProductDTO;
import com.ewersson.products.entities.mapper.ProductMapper;
import com.ewersson.products.repositories.ProductRepository;
import com.ewersson.products.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public ProductDTO create(CreateProductDTO dto){
        Product entity = productMapper.toEntity(dto);
        Product saved = productRepository.save(entity);
        return productMapper.toDTO(saved);
    }

    /** Example code without a mapper.
     *   public ProductDTO create(CreateProductDTO dto){
     *         Product prod = new Product(
     *                 null,
     *                 dto.getName(),
     *                 dto.getPrice(),
     *                 dto.getImage(),
     *                 dto.getQuantity()
     *         );
     *
     *         Product saved = productRepository.save(prod);
     *         return new ProductDTO(saved);
     *     }
     */

    public List<ProductDTO> getAll(){
        return productMapper.toDTOList(productRepository.findAll());
    }

    /** Example code without a mapper.
     *
     *  public List<ProductDTO> getAll(){
     *         List<Product> products = productRepository.findAll();
     *         return products.stream().map(ProductDTO::new).toList();
     *     }
     *
     */

    public Optional<ProductDTO> findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Product Not Found!"));

        return Optional.ofNullable(productMapper.toDTO(product));
    }

    public List<ProductDTO> findBetweenPrice(BigDecimal smaller, BigDecimal bigger) {
        List<Product> products = productRepository.findProductBetweenPrice(smaller, bigger);
        return productMapper.toDTOList(products);
    }

}