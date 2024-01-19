package com.demo.dao;

import java.util.List;

import com.demo.model.Product;

public interface ProductDao {

	List<Product> getAllProducts();

	Product getById(int id);

	void insertProduct(Product p);

	void updateProduct(Product p);

	void removeById(int id);

}
