package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.model.Employee;


@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Employee> findEmployee() {
		return jdbcTemplate.query("select * from employee", (rs,num) -> {
			Employee p = new Employee();
			p.setId(rs.getInt(1));
			p.setName(rs.getString(2));
			p.setGender(rs.getString(4));
			p.setPrice(rs.getDouble(3));
			return p;
		});
	}

	@Override
	public void insertEmployee(Employee p) {
		String query = "insert into employee values(?,?,?,?)";
		jdbcTemplate.update(query,new Object[] {p.getId(),p.getName(),p.getPrice(),p.getGender()});
	}

	@Override
	public void updateById(Employee p) {
		String query = "update employee set name=?,price=?,gender=? where id=?";
		jdbcTemplate.update(query,new  Object[] {p.getName(),p.getPrice(),p.getGender(),p.getId()});
	}

	@Override
	public Employee getById(int id) {
		String query = "select * from employee where id=?";
		return jdbcTemplate.queryForObject(query,new Object[] {id},(rs,num) ->{
			return new Employee(rs.getInt(1),rs.getString(2),rs.getString(4),rs.getDouble(3));
		});
	}

	@Override
	public void deleteById(int id) {
		String query = "delete from employee where id=?";
		jdbcTemplate.update(query,new Object[] {id});
	}

}
