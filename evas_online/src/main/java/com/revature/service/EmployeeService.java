package com.revature.service;

import com.revature.model.Employee;

import com.revature.repository.EvasDAO;

public class EmployeeService {
	
	public EmployeeService(EvasDAO evasDao) {
		this.evasDao = evasDao;
		this.selectedEmployee = new Employee();
	}
	
	private Employee selectedEmployee;
	private EvasDAO evasDao;
	
	public Employee getSelectedEmployee() {
		return selectedEmployee;
	}
	
	public void setSelectedEmployee(Employee selectedEmployee) {
		this.selectedEmployee = selectedEmployee;
	}
	
		
	public void updateSelectedEmployee() {
		evasDao.updateEmployee(selectedEmployee);
	}
	
	

}
