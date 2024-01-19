package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.model.Employee;

public class EmpDaoImpl implements EmpDao{
	
	static Connection conn;
	static PreparedStatement selAll,selById,upEmp,delById,insEmp;
	static {
		conn = DBUtil.getMyConnection();
		try {
			selAll = conn.prepareStatement("select * from employee");
			selById = conn.prepareStatement("select * from employee where id=?");
			upEmp = conn.prepareStatement("update employee set name=?, salary=?, gender=? where id=?");
			delById = conn.prepareStatement("delete from employee where id=?");
			insEmp = conn.prepareStatement("insert into employee values(?,?,?,?)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list = new ArrayList<>();
		try {
			ResultSet rs = selAll.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int salary = rs.getInt(3);
				String gender = rs.getString(4);
				
				Employee e = new Employee(id,name,salary,gender);
				list.add(e);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Employee findById(int id) {
		try {
			selById.setInt(1, id);
			ResultSet rs = selById.executeQuery();
			if(rs.next()) {
				return new Employee(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateEmp(Employee e) {
		try {
			upEmp.setString(1, e.getName());
			upEmp.setInt(2,e.getSalary());
			upEmp.setString(3, e.getGender());
			upEmp.setInt(4, e.getId());
			
			upEmp.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public void deleteById(int id) {
		try {
			delById.setInt(1, id);
			delById.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void insertEmp(Employee e) {
		try {
			insEmp.setInt(1, e.getId());
			insEmp.setString(2, e.getName());
			insEmp.setInt(3, e.getSalary());
			insEmp.setString(4, e.getGender());
			
			insEmp.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
