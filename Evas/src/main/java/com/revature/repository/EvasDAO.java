package com.revature.repository;

import com.revature.model.Employee;
import com.revature.model.Image;
import com.revature.model.Reimbursement;
import com.revature.model.Request;

public interface EvasDAO {
	
	Employee getEmailandPass(String employeeemail, String employeepassword);
	
	boolean createRequest(Request r);
	
	boolean updateEmployee(Employee em);
	
	Image insertImage(String imagename, byte[] image);
	
	boolean updateRequest(Request ru);
	
	Reimbursement getReimbursement(int reimbursementid);
	
}
