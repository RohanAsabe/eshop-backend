package com.eshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshop.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	 List<Product> findByCategory(String category);
}
