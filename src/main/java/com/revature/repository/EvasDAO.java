package com.revature.repository;

import java.sql.Array;
import java.sql.Date;
import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Image;
import com.revature.model.MultiModelMode;
import com.revature.model.Reimbursement;
import com.revature.model.Request;

public interface EvasDAO {

	// Employees and Manager (Managers are Employees)
	Employee getEmailandPass(String employeeemail, String employeepassword);

	boolean updateEmployee(Employee ru);

	Employee getReportTo(Employee em);

	// Requests
	boolean createRequest(Request rc);
	// boolean createRequest(int requestid, double requestvalue, String
	// requeststatus, String requestcatagory,
	// String requestdescription, Date requestdate, Date eventdate, String
	// requestinformation);

	boolean updateRequest(Request ru);
	// boolean updateRequest(int requestid, double requestvalue, String
	// requeststatus, String requestcatagory,
	// String requestdescription, Date requestdate, Date eventdate, String
	// requestinformation);

	// Request
	MultiModelMode getRequest(int requestid);

	// Reimbursement
	Reimbursement getReimbursement(int reimbursementid);

	// Image
	Image insertImage(String imagename, byte[] image);

	byte[] getImage(int id);

	void addImage(int id, byte[] image);

	// Full list arrays
	List<Employee> getEmployee(Employee ea);

	List<Request> getRequest(Request ra);

	List<Reimbursement> getReimbursement(Reimbursement ar);

	List<Image> getImage(Image ia);

	Employee getEmployeeById(int id);

	List<Reimbursement> getEmployeeReimbursements(int employeeid);

	Reimbursement getEmployeeReimbursement(int employeeid);

	List<Request> viewRequestManager(Request rm);

	List<MultiModelMode> getRequestViewManager(MultiModelMode rm);

	List<MultiModelMode> getViewPending(MultiModelMode vp);

	List<MultiModelMode> getViewResolved(MultiModelMode vr);

	List<MultiModelMode> getViewDenied(MultiModelMode vd);

	List<MultiModelMode> getMyPending(int employeerequest);// MultiModelMode mp);

	List<MultiModelMode> getMyResolved(int employeerequest);

	List<MultiModelMode> getMyDenied(int employeerequest);

	List<MultiModelMode> viewEmpReq(int employeerequest);
	
	boolean updateRequestStatus(int requestid, String requeststatus);


}
