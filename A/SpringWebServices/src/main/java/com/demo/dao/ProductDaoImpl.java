package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Product> getAllProducts() {
		return jdbcTemplate.query("select * from product",(rs,num)-> {
			Product p = new Product();
			p.setId(rs.getInt(1));
			p.setName(rs.getString(2));
			p.setPrice(rs.getDouble(3));
			p.setQty(rs.getInt(4));
			return p;
		});
	}

	@Override
	public Product getById(int id) {
		return jdbcTemplate.queryForObject("select * from product where id=?",new Object[] {id},BeanPropertyRowMapper.newInstance(Product.class));
	}

	@Override
	public void insertProduct(Product p) {
		jdbcTemplate.update("insert into product values(?,?,?,?)",new Object[] {p.getId(),p.getName(),p.getPrice(),p.getQty()});
		
	}

	@Override
	public void updateProduct(Product p) {
		jdbcTemplate.update("update product set name=?,price=?,qty=? where id=?",new Object[] {p.getName(),p.getPrice(),p.getQty(),p.getId()});
		
	}

	@Override
	public void removeById(int id) {
		jdbcTemplate.update("delete from product where id=?",new Object[] {id});
		
	}

}
