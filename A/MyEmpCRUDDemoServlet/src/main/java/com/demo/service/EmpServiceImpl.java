package com.demo.service;

import java.util.List;

import com.demo.dao.EmpDao;
import com.demo.dao.EmpDaoImpl;
import com.demo.model.Employee;

public class EmpServiceImpl implements EmpService {

	private EmpDao edao;
	
	public EmpServiceImpl() {
		this.edao = new EmpDaoImpl();
	}
	@Override
	public List<Employee> getAllEmployees() {
		return edao.getAllEmployees();
	}
	@Override
	public Employee getById(int id) {
		return edao.findById(id);
	}
	@Override
	public void modifyemp(Employee e) {
		edao.updateEmp(e);
		
	}
	@Override
	public void deleteById(int id) {
		edao.deleteById(id);
		
	}
	@Override
	public void addnewemployee(Employee e) {
		edao.insertEmp(e);
		
	}

}
