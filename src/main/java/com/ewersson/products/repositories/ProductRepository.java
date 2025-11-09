package com.ewersson.products.repositories;

import com.ewersson.products.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM products WHERE price BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Product> findProductBetweenPrice(BigDecimal smaller, BigDecimal bigger);
}
