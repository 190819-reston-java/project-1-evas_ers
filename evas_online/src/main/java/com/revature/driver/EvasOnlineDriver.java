package com.revature.driver;

import java.sql.Date;

import org.apache.log4j.Logger;

import com.revature.frontend.BasicLogin;
import com.revature.model.Employee;
import com.revature.model.Reimbursement;
import com.revature.model.Request;
import com.revature.repository.EvasDAO;
import com.revature.repository.EvasJDBC;
import com.revature.service.EmployeeService;
import com.revature.util.ConnectionUtil;


public class EvasOnlineDriver {
/**
 * EVAS Online Driver
 * @param args
 */
	public static void main(String[] args) {

		
		Logger logger = Logger.getLogger(EvasOnlineDriver.class);
		logger.debug("Conenction test");
		ConnectionUtil.getConnection();

		
		// create testing from db to forward
		EvasDAO evasDao = new EvasJDBC();
		EmployeeService employeeService = new EmployeeService();
		
		
		logger.info("getEmailandPass"); // works
			System.out.println("get email and pass: " + evasDao.getEmailandPass("ev", "4321"));
			employeeService.setSelectedEmployee(evasDao.getEmailandPass("ev", "4321"));
			System.out.println("***selected employee: " + employeeService.getSelectedEmployee());
			
		
		logger.info("getReimbursement"); // works
			System.out.println("get reimbursement: " + evasDao.getReimbursement(8));
		
		logger.info("updateEmployee"); // works
			//Employee ru = new Employee(10, "Spring", "Java", "Coder", "jspring@evas.com", "js9876");
				//System.out.println(evasDao.updateEmployee(ru));
		
		
		logger.info("updateRequest");// works
			//Request ru = new Request(8, 25.58, "pending", "Fuel", "Home", java.sql.Date.valueOf("2019-09-28"), java.sql.Date.valueOf("2019-10-01"), "Short trip");
				//System.out.println(evasDao.updateRequest(ru));
		
		logger.info("createRequest"); //wip - not updating in db 
			Request rc = new Request(0, 10.50, "pending", "Travel", "Work-Related", java.sql.Date.valueOf("2019-07-01"), java.sql.Date.valueOf("2019-10-29"), "public transit");
				System.out.println(evasDao.createRequest(rc));
		
		logger.info("getEmployeee List"); // works
			Employee ea = new Employee ();
			System.out.println("Get employee list: " + evasDao.getEmployee(ea));
		
		logger.info("getRequest List"); // works
			Request ra = new Request ();
			System.out.println("Get request list: " + evasDao.getRequest(ra));

		
		logger.info("insertImage"); // not working
			//System.out.println(evasDao.insertImage(smilyface, image));

		System.out.println("result end");
		
		System.out.println(evasDao.getEmployeeReimbursements(6));
		
//		System.out.println("****Lets try this: "+evasDao.getPendingReimbursements());
//		System.out.println("creating request");
//		
//		evasDao.createRequest(rc);
		
	}

}