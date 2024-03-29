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
public class MyResolved extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EvasDAO evasDao = new EvasJDBC();
		Employee employeeService = evasDao.getEmployeeById(BasicLogin.loggedAccount);
		
		int employeerequest = employeeService.getEmployeeid(); // employee id
		System.out.println("Getting requests for employee #"+ employeerequest);
		
		ObjectMapper om = new ObjectMapper();
		PrintWriter pw = resp.getWriter();

		String transactionString = om.writeValueAsString(evasDao.getMyResolved(BasicLogin.employeeOfInterest));
		System.out.println("ArrayList: " + evasDao.getMyResolved(BasicLogin.employeeOfInterest));
		System.out.println("String being sent to JS: " + transactionString);
		pw.write(transactionString);
		pw.close();
		
//		if(BasicLogin.manager==false) {
//		String transactionString = om.writeValueAsString(evasDao.getMyResolved(BasicLogin.employeeOfInterest));
//		System.out.println("ArrayList: " + evasDao.getMyResolved(BasicLogin.employeeOfInterest));
//		System.out.println("String being sent to JS: " + transactionString);
//		pw.write(transactionString);
//		pw.close();
//		} else {
//			String transactionString = om.writeValueAsString(evasDao.getMyResolved(BasicLogin.prevEOI));
//			System.out.println("ArrayList: " + evasDao.getMyResolved(BasicLogin.prevEOI));
//			System.out.println("String being sent to JS: " + transactionString);
//			pw.write(transactionString);
//			pw.close();
//		}
		
	}

}
