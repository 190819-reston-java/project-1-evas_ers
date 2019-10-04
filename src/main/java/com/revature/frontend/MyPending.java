package com.revature.frontend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Employee;
import com.revature.model.MultiModelMode;
import com.revature.model.Reimbursement;
import com.revature.repository.EvasDAO;
import com.revature.repository.EvasJDBC;

/**
 * Servlet implementation class ViewAll
 */
public class MyPending extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("1***employee of interest is: " + BasicLogin.employeeOfInterest);


		EvasDAO evasDao = new EvasJDBC();
		Employee employeeService = evasDao.getEmployeeById(BasicLogin.loggedAccount);
		
		int employeerequest = employeeService.getEmployeeid(); // employee id

		System.out.println("2***employee of interest is: " + BasicLogin.employeeOfInterest);
		
		ObjectMapper om = new ObjectMapper();
		PrintWriter pw = resp.getWriter();

		
		System.out.println("Investigating #" + BasicLogin.loggedAccount + ", employee of interest is: " + BasicLogin.employeeOfInterest);


		String transactionString = om.writeValueAsString(evasDao.getMyPending(BasicLogin.employeeOfInterest));
		System.out.println("Getting requests for employee #"+ BasicLogin.employeeOfInterest);
		System.out.println("ArrayList: " + evasDao.getMyPending(BasicLogin.employeeOfInterest));
		System.out.println("String being sent to JS: " + transactionString);
		pw.write(transactionString);

//		String transactionString = om.writeValueAsString(evasDao.getMyPending(employeerequest));
//		System.out.println("Getting requests for employee #"+ employeerequest);
//		System.out.println("ArrayList: " + evasDao.getMyPending(employeerequest));
//		System.out.println("String being sent to JS: " + transactionString);
//		pw.write(transactionString);
		

		System.out.println("Getting requests for employee #1");
		System.out.println("ArrayList: " + evasDao.getMyPending(1));
		pw.close();
		
	}

}
