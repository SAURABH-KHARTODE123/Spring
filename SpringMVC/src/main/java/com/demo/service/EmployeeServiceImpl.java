package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.EmployeeDao;
import com.demo.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao pdao;

	
	public List<Employee> getAllEmployee() {
		return pdao.findEmployee();
	}


	@Override
	public void addNewEmployee(Employee p) {
		pdao.insertEmployee(p);
		
	}


	@Override
	public void updateEmployee(Employee p) {
		pdao.updateById(p);
		
	}


	@Override
	public Employee getById(int id) {
		return pdao.getById(id);
	}


	@Override
	public void deleteById(int id) {
		pdao.deleteById(id);
	}

}
