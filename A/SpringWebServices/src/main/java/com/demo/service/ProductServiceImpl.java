package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.ProductDao;
import com.demo.model.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao pdao;
	
	
	public List<Product> getAllProducts() {
		return pdao.getAllProducts();
	}


	@Override
	public Product getById(int id) {
		return pdao.getById(id);
	}


	@Override
	public void addProduct(Product p) {
		pdao.insertProduct(p);
		
	}


	@Override
	public void modifyProduct(Product p) {
		pdao.updateProduct(p);
		
	}


	@Override
	public void deleteById(int id) {
		pdao.removeById(id);
		
	}

}
