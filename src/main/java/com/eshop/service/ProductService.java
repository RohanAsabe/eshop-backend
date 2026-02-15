package com.eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.entity.Product;
import com.eshop.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	// To get All product
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	//To save Product
	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	// To get product by id
	public Product getProductById(Long id) {
		return productRepository.findById(id).orElse(null);
	}
	
	//To delete product
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}
