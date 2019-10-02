package com.revature.repository;

import java.sql.Array;
import java.sql.Date;
import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Image;
import com.revature.model.Reimbursement;
import com.revature.model.Request;

public interface EvasDAO {
	
	Employee getEmailandPass(String employeeemail, String employeepassword);
	
	//boolean createRequest(int requestid, double requestvalue, String requeststatus, String requestcatagory,
	//		String requestdescription, Date requestdate, Date eventdate, String requestinformation);
	boolean createRequest(Request rc);
	
	boolean updateEmployee(Employee ru);
	
	
	
	//boolean updateRequest(int requestid, double requestvalue, String requeststatus, String requestcatagory,
	//		String requestdescription, Date requestdate, Date eventdate, String requestinformation);
	boolean updateRequest(Request ru);
	
	Reimbursement getReimbursement(int reimbursementid);
	
	List<Employee> getEmployee(Employee ea);

	List<Request> getRequest(Request ra);

	//List<Request> updateRequest();

	Image insertImage(String imagename, byte[] image);
	
	byte[] getImage(int id);
	
	void addImage(int id, byte[] image );
}
