package com.demo.dao;

import java.util.List;

import com.demo.model.Employee;

public interface EmployeeDao {

	List<Employee> findEmployee();

	void insertEmployee(Employee p);

	void updateById(Employee p);

	Employee getById(int id);

	void deleteById(int id);

}
