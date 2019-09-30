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
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		private static EmployeeService employeeService = new EmployeeService();
//			fursa@evas.com		asdf
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		ObjectMapper om = new ObjectMapper();
		EvasDAO evasDao = new EvasJDBC();

		String email = req.getParameter("enterEmail");
		String password = req.getParameter("enterPassword");

//		RequestDispatcher homePage = req.getRequestDispatcher("index.html");
//		homePage.forward(req, resp);

		System.out.println("testing DB connection:");
		ConnectionUtil.getConnection();

		System.out.println(evasDao.getEmailandPass(email, password));

//		String test = evasDao.getEmailandPass(username, password);

		if (evasDao.getEmailandPass(email, password) == (null)) {
			// if the login fails:

			System.out.println("uh oh");
			resp.sendRedirect("login.html");
		} else { // if the login succeeds
//			pw.println(evasDao.getEmailandPass(email, password));
			HttpSession session = req.getSession();
			session.setAttribute("activeAccount", email);
			System.out.println(session);
			resp.sendRedirect("index.jsp");
		}

//		Employee employee = null;
//
//		switch (req.getMethod()) {
//		case "GET":
//			String employeeName = om.writeValueAsString(evasDao.getEmailandPass(username, password));
//			break;
//		case "POST":
//			employee = om.readValue(req.getReader(), Employee.class);
//		}

//		if (username.equals("hi")) {
//			pw.println("NICE!");
//
//			// using sessions to verify the user has logged in
//			HttpSession session = req.getSession();
//			session.setAttribute("user", username);
//
//			resp.sendRedirect("index.html");
//		} else {
//			resp.sendRedirect("login.html");
//			pw.println("invalid account information");
//		}
//
//		{
		/*
		 * Connection conn = null;
		 * 
		 * try { Class.forName("org.postgresql.Driver"); } catch (ClassNotFoundException
		 * e1) { e1.printStackTrace(); }
		 * 
		 * try { Properties props = new Properties();
		 * 
		 * //The following lines just ensure we find connection.properties regardless of
		 * how our project is built: ClassLoader loader =
		 * Thread.currentThread().getContextClassLoader();
		 * props.load(loader.getResourceAsStream("connection.properties")); //changed to
		 * db as per file is correct 0738
		 * 
		 * // All we've done is set these value to the values found in
		 * connection.properties String url = props.getProperty("url"); String asd =
		 * props.getProperty("username"); String sdf = props.getProperty("password");
		 * 
		 * // How to actually make connection with jdbc conn =
		 * DriverManager.getConnection(url, asd, sdf); System.out.println("--online--");
		 * 
		 * }catch (IOException e) { e.printStackTrace();
		 * 
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } System.out.println("welp: " + conn); }
		 */
//		EvasDAO evasDao = new EvasJDBC();
//		System.out.println(evasDao.getEmailandPass("fursa@evas.com", "FU9630"));

//		System.out.println(evasDao.getEmailandPass(username, password));

//		if(evasDao.getEmailandPass(username, password)==null) {
//			pw.println("Invalid username or password");
//		}else {
//			pw.println("Welcome");
//		}

	}
}
