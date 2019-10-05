package com.revature.frontend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
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
import com.revature.util.ConnectionUtil;

public class BasicLogin extends HttpServlet {
	
//	Employee selectedEmployee = new Employee(112, "Bradley", "James", "Janitor", "jbrad@evas.com", "asdf");
//	public static String aea = "null";
//	public static String apw = "null";
	public static int loggedAccount = 0;
	
	public static int employeeOfInterest = 0;
//	public static boolean manager = false;
//	public static int prevEOI = 0;
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		private static EmployeeService employeeService = new EmployeeService();
//			fursa@evas.com		FU9630
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		ObjectMapper om = new ObjectMapper();
		EvasDAO evasDao = new EvasJDBC();
		EmployeeService employeeService = new EmployeeService();

		String email = req.getParameter("enterEmail");
		String password = req.getParameter("enterPassword");

//		aea = email;
//		apw = password;
//		System.out.println(aea+apw);

		System.out.println("testing DB connection:");
		ConnectionUtil.getConnection();

		System.out.println("  *Logging in: " + evasDao.getEmailandPass(email, password));


		
		if (evasDao.getEmailandPass(email, password) == (null)) {
			// if the login fails:

			System.out.println("uh oh");
			resp.sendRedirect("login.html");
//			System.out.println(aea+apw);
		} else if(evasDao.getEmailandPass(email, password).getEmployeeposition().equals("Manager")) { // if the login succeeds
			System.out.println("manager_home.html");
			
			loggedAccount = evasDao.getEmailandPass(email, password).getEmployeeid();
			System.out.println("  *Setting selected employee: " + evasDao.getEmailandPass(email, password).getEmployeeid());
			employeeService.setSelectedEmployee(evasDao.getEmailandPass(email, password));
//			System.out.println("   *Our selected employee: " + employeeService.getSelectedEmployee());
			
//			prevEOI = employeeOfInterest;
			
			loggedAccount = evasDao.getEmailandPass(email, password).getEmployeeid();
			employeeOfInterest = loggedAccount;
			System.out.println("Logging in account #"+loggedAccount + ", employee of interest is: " + employeeOfInterest);
			
			
			
			HttpSession session = req.getSession();
			session.setAttribute("activeAccount", email);
			System.out.println("Initiating Session for: " + session);
//			manager = true;
			
			resp.sendRedirect("manager_home.html");
			}
			else {
				System.out.println("index.html");
				
			loggedAccount = evasDao.getEmailandPass(email, password).getEmployeeid();
			System.out.println("  *Setting selected employee: " + evasDao.getEmailandPass(email, password).getEmployeeid());
			employeeService.setSelectedEmployee(evasDao.getEmailandPass(email, password));
//			System.out.println("   *Our selected employee: " + employeeService.getSelectedEmployee());

			loggedAccount = evasDao.getEmailandPass(email, password).getEmployeeid();
			employeeOfInterest = loggedAccount;
			System.out.println("Logging in account #"+loggedAccount + ", employee of interest is: " + employeeOfInterest);
			
			
			HttpSession session = req.getSession();
			session.setAttribute("activeAccount", email);
			System.out.println("Initiating Session for: " + session);
			System.out.println("  --redirecting to index.html--");
//			System.out.println(aea+apw);
			
			resp.sendRedirect("index.html");
			pw.close();
		}
	}
}