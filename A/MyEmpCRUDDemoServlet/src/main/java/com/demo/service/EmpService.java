package com.demo.service;

import java.util.List;

import com.demo.model.Employee;

public interface EmpService {

	List<Employee> getAllEmployees();

	Employee getById(int id);

	void modifyemp(Employee e);

	void deleteById(int id);

	void addnewemployee(Employee e);

}
