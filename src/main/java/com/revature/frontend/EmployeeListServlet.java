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
 * Servlet implementation class EmployeeListServlet
 */
public class EmployeeListServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EvasDAO evasDao = new EvasJDBC();
		Employee employeeService = evasDao.getEmployeeById(BasicLogin.loggedAccount);

		ObjectMapper om = new ObjectMapper();
		PrintWriter pw = resp.getWriter();

		String transactionString = om.writeValueAsString(evasDao.getEmployee(employeeService));
		System.out.println("ArrayList: " + evasDao.getEmployee(employeeService));
		System.out.println("String being sent to JS: " + transactionString);
		pw.write(transactionString);
		pw.close();

	}

}
