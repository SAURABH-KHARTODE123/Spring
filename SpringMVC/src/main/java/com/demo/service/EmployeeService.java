package com.demo.service;
import com.demo.model.Employee;

import java.util.List;

public interface EmployeeService {
	List<Employee> getAllEmployee();

	void addNewEmployee(Employee p);

	void updateEmployee(Employee p);

	Employee getById(int id);

	void deleteById(int id);
}
