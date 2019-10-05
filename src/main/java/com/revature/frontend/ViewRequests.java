package com.revature.frontend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Employee;
import com.revature.repository.EvasDAO;
import com.revature.repository.EvasJDBC;

/**
 * Servlet implementation class ViewRequests
 */
public class ViewRequests extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("%%%%%%%%%%%%%%% + %%%%%%%%");

		EvasDAO evasDao = new EvasJDBC();
		Employee employeeService = evasDao.getEmployeeById(BasicLogin.loggedAccount);
		
		System.out.println("employee of interest is: " + BasicLogin.employeeOfInterest);

		ObjectMapper om = new ObjectMapper();
		PrintWriter pw = resp.getWriter();

//		String transactionString = om.writeValueAsString(evasDao.viewEmpReq(employeeService.getEmployeeid()));
//		System.out.println("ArrayList: " + evasDao.viewEmpReq(employeeService.getEmployeeid()));
//		System.out.println("String being sent to JS: " + transactionString);
//		pw.write(transactionString);
		
		System.out.println("Investigating #" + BasicLogin.loggedAccount + ", employee of interest is: " + BasicLogin.employeeOfInterest);
		
		String transactionString = om.writeValueAsString(evasDao.viewEmpReq(BasicLogin.employeeOfInterest));
		System.out.println("ArrayList: " + evasDao.viewEmpReq(BasicLogin.employeeOfInterest));
		System.out.println("String being sent to JS: " + transactionString);
		pw.write(transactionString);
		
		pw.close();
	}

//	if(BasicLogin.manager==false) {
//	String transactionString = om.writeValueAsString(evasDao.viewEmpReq(BasicLogin.employeeOfInterest));
//	System.out.println("ArrayList: " + evasDao.viewEmpReq(BasicLogin.employeeOfInterest));
//	System.out.println("String being sent to JS: " + transactionString);
//	pw.write(transactionString);
//	pw.close();
//	} else {
//		String transactionString = om.writeValueAsString(evasDao.viewEmpReq(BasicLogin.prevEOI));
//		System.out.println("ArrayList: " + evasDao.viewEmpReq(BasicLogin.prevEOI));
//		System.out.println("String being sent to JS: " + transactionString);
//		pw.write(transactionString);
//		pw.close();
//	}

}
