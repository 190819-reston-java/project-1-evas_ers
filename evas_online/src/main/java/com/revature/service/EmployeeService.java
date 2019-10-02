package com.revature.service;

import com.revature.model.Employee;
import com.revature.repository.EvasDAO;
import com.revature.repository.EvasJDBC;

public class EmployeeService {

	public Employee selectedEmployee = new Employee(0, "last_name", "first_name", "position", "email", "12345");
	
	private EvasDAO evasDao = new EvasJDBC();
	
//	public EmployeeService() {
//		this.evasDao = evasDao;
//		this.selectedEmployee = new Employee(0, "last_name", "first_name", "position", "email", "12345");
//	}
	
//	public EmployeeService(EvasDAO evasDao) {
//		this.evasDao = evasDao;
//		this.selectedEmployee = new Employee();
//	}
	
	
	public Employee getSelectedEmployee() {
		return selectedEmployee;
	}
	
	public void setSelectedEmployee(Employee selectedEmployee) {
		this.selectedEmployee = selectedEmployee;
	}

	
	public void updateSelectedEmployee() {
		evasDao.updateEmployee(selectedEmployee);
	}
//	public void newReimbursement()
	
	/**
	 * Alternate:
	 */
	
//	public EmployeeService(EvasDAO evasDao) {
//		this.evasDao = evasDao;
//		this.selectedEmployee = new Employee();
//	}
//	
//	private Employee selectedEmployee;
//	private EvasDAO evasDao;
//	
//	public Employee getSelectedEmployee() {
//		return selectedEmployee;
//	}
//	
//	public void setSelectedEmployee(Employee selectedEmployee) {
//		this.selectedEmployee = selectedEmployee;
//	}
//	
//		
//	public void updateSelectedEmployee() {
//		evasDao.updateEmployee(selectedEmployee);
//	}
	
	

}
