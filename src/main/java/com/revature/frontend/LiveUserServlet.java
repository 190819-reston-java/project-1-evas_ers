package com.revature.frontend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Employee;
import com.revature.repository.EvasDAO;
import com.revature.repository.EvasJDBC;
import com.revature.service.EmployeeService;

/**
 * Servlet implementation class LiveUserServlet
 */
public class LiveUserServlet extends HttpServlet {
	
//	Employee selectedEmployee = new Employee(112, "Bradley", "James", "Janitor", "jbrad@evas.com", "asdf");


	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EvasDAO evasDao = new EvasJDBC();
		Employee employeeService = evasDao.getEmployeeById(BasicLogin.loggedAccount);
		
		BasicLogin.employeeOfInterest = BasicLogin.loggedAccount;
		
//		System.out.println(BasicLogin.aea+BasicLogin.apw);
		System.out.println("  *Selected Employee: " + employeeService);
		ObjectMapper om = new ObjectMapper();
		PrintWriter pw = resp.getWriter();
		HttpSession hs = req.getSession();
		System.out.println("Initiating Session for: " + hs);

		String employeeInfo=om.writeValueAsString(employeeService);
		System.out.println(employeeInfo);
		pw.write(employeeInfo);
		pw.close();

	}
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		PrintWriter pw = resp.getWriter();
//		HttpSession hs = req.getSession();
//		
//		pw.write("helllllloooooo!");
//
//	}
	


}
