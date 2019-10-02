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

		EvasDAO evasDao = new EvasJDBC();
		Employee employeeService = evasDao.getEmployeeById(BasicLogin.loggedAccount);
		
		ObjectMapper om = new ObjectMapper();
		PrintWriter pw = resp.getWriter();
		
		String transactionString = om.writeValueAsString(evasDao.getEmployeeReimbursements(3));
		System.out.println("ArrayList: " + evasDao.getEmployeeReimbursements(3));
		System.out.println("String being sent to JS: " + transactionString);
		pw.write(transactionString);
		
		
	}

}
