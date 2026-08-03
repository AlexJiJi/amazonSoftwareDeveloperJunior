package com.coffeshop.menu.repository;

import com.coffeshop.menu.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
