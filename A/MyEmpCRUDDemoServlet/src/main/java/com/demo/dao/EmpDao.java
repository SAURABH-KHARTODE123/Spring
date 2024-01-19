package com.demo.dao;

import java.util.List;

import com.demo.model.Employee;

public interface EmpDao {

	List<Employee> getAllEmployees();

	Employee findById(int id);

	void updateEmp(Employee e);

	void deleteById(int id);

	void insertEmp(Employee e);

}
