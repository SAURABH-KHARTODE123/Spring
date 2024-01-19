package com.demo.service;

import java.util.List;

import com.demo.model.Product;

public interface ProductService {

	List<Product> getAllProducts();

	Product getById(int id);

	void addProduct(Product p);

	void modifyProduct(Product p);

	void deleteById(int id);

}
