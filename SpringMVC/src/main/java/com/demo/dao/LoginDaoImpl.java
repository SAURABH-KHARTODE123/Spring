package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.model.MyUser;

@Repository
public class LoginDaoImpl implements LoginDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public MyUser checkUser(String uname, String pass) {
		return jdbcTemplate.queryForObject("select * from my_user where user_name=? and password=?",new Object[] {uname,pass},BeanPropertyRowMapper.newInstance(MyUser.class));
	}
	
}
