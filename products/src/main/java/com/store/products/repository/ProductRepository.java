package com.store.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.store.products.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}