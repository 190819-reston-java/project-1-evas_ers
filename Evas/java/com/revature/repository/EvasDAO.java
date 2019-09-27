package com.revature.repository;

import com.revature.model.Employee;
import com.revature.model.Image;
import com.revature.model.Reimbursement;
import com.revature.model.Request;

public interface EvasDAO {
	
	Employee getEmailandPass(String employeeemail, String employeepassword);
	
	boolean createRequest(Request r);
	
	boolean updateEmployee(int employeeid);
	
	Image insertImage(int imageid, byte[] image);
	
	boolean updateRequest(int requestid);
	
	Reimbursement getReimbursement(int reimburementid);
	
}
