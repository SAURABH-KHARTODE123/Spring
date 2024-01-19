package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.demo.model.Product;
import com.demo.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService pservice;
	
	@GetMapping("/getproducts")
	public ModelAndView getProducts(HttpSession session) {
		   List<Product> plist=pservice.getAllProducts();
		   return new ModelAndView("displayproduct","plist",plist);
		
	}
	
	@GetMapping("/addproduct")
	public String displayaddform(HttpSession session) {
		  return "addproduct";
		
	}
	
	@PostMapping("/insertProduct")
	public ModelAndView insertProduct(@RequestParam int id, @RequestParam String name,@RequestParam int qty,@RequestParam double price) {
		Product p=new Product(id,name,qty,price);
		pservice.addnewProduct(p);
		return new ModelAndView("redirect:/product/getproducts");
		
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView editProduct(@PathVariable("id") int id) {
		Product p=pservice.getById(id);
		return new ModelAndView("editProduct","p",p);
		
	}
	
	@PostMapping("/updateProduct")
	public ModelAndView updateProdut(@RequestParam int id, @RequestParam String name,@RequestParam int qty,@RequestParam double price) {
		pservice.updateById(new Product(id,name,qty,price));
		return new ModelAndView("redirect:/product/getproducts");
	}
	
	@GetMapping("delete/{id}")
	public ModelAndView deleteProduct(@PathVariable int id) {
		pservice.deleteById(id);
		return new ModelAndView("redirect:/product/getproducts");
	}
	
	@GetMapping("/products/price/{lpr}/{hpr}")
	public ModelAndView getProductByprice(@PathVariable int lpr,@PathVariable int hpr) {
		List<Product> plist=pservice.getByPrice(lpr,hpr);
		return new ModelAndView("displayproduct","plist",plist);
	}
	
	

}
