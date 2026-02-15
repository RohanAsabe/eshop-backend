package com.eshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.entity.Product;
import com.eshop.service.ProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductController {
	
	@Autowired
	private ProductService productService;

	
	@GetMapping
	public List<Product> getProducts(){
		return productService.getAllProducts();
	}
	
	
	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product){
	    return productService.save(product);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteProduct(@PathVariable Long id){
	    productService.deleteProduct(id);
	}

}
