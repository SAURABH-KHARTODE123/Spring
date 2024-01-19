package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Product;
import com.demo.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService pservice;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> plist = pservice.getAllProducts();
		return ResponseEntity.ok(plist);
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getAllProducts(@PathVariable int id){
		Product p = pservice.getById(id);
		if(p!=null) {
			return ResponseEntity.ok(p);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PostMapping("/products/{id}")
	public ResponseEntity<String> addProduct(@RequestBody Product p){
		pservice.addProduct(p);
		return ResponseEntity.ok("product added successfully");
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<String> updateProduct(@RequestBody Product p){
		pservice.modifyProduct(p);
		return ResponseEntity.ok("updated successfully..");
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id){
		pservice.deleteById(id);
		return ResponseEntity.ok("deleted successfully...");
	}
}
