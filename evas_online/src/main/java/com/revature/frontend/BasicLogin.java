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
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		doPost(req, resp);
//	}

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
			resp.sendRedirect("index.html");
		}
	}
}
