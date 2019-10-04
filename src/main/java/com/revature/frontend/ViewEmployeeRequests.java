package com.revature.frontend;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewEmployeeRequests
 */
public class ViewEmployeeRequests extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^");

//		int id = Integer.parseInt(req.getParameter("id"));
		
		String value = req.getParameter("id");
		
		System.out.println(value);
		
		BasicLogin.employeeOfInterest = Integer.parseInt(req.getParameter("id"));
		
		System.out.println("helllooooo");
		resp.sendRedirect("recent.html");

	}

}
